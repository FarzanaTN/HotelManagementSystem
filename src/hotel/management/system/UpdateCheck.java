package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class UpdateCheck extends JFrame implements ActionListener{

    Choice ccustomer;
    JTextField tfroom, tfname, tfcheckin, tfpaid, tfpending;
    JButton check, update, back;

    UpdateCheck(){

        getContentPane().setBackground(new Color(255,242,215));
        setLayout(null);

        JLabel text = new  JLabel("UPDATE CUSTOMER STATUS");
        text.setFont(new Font("Tahoma", Font.BOLD, 20));
        text.setBounds(350, 20, 300, 30);
        text.setForeground(Color.BLACK);
        add(text);

        JLabel lb1id = new  JLabel("Customer ID");
        lb1id.setBounds(30, 80, 100, 20);
        add(lb1id);

        ccustomer = new Choice();
        ccustomer.setBounds(200, 80, 150, 25);
        ccustomer.setBackground(new Color(255,242,215));
        add(ccustomer);

        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer");
            while(rs.next()){
                ccustomer.add(rs.getString("number"));
            }
        }
        catch(Exception e){
            e.printStackTrace();;
        }

        JLabel lb1room = new  JLabel("Room Number");
        lb1room.setBounds(30, 120, 100, 20);
        add(lb1room);

        tfroom = new JTextField();
        tfroom.setBounds(200, 120, 150, 25);
        tfroom.setBackground(new Color(255,242,215));
        add(tfroom);

        JLabel lb1name = new  JLabel("Name");
        lb1name.setBounds(30, 160, 100, 20);
        add(lb1name);

        tfname = new JTextField();
        tfname.setBounds(200, 160, 150, 25);
        tfname.setBackground(new Color(255,242,215));
        add(tfname);

        JLabel lb1checkin = new  JLabel("Check in Time");
        lb1checkin.setBounds(30, 200, 100, 20);
        add(lb1checkin);

        tfcheckin = new JTextField();
        tfcheckin.setBounds(200, 200, 150, 25);
        tfcheckin.setBackground(new Color(255,242,215));
        add(tfcheckin);

        JLabel lb1paid = new  JLabel("Amount Paid");
        lb1paid.setBounds(30, 240, 100, 20);
        add(lb1paid);

        tfpaid = new JTextField();
        tfpaid.setBounds(200, 240, 150, 25);
        tfpaid.setBackground(new Color(255,242,215));
        add(tfpaid);

        JLabel lb1pending = new  JLabel("Pending Amount");
        lb1pending.setBounds(30, 280, 100, 20);
        add(lb1pending);

        tfpending = new JTextField();
        tfpending.setBounds(200, 280, 150, 25);
        tfpending.setBackground(new Color(255,242,215));
        add(tfpending);

        check =  new JButton("Check");
        check.setBackground(new Color(184,80,66));
        check.setForeground(Color.WHITE);
        check.setBounds(270, 340, 100, 30);
        check.addActionListener(this);
        add(check);

        update =  new JButton("Update");
        update.setBackground(new Color(141,155,106));
        update.setForeground(Color.WHITE);
        update.setBounds(150, 340, 100, 30);
        update.addActionListener(this);
        add(update);

        back =  new JButton("Back");
        back.setBackground(new Color(184,80,66));
        back.setForeground(Color.WHITE);
        back.setBounds(30, 340, 100, 30);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/nine.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(400, 80, 500, 300);
        add(image);

        setBounds(200, 200, 950, 500);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae){
        if( ae.getSource() == check ){
            String id = ccustomer.getSelectedItem();
            String query = "select * from customer where number = '"+id+"'";

            try{
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);

                while (rs.next()) {
                    tfroom.setText(rs.getString("room"));
                    tfname.setText(rs.getString("name"));
                    tfcheckin.setText(rs.getString("checkintime"));
                    tfpaid.setText(rs.getString("deposit"));
                }

                ResultSet rs2 = c.s.executeQuery("select * from room where roomnumber = '"+tfroom.getText()+"'");
                while (rs2.next()) {
                    String price = rs2.getString("price");
                    int amountPaid = Integer.parseInt(price) - Integer.parseInt(tfpaid.getText());
                    tfpending.setText("" + amountPaid);
                }
            }
            catch(Exception e ){
                e.printStackTrace();
            }
        }
        else if( ae.getSource() == update){
            String number  = ccustomer.getSelectedItem();
            String room = tfroom.getText();
            String name = tfname.getText();
            String checkin = tfcheckin.getText();
            String deposit = tfpaid.getText();

            try{
                Conn c = new Conn();
                c.s.executeUpdate("update customer set room = '"+room+"', name = '"+name+"', checkintime = '"+checkin+"', deposit = '"+deposit+"' where number = '"+number+"'");


                JOptionPane.showMessageDialog(null, "Data Updated Successfully");
                //setVisible(false);
               // new Reception();
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
        new UpdateCheck();
    }
}