/*
    Copyright 2016 Apteligent, Inc.

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
 */
package com.apteligent;

import com.apteligent.display.Pie;
import com.apteligent.display.Sparklines;
import com.apteligent.types.App;
import com.apteligent.types.Crash;
import com.apteligent.types.CrashSummary;
import com.apteligent.types.Token;
import com.apteligent.types.User;
import com.apteligent.util.Base64;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;

//import com.fasterxml.jackson.databind.JsonNode;

/*
    This is a Java client library for the Apteligent (formerly Crittericsm) API.
    This lib can be used in standard java projects as well as an Android app.
 */
public class ApteligentJavaClient {

    private static final String API_VERSION = "v1.0";
    private static final String API_BASE = "https://developers.crittercism.com/" + API_VERSION + "/";
    private static final String API_TOKEN = API_BASE + "token";
    private static final String API_APPS = API_BASE + "apps";

    private static final String API_ERROR_GRAPH = API_BASE + "errorMonitoring/graph";
    private static final String API_ERROR_PIE = API_BASE + "errorMonitoring/pie";
    private static final String API_ERROR_SPARKLINES = API_BASE + "errorMonitoring/sparklines";

    private static final String API_CRASH_DETAILS = API_BASE + "crash/{hash}";
    private static final String API_CRASH_USERS_AFFECTED = API_BASE + "{appId}/crash/{hash}/userData";

    private String apiKey = "";
    private Token token = null;

    public ApteligentJavaClient(String apiKey) {
        this.apiKey = apiKey;
    }

    /**
     * Authenticates with our API, call if you need a token or if it's expired
     * @param email
     * @param password
     * @return true if successful, false otherwise
     */
    public boolean connect(String email, String password) {
        try {
            this.token = auth(email, password);
            return (this.token != null && !this.token.getAccessToken().equals(""));
        }
        catch(IOException ioex) {
            System.err.println("[ApteligentJavaClient] connect: " + ioex.toString());
            ioex.printStackTrace();
        }
        return false;
    }

    /**
     * Attempt to validate an existing token object
     * Note: this call does not yet check the validity of a token, only if it has not yet expired.
     * @param apiTokenObj
     * @return true if the client accepted the token, false otherwise
     */
    public boolean connect(Token apiTokenObj) {
        boolean success = false;
        if(apiTokenObj != null) {

            // check if the token is still active or expired
            Date today = new Date();

            // setup expiration date object
            Date dateTokenExpires = apiTokenObj.getCreationDate();
            long secondsOffset = apiTokenObj.getExpiresIn();
            dateTokenExpires.setTime(dateTokenExpires.getTime() + 1000*secondsOffset);

            if(today.before(dateTokenExpires)) {
                this.token = apiTokenObj;
                success = true;
            }
        }
        return success;
    }

    /**
     * Returns the API token object
     * @return the token object, null if none exists
     */
    public Token getApiToken() {
        return this.token;
    }

    /**
     * Query the API for a list of Apps, and the details of each App
     * @return map of App IDs -> App Objects
     */
    public Map<String, App> getAppListing() {
        Map<String, App> map = null;
        try {
            String urlParameters = "?attributes=appName%2CappType%2CappVersions%2CcrashPercent%2Cdau%2Clatency%2C" +
                    "latestAppStoreReleaseDate%2ClatestVersionString%2ClinkToAppStore%2CiconURL%2Cmau%2Crating%2Crole";
            HttpsURLConnection conn = sendGetRequest(API_APPS, urlParameters);
            JsonFactory jsonFactory = new JsonFactory();
            JsonParser jp = jsonFactory.createParser(conn.getInputStream());
            ObjectMapper mapper = getObjectMapper();
            map = mapper.readValue(jp, new TypeReference<Map<String,App>>(){});
        }
        catch(IOException ioex) {
            ioex.printStackTrace();
        }
        return map;
    }

    //  error data can be in bulk with param: appIds (array[string], optional): A list of apps to retrieve data about,
    // filters (Filter, optional): The graph endpoint only supports a single filter per request

