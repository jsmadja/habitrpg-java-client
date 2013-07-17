package com.habitrpg.client;

import com.habitrpg.client.resource.Task;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;

import java.io.IOException;

import static org.fest.assertions.Assertions.assertThat;

public class TaskUnmarshallerTest {

    private ObjectMapper mapper = new ObjectMapper();

    @Test
    public void should_unmarshall_task() throws IOException {
        String response = "{\n" +
                "    \"text\": \"from the api!\",\n" +
                "    \"type\": \"todo\",\n" +
                "    \"completed\": false,\n" +
                "    \"id\": \"7f4814d8-7a46-4eaa-a024-5f0b70178d05\"\n" +
                "}";

        Task task = mapper.readValue(response, Task.class);
        assertThat(task.getText()).isEqualTo("from the api!");
        assertThat(task.getType()).isEqualTo(Task.Type.todo);
        assertThat(task.isCompleted()).isFalse();
        assertThat(task.getId()).isEqualTo("7f4814d8-7a46-4eaa-a024-5f0b70178d05");
    }

    @Test
    public void should_unmarshall_completed_task() throws IOException {
        String response = "{\n" +
                "    \"text\": \"from the api!\",\n" +
                "    \"type\": \"daily\",\n" +
                "    \"completed\": true,\n" +
                "    \"id\": \"7f4814d8-7a46-4eaa-a024-5f0b70178d05\"\n" +
                "}";

        Task task = mapper.readValue(response, Task.class);
        assertThat(task.getText()).isEqualTo("from the api!");
        assertThat(task.getType()).isEqualTo(Task.Type.daily);
        assertThat(task.isCompleted()).isTrue();
        assertThat(task.getId()).isEqualTo("7f4814d8-7a46-4eaa-a024-5f0b70178d05");
    }
}
