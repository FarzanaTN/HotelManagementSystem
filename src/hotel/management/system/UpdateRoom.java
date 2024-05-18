package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class UpdateRoom extends JFrame implements ActionListener{

    Choice customer;
    JTextField tfroom, tfavailable, tfstatus, tfpaid, tfpending;
    JButton check, update, back;

    UpdateRoom(){

        getContentPane().setBackground(new Color(255,242,215));
        setLayout(null);

        JLabel text = new  JLabel("UPDATE ROOM STATUS");
        text.setFont(new Font("Tahoma", Font.BOLD, 20));
        text.setBounds(320, 20, 250, 30);
        text.setForeground(Color.BLACK);
        add(text);

        JLabel lb1id = new  JLabel("Customer ID");
        lb1id.setBounds(30, 80, 100, 20);
        add(lb1id);

        customer = new Choice();
        customer.setBounds(200, 80, 150, 25);
        customer.setBackground(new Color(255,242,215));
        add(customer);

        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer");
            while(rs.next()){
                customer.add(rs.getString("number"));
            }
        }
        catch(Exception e){
            e.printStackTrace();;
        }

        JLabel lb1roomno = new  JLabel("Room Number");
        lb1roomno.setBounds(30, 130, 100, 20);
        add(lb1roomno);

        tfroom = new JTextField();
        tfroom.setBounds(200, 130, 150, 25);
        tfroom.setBackground(new Color(255,242,215));
        add(tfroom);

        JLabel lb1available = new  JLabel("Availability");
        lb1available.setBounds(30, 180, 100, 20);
        add(lb1available);

        tfavailable = new JTextField();
        tfavailable.setBounds(200, 180, 150, 25);
        tfavailable.setBackground(new Color(255,242,215));
        add(tfavailable);

        JLabel lb1status = new  JLabel("Cleaning Status");
        lb1status.setBounds(30, 230, 100, 20);
        add(lb1status);

        tfstatus = new JTextField();
        tfstatus.setBounds(200, 230, 150, 25);
        tfstatus.setBackground(new Color(255,242,215));
        add(tfstatus);


        check =  new JButton("Check");
        check.setBackground(new Color(184,80,66));
        check.setForeground(Color.WHITE);
        check.setBounds(270, 300, 100, 30);
        check.addActionListener(this);
        add(check);

        update =  new JButton("Update");
        update.setBackground(new Color(141,155,106));
        update.setForeground(Color.WHITE);
        update.setBounds(150, 300, 100, 30);
        update.addActionListener(this);
        add(update);

        back =  new JButton("Back");
        back.setBackground(new Color(184,80,66));
        back.setForeground(Color.WHITE);
        back.setBounds(30, 300, 100, 30);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/seventh.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400, 80, 500, 280);
        add(image);

        setBounds(300, 200, 930, 450);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae){
        if( ae.getSource() == check ){
            String id = customer.getSelectedItem();
            String query = "select * from customer where number = '"+id+"'";

            try{
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);

                while (rs.next()) {
                    tfroom.setText(rs.getString("room"));

                }

                ResultSet rs2 = c.s.executeQuery("select * from room where roomnumber = '"+tfroom.getText()+"'");
                while (rs2.next()) {
                    tfavailable.setText(rs2.getString("availability"));
                    tfstatus.setText(rs2.getString("cleaning_status"));
                }
            }
            catch(Exception e ){
                e.printStackTrace();
            }
        }
        else if( ae.getSource() == update){
            String number  = customer.getSelectedItem();
            String room = tfroom.getText();
            String available = tfavailable.getText();
            String status = tfstatus.getText();


            try{
                Conn c = new Conn();
                c.s.executeUpdate("update room set availability = '"+available+"', cleaning_status = '"+status+"' where roomnumber = '"+room+"'");


                JOptionPane.showMessageDialog(null, "Data Updated Successfully");
                setVisible(false);
                new Reception();
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
        else {
            setVisible(false);
            new Reception();
        }
    }

    public static void main(String[] args) {
        new UpdateRoom();
    }
}