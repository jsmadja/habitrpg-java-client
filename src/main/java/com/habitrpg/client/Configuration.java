package com.habitrpg.client;

public class Configuration {

    private boolean failOnUnknownProperties;

    public boolean shouldFailOnUnknownProperties() {
        return failOnUnknownProperties;
    }

    public void setFailOnUnknownProperties(boolean failOnUnknownProperties) {
        this.failOnUnknownProperties = failOnUnknownProperties;
    }
}
