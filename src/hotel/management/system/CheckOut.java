package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class CheckOut extends JFrame implements ActionListener, ItemListener {

    Choice ccustomer;
    JLabel lblroomnumber, lblcheckintime, lblcheckouttime;
    JButton back, checkout;

    CheckOut() {

        getContentPane().setBackground(new Color(255,242,215));
        setLayout(null);

        JLabel text = new JLabel("CHECK OUT");
        text.setBounds(350, 20, 200, 30);
        text.setForeground(Color.BLACK);
        text.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(text);

        JLabel lblid = new JLabel("Customer Id");
        lblid.setBounds(30, 80, 100, 30);
        add(lblid);

        ccustomer = new Choice();
        ccustomer.setBounds(150, 80, 150, 25);
        ccustomer.addItemListener(this);
        ccustomer.setBackground(new Color(255,242,215));// Add item listener
        add(ccustomer);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/tick.png"));
        Image i2 = i1.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel tick = new JLabel(i3);
        tick.setBounds(310, 80, 20, 20);
        add(tick);

        JLabel lblroom = new JLabel("Room Number");
        lblroom.setBounds(30, 130, 100, 30);
        add(lblroom);

        lblroomnumber = new JLabel();
        lblroomnumber.setBounds(150, 130, 100, 30);
        lblroomnumber.setBackground(new Color(255,242,215));
        add(lblroomnumber);

        JLabel checkintime = new JLabel("Check in Time");
        checkintime.setBounds(30, 180, 100, 30);
        add(checkintime);

        lblcheckintime = new JLabel();
        lblcheckintime.setBounds(150, 180, 200, 30);
        lblcheckintime.setBackground(new Color(255,242,215));
        add(lblcheckintime);

        JLabel lblcheckout = new JLabel("Check out Time");
        lblcheckout.setBounds(30, 230, 100, 30);
        add(lblcheckout);

        Date date = new Date();

        lblcheckouttime = new JLabel("" + date);
        lblcheckouttime.setBounds(150, 230, 200, 30);
        lblcheckouttime.setBackground(new Color(255,242,215));
        add(lblcheckouttime);

        checkout = new JButton("Check out");
        checkout.setBackground(new Color(141,155,106));
        checkout.setForeground(Color.WHITE);
        checkout.setBounds(170, 280, 120, 30);
        checkout.addActionListener(this);
        add(checkout);

        back = new JButton("Back");
        back.setBackground(new Color(184,80,66));
        back.setForeground(Color.WHITE);
        back.setBounds(30, 280, 120, 30);
        back.addActionListener(this);
        add(back);

        // Fetch customer IDs from the database and populate the Choice component
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer");
            while (rs.next()) {
                ccustomer.add(rs.getString("number"));
            }
            
            // If there's only one choice, fetch data for it directly
            if (ccustomer.getItemCount() == 1) {
                rs = c.s.executeQuery("select * from customer where number='" + ccustomer.getSelectedItem() + "'");
                if (rs.next()) {
                    lblroomnumber.setText(rs.getString("room"));
                    lblcheckintime.setText(rs.getString("checkintime"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/sixth.jpg"));
        Image i5 = i4.getImage().getScaledInstance(400, 250, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel image = new JLabel(i6);
        image.setBounds(350, 80, 400, 250);
        add(image);

        setBounds(300, 200, 800, 400);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == checkout) {

            String query1 = "delete from customer where number ='" + ccustomer.getSelectedItem() + "'";
            String query2 = "update room set availability='Available' where roomnumber ='" + lblroomnumber.getText() + "'";

            try {

                Conn c = new Conn();
                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);
                JOptionPane.showMessageDialog(null, "Customer Checked Out");
                setVisible(false);
                new Reception();

            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (ae.getSource() == back) {
            setVisible(false);
            new Reception();
        }
    }

    // Implementing the itemStateChanged method to fetch data for the selected customer
    public void itemStateChanged(ItemEvent e) {
        if (e.getSource() == ccustomer) {
            try {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery("select * from customer where number='" + ccustomer.getSelectedItem() + "'");
                if (rs.next()) {
                    lblroomnumber.setText(rs.getString("room"));
                    lblcheckintime.setText(rs.getString("checkintime"));
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new CheckOut();
    }
}
