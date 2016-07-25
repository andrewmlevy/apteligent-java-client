package com.apteligent.types;

import com.apteligent.display.Graph;
import com.apteligent.display.Pie;
import com.apteligent.display.Sparklines;


/* ErrorMonitoring Endpoint */

// TODO refactor
public class CrashSummary {

    public static enum DisplayType {
        GRAPH("graph"), PIE("pie"), SPARKLINES("sparklines");
        private final String text;
        private DisplayType(final String text) {
            this.text = text;
        }
        @Override
        public String toString() {
            return text;
        }
    }

    public static enum MetricType {
        DAU("dau"), MAU("mau"), RATING("rating"), CRASHES("crashes"), CRASH_PERCENT("crashPercent"),
        APP_LOADS("appLoads"), AFFECTED_USERS("affectedUsers"), AFFECTED_USER_PERCENT("affectedUserPercent");
        private final String text;
        private MetricType(final String text) {
            this.text = text;
        }
        @Override
        public String toString() {
            return text;
        }
    }

    private String start;
    private String end;
    private long interval;

    private Graph series[];
    private Pie[] slices;
    private Sparklines[] points;


    public Graph[] getSeries() {
        return this.series;
    }

    private int duration;
    private MetricType metricType;
    private String appID;

    public void setParams(String appID, MetricType metricType, int duration) {
        this.appID = appID;
        this.duration = duration;
        this.metricType = metricType;
    }

    public Graph[] getGraphSeries() {
        return this.series;
    }

    public Pie[] getPieSlices() {
        return this.slices;
    }

    public Sparklines[] getSparkLines() {
        return this.points;
    }

/*
    { "data" :
        {
          "start" : "2014-11-13T00:00:00"
          "end" : "2014-12-13T00:00:00",
          "interval" : 86400,
          "series" :
            [ { "name" : "crashes",
                "points" : [ 2108,
                            2127,
                            1988,
                            2071,
                            2225,
                            2079,
                            2203,
                            2298,
                            2296,
                            2347,
                            2194,
                            2182,
                            2318,
                            2102,
                            2297,
                            2346,
                            2236,
                            2252,
                            2348,
                            2275,
                            2225,
                            2318,
                            2280,
                            2301,
                            2337,
                            2335,
                            2329,
                            2220,
                            2258,
                            2175]
               } ]

    }
    */

}