    /**
     * @param appID appId (string, optional): The app to retrieve data about,
     * @param metricType The metric to retrieve
     * @param duration can only be 1440 (24 hours) or 43200 (1 month)
     * @return Error object
     */
    public CrashSummary getErrorGraph(String appID, CrashSummary.MetricType metricType, int duration) {

        // { "params": {"duration": 43200, "graph": "crashes", "appId": "4f2cc6dfb09315234e000639"}}
        //String responseStr = "{\"data\": {\"start\": \"2014-11-13T00:00:00\", \"interval\": 86400, \"end\": \"2014-12-13T00:00:00\", \"series\": [{\"points\": [0, 3, 2, 0, 2, 3, 2, 3, 0, 6, 0, 0, 0, 1, 0, 0, 6, 2, 0, 1, 0, 0, 4, 1, 0, 0, 1, 2, 0, 0], \"name\": \"crashes\"}]}, \"params\": {\"duration\": 43200, \"graph\": \"crashes\", \"appId\": \"4f2cc6dfb09315234e000639\"}}";

        String params =
                "{ \"params\": " +
                        "{\"duration\": " + duration + "," +
                        " \"graph\": \"" + metricType.toString() + "\"," +
                        " \"appId\": \"" + appID + "\"}" +
                "}";

        System.out.println(params);
        CrashSummary crashSummary = null;
        try {
            HttpsURLConnection conn = sendPostRequest(API_ERROR_GRAPH, params);
            JsonFactory jsonFactory = new JsonFactory();
            JsonParser jp = jsonFactory.createParser(conn.getInputStream());
            ObjectMapper mapper = getObjectMapper();
            TreeNode node = mapper.readTree(jp);
            crashSummary = mapper.treeToValue(node.get("data"), CrashSummary.class);
            if(crashSummary != null) {
                crashSummary.setParams(appID, metricType, duration);
            }
        }
        catch(IOException ioex) {
            ioex.printStackTrace();
        }
        return crashSummary;
    }

    /**
     * @param appID appId (string, optional): The app to retrieve data about,
     * @param metricType The metric to retrieve
     * @param duration can only be 1440 (24 hours) or 43200 (1 month)
     * @param groupBy TODO FILL IN THIS COMMENT
     * @return
     */
    public CrashSummary getErrorPie(String appID, CrashSummary.MetricType metricType, int duration, Pie.GroupBy groupBy) {

        String params =
                "{ \"params\": " +
                        "{\"duration\": " + duration + "," +
                        " \"graph\": \"" + metricType.toString() + "\"," +
                        " \"appId\": \"" + appID + "\"" +
                        ",\"groupBy\": \"" + groupBy.toString() + "\"}" +
                "}";

        CrashSummary crashSummary = null;
        try {
            HttpsURLConnection conn = sendPostRequest(API_ERROR_PIE, params);
            JsonFactory jsonFactory = new JsonFactory();
            JsonParser jp = jsonFactory.createParser(conn.getInputStream());
            ObjectMapper mapper = getObjectMapper();
            TreeNode node = mapper.readTree(jp);
            crashSummary = mapper.treeToValue(node.get("data"), CrashSummary.class);
            if(crashSummary != null) {
                crashSummary.setParams(appID, metricType, duration);
            }
        }
        catch(IOException ioex) {
            ioex.printStackTrace();
        }
        return crashSummary;
    }

    /**
     * @param appID appId (string, optional): The app to retrieve data about,
     * @param metricType The metric to retrieve
     * @param duration can only be 1440 (24 hours) or 43200 (1 month)
     * @param groupBy TODO FILL IN THIS COMMENT
     * @return
     */
    public CrashSummary getErrorSparklines(String appID, CrashSummary.MetricType metricType, int duration, Sparklines.GroupBy groupBy) {

        String params =
                "{ \"params\": " +
                        "{\"duration\": " + duration + "," +
                        " \"graph\": \"" + metricType.toString() + "\"," +
                        " \"appId\": \"" + appID + "\"" +
                        ",\"groupBy\": \"" + groupBy.toString() + "\"}" +
                "}";

        CrashSummary crashSummary = null;
        try {
            HttpsURLConnection conn = sendPostRequest(API_ERROR_SPARKLINES, params);
            JsonFactory jsonFactory = new JsonFactory();
            JsonParser jp = jsonFactory.createParser(conn.getInputStream());
            ObjectMapper mapper = getObjectMapper();
            TreeNode node = mapper.readTree(jp);
            crashSummary = mapper.treeToValue(node.get("data"), CrashSummary.class);
            if(crashSummary != null) {
                crashSummary.setParams(appID, metricType, duration);
            }
        }
        catch(IOException ioex) {
            ioex.printStackTrace();
        }
        return crashSummary;
    }


    /**
     * @param hash The crash hash to retrieve
     * By default this will request diagnostics but tells the API to not retrieve extra sample crash groups
     * that have been grouped into this same crash group
     * @return Crash object
     */
    public Crash getCrash(String hash) {
        return getCrash(hash, true, false);
    }

    /**
     * @param hash The crash hash to retrieve
     * @param diagnostics include detailed diagnostics information for crash
     * @param getOtherCrashes include other crashes and legacy crash groups now part of this group
     * @return Crash object
     */
    public Crash getCrash(String hash, boolean diagnostics, boolean getOtherCrashes) {
        String params = "?diagnostics=" + diagnostics + "&get_other_crashes=" + getOtherCrashes;
        Crash crash = null;
        try {
            HttpsURLConnection conn = sendGetRequest(API_CRASH_DETAILS.replace("{hash}",hash), params);
            JsonFactory jsonFactory = new JsonFactory();
            JsonParser jp = jsonFactory.createParser(conn.getInputStream());
            ObjectMapper mapper = getObjectMapper();
            TreeNode node = mapper.readTree(jp);
            crash = mapper.treeToValue(node, Crash.class);
        }
        catch(IOException ioex) {
            ioex.printStackTrace();
        }
        return crash;
    }

