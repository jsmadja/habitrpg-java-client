package com.habitrpg.client.resource;

import java.util.Collection;

public class Profile {

    private String imageUrl;
    private String name;
    private Collection<String> websites;
    private String blurb;

    public String getImageUrl() {
        return imageUrl;
    }

    public String getName() {
        return name;
    }

    public Collection<String> getWebsites() {
        return websites;
    }

    public String getBlurb() {
        return blurb;
    }
}
