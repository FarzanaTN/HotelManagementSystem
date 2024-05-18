package hotel.management.system;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import net.proteanit.sql.*;

import javax.swing.table.DefaultTableModel;

public class ShowFoodList extends JFrame implements ActionListener,Searchable {

    JTable table;
    JButton back;
    JComboBox<String> searchOptions;
    JTextField searchField;
    JButton searchButton;
    JLabel messageLabel;

    ShowFoodList() {
        getContentPane().setBackground(new Color(255,242,215));
        setLayout(null);

        JLabel heading = new JLabel("ALL FOOD INFO");
        heading.setFont(new Font("Tahoma", Font.BOLD, 24));
        heading.setBounds(400, 5, 200, 30);
        add(heading);

        JLabel l1 = new JLabel("Search By:");
        l1.setBounds(40, 50, 100, 20);
        add(l1);

        String[] options = {"Id", "Name", "Price", "Category"};
        searchOptions = new JComboBox<>(options);
        searchOptions.setBounds(110, 50, 100, 20);
        searchOptions.setBackground(new Color(255,242,215));
        add(searchOptions);

        searchField = new JTextField();
        searchField.setBounds(220, 50, 150, 20);
        searchField.setBackground(new Color(255,242,215));
        add(searchField);

        messageLabel = new JLabel("");
        messageLabel.setBounds(400, 50, 200, 20);
        add(messageLabel);

        JLabel l2 = new JLabel("ID");
        l2.setBounds(100, 80, 100, 20);
        add(l2);

        l2 = new JLabel("Name");
        l2.setBounds(350, 80, 100, 20);
        add(l2);

        l2 = new JLabel("Price");
        l2.setBounds(550, 80, 100, 20);
        add(l2);

        l2 = new JLabel("Category");
        l2.setBounds(800, 80, 100, 20);
        add(l2);

        // Add labels for other attributes here
        table = new JTable();
        table.setBounds(10, 110, 980, 400);
        table.setBackground(new Color(255,242,215));
        add(table);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from allfood");
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

        setBounds(200, 200, 1030, 600);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == searchButton) {
            String searchOption = (String) searchOptions.getSelectedItem();
            String searchText = searchField.getText();
            searchAndHighlight(searchOption, searchText);
        } else if (ae.getSource() == back) {
            setVisible(false);
            new FoodAddandShow();
          //  new Reception();
        }
    }





    public int getColumnIndex(String columnName) {
        switch (columnName) {
            case "Id":
                return 0;
            case "Name":
                return 1;
            case "Price":
                return 2;
            case "Category":
                return 3;
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
        new ShowFoodList();
    }
}

