package com.habitrpg.client.resource;

public class Task {

    private Direction direction = Direction.up;
    private Status status = Status.INCOMPLETE;
    private String notes = "";
    private int value;
    private String text;
    private Type type;
    private String id;
    private boolean completed;
    private boolean up;
    private boolean down;
    private Repeat repeat;

    Task() {
    }

    public Task(String text, Type type) {
        this.text = text;
        this.type = type;
    }

    public Task(String text, Type type, int value, String notes, Status status, Direction direction) {
        this(text, type);
        this.value = value;
        this.notes = notes;
        this.status = status;
        this.direction = direction;
    }

    public String getId() {
        return id;
    }

    public boolean isCompleted() {
        return completed || status == Task.Status.COMPLETED;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        if (id != null ? !id.equals(task.id) : task.id != null) return false;
        return true;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    public String getNotes() {
        return notes;
    }

    public Direction getDirection() {
        return direction;
    }

    public String getText() {
        return text;
    }

    public Type getType() {
        return type;
    }

    public int getValue() {
        return value;
    }

    public boolean isUp() {
        return up;
    }

    public boolean isDown() {
        return down;
    }

    public Repeat getRepeat() {
        return repeat;
    }

    public enum Direction {
        up, down;
    }

    public enum Status {
        COMPLETED, INCOMPLETE;
    }

    public enum Type {
        todo,
        habit,
        daily,
        reward;
    }

}
