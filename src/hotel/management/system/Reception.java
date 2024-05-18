package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Reception extends JFrame implements ActionListener {

    JButton newCustomer, rooms, department, allEmployee, managerInfo, customers, checkOut,
            update, roomStatus, searchRoom, logout;

    Reception() {

        getContentPane().setBackground(new Color(255,242,215));
        setLayout(null);

        JLabel text = new JLabel("RECEPTION");
        text.setFont(new Font("Tahoma", Font.BOLD, 20));
        text.setBounds(350, 10, 200, 30);
        add(text);

        newCustomer = new JButton("New Customer");
        newCustomer.setBounds(10, 60, 200, 30);
        newCustomer.setBackground(new Color(141,155,106));
        newCustomer.setForeground(Color.WHITE);
        newCustomer.addActionListener(this);
        add(newCustomer);

        rooms = new JButton("Rooms");
        rooms.setBounds(10, 110, 200, 30);
        rooms.setBackground(new Color(141,155,106));
        rooms.setForeground(Color.WHITE);
        rooms.addActionListener(this);
        add(rooms);

        department = new JButton("Department");
        department.setBounds(10, 160, 200, 30);
        department.setBackground(new Color(141,155,106));
        department.setForeground(Color.WHITE);
        department.addActionListener(this);
        add(department);

        allEmployee = new JButton("All Employee");
        allEmployee.setBounds(10, 210, 200, 30);
        allEmployee.setBackground(new Color(141,155,106));
        allEmployee.setForeground(Color.WHITE);
        allEmployee.addActionListener(this);
        add(allEmployee);

        customers = new JButton("Customer Information");
        customers.setBounds(10, 260, 200, 30);
        customers.setBackground(new Color(141,155,106));
        customers.setForeground(Color.WHITE);
        customers.addActionListener(this);
        add(customers);

//        managerInfo = new JButton("Manager Information");
//        managerInfo.setBounds(10, 230, 200, 30);
//        managerInfo.setBackground(Color.BLACK);
//        managerInfo.setForeground(Color.WHITE);
//        managerInfo.addActionListener(this);
//        add(managerInfo);

        checkOut = new JButton("CheckOut");
        checkOut.setBounds(10, 310, 200, 30);
        checkOut.setBackground(new Color(141,155,106));
        checkOut.setForeground(Color.WHITE);
        checkOut.addActionListener(this);
        add(checkOut);

        update = new JButton("Update Customer Status");
        update.setBounds(10, 360, 200, 30);
        update.setBackground(new Color(141,155,106));
        update.setForeground(Color.WHITE);
        update.addActionListener(this);
        add(update);

        roomStatus = new JButton("Update Room Status");
        roomStatus.setBounds(10, 410, 200, 30);
        roomStatus.setBackground(new Color(141,155,106));
        roomStatus.setForeground(Color.WHITE);
        roomStatus.addActionListener(this);
        add(roomStatus);

//        pickUp = new JButton("PickUp Status");
//        pickUp.setBounds(10, 350, 200, 30);
//        pickUp.setBackground(Color.BLACK);
//        pickUp.setForeground(Color.WHITE);
//        pickUp.addActionListener(this);
//        add(pickUp);

        searchRoom = new JButton("Search Room");
        searchRoom.setBounds(10, 460, 200, 30);
        searchRoom.setBackground(new Color(141,155,106));
        searchRoom.setForeground(Color.WHITE);
        searchRoom.addActionListener(this);
        add(searchRoom);

        logout = new JButton("Logout");
        logout.setBounds(350, 530, 150, 30);
        logout.setBackground(new Color(184,80,66));
        logout.setForeground(Color.WHITE);
        logout.addActionListener(this);
        add(logout);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/reception.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(250, 60, 500, 450);
        add(image);

        setBounds(350, 200, 800, 620);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == newCustomer) {
            setVisible(false);
            new AddCustomer();
        } else if (ae.getSource() == rooms) {
            setVisible(false);
            new Room();
        } else if (ae.getSource() == department) {
            setVisible(false);
            new Department();
        } else if (ae.getSource() == allEmployee) {
            setVisible(false);
            new ShowAllTypesOfEmployeeInfo();

        } else if (ae.getSource() == managerInfo) {
            setVisible(false);
            new ShowManagerInfo();
        } else if (ae.getSource() == customers) {
            setVisible(false);
            new CustomerInfo();
        } else if (ae.getSource() == searchRoom) {
            setVisible(false);
            new SearchRoom();
        } else if (ae.getSource() == update) {
            setVisible(false);
            new UpdateCheck();
        }else if (ae.getSource() == roomStatus) {
            setVisible(false);
            new UpdateRoom();
        }else if (ae.getSource() == checkOut) {
            setVisible(false);
            new CheckOut();
        }else if (ae.getSource() == logout) {
            setVisible(false);
            System.exit(0);
          
        }
    }

    public static void main(String[] args) {
        new Reception();
    }
}
