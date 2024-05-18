package hotel.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;



public class CustomerInfo extends JFrame implements ActionListener, Searchable{
    
    JTable table;
    JButton back;

    JComboBox<String> searchOptions;
    JTextField searchField;
    JLabel messageLabel;


    CustomerInfo(){

        getContentPane().setBackground(new Color(255,242,215));
        setLayout(null);

        JLabel heading = new JLabel("CUSTOMER INFO");
        heading.setFont(new Font("Tahoma", Font.BOLD, 24));
        heading.setBounds(400, 5, 300, 30);
        add(heading);

        String[] options = {"Number", "Name", "Gender", "Country","Room", "Deposit"};
        searchOptions = new JComboBox<>(options);
        searchOptions.setBounds(80, 50, 100, 20);
        searchOptions.setBackground(new Color(255,242,215));
        add(searchOptions);


        searchField = new JTextField();
        searchField.setBounds(200, 50, 150, 20);
        searchField.setBackground(new Color(255,242,215));
        add(searchField);

        messageLabel = new JLabel("");
        messageLabel.setBounds(380, 50, 200, 20);
        add(messageLabel);

        JLabel l1 = new JLabel("Document Type");
        l1.setBounds(10, 100, 100, 20);
        add(l1);

        JLabel l2 = new JLabel("Number");
        l2.setBounds(160, 100, 100, 20);
        add(l2);

        JLabel l3 = new JLabel("Name");
        l3.setBounds(290, 100, 100, 20);
        add(l3);

        JLabel l4 = new JLabel("Gender");
        l4.setBounds(410, 100, 100, 20);
        add(l4);

        JLabel l5 = new JLabel("Country");
        l5.setBounds(540, 100, 100, 20);
        add(l5);

        JLabel l6 = new JLabel("Room Number");
        l6.setBounds(640, 100, 100, 20);
        add(l6);

        JLabel l7 = new JLabel("Check in Time");
        l7.setBounds(760, 100, 100, 20);
        add(l7);

        JLabel l8 = new JLabel("Deposit");
        l8.setBounds(900, 100, 100, 20);
        add(l8);


        table = new JTable();
        table.setBounds(10, 130, 980, 400);
        table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        table.setBackground(new Color(255,242,215));// Allow multiple row selection
        add(table);

        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer");
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

        setBounds(300, 200, 1000, 600);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Reception();
    }

    public int getColumnIndex(String columnName) {
        switch (columnName) {
            case "Number":
                return 1;
            case "Name":
                return 2;
            case "Gender":
                return 3;
            case "Country":
                return 4;
            case "Room":
                return 5;
            case "Deposit":
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
        new CustomerInfo();
    }
}