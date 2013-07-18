package com.habitrpg.client.resource;


public class Flags {

    private boolean partyEnabled;
    private boolean itemsEnabled;
    private String ads;
    private boolean customizationsNotification;
    private boolean dropsEnabled;

    public boolean getPartyEnabled() {
        return partyEnabled;
    }

    public boolean getItemsEnabled() {
        return itemsEnabled;
    }

    public String getAds() {
        return ads;
    }

    public boolean isCustomizationsNotification() {
        return customizationsNotification;
    }

    public boolean isDropsEnabled() {
        return dropsEnabled;
    }
}