package com.mytasks.ui;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.mytasks.service.NotificationMgr;
import com.mytasks.service.TaskManager;


public class GUI extends JFrame{
    private TaskManager taskManager;
    private NotificationMgr notificationMgr;

    public GUI(TaskManager tm, NotificationMgr nm){
        this.taskManager = tm;
        this.notificationMgr = nm;

        setTitle("Task Manager");
        setSize(600,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        initUI();

        // MAKE BUTTONS
        // add button
        JButton addBtn = new JButton("Add Task");
        addBtn.addActionListener(e -> taskManager.addTask(task));
        JButton viewBtn = new JButton("View Task");
        viewBtn.addActionListener(e -> taskManager.listTasks());
        JButton deleteBtn = new JButton("Delete Task");
        deleteBtn.addActionListener(e -> taskManager.deleteTask());  // delete based on row not ID
        // excel sheet
        JPanel bottomPanel = new JPanel(new BorderLayout(5,5));
        bottomPanel.add(addBtn, BorderLayout.WEST);
        bottomPanel.add(viewBtn, BorderLayout.CENTER);
        bottomPanel.add

    }

    JTable --> excel-like format
    JList -- select rows/list

    private void initUI(){
        // create the UI
        JPanel mainPanel = new JPanel(new BorderLayout());

        add(mainPanel);
    }

    private void addTaskRow(){
        JTextField field
    }
}
