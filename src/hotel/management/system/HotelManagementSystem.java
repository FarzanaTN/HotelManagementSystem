package hotel.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class HotelManagementSystem extends JFrame implements ActionListener {

    HotelManagementSystem() {
        setSize( 1366, 670);
        setLocation(100, 100);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/11.jpg"));
        Image i2=i1.getImage().getScaledInstance(1366, 670, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);

        
        
        image.setBounds(0, 0, 1366, 670);
        add(image);
        
        
        
       

        JLabel text = new JLabel("HOTEL MANAGEMENT SYSTEM");
        text.setBounds(300, 20, 1000, 90);
        text.setForeground(Color.BLACK);
        text.setFont(new Font("Tahoma", Font.BOLD, 50));
        image.add(text);

        JButton next = new JButton("START");
        next.setBounds(1050, 520, 150, 50);
        next.setBackground(new Color(255,242,215));
        next.setForeground(Color.BLACK);
        next.setFont(new Font("Tahoma", Font.CENTER_BASELINE, 20));
        image.add(next);
        next.addActionListener(this);
        setVisible(true);

        while (true) {
            text.setVisible(false);
            try {
                Thread.sleep(500);
            } catch (Exception e) {
                e.printStackTrace();
            }
            text.setVisible(true);

            try {
                Thread.sleep(500);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }

    public void actionPerformed(ActionEvent a) {
        setVisible(false);
        new Login();
    }

    public static void main(String[] args) {
        new HotelManagementSystem();
    }

}
