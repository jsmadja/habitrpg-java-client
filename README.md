habitrpg-java-client
====================

HabitRPG Java Client is very simple to use!

First, you have to create a client with your own key:

AuthenticationInformations authenticationInformations = new AuthenticationInformations("3de939f9-b0c0-4668-ac2c-f5a02abfe6aa", "56dbdfdd-a161-412d-a575-1050639ce8e7");
HabitRpgClient client = new HabitRpgClient(new URL("https://habitrpg.com"), authenticationInformations);

Then, you can call multiple operations to interact with your HabitRPG account:

Get user status
User user = client.getUser();

Create a new task
Task task = client.createTask(new Task("from the api!", Task.Type.todo));

Get all tasks
Collection<Task> tasks = client.getTasks();

Get all todo tasks
Collection<Task> tasks = client.getTasks(Task.Type.todo);

Get a task by id
Task task = client.getTask("bc8b6db0-2605-4943-bf18-114f628bb287");

Update a task
Task task = client.updateTask("bc8b6db0-2605-4943-bf18-114f628bb287", new Task("from the api! EDITED", Task.Type.daily, 2, "notes EDITED", Task.Status.INCOMPLETE, Task.Direction.up));

Delete a task
client.deleteTask("bc8b6db0-2605-4943-bf18-114f628bb287");
