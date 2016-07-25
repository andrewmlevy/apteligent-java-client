package com.apteligent.display;

/**
 * Created by levy on 12/13/14.
 */
public class Pie {

    public static enum GroupBy {
        APP_VERSION("appVersion"), OS("os"), CARRIER("carrier"), DEVICE("device"), APP_ID("appId");
        private final String text;
        private GroupBy(final String text) {
            this.text = text;
        }
        @Override
        public String toString() {
            return text;
        }
    }

    public String name;
    public String label;
    public long value;

    public GroupBy groupBy;
}
