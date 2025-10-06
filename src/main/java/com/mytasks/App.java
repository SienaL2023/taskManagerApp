package main.java.com.mytasks;

import java.time.LocalDateTime;

import main.java.com.mytasks.model.Priority;
import main.java.com.mytasks.model.Status;
import main.java.com.mytasks.model.Task;
import main.java.com.mytasks.service.TaskManager;
// import com.fasterxml.jackson.databind.ObjectMapper;

public class App {
    public static void main(String[] args) throws Exception {
        Task task = new Task(0, "Test", "sample entry", LocalDateTime.now(), Status.PENDING, Priority.LOW);
        Task task2 = new Task(2, null, null, null, null, null);
        // System.out.println(task.toString());
        TaskManager taskManager = new TaskManager();
        taskManager.addTask(task);
        taskManager.addTask(task2);
        taskManager.deleteTask(0);
    }
}

// taskmanager-app/
// │── src/
// │   └── main/
// │       └── java/
// │           └── com/
// │               └── mytasks/
// │                   ├── App.java
// │                   │
// │                   ├── model/
// │                   │   ├── Task.java
// │                   │   ├── Status.java
// │                   │   └── Priority.java
// │                   │
// │                   ├── service/
// │                   │   ├── TaskManager.java
// │                   │   ├── NotificationMgr.java
// │                   │   └── GoogleCalendarMgr.java
// │                   │
// │                   ├── util/
// │                   │   └── JsonUtil.java
// │                   │
// │                   ├── ui/
// │                   │   └── ConsoleUI.java
// │                   │
// │                   └── storage/
// │                       └── tasks.json   (store all the data, not code)