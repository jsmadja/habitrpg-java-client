package com.habitrpg.client.resource;

public class Server {

    private Status status;

    public Status getStatus() {
        return status;
    }

    public enum Status {
        down,
        up
    }
}