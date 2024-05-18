package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DashBoard extends JFrame implements ActionListener {

    DashBoard() {
        setBounds(0, 0, 1550, 1000);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/dashboard.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1550, 1000, Image.SCALE_DEFAULT);

        ImageIcon i3 = new ImageIcon(i2);

        JLabel image = new JLabel(i3);

        image.setBounds(0, 0, 1550, 1000);
        add(image);

        JLabel text = new JLabel("WELCOME TO OUR HOTEL");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Tahoma", Font.PLAIN, 46));
        text.setBounds(500, 60, 1000, 85);
        image.add(text);

        JMenuBar mb = new JMenuBar();
        // setJMenuBar(mb);
        mb.setBounds(0, 0, 1550, 50);

        image.add(mb);

        JMenu h = new JMenu("HOTEL MANAGEMENT");
        h.setForeground(new Color(141,155,106));
        h.setFont(new Font("Tahoma", Font.BOLD, 24));
        mb.add(h);

        JMenuItem reception = new JMenuItem("RECEPTION");
        reception.setBackground(new Color(255,242,215));
        reception.addActionListener(this);

        h.add(reception);
        
        JMenuItem foodcorner = new JMenuItem("FOOD CORNER");
        foodcorner.setBackground(new Color(255,242,215));
        foodcorner.addActionListener(this);

        h.add(foodcorner);

        JMenu admin = new JMenu("ADMIN");
        admin.setForeground(new Color(141,155, 106));
        admin.setFont(new Font("Tahoma", Font.BOLD, 24));
        mb.add(admin);

        JMenuItem add_em = new JMenuItem("ADD EMPLOYEE");
        add_em.setBackground(new Color(255,242,215));
        add_em.addActionListener(this);
        admin.add(add_em);

        JMenuItem add_room = new JMenuItem("ADD ROOMS");
        add_room.setBackground(new Color(255,242,215));
        add_room.addActionListener(this);
        admin.add(add_room);

        JMenuItem rmv_em = new JMenuItem("REMOVE EMPLOYEE");
        rmv_em.addActionListener(this);
        rmv_em.setBackground(new Color(255,242,215));
        admin.add(rmv_em);



        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getActionCommand().equals("ADD EMPLOYEE")) {
            new AddTypesOfEmployee();
            // new AddEmployee();
        } else if (ae.getActionCommand().equals("ADD ROOMS")) {
            new AddRooms();
        } else if (ae.getActionCommand().equals("RECEPTION")) {
            new Reception();
        }else if (ae.getActionCommand().equals("FOOD CORNER")) {
            new FoodAddandShow();
        }else if (ae.getActionCommand().equals("REMOVE EMPLOYEE")) {
            new RemoveEmployee();
        }
    }

    public static void main(String[] args) {
        new DashBoard();
    }

}
