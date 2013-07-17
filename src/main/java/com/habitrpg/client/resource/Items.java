package com.habitrpg.client.resource;

import java.util.Collection;

public class Items {

    private int armor;
    private int head;
    private Collection<String> pets;
    private int shield;
    private int weapon;

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
}