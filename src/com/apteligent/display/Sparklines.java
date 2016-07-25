package com.apteligent.display;

/**
 * Created by levy on 12/13/14.
 */
public class Sparklines {

    public static enum GroupBy {
        APP_ID("appId");
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
    public long points[];
}
