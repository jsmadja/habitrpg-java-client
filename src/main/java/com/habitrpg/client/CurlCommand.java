package com.habitrpg.client;

import java.util.HashMap;
import java.util.Map;

public class CurlCommand {

    private String method = "GET";
    private Map<String, String> headers = new HashMap<String, String>();
    private String url;
    private String body;

    public CurlCommand post() {
        this.method = "POST";
        return this;
    }

    public CurlCommand put() {
        this.method = "PUT";
        return this;
    }

    public CurlCommand get() {
        this.method = "GET";
        return this;
    }

    public CurlCommand delete() {
        this.method = "DELETE";
        return this;
    }

    public CurlCommand withHeaders(Map<String, String> headers) {
        this.headers.putAll(headers);
        return this;
    }

    public CurlCommand build() {
        return this;
    }


    public CurlCommand withBody(String body) {
        this.body = body;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("curl --compressed -X ").append(method);
        for (Map.Entry<String, String> header : headers.entrySet()) {
            sb.append(" -H '").append(header.getKey()).append(": ").append(header.getValue()).append("'");
        }
        if(body != null) {
            sb.append(" -d '").append(body).append("'");
        }
        sb.append(" ").append(url);
        return sb.toString();
    }

    public CurlCommand withUrl(String url) {
        this.url = url;
        return this;
    }

}
