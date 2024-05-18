package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

public class ShowManagerInfo extends JFrame implements ActionListener{
    
    JTable table;
    JButton back;


    ShowManagerInfo(){

        getContentPane().setBackground(new Color(255,242,215));
        setLayout(null);

        JLabel heading = new JLabel("MANAGER INFO");
        heading.setFont(new Font("Tahoma", Font.BOLD, 24));
        heading.setBounds(420, 3, 400, 30);
        add(heading);


        JLabel l1 = new JLabel("Name");
        l1.setBounds(40, 60, 100, 20);
        add(l1);

        JLabel l2 = new JLabel("Age");
        l2.setBounds(170, 60, 100, 20);
        add(l2);

        JLabel l3 = new JLabel("Gender");
        l3.setBounds(290, 60, 100, 20);
        add(l3);

        JLabel l4 = new JLabel("Job");
        l4.setBounds(400, 60, 100, 20);
        add(l4);

        JLabel l5 = new JLabel("Salary");
        l5.setBounds(540, 60, 100, 20);
        add(l5);

        JLabel l6 = new JLabel("Phone");
        l6.setBounds(670, 60, 100, 20);
        add(l6);

        JLabel l7 = new JLabel("Email");
        l7.setBounds(790, 60, 100, 20);
        add(l7);

        JLabel l8 = new JLabel("Address");
        l8.setBounds(910, 60, 100, 20);
        add(l8);


        table = new JTable();
        table.setBounds(0, 100, 1000, 400);
        table.setBackground(new Color(255,242,215));
        add(table);

        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from employee where job = 'Manager'");
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

        setBounds(250, 200, 1000, 600);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new ShowAllTypesOfEmployeeInfo();
    }

    public static void main(String[] args) {
        new ShowManagerInfo();
    }
}