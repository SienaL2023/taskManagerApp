package com.mytasks.ui;
//package main.java.com.ui;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

import com.mytasks.model.Priority;
import com.mytasks.model.Status;
import com.mytasks.model.Task;
import com.mytasks.service.NotificationMgr;
import com.mytasks.service.TaskManager;


public class ConsoleUI {
    private TaskManager taskManager;
    private Scanner scanner = new Scanner(System.in);
    private NotificationMgr notificationMgr;
    public ConsoleUI(TaskManager tm, NotificationMgr nm){
        this.taskManager = tm;
        this.notificationMgr = nm;
    }

    public void start(){
        while (true) { 
            System.out.println("\n=== Task Manager ===");
            System.out.println("1. Add Task");
            System.out.println("2. View Task");
            System.out.println("3. Delete Task");
            System.out.println("4. Exit");
            System.out.println("Choose: ");

            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice){
                case 1 -> addTask();
                case 2 -> viewTask();
                case 3 -> deleteTask();
                case 4 -> {
                    System.out.println("Goodbye!");
                    notificationMgr.shutdown();
                    return;
                }
                default -> System.out.println("Invalid Choice");
            }
        }}
            
    

    private void addTask(){
        System.out.print("Title: ");
        String title = scanner.nextLine();

        System.out.print("Description: ");
        String desc = scanner.nextLine();

        System.out.println("Deadline (yyyy-MM-ddTHH:mm): ");
        String deadlineStr = scanner.nextLine();
        LocalDateTime deadline = LocalDateTime.parse(deadlineStr);

        System.out.print("Priority (LOW, MEDIUM, HIGH): ");
        Priority priority = Priority.valueOf(scanner.nextLine());

        Task task = new Task(0, title, desc, deadline, Status.PENDING, priority);
        taskManager.addTask(task);
        notificationMgr.scheduleReminder(task);
        System.out.println("Task added!");
    }

    private void viewTask(){
        List<Task> tasks = taskManager.listTasks();
        if(tasks.isEmpty()){
            System.out.println("No tasks found.");
        }
        else{
            tasks.forEach(System.out::println);
        }
    }

    private void deleteTask(){
        // delete tasks based on ID number
        // ask for ID number
        // call deleteTask()
        System.out.print("Enter task ID to delete: ");
        int taskID = scanner.nextInt();
        scanner.nextLine();
        taskManager.deleteTask(taskID);
        System.out.println("Task deleted");
    }
}
