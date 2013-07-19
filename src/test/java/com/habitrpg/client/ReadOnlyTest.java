package com.habitrpg.client;

import com.habitrpg.client.resource.Task;
import org.junit.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collection;

public class ReadOnlyTest {

    @Test
    public void test() throws MalformedURLException, ResourceNotFoundException {
        String apiUser = System.getProperty("test.api.user");
        String apiKey = System.getProperty("test.api.key");
        if(apiUser == null || apiKey == null) {
            System.err.println("You should pass -Dtest.api.user=\"<your-api-user>\" -Dtest.api.key=\"<your-api-key>\" to validate client compatibility");
            return;
        }
        HabitRpgClient client = new HabitRpgClient(new AuthenticationInformations(apiUser, apiKey));
        client.getUser();
        client.getStatus();
        for (Task task : client.getTasks()) {
            client.getTask(task.getId());
        }
    }

}
