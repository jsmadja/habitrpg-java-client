package com.habitrpg.client.resource;

import java.util.Collection;

public class Items {

    private int armor;
    private int head;
    private Collection<String> pets;
    private int shield;
    private int weapon;
    private Collection<Egg> eggs;
    private Drop lastDrop;
    private Collection<String> hatchingPotions;

    public int getArmor() {
        return armor;
    }

    public int getHead() {
        return head;
    }

    public Collection<String> getPets() {
        return pets;
    }

    public int getShield() {
        return shield;
    }

    public int getWeapon() {
        return weapon;
    }

    public Collection<Egg> getEggs() {
        return eggs;
    }

    public Drop getLastDrop() {
        return lastDrop;
    }

    public Collection<String> getHatchingPotions() {
        return hatchingPotions;
    }
}