package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

public class ShowAccountantInfo extends JFrame implements ActionListener,Searchable{
   
    JTable table;
    JButton back;
    JComboBox<String> searchOptions;
    JTextField searchField;
    JLabel messageLabel;



    ShowAccountantInfo(){

        getContentPane().setBackground(new Color(255,242,215));
        setLayout(null);
       
        JLabel heading = new JLabel("ACCOUNTANT INFO");
        heading.setFont(new Font("Tahoma", Font.BOLD, 24));
        heading.setBounds(400, 5, 300, 30);
        add(heading);
        
        
        String[] options = {"Name", "Age", "Gender", "Degree","Designation", "Salary", "Phone", "Email", "NID No."};
        searchOptions = new JComboBox<>(options);
        searchOptions.setBounds(80, 30, 100, 20);
        searchOptions.setBackground(new Color(255,242,215));
        add(searchOptions);

        searchField = new JTextField();
        searchField.setBounds(200, 30, 150, 20);
        searchField.setBackground(new Color(255,242,215));
        add(searchField);

        messageLabel = new JLabel("");
        messageLabel.setBounds(380, 30, 200, 20);
        add(messageLabel);
        
         JLabel ls = new JLabel("Search By:");
        ls.setBounds(10, 30, 100, 20);
        add(ls);


        JLabel l1 = new JLabel("Name");
        l1.setBounds(40, 70, 100, 20);
        add(l1);

        JLabel l2 = new JLabel("Age");
        l2.setBounds(160, 70, 100, 20);
        add(l2);

        JLabel l3 = new JLabel("Gender");
        l3.setBounds(260, 70, 100, 20);
        add(l3);
        
        JLabel l4 = new JLabel("Degree");
        l4.setBounds(370, 70, 100, 20);
        add(l4);

        JLabel l5 = new JLabel("Designation");
        l5.setBounds(465, 70, 100, 20);
        add(l5);

        JLabel l6 = new JLabel("Salary");
        l6.setBounds(590, 70, 100, 20);
        add(l6);

        JLabel l7 = new JLabel("Phone");
        l7.setBounds(695, 70, 100, 20);
        add(l7);

        JLabel l8 = new JLabel("Email");
        l8.setBounds(810, 70, 100, 20);
        add(l8);

        JLabel l9 = new JLabel("NID No.");
        l9.setBounds(910, 70, 100, 20);
        add(l9);


        table = new JTable();
        table.setBounds(10, 100, 980, 400);
        table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        table.setBackground(new Color(255,242,215));// Allow multiple row selection
        add(table);

        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from accountant");
            table.setModel(DbUtils.resultSetToTableModel(rs));

        }
        catch(Exception e){
            e.printStackTrace();;
        }

        back = new JButton("Back");
        back.setBackground(new Color(184,80,66));
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        back.setBounds(420, 500, 120, 30);
        add(back);
        
        
         searchField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                performSearch();
            }
        });


        setBounds(200, 200, 1000, 600);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        setVisible(false);
       new ShowAllTypesOfEmployeeInfo();
    }
    
    
     public int getColumnIndex(String columnName) {
        switch (columnName) {
            case "Name":
                return 0;
            case "Age":
                return 1;
            case "Gender":
                return 2;
            case "Degree":
                return 3;
            case "Designation":
                return 4;
            case "Salary":
                return 5;
            case "Phone":
                return 6;
            case "Email":
                return 7;
            case "NID No.":
                return 8;
            default:
                return -1;
        }
    }

    public void performSearch() {
        Searchable.super.performSearch(searchOptions, searchField, messageLabel, table);
    }

    public void searchAndHighlight(String searchOption, String searchText) {
        Searchable.super.searchAndHighlight(searchOption, searchText, messageLabel, table);
    }


    public static void main(String[] args) {
        new ShowAccountantInfo();
    }
}
