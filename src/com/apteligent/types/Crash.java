package com.apteligent.types;

import com.apteligent.display.BreadcrumbTrail;
import com.apteligent.display.Diagnostics;
import com.apteligent.display.StacktraceLine;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.Date;

public class Crash {

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

    private String status;
    private ArrayList<StacktraceLine> stacktrace;
    private String displayReason;
    private String hash;
    private Date firstOccurred;
    private Object dailyOccurrencesByVersion;
    private Object uniqueSessionCountsByVersion;
    private ArrayList<BreadcrumbTrail> breadcrumbTraces;
    private String appID;
    private ArrayList<StacktraceLine> symbolizedStacktrace;
    private Object otherCrashes;
    private String unsymbolizedHash;
    private String reason;
    private Object sessionCountsByVersion;
    private Diagnostics diagnostics;
    private Object legacyCrashes;
    @JsonProperty("class")
    private String className; // crash type
    private Date lastOccurred;
    private String name;

    @Override
    public String toString() {
        return "";
       // return String.format("{appId:\"%s\",stacktrace:%s}",
       //         appID, java.util.Arrays.toString(stacktrace));
    }

    public String getName() {
        return this.name;
    }

    public String getReason() {
        return this.reason;
    }

    public ArrayList<StacktraceLine> getStacktrace() {
        return this.stacktrace;
    }

    public ArrayList<BreadcrumbTrail> getBreadcrumbs() {
        return this.breadcrumbTraces;
    }

    public boolean hasBreadcrumbs() {
        return (this.breadcrumbTraces != null && this.breadcrumbTraces.size() > 0);
    }
}