package com.habitrpg.client;

import com.habitrpg.client.resource.Answer;
import com.habitrpg.client.resource.Server;
import com.habitrpg.client.resource.Task;
import com.habitrpg.client.resource.User;
import org.junit.Rule;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

public class HabitRpgClientIT {

    @Rule
    public HabitRpgClientRule rule = new HabitRpgClientRule();

    @Test
    public void should_get_status() throws ResourceNotFoundException {
        Server.Status status = rule.client().getStatus();
        assertThat(status).isEqualTo(Server.Status.up);
    }

    @Test
    public void should_get_user() throws ResourceNotFoundException {
        User user = rule.client().getUser();
        assertThat(user).isNotNull();
    }

    @Test
    public void should_create_task() {
        Task task = rule.client().createTask(new Task("from the api!", Task.Type.todo));

        assertThat(task.getId()).matches("[a-f0-9]{8}-[a-f0-9]{4}-[a-f0-9]{4}-[a-f0-9]{4}-[a-f0-9]{12}");
        assertThat(task.isCompleted()).isFalse();
    }

    @Test
    public void should_create_task_with_optional() {
        Task task = rule.client().createTask(new Task("from the api!", Task.Type.todo, 1, "notes", Task.Status.COMPLETED, Task.Direction.down));

        assertThat(task.getId()).matches("[a-f0-9]{8}-[a-f0-9]{4}-[a-f0-9]{4}-[a-f0-9]{4}-[a-f0-9]{12}");
        assertThat(task.isCompleted()).isTrue();
        assertThat(task.getNotes()).isEqualTo("notes");
        assertThat(task.getDirection()).isEqualTo(Task.Direction.down);
    }

    @Test
    public void should_get_all_tasks() throws ResourceNotFoundException {
        Task task1 = rule.client().createTask(new Task("from the api!", Task.Type.todo));
        Task task2 = rule.client().createTask(new Task("from the api! no 2", Task.Type.todo));

        assertThat(rule.client().getTasks()).contains(task1, task2);
    }

    @Test
    public void should_get_all_todo_tasks() throws ResourceNotFoundException {
        Task task1 = rule.client().createTask(new Task("from the api!", Task.Type.todo));
        Task task2 = rule.client().createTask(new Task("from the api! no 2", Task.Type.daily));

        assertThat(rule.client().getTasks(Task.Type.todo)).contains(task1).isNotIn(task2);
    }

    @Test
    public void should_get_task_by_id() throws ResourceNotFoundException {
        Task task1 = rule.client().createTask(new Task("from the api!", Task.Type.todo));

        assertThat(rule.client().getTask(task1.getId())).isEqualTo(task1);
    }

    @Test
    public void should_update_task_direction() throws ResourceNotFoundException {
        Task task = rule.client().createTask(new Task("from the api!", Task.Type.todo));
        assertThat(rule.client().getTask(task.getId()).getDirection()).isEqualTo(Task.Direction.up);
        Answer answer = rule.client().updateTaskDirection(task.getId(), Task.Direction.down);
        assertThat(answer).isNotNull();
    }

    @Test
    public void should_update_task() {
        Task task = rule.client().createTask(new Task("from the api!", Task.Type.todo, 1, "notes", Task.Status.COMPLETED, Task.Direction.down));

        task = rule.client().updateTask(task.getId(), new Task("from the api! EDITED", Task.Type.daily, 2, "notes EDITED", Task.Status.INCOMPLETE, Task.Direction.up));

        assertThat(task.isCompleted()).isFalse();
        assertThat(task.getNotes()).isEqualTo("notes EDITED");
        assertThat(task.getDirection()).isEqualTo(Task.Direction.up);
        assertThat(task.getText()).isEqualTo("from the api! EDITED");
//        assertThat(task.getType()).isEqualTo(Task.Type.daily);
        assertThat(task.getValue()).isEqualTo(2);
    }

    @Test(expected = ResourceNotFoundException.class)
    public void should_delete_task() throws ResourceNotFoundException {
        Task task = rule.client().createTask(new Task("from the api!", Task.Type.todo));

        rule.client().deleteTask(task.getId());

        rule.client().getTask(task.getId());
    }
}
