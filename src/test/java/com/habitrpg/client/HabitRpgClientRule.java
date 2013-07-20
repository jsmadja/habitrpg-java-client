package com.habitrpg.client;

import com.habitrpg.client.resource.Task;
import org.junit.rules.ExternalResource;

public class HabitRpgClientRule extends ExternalResource {


    public static final AuthenticationInformations AUTHENTICATION_INFORMATIONS = new AuthenticationInformations("3de939f9-b0c0-4668-ac1c-f5a02abfe6aa", "56dbdfdd-a161-412d-a57c-1050639ce8e7");

    private HabitRpgClient client;

    public HabitRpgClient client() {
        Configuration configuration = new Configuration();
        configuration.setFailOnUnknownProperties(true);
        client = new HabitRpgClient(AUTHENTICATION_INFORMATIONS, configuration);
        return client;
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
