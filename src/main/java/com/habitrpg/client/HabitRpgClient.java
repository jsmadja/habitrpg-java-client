package com.habitrpg.client;

import com.habitrpg.client.resource.Answer;
import com.habitrpg.client.resource.Server;
import com.habitrpg.client.resource.Task;
import com.habitrpg.client.resource.User;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.String.format;

public class HabitRpgClient {

    private final URL serverUrl;

    private final RestClient restClient;

    public HabitRpgClient(URL serverUrl, AuthenticationInformations authenticationInformations) {
        this.serverUrl = serverUrl;
        this.restClient = new RestClient(withHeaders(authenticationInformations));
    }

    public HabitRpgClient(AuthenticationInformations authenticationInformations) {
        this("https://www.habitrpg.com", authenticationInformations);
    }

    public HabitRpgClient(String url, AuthenticationInformations authenticationInformations) {
        try {
            this.serverUrl = new URL(url);
            this.restClient = new RestClient(withHeaders(authenticationInformations));
        } catch (MalformedURLException e) {
            throw new IllegalArgumentException(e);
        }
    }

    private Map<String, String> withHeaders(AuthenticationInformations authenticationInformations) {
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("x-api-user", authenticationInformations.getApiUser());
        headers.put("x-api-key", authenticationInformations.getApiKey());
        headers.put("Accept-Encoding", "deflate, gzip");
        headers.put("Content-Type", "application/json");
        return headers;
    }

    public Server.Status getStatus() throws ResourceNotFoundException {
        return restClient.get(api("/status"), Server.class).getStatus();
    }

    public User getUser() throws ResourceNotFoundException {
        return restClient.get(api("/user"), User.class);
    }

    public Task createTask(Task task) {
        return restClient.post(task, api("/user/task"), Task.class);
    }

    public Task updateTask(String taskId, Task task) {
        return restClient.put(task, api("/user/task/" + taskId), Task.class);
    }

    public Answer updateTaskDirection(String taskId, Task.Direction direction) {
        return restClient.post(api(format("/user/tasks/%s/%s", taskId, direction.name())), Answer.class);
    }

    public Collection<Task> getTasks() throws ResourceNotFoundException {
        return restClient.getCollection(api("/user/tasks"), List.class, Task.class);
    }

    public Collection<Task> getTasks(Task.Type type) throws ResourceNotFoundException {
        return restClient.getCollection(api("/user/tasks?type=" + type.name()), List.class, Task.class);
    }

    public Task getTask(String id) throws ResourceNotFoundException {
        return restClient.get(api("/user/task/" + id), Task.class);
    }

    public void deleteTask(String taskId) {
        restClient.delete(api("/user/task/" + taskId));
    }

    private String api(String resource) {
        return serverUrl.toString() + "/api/v1" + resource;
    }

}
