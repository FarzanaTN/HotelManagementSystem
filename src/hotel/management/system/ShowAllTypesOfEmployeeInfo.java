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

/**
 *
 * @author ASUS
 */
public class ShowAllTypesOfEmployeeInfo extends JFrame implements ActionListener {
    
    
     JButton Manager, Chef, Accountants, Receptionist, Housekeeper, Driver, Waiter,
            SecurityGuard,allEmployee, back;
    
    ShowAllTypesOfEmployeeInfo(){
         getContentPane().setBackground(new Color(255, 242, 215));
        setLayout(null);
        
        JLabel text = new JLabel("Details of Employees");
        text.setFont(new Font("Tahoma", Font.BOLD, 20));
        text.setBounds(320, 10, 250, 30);
        add(text);

        allEmployee = new JButton("All Employees");
        allEmployee.setBounds(30, 70, 200, 30);
        allEmployee.setBackground(new Color(141, 155, 106));
        allEmployee.setForeground(Color.WHITE);
        allEmployee.addActionListener(this);
        add(allEmployee);

        Manager = new JButton("Manager");
        Manager.setBounds(60, 120, 200, 30);
        Manager.setBackground(new Color(141, 155, 106));
        Manager.setForeground(Color.WHITE);
        Manager.addActionListener(this);
        add(Manager);

        Chef = new JButton("Chef");
        Chef.setBounds(30, 170, 200, 30);
        Chef.setBackground(new Color(141, 155, 106));
        Chef.setForeground(Color.WHITE);
       Chef.addActionListener(this);
        add(Chef);

        Accountants = new JButton("Accountant");
        Accountants.setBounds(60, 220, 200, 30);
        Accountants.setBackground(new Color(141, 155, 106));
        Accountants.setForeground(Color.WHITE);
        Accountants.addActionListener(this);
        add(Accountants);

        Receptionist = new JButton("Receptionist");
        Receptionist.setBounds(30, 270, 200, 30);
        Receptionist.setBackground(new Color(141, 155, 106));
        Receptionist.setForeground(Color.WHITE);
        Receptionist.addActionListener(this);
        add(Receptionist);

        Housekeeper = new JButton("HouseKeeper");
        Housekeeper.setBounds(60, 320, 200, 30);
        Housekeeper.setBackground(new Color(141, 155, 106));
        Housekeeper.setForeground(Color.WHITE);
       Housekeeper.addActionListener(this);
        add(Housekeeper);

        Driver = new JButton("Driver");
        Driver.setBounds(30, 370, 200, 30);
        Driver.setBackground(new Color(141, 155, 106));
        Driver.setForeground(Color.WHITE);
       Driver.addActionListener(this);
        add(Driver);

        Waiter = new JButton("Waiter");
        Waiter.setBounds(60, 420, 200, 30);
        Waiter.setBackground(new Color(141, 155, 106));
        Waiter.setForeground(Color.WHITE);
       Waiter.addActionListener(this);
        add(Waiter);


        SecurityGuard = new JButton("Security Guard");
        SecurityGuard.setBounds(30, 470, 200, 30);
        SecurityGuard.setBackground(new Color(141, 155, 106));
        SecurityGuard.setForeground(Color.WHITE);
        SecurityGuard.addActionListener(this);
        add(SecurityGuard);
        
        

        back = new JButton("Back");
        back.setBounds(450, 520, 100, 30);
        back.setBackground(new Color(184, 80, 66));
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

     

       ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/allemployeeinfo.png"));
        Image i3 = i1.getImage().getScaledInstance(600, 450, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel image = new JLabel(i2);
        image.setBounds(300, 60, 600, 450);
        add(image);

        setBounds(350, 150, 900, 600);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == allEmployee) {
            setVisible(false);
            new ShowAllEmployeeInfo();

        } else if (ae.getSource() == Manager) {
            setVisible(false);
            new ShowManagerInfo();

        } else if (ae.getSource() == Chef) {
            setVisible(false);
            new ShowChefInfo();

        } else if (ae.getSource() == Accountants) {
            setVisible(false);
            new ShowAccountantInfo();

        } else if (ae.getSource() == Receptionist) {
            setVisible(false);
           new ShowReceptionistInfo();
        } else if (ae.getSource() == Housekeeper) {

            setVisible(false);
            new ShowHouseKeeperInfo();

        } else if (ae.getSource() == Driver) {

            setVisible(false);
            new ShowDriverInfo();

        } else if (ae.getSource() == Waiter) {
            setVisible(false);
            new ShowWaiterInfo();

        }else if (ae.getSource() == SecurityGuard) {

            setVisible(false);
            new ShowSecurityGuardInfo();

        }else if (ae.getSource() == back) {
            setVisible(false);
            new Reception();

        }
    }

   
    
    
    public static void main(String []args){
        new ShowAllTypesOfEmployeeInfo();
    }
    
}
