package com.mytasks.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.time.LocalDateTime;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.mytasks.model.Priority;
import com.mytasks.model.Status;
import com.mytasks.model.Task;
import com.mytasks.service.NotificationMgr;
import com.mytasks.service.TaskManager;


public class GUI extends JFrame{
    private TaskManager taskManager;
    private NotificationMgr notificationMgr;
    private String[] columnNames = {"ID", "Title", "Desc", "Deadline", "Status", "Prioity"};
    private DefaultTableModel taskTableModel;  // helps put in table format


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

        // String[][] data = {
        //      {"0", "Test", "11:05", "high"},
        //      {"1", "Test 1","11:07", "low"}
        //  };
        // String [] columnNames = {"ID", "Title", "Deadline", "Prioity"};

        Font newFont = new Font("Comic Sans MS", Font.PLAIN, 14);
        taskTableModel = new DefaultTableModel(columnNames, 0){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;  // override the editable method so u cant edit rows :)
            }
        };
        table = new JTable(taskTableModel);
        // table.SelectionMode(ListSelctionModel.SINGLESELECTION);
        
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


        // BUTTONS
        JButton addBtn = new JButton("Add Task");
        addBtn.setFont(newFont);        
        addBtn.addActionListener(e -> handleAddTask(e));

        // addBtn.addActionListener(e -> taskManager.addTask(task));
        JButton viewBtn = new JButton("View Task");
        viewBtn.setFont(newFont);
        // viewBtn.addActionListener(e -> taskManager.listTasks());

        JButton deleteBtn = new JButton("Delete Task");
        deleteBtn.setFont(newFont);
        // deleteBtn.addActionListener(e -> taskManager.deleteTask());  // delete based on row not ID
        table.getSelectedRow();

        JButton refreshBtn = new JButton("Refresh Task");
        refreshBtn.setFont(newFont);
        

        JPanel btnPanel = new JPanel(new FlowLayout());
        
        mainPanel.add(btnPanel, BorderLayout.SOUTH);
        btnPanel.add(addBtn, BorderLayout.WEST);
        btnPanel.add(viewBtn, BorderLayout.CENTER);
        btnPanel.add(deleteBtn, BorderLayout.EAST);
        btnPanel.add(refreshBtn, BorderLayout.EAST);

        btnPanel.setFont(newFont);
        add(mainPanel);

        
    }

    // to create a task
    private void handleAddTask(ActionEvent e){
        // diag table
        // list out everything u need (task name, description, deadline, priority)
        //      this will be a JTextField
        // add all that info into a list

        
        // words in the pop out window
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

         // options for pop out (cancel and ok)
        int option = JOptionPane.showConfirmDialog(titleField, message,"Add Task", JOptionPane.OK_CANCEL_OPTION);

        if(option == JOptionPane.OK_OPTION){
            // retrive values from textfield and combobox
            String title = titleField.getText();
            // we want it in local date time type
            LocalDateTime deadLine = LocalDateTime.parse(dlField.getText());
            String desc = descField.getText();
            Status status = Status.PENDING;
            Priority prior = (Priority)priBox.getSelectedItem();  // originally combo box
            
            // create new task with those values
            Task task = new Task(0, title, desc, deadLine, status, prior);
            
            taskManager.addTask(task);
            notificationMgr.scheduleReminder(task); // schedule

            loadTask();  
        }

    }

    // actually creates the new row with the task
    private void loadTask(){
        taskTableModel.setRowCount(0); // clears existing rows
        
        // holds the task made from handle task
        ArrayList<Task> tasks = (ArrayList<Task>)taskManager.listTasks(); 
        for(Task t: tasks){  // to go through all the tasks
            Object[] row = {
                t.getID(),
                t.getTitle(),
                t.getDescription(),
                t.getDeadLine(),
                t.getStatus(),
                t.getPriority()
            };

            // adds the task
            taskTableModel.addRow(row);
        }
    
    }

}
