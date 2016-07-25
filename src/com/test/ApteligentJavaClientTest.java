package com.test;

import com.apteligent.ApteligentJavaClient;
import com.apteligent.display.BreadcrumbTrail;
import com.apteligent.display.Pie;
import com.apteligent.display.Sparklines;
import com.apteligent.display.StacktraceLine;
import com.apteligent.types.App;
import com.apteligent.types.Crash;
import com.apteligent.types.CrashSummary;
import com.apteligent.types.User;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class ApteligentJavaClientTest {

    public static void main(String[] args) {

        /*
            This is a scratchpad of interactions with the client library. Not a formal test of the lib itself.
         */

        // initialize client library with API Token
        ApteligentJavaClient client = new ApteligentJavaClient("API_TOKEN");

        // Apteligent / Crittercism username and password
        boolean connected = client.connect("EMAIL", "PASSWORD");

        if(connected) {

            LinkedHashMap<String, App> apps = (LinkedHashMap)client.getAppListing();

            System.out.println("List of Apps:");
            for (Map.Entry<String,App> entry : apps.entrySet()) {
                String key = entry.getKey();
                App value = entry.getValue();
                System.out.println(key + ":" + value.toString());
            }

            String dydAppID = "4f2cc6dfb09315234e000639";
            int duration24Hours = 1440;
            int durationMonth = 43200;
            CrashSummary crashSummaryGraph = client.getErrorGraph(dydAppID, CrashSummary.MetricType.CRASHES, durationMonth);

            CrashSummary crashSummaryPie = client.getErrorPie(dydAppID, CrashSummary.MetricType.CRASH_PERCENT, durationMonth, Pie.GroupBy.OS);

            int sum = 0;
            Pie[] slices = crashSummaryPie.getPieSlices();
            for(Pie slice : slices) {
                sum += slice.value;
            }
            System.out.println("slices sum = " + sum);

            CrashSummary crashSummarySpark = client.getErrorSparklines(dydAppID, CrashSummary.MetricType.RATING, durationMonth, Sparklines.GroupBy.APP_ID);

            // java.lang.IllegalArgumentException
            String crashHash = "582bfd990ea7814a";
            Crash crash = client.getCrash(crashHash);
            System.out.println("\nSample Crash Name : Reason");
            System.out.println(crash.getName() + " : " + crash.getReason());
            StacktraceLine.printStacktrace(crash.getStacktrace(), true);

            ArrayList<BreadcrumbTrail> trail = crash.getBreadcrumbs();
            if(crash.hasBreadcrumbs()) {
                System.out.println("\nOne Breadcrumb Trail of " + trail.size() + " Total:");
                System.out.println(trail.get(0).toString());
            }

            System.out.println("\nUsers Affected:");
            ArrayList<User> crashUsers = client.getCrashUsersAffected(dydAppID, crashHash);
            if(crashUsers != null && crashUsers.size() > 0) {
                for (User user : crashUsers) {
                    System.out.println(user.toString());
                }
            }
        }
    }
}
