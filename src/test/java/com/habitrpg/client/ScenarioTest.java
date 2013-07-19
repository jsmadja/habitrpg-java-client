package com.habitrpg.client;

import com.habitrpg.client.resource.Stats;
import com.habitrpg.client.resource.Task;
import com.habitrpg.client.resource.User;
import org.junit.Test;

import java.util.Collection;

import static com.habitrpg.client.HabitRpgClientRule.AUTHENTICATION_INFORMATIONS;

public class ScenarioTest {

    @Test
    public void test() throws Exception {
        HabitRpgClient client = new HabitRpgClient("https://beta.habitrpg.com", AUTHENTICATION_INFORMATIONS);
        User user = client.getUser();
        int initialLevel = user.getLevel();
        Task task = taskToUpdate(client);
        int loop = 0;
        while (user.getLevel() < (initialLevel + 1)) {
            client.updateTaskDirection(task.getId(), Task.Direction.up);
            if (loop % 10 == 0) {
                user = client.getUser();
                System.err.println(toString(user));
            }
            loop++;
        }

    }

    private Task taskToUpdate(HabitRpgClient client) throws ResourceNotFoundException {
        Collection<Task> tasks = client.getTasks();
        Task task;
        if (tasks.isEmpty()) {
            task = client.createTask(new Task("my task", Task.Type.habit));
        } else {
            task = tasks.iterator().next();
        }
        return task;
    }

    private String toString(User user) {
        Stats stats = user.getStats();
        return "Level " + stats.getLvl() + ", EXP " + stats.getExp() + "/" + stats.getToNextLevel() +
                "\n" + user.getItems().getHatchingPotions().size() + " potions" +
                "\n" + user.getItems().getEggs().size() + " eggs";
    }

}
