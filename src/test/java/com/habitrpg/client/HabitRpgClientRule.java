package com.habitrpg.client;

import com.habitrpg.client.resource.Task;
import org.junit.rules.ExternalResource;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class HabitRpgClientRule extends ExternalResource {

    private HabitRpgClient client;

    public HabitRpgClient client() {
        AuthenticationInformations authenticationInformations = new AuthenticationInformations("3de939f9-b0c0-4668-ac1c-f5a02abfe6aa", "56dbdfdd-a161-412d-a57c-1050639ce8e7");
        try {
            client = new HabitRpgClient(new URL("https://habitrpg.com"), authenticationInformations);
            return client;
        } catch (MalformedURLException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    protected void after() {
        try {
            List<Task> tasks = (ArrayList<Task>) client.getTasks();
            for (Task task : tasks) {
                client.deleteTask(task.getId());
            }
        } catch (ResourceNotFoundException e) {
            e.printStackTrace();
        }
    }
}
