package com.habitrpg.client.resource;

import org.codehaus.jackson.annotate.JsonProperty;

public class Timestamps {

    private long created;

    @JsonProperty("loggedin")
    private long loggedIn;

    public long getCreated() {
        return created;
    }

    public long getLoggedIn() {
        return loggedIn;
    }
}