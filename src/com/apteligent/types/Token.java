package com.apteligent.types;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Date;


public class Token implements Serializable {

    private static final long serialVersionUID = 0L;

    @JsonProperty("access_token")
    private String accessToken = "";

    @JsonProperty("token_type")
    private String tokenType = "";

    @JsonProperty("expires_in")
    private long expiresIn = 0;

    private Date creationDate = new Date();

    public String getAccessToken() { return this.accessToken; }

    public String getTokenType() {
        return this.tokenType;
    }

    public long getExpiresIn() {
        return this.expiresIn;
    }

    public Date getCreationDate() { return this.creationDate; }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    public void setExpiresIn(long expiresIn) {
        this.expiresIn = expiresIn;
    }

}
