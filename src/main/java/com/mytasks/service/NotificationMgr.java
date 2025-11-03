package com.mytasks.service;

import java.awt.SystemTray;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import com.mytasks.model.Task;

public class NotificationMgr {
    // create a notificationn through terminal (print message)
    // TODO: windows popup message

    // threading (multithreading, same thing)

    //CPU/GPU
    // CPU - 8 cores (perform 8 seperate tasks without conflicting)
    // GPU - 1000s cores (each core can only do simple commands)
    
    private ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1); // how many cores does it use

    public void scheduleReminder(Task task){
        // long delay = Duration.between(LocalDateTime.now(),task.getDeadLine().minusMinutes(10)).toMillis();  // 10 mins before task deadline
        long delay = 5000;  // 5 seconds after u create task

        if(delay > 0){
            scheduler.schedule( () -> {  // scheduling the follow after _ delay in milliseconds
                System.out.println("Reminder: " + task.getTitle() + " is due at " + task.getDeadLine());
                showDesktopNotifications(task.getTitle(), "Message");
            }, delay, TimeUnit.MILLISECONDS);
        }
    }

    public void showDesktopNotifications(String title, String message){
        // SystemTray - library for windows to access the system settings
        try {
            if(!SystemTray.isSupported())return;
            
            SystemTray tray = SystemTray.getSystemTray();

            // TODO: TO BE COMPLETED TO SHOW DESKTOP NOTIF
            
        } catch (Exception e) {
            System.out.println("SystemTray not supported");

        }


    }

    public void shutdown(){
        scheduler.shutdown();
    }

}
