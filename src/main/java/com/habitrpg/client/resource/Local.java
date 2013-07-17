package com.habitrpg.client.resource;

import org.codehaus.jackson.annotate.JsonProperty;

public class Local {

    private String username;
    private String email;
    private String salt;

    @JsonProperty("hashed_password")
    private String hashedPassword;

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getSalt() {
        return salt;
    }

    public String getHashedPassword() {
        return hashedPassword;
    }

}