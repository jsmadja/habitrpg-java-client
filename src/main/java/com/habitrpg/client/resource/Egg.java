package com.habitrpg.client.resource;

public class Egg {

    private String text;
    private String name;
    private int value;
    private String notes;
    private Type type;
    private String dialog;

    public String getText() {
        return text;
    }

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

    public String getNotes() {
        return notes;
    }

    public Type getType() {
        return type;
    }

    public String getDialog() {
        return dialog;
    }

    public enum Type {Egg}
}
