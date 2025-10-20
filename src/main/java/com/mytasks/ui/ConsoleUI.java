package com.mytasks.ui;
//package main.java.com.ui;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

import com.mytasks.model.*;
import com.mytasks.service.*;

public class ConsoleUI {
    private TaskManager taskManager;
    private Scanner scanner = new Scanner(System.in);

    public ConsoleUI(TaskManager tm){
        this.taskManager = tm;
    }

    public void start(){
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
            case 3 -> viewTask();  // delete tasks
            case 4 -> {
                System.out.println("Goodbye!");
                return;
            }
            default -> System.out.println("Invalid Choice");
        }
    }

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
}
