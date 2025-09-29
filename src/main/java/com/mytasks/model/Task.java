package main.java.com.mytasks.model;

import java.time.LocalDateTime;

public class Task {
    private int id;
    private String title;
    private String description;
    private LocalDateTime deadline;
    private Status status;
    private Priority priority;

    public Task(int id, String title, String description, LocalDateTime deadline,
                Status status, Priority priority){
        this.id = id;
        this.description = description;
        this.deadline = deadline;
        this.status = status;
        this.priority = priority;


                
    
        }
        // getters and setters
        public int getID(){
                return id;
        }
        public void setID(int id){
                this.id = id;
        }

        public String getTitle(){
                return title;
        }

        public void setTitle(String title){
                this.title = title;
        }

        public LocalDateTime getDeadLine(){
                return deadline;
        }
        public void setDeadLine(LocalDateTime deadline){
                this.deadline = deadline;
        }

        public Status getStatus(){
                return status;
        }
        public void setStatus(Status status){
                this.status = status;
        }
         
        public Priority getPriority(){
                return priority;
        }
        public void setPriority(Priority priority){
                this.priority = priority;
        }

        @Override
        public String toString(){
                return"[" + id + "] "+ title+"(Due: " + deadline+", "+status+", "+priority+")";
                
        }
}
    

