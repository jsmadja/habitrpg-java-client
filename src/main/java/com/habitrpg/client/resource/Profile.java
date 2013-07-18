package com.habitrpg.client.resource;

import java.util.Collection;

public class Profile {

    private String imageUrl;
    private String name;
    private Collection<String> websites;

    public String getImageUrl() {
        return imageUrl;
    }

    public String getName() {
        return name;
    }

    public Collection<String> getWebsites() {
        return websites;
    }
}
