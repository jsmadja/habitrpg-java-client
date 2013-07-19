package com.habitrpg.client;

import com.habitrpg.client.resource.Task;
import org.junit.rules.ExternalResource;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class HabitRpgClientRule extends ExternalResource {


    public static final AuthenticationInformations AUTHENTICATION_INFORMATIONS = new AuthenticationInformations("3de939f9-b0c0-4668-ac1c-f5a02abfe6aa", "56dbdfdd-a161-412d-a57c-1050639ce8e7");

    private HabitRpgClient client;

    public HabitRpgClient client() {
        try {
            client = new HabitRpgClient(new URL("https://habitrpg.com"), AUTHENTICATION_INFORMATIONS);
            return client;
        } catch (MalformedURLException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    protected void after() {
        try {
            for (Task task : client.getTasks()) {
                client.deleteTask(task.getId());
            }
        } catch (ResourceNotFoundException e) {
            e.printStackTrace();
        }
    }
}
