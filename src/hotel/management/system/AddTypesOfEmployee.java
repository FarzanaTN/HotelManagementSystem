/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.management.system;


import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.event.*;
import java.sql.*;

/**
 *
 * @author ASUS
 */
public class AddTypesOfEmployee extends JFrame implements ActionListener {
    
    
     JButton addManager, addChef, addAccountants, addReceptionist, addHousekeeper, addDriver, addWaiter,
            addSecurityGuard, back;
    
    AddTypesOfEmployee(){
         getContentPane().setBackground(new Color(255,242,215));
        setLayout(null);
        
        JLabel text = new JLabel("ADD EMPLOYEE");
        text.setFont(new Font("Tahoma", Font.BOLD, 20));
        text.setBounds(350, 10, 200, 30);
        add(text);

        addManager = new JButton("As Manager");
        addManager.setBounds(30, 70, 200, 30);
        addManager.setBackground(new Color(141,155,106));
        addManager.setForeground(Color.WHITE);
        addManager.addActionListener(this);
        add(addManager);

        addChef = new JButton("As Chef");
        addChef.setBounds(60, 120, 200, 30);
        addChef.setBackground(new Color(141,155,106));
        addChef.setForeground(Color.WHITE);
        addChef.addActionListener(this);
        add(addChef);

        addAccountants = new JButton("As Accountant");
        addAccountants.setBounds(30, 170, 200, 30);
        addAccountants.setBackground(new Color(141,155,106));
        addAccountants.setForeground(Color.WHITE);
       addAccountants.addActionListener(this);
        add(addAccountants);

        addReceptionist = new JButton("As Receptionist");
        addReceptionist.setBounds(60, 220, 200, 30);
        addReceptionist.setBackground(new Color(141,155,106));
        addReceptionist.setForeground(Color.WHITE);
        addReceptionist.addActionListener(this);
        add(addReceptionist);

        addHousekeeper = new JButton("As HouseKeeper");
        addHousekeeper.setBounds(30, 270, 200, 30);
        addHousekeeper.setBackground(new Color(141,155,106));
        addHousekeeper.setForeground(Color.WHITE);
       addHousekeeper.addActionListener(this);
        add(addHousekeeper);

        addDriver = new JButton("As Driver");
        addDriver.setBounds(60, 320, 200, 30);
        addDriver.setBackground(new Color(141,155,106));
        addDriver.setForeground(Color.WHITE);
       addDriver.addActionListener(this);
        add(addDriver);

        addWaiter = new JButton("As Waiter");
        addWaiter.setBounds(30, 370, 200, 30);
        addWaiter.setBackground(new Color(141,155,106));
        addWaiter.setForeground(Color.WHITE);
      addWaiter.addActionListener(this);
        add(addWaiter);

        addSecurityGuard = new JButton("As Security Guard");
        addSecurityGuard.setBounds(60, 420, 200, 30);
        addSecurityGuard.setBackground(new Color(141,155,106));
        addSecurityGuard.setForeground(Color.WHITE);
       addSecurityGuard.addActionListener(this);
        add(addSecurityGuard);

        back = new JButton("Back");
        back.setBounds(350, 470, 100, 30);
        back.setBackground(new Color(184,80,66));
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

       

       ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/tenth.jpg"));
        Image i3 = i1.getImage().getScaledInstance(450, 450, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel image = new JLabel(i2);
        image.setBounds(300, 60, 450, 370);
        add(image);

        setBounds(350, 200, 800, 570);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == addManager) {
            setVisible(false);
            new AddManager();
        } else if (ae.getSource() == addChef) {
            setVisible(false);
            new AddChef();
        } else if (ae.getSource() == addAccountants) {
            setVisible(false);
            new AddAccountant();
        } else if (ae.getSource() == addReceptionist) {
            setVisible(false);
            //new EmployeeInfo();
            new AddReceptionist();

        } else if (ae.getSource() == addHousekeeper) {
            setVisible(false);
            new AddHouseKeeper();

        } else if (ae.getSource() == addDriver) {
            setVisible(false);
            new AddDriver();


        } else if (ae.getSource() == addWaiter) {
            setVisible(false);
            new AddWaiter();

        } else if (ae.getSource() == addSecurityGuard) {
            setVisible(false);
            new AddSecurityGuard();

        }else if (ae.getSource() == back) {
            setVisible(false);


        }
    }

   
    
    
    public static void main(String []args){
        new AddTypesOfEmployee();
    }
    
}
