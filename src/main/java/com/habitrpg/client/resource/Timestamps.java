package com.habitrpg.client.resource;

import org.codehaus.jackson.annotate.JsonProperty;

import java.util.Date;

public class Timestamps {

    private Date created;

    @JsonProperty("loggedin")
    private Date loggedIn;

    public Date getCreated() {
        return created;
    }

    public Date getLoggedIn() {
        return loggedIn;
    }
}