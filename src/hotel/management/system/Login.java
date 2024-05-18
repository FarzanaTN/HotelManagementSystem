
package hotel.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {

    JLabel user, pass;
    JTextField t1;
    JPasswordField t2;
    JButton login, cancel;

    Login() {

        super("Login");

        setLayout(null);

        JLabel heading = new JLabel("LOGIN");
        heading.setFont(new Font("Tahoma", Font.BOLD, 25));
        heading.setBounds(250, 5, 150, 30);
        heading.setForeground(Color.black);
        add(heading);

        user = new JLabel("Username");
        user.setBounds(40, 60, 100, 30);
        user.setBackground(new Color(255,242,215));
        add(user);

        pass = new JLabel("Password");
        pass.setBounds(40, 130, 100, 30);
        pass.setBackground(new Color(255,242,215));
        add(pass);

        t1 = new JTextField();
        t1.setBounds(150, 60, 150, 30);
        t1.setBackground(new Color(255,242,215));
        add(t1);

        t2 = new JPasswordField();
        t2.setBounds(150, 130, 150, 30);
        t2.setBackground(new Color(255,242,215));
        add(t2);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/loginIcon.png"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(350, 40, 150, 150);
        add(l3);

        login = new JButton("Login");
        login.setBounds(340, 200, 120, 30);
        login.setFont(new Font("Tahoma", Font.BOLD, 15));
        login.addActionListener(this);
        login.setBackground(new Color(141,155,106));
        login.setForeground(Color.WHITE);
        add(login);

        cancel = new JButton("Cancel");
        cancel.setBounds(160, 200, 120, 30);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 15));
        cancel.setBackground(new Color(184,80,66));
        cancel.setForeground(Color.WHITE);
        add(cancel);

        cancel.addActionListener(this);

        getContentPane().setBackground(new Color(255,242,215));

        setVisible(true);
        setSize(600, 300);
        setLocation(500, 350);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == login) {

            String u = t1.getText();
            String p = new String(t2.getPassword());

            try {
                Conn c = new Conn();
                String query = "select * from login where username = '" + u + "'and password ='" + p + "'";

                ResultSet rs = c.s.executeQuery(query);

                if (rs.next()) {

                    setVisible(false);
                    new DashBoard();

                } else {
                    JOptionPane.showMessageDialog(null, "Invalid login");
                    setVisible(false);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (ae.getSource() == cancel) {
            setVisible(false);
        }

    }

    public static void main(String[] arg) {
        new Login();
    }
}
