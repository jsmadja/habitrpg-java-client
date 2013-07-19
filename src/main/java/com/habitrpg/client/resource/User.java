package com.habitrpg.client.resource;

import java.util.Collection;
import java.util.Date;
import java.util.Map;

public class User {

    private int balance;
    private Auth auth;
    private Collection<String> dailyIds;
    private Flags flags;
    private Collection<String> habitIds;
    private Invitations invitations;
    private Items items;
    private Date lastCron;
    private Preferences preferences;
    private Collection<String> rewardIds;
    private Stats stats;
    private Collection<Tag> tags;
    private Map<String, Task> tasks;
    private Collection<String> todoIds;
    private String id;
    private History history;
    private Filters filters;
    private Profile profile;
    private Achievements achievements;

    public int getBalance() {
        return balance;
    }

    public Auth getAuth() {
        return auth;
    }

    public Collection<String> getDailyIds() {
        return dailyIds;
    }

    public Flags getFlags() {
        return flags;
    }

    public Collection<String> getHabitIds() {
        return habitIds;
    }

    public Invitations getInvitations() {
        return invitations;
    }

    public Items getItems() {
        return items;
    }

    public Date getLastCron() {
        return lastCron;
    }

    public Preferences getPreferences() {
        return preferences;
    }

    public Collection<String> getRewardIds() {
        return rewardIds;
    }

    public Stats getStats() {
        return stats;
    }

    public Collection<Tag> getTags() {
        return tags;
    }

    public Map<String, Task> getTasks() {
        return tasks;
    }

    public Collection<String> getTodoIds() {
        return todoIds;
    }

    public String getId() {
        return id;
    }

    public History getHistory() {
        return history;
    }

    public Filters getFilters() {
        return filters;
    }

    public Profile getProfile() {
        return profile;
    }

    public int getLevel() {
        return stats.getLvl();
    }

    public Achievements getAchievements() {
        return achievements;
    }
}
