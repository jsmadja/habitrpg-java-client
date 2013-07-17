package com.habitrpg.client.resource;

public class Preferences {

    private Gender gender;
    private Skin skin;
    private Hair hair;
    private String armorSet;
    private int dayStart;
    private boolean showHelm;

    public Gender getGender() {
        return gender;
    }

    public Skin getSkin() {
        return skin;
    }

    public Hair getHair() {
        return hair;
    }

    public String getArmorSet() {
        return armorSet;
    }

    public int getDayStart() {
        return dayStart;
    }

    public boolean isShowHelm() {
        return showHelm;
    }

    public enum Gender {
        m
    }

    public enum Skin {white}

    public enum Hair {blond}
}