    //
    /**
     * @param appID The app ID
     * @param hash The crash hash to retrieve
     * @return Array of impacted users
     */
    public ArrayList<User> getCrashUsersAffected(String appID, String hash) {
        ArrayList<User> users = null;
        try {
            HttpsURLConnection conn = sendGetRequest(API_CRASH_USERS_AFFECTED.replace("{appId}",appID).replace("{hash}", hash));
            JsonFactory jsonFactory = new JsonFactory();
            JsonParser jp = jsonFactory.createParser(conn.getInputStream());
            ObjectMapper mapper = getObjectMapper();
            users = mapper.readValue(jp, new TypeReference<ArrayList<User>>(){});
        }
        catch(IOException ioex) {
            ioex.printStackTrace();
        }
        return users;
    }


    /*********************************************************************************************************************/

    private Token auth(String email, String password) throws IOException {
        String urlParameters = "grant_type=password&username=" + email + "&password=" + password;

        URL obj = new URL(API_TOKEN);
        HttpsURLConnection conn = (HttpsURLConnection) obj.openConnection();
        conn.setSSLSocketFactory((SSLSocketFactory)SSLSocketFactory.getDefault());
        conn.setDoOutput(true);
        conn.setDoInput(true);

        //add request header
        String basicAuth = new String(Base64.encodeBytes(apiKey.getBytes()));
        conn.setRequestProperty ("Authorization", String.format("Basic %s", basicAuth));
        conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        conn.setRequestProperty("Accept", "*/*");
        conn.setRequestProperty("Content-Length", Integer.toString(urlParameters.getBytes().length));
        conn.setRequestMethod("POST");

        // Send post request
        DataOutputStream wr = new DataOutputStream(conn.getOutputStream());
        wr.writeBytes(urlParameters);
        wr.flush();
        wr.close();

        // read token
        JsonFactory jsonFactory = new JsonFactory();
        JsonParser jp = jsonFactory.createParser(conn.getInputStream());
        ObjectMapper mapper = getObjectMapper();
        Token token = mapper.readValue(jp, Token.class);

        return token;
    }

    private ObjectMapper getObjectMapper() {
        // configure and return ObjectMapper for JSON->Java Object de-serialization
        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        mapper.setVisibilityChecker(mapper.getSerializationConfig().getDefaultVisibilityChecker()
                .withFieldVisibility(JsonAutoDetect.Visibility.ANY)
                .withGetterVisibility(JsonAutoDetect.Visibility.NONE)
                .withSetterVisibility(JsonAutoDetect.Visibility.NONE)
                .withCreatorVisibility(JsonAutoDetect.Visibility.NONE));
        mapper.configure(DeserializationFeature.READ_ENUMS_USING_TO_STRING, true);
        return mapper;
    }

    private HttpsURLConnection sendGetRequest(String endpoint, String urlParameters) throws IOException {
        // build connection object for GET request
        URL obj = new URL(endpoint + urlParameters);
        HttpsURLConnection conn = (HttpsURLConnection) obj.openConnection();
        conn.setSSLSocketFactory((SSLSocketFactory)SSLSocketFactory.getDefault());
        conn.setDoOutput(false);
        conn.setDoInput(true);
        conn.setRequestProperty ("Authorization", "Bearer " + this.token.getAccessToken());
        conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        conn.setRequestProperty("Accept", "*/*");
        conn.setRequestMethod("GET");
        return conn;
    }

    private HttpsURLConnection sendGetRequest(String endpoint) throws IOException {
        return sendGetRequest(endpoint, "");
    }

    private HttpsURLConnection sendPostRequest(String endpoint, String params) throws IOException {
        // build conn object for POST request
        URL obj = new URL(endpoint);
        HttpsURLConnection conn = (HttpsURLConnection) obj.openConnection();
        conn.setSSLSocketFactory((SSLSocketFactory)SSLSocketFactory.getDefault());
        conn.setDoOutput(true);
        conn.setDoInput(true);
        conn.setRequestProperty ("Authorization", "Bearer " + this.token.getAccessToken());
        conn.setRequestProperty("Content-Type", "application/json");
        conn.setRequestProperty("Accept", "*/*");
        conn.setRequestProperty("Content-Length", Integer.toString(params.getBytes().length));
        conn.setRequestMethod("POST");

        // Send post request
        DataOutputStream wr = new DataOutputStream(conn.getOutputStream());
        wr.writeBytes(params);
        wr.flush();
        wr.close();
        return conn;
    }
}
