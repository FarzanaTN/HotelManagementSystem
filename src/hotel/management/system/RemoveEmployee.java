package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RemoveEmployee extends JFrame implements ActionListener {

    JTextField tfnid;
    JComboBox<String> combotype;
    JButton remove, back;

    RemoveEmployee() {
        getContentPane().setBackground(new Color(255, 242, 215));
        setLayout(null);

        JLabel text = new JLabel("REMOVE EMPLOYEE");
        text.setBounds(320, 20, 260, 30);
        text.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(text);

        JLabel lblnid = new JLabel("NID");
        lblnid.setBounds(35, 150, 100, 20);
        lblnid.setFont(new Font("Raleway", Font.PLAIN, 20));
        add(lblnid);

        tfnid = new JTextField();
        tfnid.setBounds(200, 150, 150, 30);
        tfnid.setBackground(new Color(255, 242, 215));
        add(tfnid);


        JLabel lbltype = new JLabel("Type");
        lbltype.setBounds(35, 200, 100, 30);
        lbltype.setFont(new Font("Raleway", Font.PLAIN, 20));
        add(lbltype);

        String options[] = {"Manager", "Chef", "Accountant", "Receptionist", "Housekeeper", "Driver", "Waiter", "SecurityGuard"};
        combotype = new JComboBox<>(options);
        combotype.setBounds(200, 200, 150, 30);
        combotype.setBackground(new Color(255, 242, 215));
        add(combotype);


        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/remove.jpg"));
        Image i3 = i1.getImage().getScaledInstance(500, 500, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel image = new JLabel(i2);
        image.setBounds(420, 60, 450, 450);
        add(image);


        remove = new JButton("Remove");
        remove.setBounds(260, 400, 150, 30);
        remove.setForeground(Color.WHITE);
        remove.setBackground(new Color(184, 80, 66));
        remove.addActionListener(this);
        add(remove);

        back = new JButton("Back");
        back.setBounds(50, 400, 150, 30);
        back.setForeground(Color.WHITE);
        back.setBackground(new Color(141, 155, 106));
        back.addActionListener(this);
        add(back);



        setBounds(350, 200, 900, 600);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == remove) {
            String nid = tfnid.getText();
            String type = (String) combotype.getSelectedItem();
            try {
                Conn conn = new Conn();
                String query1 = "delete from employee where nid = '" + nid + "'";
                int rowsAffected1 = conn.s.executeUpdate(query1);
                String query2 = "delete from " + type.toLowerCase() + " where nid = '" + nid + "'";
                int rowsAffected2 = conn.s.executeUpdate(query2);

                if (rowsAffected1 > 0 && rowsAffected2 > 0) {
                    JOptionPane.showMessageDialog(null, type + " Deleted Successfully!!");
                } else {
                    JOptionPane.showMessageDialog(null, type + " Not Found!!");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == back) {
            // Implement back button functionality if needed
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new RemoveEmployee();
    }
}
