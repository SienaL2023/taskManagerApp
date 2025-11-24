package com.mytasks.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import com.mytasks.model.Priority;
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

        

    }

    // JTable --> excel-like format
    // JList -- select rows/list

    private void initUI(){
        // create the UI
        JPanel mainPanel = new JPanel(new BorderLayout());
        JTable table;

        String[][] data = {
             {"0", "Test", "11:05", "high"},
             {"1", "Test 1","11:07", "low"}
         };
        String [] columnNames = {"ID", "Title", "Deadline", "Prioity"};

        table = new JTable(data, columnNames);
        Font newFont = new Font("Comic Sans MS", Font.PLAIN, 14);
        table.setFont(newFont);
        JScrollPane scrollPane = new JScrollPane(table);
        mainPanel.add(scrollPane);

        // MAKE BUTTONS
        // add button

        // JFrame frame;
        // JTable table;

        // frame = new JFrame();
        // frame.setTitle("JTable Example");

        // // columns
        // // ID  Deadline  Urgency
        // // 0    11:05    high

        // String[][] data = {
        //     {"0", "11:05", "high"},
        //     {"1", "11:07", "low"}
        // };

        // String [] columnNames = {"ID", "Deadline", "Urgency"};

        // table = new JTable(data, columnNames);

        // JScrollPane scrollPane = new JScrollPane(table);
        // frame.add(scrollPane);
        // frame.setSize(600,600);
        // frame.setVisible(true);



        JButton addBtn = new JButton("Add Task");
        addBtn.setFont(newFont);
        // addBtn.addActionListener(e -> taskManager.addTask(task));
        JButton viewBtn = new JButton("View Task");
        viewBtn.setFont(newFont);
        // viewBtn.addActionListener(e -> taskManager.listTasks());

        JButton deleteBtn = new JButton("Delete Task");
        deleteBtn.setFont(newFont);
        // deleteBtn.addActionListener(e -> taskManager.deleteTask());  // delete based on row not ID
        table.getSelectedRow();
        

        JPanel btnPanel = new JPanel(new FlowLayout());
        
        mainPanel.add(btnPanel, BorderLayout.SOUTH);
        btnPanel.add(addBtn, BorderLayout.WEST);
        btnPanel.add(viewBtn, BorderLayout.CENTER);
        btnPanel.add(deleteBtn, BorderLayout.EAST);

        btnPanel.setFont(newFont);
        add(mainPanel);

        
    }


    private void addTaskRow(){
        // diag table:
        // list out everything u need (task name, description, deadline, priority)
        //      this will be a JTextField
        // add all that info into a list

        JTextField titleField = new JTextField();
        JTextField descField = new JTextField();
        JTextField dlField = new JTextField();
        JComboBox<Priority> priBox = new JComboBox<>(Priority.values());
         Object[] message = {
            "Title: ", titleField,
            "Desc: ", descField,
            "Deadline(YYYY-MM-DDTHH:mm): ", dlField,
            "Priority: ", priBox
         };

        JOptionPane.showConfirmDialog(titleField, message,"Add Task", JOptionPane.OK_CANCEL_OPTION);
    }
}
