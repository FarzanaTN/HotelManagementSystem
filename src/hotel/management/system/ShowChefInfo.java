package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import net.proteanit.sql.*;

import javax.swing.table.DefaultTableModel;

public class ShowChefInfo extends JFrame implements ActionListener, Searchable {

    JTable table;
    JButton back;
    JComboBox<String> searchOptions;
    JTextField searchField;
    JButton searchButton;
    JLabel messageLabel;

    ShowChefInfo() {
        getContentPane().setBackground(new Color(255,242,215));
        setLayout(null);

        JLabel heading = new JLabel("Chef Info");
        heading.setFont(new Font("Tahoma", Font.BOLD, 24));
        heading.setBounds(430, 5, 200, 30);
        add(heading);

        String[] options = {"Name", "Age", "Gender", "Designation", "Salary", "Phone", "Email", "NID No."};
        searchOptions = new JComboBox<>(options);
        searchOptions.setBounds(110, 50, 100, 20);
        searchOptions.setBackground(new Color(255,242,215));
        add(searchOptions);

        searchField = new JTextField();
        searchField.setBounds(220, 50, 150, 20);
        searchField.setBackground(new Color(255,242,215));
        add(searchField);

        messageLabel = new JLabel("");
        messageLabel.setBounds(470, 50, 200, 20);
        add(messageLabel);

        JLabel ls = new JLabel("Search By:");
        ls.setBounds(40, 50, 100, 20);
        add(ls);

        JLabel  l1 = new JLabel("Name");
        l1.setBounds(40, 80, 100, 20);
        add(l1);

        JLabel l2 = new JLabel("Age");
        l2.setBounds(150, 80, 100, 20);
        add(l2);

        JLabel l3 = new JLabel("Gender");
        l3.setBounds(270, 80, 100, 20);
        add(l3);

        JLabel l4 = new JLabel("Designation");
        l4.setBounds(400, 80, 300, 20);
        add(l4);

        JLabel  l5 = new JLabel("Salary");
        l5.setBounds(520, 80, 100, 20);
        add(l5);

        JLabel  l6 = new JLabel("Phone");
        l6.setBounds(650, 80, 100, 20);
        add(l6);

        JLabel  l7 = new JLabel("Email");
        l7.setBounds(800, 80, 100, 20);
        add(l7);

        JLabel   l8= new JLabel("NID");
        l8.setBounds(900, 80, 100, 20);
        add(l8);

        // Add labels for other attributes here
        table = new JTable();
        table.setBounds(10, 110, 980, 400);
        table.setBackground(new Color(255,242,215));
        add(table);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from chef");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }

        back = new JButton("Back");
        back.setBackground(new Color(184,80,66));
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        back.setBounds(420, 520, 120, 30);
        add(back);

        searchField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                performSearch();
            }
        });

        setBounds(300, 150, 1000, 600);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == searchButton) {
            performSearch();
        } else if (ae.getSource() == back) {
            setVisible(false);
            new ShowAllTypesOfEmployeeInfo();
        }
    }

    public int getColumnIndex(String columnName) {
        switch (columnName) {
            case "Name":
                return 0;
            case "Age":
                return 1;
            case "Gender":
                return 2;
            case "Designation":
                return 3;
            case "Salary":
                return 4;
            case "Phone":
                return 5;
            case "Email":
                return 6;
            case "NID No.":
                return 7;
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
        new ShowChefInfo();
    }
}
