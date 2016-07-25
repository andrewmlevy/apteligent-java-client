package com.apteligent.types;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by levy on 7/19/16.
 */
public class User {
    String username;
    @JsonProperty("app_version")
    String appVersion; //"app_version":"4.0",
    @JsonProperty("crash_last_occurred_iso")
    String crashLastOccurred; // ex: "2016-07-10T07:33:27.924+00:00"
    String locale;
    String system;
    String carrier;
    String model;
    @JsonProperty("last_login_time_iso")
    String lastLoginTime; // ex: "2016-07-10T07:33:44.178Z"
    String system_version;
    Object metadata; // TODO

    @Override
    public String toString() {
            return String.format("{username:\"%s\",appVersion:\"%s\",crashLastOccurred:%s,locale:%s,system:%s,system_version:%s" +
                                 ",carrier:%s,model:\"%s\",lastLoginTime:\"%s\",metadata:\"%s\"}",
                    username, appVersion,crashLastOccurred, locale,system,system_version, carrier,model,
                    lastLoginTime,metadata);
    }

}
