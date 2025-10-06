package main.java.com.mytasks.util;
import java.util.ArrayList;
import java.util.List;

import main.java.com.mytasks.model.Task;
//import main.java.com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtil {
    // private static ObjectMapper mapper =  new ObjectMapper();
    public static void saveTasks(String path, List<Task> tasks){
        System.out.println("Task saved!!");
    }
    public static List<Task>loadTasks(String path){
        return new ArrayList<>();
    }
}
