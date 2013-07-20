package com.habitrpg.client.unmarshalling;


import com.habitrpg.client.resource.Task;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.type.CollectionType;
import org.codehaus.jackson.map.type.SimpleType;
import org.codehaus.jackson.type.JavaType;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.fest.assertions.Assertions.assertThat;

public class TasksUnmarshallerTest {

    private String response = "[" +
            "{" +
                "\"type\":\"habit\"," +
                "\"text\":\"1h Productive Work\"," +
                "\"notes\":\"-- Habits: Constantly Track --\\nFor some habits, it only makes sense to *gain* points (like this one).\"," +
                "\"value\":0," +
                "\"up\":true," +
                "\"down\":false," +
                "\"id\":\"9e1a2381-783d-4f2d-9ea8-e0919c97cfab\"" +
            "}" +
            ",{\"type\":\"habit\",\"text\":\"Eat Junk Food\",\"notes\":\"For others, it only makes sense to *lose* points\",\"value\":0,\"up\":false,\"down\":true,\"id\":\"9a12be85-2d32-4e49-aad2-04566d537731\"},{\"type\":\"habit\",\"text\":\"Take The Stairs\",\"notes\":\"For the rest, both + and - make sense (stairs = gain, elevator = lose)\",\"value\":0,\"up\":true,\"down\":true,\"id\":\"a009d23f-a37f-4b44-a134-1eea86f35e84\"},{\"type\":\"todo\",\"text\":\"Call Mom\",\"notes\":\"-- Todos: Complete Eventually --\\nNon-completed Todos won't hurt you, but they will become more valuable over time. This will encourage you to wrap up stale Todos.\",\"value\":-3,\"completed\":false,\"id\":\"07bbd2c3-9de5-405b-b090-2851497d5d64\"},{\"completed\":false,\"direction\":\"up\",\"down\":false,\"id\":\"20bbb6a6-c5d5-4ef9-8191-2820e89907c3\",\"notes\":\"\",\"repeat\":null,\"text\":\"from the api!\",\"type\":\"todo\",\"up\":false,\"value\":-1},{\"direction\":\"up\",\"notes\":\"\",\"value\":0,\"text\":\"from the api!\",\"type\":\"todo\",\"id\":\"d1dbc1f8-b1ea-42bb-8fa0-76ce747f5ca7\",\"completed\":false,\"up\":false,\"down\":false,\"repeat\":null},{\"direction\":\"down\",\"notes\":\"notes\",\"value\":1,\"text\":\"from the api!\",\"type\":\"todo\",\"id\":\"923145af-e2ea-4b0c-88f2-68cca7877f30\",\"completed\":true,\"up\":false,\"down\":false,\"repeat\":null},{\"direction\":\"up\",\"notes\":\"\",\"value\":0,\"text\":\"from the api!\",\"type\":\"todo\",\"id\":\"8b90a281-44f4-4d71-984c-87bef25c9a65\",\"completed\":false,\"up\":false,\"down\":false,\"repeat\":null},{\"direction\":\"up\",\"notes\":\"\",\"value\":0,\"text\":\"from the api!\",\"type\":\"todo\",\"id\":\"e7e18ff1-b407-44b8-bccb-f3754076bf3c\",\"completed\":false,\"up\":false,\"down\":false,\"repeat\":null},{\"direction\":\"up\",\"notes\":\"\",\"value\":0,\"text\":\"from the api!\",\"type\":\"todo\",\"id\":\"576c0c00-1946-4dac-a3ee-d593f3615f11\",\"completed\":false,\"up\":false,\"down\":false,\"repeat\":null},{\"direction\":\"up\",\"notes\":\"\",\"value\":0,\"text\":\"from the api!\",\"type\":\"todo\",\"id\":\"4f1dcfbf-0888-4ef1-9bf3-f5b6e7fb2945\",\"completed\":false,\"up\":false,\"down\":false,\"repeat\":null},{\"direction\":\"up\",\"notes\":\"\",\"value\":0,\"text\":\"from the api!\",\"type\":\"todo\",\"id\":\"d4f6ad4d-ce7a-40bd-9bd6-f19aa4addd4d\",\"completed\":false,\"up\":false,\"down\":false,\"repeat\":null},{\"direction\":\"up\",\"notes\":\"\",\"value\":0,\"text\":\"from the api!\",\"type\":\"todo\",\"id\":\"bb41cab6-2985-420b-a1bf-c616fd0dfc48\",\"completed\":false,\"up\":false,\"down\":false,\"repeat\":null},{\"direction\":\"up\",\"notes\":\"\",\"value\":0,\"text\":\"from the api!\",\"type\":\"todo\",\"id\":\"bc3a5ddd-7b67-4bdd-9e52-345f13b40112\",\"completed\":false,\"up\":false,\"down\":false,\"repeat\":null},{\"direction\":\"up\",\"notes\":\"\",\"value\":0,\"text\":\"from the api!\",\"type\":\"todo\",\"id\":\"f82e0e05-1efa-4414-94d4-bf1a90d81c51\",\"completed\":false,\"up\":false,\"down\":false,\"repeat\":null},{\"direction\":\"up\",\"notes\":\"\",\"value\":0,\"text\":\"from the api!\",\"type\":\"todo\",\"id\":\"79c66bf2-54fa-4cf7-8dae-45678d298102\",\"completed\":false,\"up\":false,\"down\":false,\"repeat\":null},{\"direction\":\"up\",\"notes\":\"\",\"value\":0,\"text\":\"from the api!\",\"type\":\"todo\",\"id\":\"6428c065-67bf-4418-9afa-994cc34965e6\",\"completed\":false,\"up\":false,\"down\":false,\"repeat\":null},{\"direction\":\"up\",\"notes\":\"\",\"value\":0,\"text\":\"from the api!\",\"type\":\"todo\",\"id\":\"1f377fd5-f71f-43dd-a350-6e452089f668\",\"completed\":false,\"up\":false,\"down\":false,\"repeat\":null},{\"direction\":\"up\",\"notes\":\"\",\"value\":0,\"text\":\"from the api!\",\"type\":\"todo\",\"id\":\"7a6328e9-4a1e-4bde-bdda-423f241a111a\",\"completed\":false,\"up\":false,\"down\":false,\"repeat\":null},{\"type\":\"daily\",\"text\":\"1h Personal Project\",\"notes\":\"-- Dailies: Complete Once a Day --\\nAt the end of each day, non-completed Dailies dock you points.\",\"value\":0,\"completed\":false,\"repeat\":{\"m\":true,\"t\":true,\"w\":true,\"th\":true,\"f\":true,\"s\":true,\"su\":true},\"id\":\"a4636bda-31a3-4308-8662-3234ae48748e\"},{\"type\":\"daily\",\"text\":\"Exercise\",\"notes\":\"If you are doing well, they turn green and are less valuable (experience, gold) and less damaging (HP). This means you can ease up on them for a bit.\",\"value\":3,\"completed\":false,\"repeat\":{\"m\":true,\"t\":true,\"w\":true,\"th\":true,\"f\":true,\"s\":true,\"su\":true},\"id\":\"c1e4730b-1da6-4374-9294-75d06bd59086\"},{\"type\":\"daily\",\"text\":\"45m Reading\",\"notes\":\"But if you are doing poorly, they turn red. The worse you do, the more valuable (exp, gold) and more damaging (HP) these goals become. This encourages you to focus on your shortcomings, the reds.\",\"value\":-10,\"completed\":false,\"repeat\":{\"m\":true,\"t\":true,\"w\":true,\"th\":true,\"f\":true,\"s\":true,\"su\":true},\"id\":\"7f1d0492-f730-4de6-8e63-27b122767781\"},{\"type\":\"reward\",\"text\":\"1 Episode of Game of Thrones\",\"notes\":\"-- Rewards: Treat Yourself! --\\nAs you complete goals, you earn gold to buy rewards. Buy them liberally - rewards are integral in forming good habits.\",\"value\":20,\"id\":\"1a09a46b-47ef-4efc-a009-8ea80ba67be6\"},{\"type\":\"reward\",\"text\":\"Cake\",\"notes\":\"But only buy if you have enough gold - you lose HP otherwise.\",\"value\":10,\"id\":\"ae63088e-a804-4774-97a4-bccc86373f24\"}]\n";

    private ObjectMapper mapper = new ObjectMapper();

    @Test
    public void should_unmarshall_tasks() throws IOException {
        JavaType javaType = CollectionType.construct(List.class, SimpleType.construct(Task.class));
        List<Task> tasks = mapper.readValue(response, javaType);

        assertThat(tasks).hasSize(24);

        Task task = tasks.get(0);
        assertThat(task.getType()).isEqualTo(Task.Type.habit);
        assertThat(task.getText()).isEqualTo("1h Productive Work");
        assertThat(task.getNotes()).startsWith("-- Habits: Constantly Track --");
        assertThat(task.getValue()).isEqualTo(0);
        assertThat(task.isUp()).isTrue();
        assertThat(task.isDown()).isFalse();
        assertThat(task.getId()).isEqualTo("9e1a2381-783d-4f2d-9ea8-e0919c97cfab");
    }

}
