package com.mytasks;

import java.time.LocalDateTime;

import com.mytasks.model.Priority;
import com.mytasks.model.Status;
import com.mytasks.model.Task;
import com.mytasks.service.TaskManager;
// import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.List;

import com.mytasks.ui.ConsoleUI;

public class App {
    public static void main(String[] args) throws Exception {
        TaskManager taskManager = new TaskManager();
        ConsoleUI ui = new ConsoleUI(taskManager);
        ui.start();
        
        // Task task = new Task(0, "Test", "Test Task", LocalDateTime.parse("2025-09-11T10:15"), Status.PENDING, Priority.LOW);
        // Task task1 = new Tas1k(1, "Test2", "Test Task", LocalDateTime.parse("2025-09-11T10:15"), Status.PENDING, Priority.LOW);

        // System.out.println(task.toString());
        // System.out.println(task1.toString());
        // taskManager.addTask(task);
        // taskManager.addTask(task1);
        // taskManager.deleteTask(1);

        // taskManager.deleteTask(0);

        // ObjectMapper mapper = new ObjectMapper();
        // List <String> data = mapper.readValue(new File("test.json"));
        // System.out.println("TEST");
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

// UI --> new task --> TaskManager --> Modify/updates/ json file