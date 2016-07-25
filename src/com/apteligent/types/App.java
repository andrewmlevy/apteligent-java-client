package com.apteligent.types;

public class App {

    public static enum AppType {
        IOS("ios"), ANDROID("android"), HTML5("html5"), WINDOWS("wp");
        private final String text;
        private AppType(final String text) {
            this.text = text;
        }
        @Override
        public String toString() {
            return text;
        }
    }

    private String appName;
    private AppType appType;
    private String appVersions[];
    private double crashPercent;
    private long dau;
    private long latency;
    private String latestAppStoreReleaseDate;
    private String latestVersionString;
    private String linkToAppStore;
    private String iconURL;
    private long mau;
    private double rating;
    private String role;

    @Override
    public String toString() {
        return String.format("{appName:\"%s\",appType:\"%s\",appVersions:%s,crashPercent:%s,dau:%s,latency:%s" +
                             ",latestAppStoreReleaseDate:\"%s\",latestVersionString:\"%s\",linkToAppStore:\"%s\"" +
                             ",iconURL:\"%s\",mau:%s,rating:%s,role:\"%s\"}",
                appName, appType, java.util.Arrays.toString(appVersions), crashPercent,dau,latency,latestAppStoreReleaseDate,
                latestVersionString,linkToAppStore,iconURL,mau,rating,role);
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public AppType getAppType() {
        return appType;
    }

    public void setAppType(AppType appType) {
        this.appType = appType;
    }

    public String[] getAppVersions() {
        return appVersions;
    }

    public void setAppVersions(String[] appVersions) {
        this.appVersions = appVersions;
    }

    public double getCrashPercent() {
        return crashPercent;
    }

    public void setCrashPercent(double crashPercent) {
        this.crashPercent = crashPercent;
    }

    public long getDau() {
        return dau;
    }

    public void setDau(long dau) {
        this.dau = dau;
    }

    public long getLatency() {
        return latency;
    }

    public void setLatency(long latency) {
        this.latency = latency;
    }

    public String getLatestAppStoreReleaseDate() {
        return latestAppStoreReleaseDate;
    }

    public void setLatestAppStoreReleaseDate(String latestAppStoreReleaseDate) {
        this.latestAppStoreReleaseDate = latestAppStoreReleaseDate;
    }

    public String getLatestVersionString() {
        return latestVersionString;
    }

    public void setLatestVersionString(String latestVersionString) {
        this.latestVersionString = latestVersionString;
    }

    public String getLinkToAppStore() {
        return linkToAppStore;
    }

    public void setLinkToAppStore(String linkToAppStore) {
        this.linkToAppStore = linkToAppStore;
    }

    public String getIconURL() {
        return iconURL;
    }

    public void setIconURL(String iconURL) {
        this.iconURL = iconURL;
    }

    public long getMau() {
        return mau;
    }

    public void setMau(long mau) {
        this.mau = mau;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

}
