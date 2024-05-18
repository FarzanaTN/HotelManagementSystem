package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

public class ShowWaiterInfo extends JFrame implements ActionListener, Searchable{

    JTable table;
    JButton back;
    JComboBox<String> searchOptions;
    JTextField searchField;
    JButton searchButton;
    JLabel messageLabel;


    ShowWaiterInfo(){

        getContentPane().setBackground(new Color(255,242,215));
        setLayout(null);

        JLabel heading = new JLabel("WAITER INFO");
        heading.setFont(new Font("Tahoma", Font.BOLD, 24));
        heading.setBounds(480, 5, 200, 30);
        add(heading);

        String[] options = {"Name", "Age", "Gender", "Shift", "Assigned Table","Salary", "Phone", "Email", "NID No."};
        searchOptions = new JComboBox<>(options);
        searchOptions.setBounds(110, 50, 100, 20);
        searchOptions.setBackground(new Color(255,242,215));
        add(searchOptions);

        searchField = new JTextField();
        searchField.setBounds(220, 50, 150, 20);
        searchField.setBackground(new Color(255,242,215));
        add(searchField);

        messageLabel = new JLabel("");
        messageLabel.setBounds(390, 50, 200, 20);
        add(messageLabel);

        JLabel l1 = new JLabel("Name");
        l1.setBounds(80, 80, 100, 20);
        add(l1);

        JLabel l2 = new JLabel("Age");
        l2.setBounds(190, 80, 100, 20);
        add(l2);

        JLabel l3 = new JLabel("Gender");
        l3.setBounds(320, 80, 100, 20);
        add(l3);

        JLabel l4 = new JLabel("Shift");
        l4.setBounds(430, 80, 200, 20);
        add(l4);

        JLabel l5 = new JLabel("Assigned Table");
        l5.setBounds(545, 80, 700, 20);
        add(l5);

        JLabel l6 = new JLabel("Salary");
        l6.setBounds(700, 80, 100, 20);
        add(l6);

        JLabel l7 = new JLabel("Phone");
        l7.setBounds(820, 80, 100, 20);
        add(l7);

        JLabel l8 = new JLabel("Email");
        l8.setBounds(960, 80, 100, 20);
        add(l8);

        JLabel l9 = new JLabel("NID No.");
        l9.setBounds(1070, 80, 100, 20);
        add(l9);


        table = new JTable();
        table.setBounds(25, 110, 1150, 400);
        table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        table.setBackground(new Color(255,242,215));

        add(table);

        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from waiter");
            table.setModel(DbUtils.resultSetToTableModel(rs));

        }
        catch(Exception e){
            e.printStackTrace();;
        }

        searchField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                performSearch();
            }
        });

        back = new JButton("Back");
        back.setBackground(new Color(184,80,66));
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        back.setBounds(530, 530, 120, 30);
        add(back);

        setBounds(150, 200, 1200, 600);
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
            case "Shift":
                return 3;
            case "Assigned Table":
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

        new ShowWaiterInfo();
    }
}