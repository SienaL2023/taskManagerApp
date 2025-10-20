package com.mytasks.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import com.mytasks.model.Task;
import com.mytasks.util.JsonUtil;

public class TaskManager {
    // data controller
    // add, delete, modify, and contain all the tasks
    
    private List<Task> tasks = new ArrayList<>();
    private static final String FILE_PATH = "src/main/java/com/mytasks/storage/tasks.json";
    private AtomicInteger idCounter = new AtomicInteger();
    // atomic integer -> special integer used to generate unique (one of a kind) IDs

    public TaskManager(){
        tasks = JsonUtil.loadTasks(FILE_PATH);  // load all the tasks from json file into a list
        if(!tasks.isEmpty()){
            // give a counter ID to each task
            // find the highest id number, if none, set to 0
            int maxId = tasks.stream().mapToInt(Task::getID).max().orElse(0);
            idCounter.set(maxId + 1);
        }

    }

    public void addTask(Task task){
        task.setID(idCounter.getAndIncrement());
        tasks.add(task);
        saveTasks();
    }

    public void deleteTask(int id){
        // removeIf does a comparison
        // for each task t, check if its ID is equal to the incoming ID, remove if match
        tasks.removeIf(t -> t.getID() == id);
        saveTasks();
    }

    public List<Task> listTasks(){
        return tasks;
    }

    public void saveTasks(){
        JsonUtil.saveTasks(FILE_PATH, tasks);
    }
}
