package com.habitrpg.client;

import static com.google.common.base.Preconditions.checkNotNull;

public class AuthenticationInformations {

    private String apiUser;
    private String apiKey;

    public AuthenticationInformations(String apiUser, String apiKey) {
        checkNotNull(apiUser);
        checkNotNull(apiKey);
        this.apiUser = apiUser;
        this.apiKey = apiKey;
    }

    public String getApiUser() {
        return apiUser;
    }

    public String getApiKey() {
        return apiKey;
    }
}
