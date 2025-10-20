package com.mytasks.util;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.mytasks.model.Task;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;


public class JsonUtil {
    private static ObjectMapper mapper =  new ObjectMapper();

    static{
        // register javatimemodeul to handle localdatetime
        mapper.registerModule(new JavaTimeModule());

        // disable timestamps so dates are written as ISO strings
        mapper.disable(com.fasterxml.jackson.databind.SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

    }
    public static void saveTasks(String path, List<Task> tasks){
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File(path), tasks);
            // java -> json
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static List<Task>loadTasks(String path){
        try {
            return mapper.readValue(new File(path), new TypeReference<List<Task>>() {});
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }
}
