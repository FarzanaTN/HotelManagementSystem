package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class AddFood extends JFrame implements ActionListener {

    JTextField tfname, tfid, tfprice;

    JButton save,back;
    JComboBox cbfood;

    AddFood() {

        setLayout(null);

        JLabel heading = new JLabel("ADD FOOD INFO");
        heading.setFont(new Font("Tahoma", Font.BOLD, 24));
        heading.setBounds(350, 5, 500, 30);
        add(heading);

        JLabel lbid = new JLabel("ID");
        lbid.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lbid.setBounds(60, 100, 120, 30);
        add(lbid);

        tfid = new JTextField();
        tfid.setBounds(200, 100, 150, 30);
        tfid.setBackground(new Color(255,242,215));
        add(tfid);

        JLabel  lbname = new JLabel("Name");
        lbname.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lbname.setBounds(60, 160, 150, 30);
        add(lbname);

        tfname = new JTextField();
        tfname.setBounds(200, 160, 150, 30);
        tfname.setBackground(new Color(255,242,215));

        add(tfname);

        JLabel lblprince = new JLabel("Price");
        lblprince.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblprince.setBounds(60, 220, 150, 30);
        add(lblprince);

        tfprice = new JTextField();
        tfprice.setBounds(200, 220, 150, 30);
        tfprice.setBackground(new Color(255,242,215));

        add(tfprice);



        JLabel lblcatagory = new JLabel("Category");
        lblcatagory.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblcatagory.setBounds(60, 280, 150, 30);
        add(lblcatagory);

        String foodType[] = {"Snacks", "Dessert", "Main Course", "Drinks", "Sides", "Appetizer"};
        cbfood = new JComboBox(foodType);
        cbfood.setBackground(new Color(255,242,215));
        cbfood.setBounds(200, 280, 150, 30);
        add(cbfood);


        save = new JButton("Save");
        save.setBounds(500, 440, 150, 30);
        save.addActionListener(this);
        save.setBackground(new Color(141,155,106));
        save.setForeground(Color.WHITE);

        add(save);


        back = new JButton("Back");
        back.setBackground(new Color(184,80,66));
        back.setForeground(Color.white);
        back.addActionListener(this);
        back.setBounds(200, 440, 150, 30);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/addfood2.png"));
        Image i3 = i1.getImage().getScaledInstance(450, 450, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel image = new JLabel(i2);
        image.setBounds(380, 60, 450, 370);
        add(image);

        getContentPane().setBackground(new Color(255,242,215));
        setBounds(350, 200, 850, 540);
        setVisible(true);

    }

    /*public void actionPerformed(ActionEvent ae) {

        if(ae.getSource()==save){
            String name = tfname.getText();
            String id = tfid.getText();
            String price = tfprice.getText();

            String gender = null;



            String category = (String) cbfood.getSelectedItem();

            try {

                Conn conn = new Conn();

                String query = "insert into allfood values( '" + id + "', '" + name + "', '" + price + "','" + category +"')";

                conn.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Food Added Successfully!!");

                setVisible(false);
                new FoodAddandShow();

            } catch (Exception e) {
                e.printStackTrace();
            }

        }else if(ae.getSource()==back){
            setVisible(false);
            new FoodAddandShow();

        }


    }*/
    private void validateFields() throws ValidationException {
        StringBuilder missingFields = new StringBuilder();
        if (tfname.getText().isEmpty()) {
            missingFields.append("Name, ");
        }
        if (tfid.getText().isEmpty() || !tfid.getText().matches("\\d+")) {
            missingFields.append("ID, ");
        }
        if (tfprice.getText().isEmpty() ||  !tfprice.getText().matches("\\d+")) {
            missingFields.append("Price, ");
        }
        if (!missingFields.isEmpty()) {
            missingFields.delete(missingFields.length() - 2, missingFields.length());
            throw new ValidationException("The following fields must be filled properly: " + missingFields.toString());
        }
    }

    public void actionPerformed(ActionEvent ae) {
        /*String name = tfname.getText();
        String id = tfid.getText();
        String price = tfprice.getText();

        String gender = null;



        String category = (String) cbfood.getSelectedItem();

        try {

            Conn conn = new Conn();

            String query = "insert into allfood values( '" + id + "', '" + name + "', '" + price + "','" + category +"')";

            conn.s.executeUpdate(query);

            JOptionPane.showMessageDialog(null, "Food Added Successfully!!");

            setVisible(false);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }*/
        if(ae.getSource() == save){
            try {
                validateFields();
                String name = tfname.getText();
                String id = tfid.getText();
                String price = tfprice.getText();
                String category = (String) cbfood.getSelectedItem();



                try {

                    Conn conn = new Conn();

                    String query = "insert into allfood values( '" + id + "', '" + name + "', '" + price + "','" + category +"')";

                    conn.s.executeUpdate(query);

                    JOptionPane.showMessageDialog(null, "Food Added Successfully!!");

                    setVisible(false);

                } catch (Exception e) {
                    e.printStackTrace();
                }

                setVisible(false);
            } catch (ValidationException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
        else{
            setVisible(false);
            new FoodAddandShow();
        }
         /*
        try {
            validateFields();
            String name = tfname.getText();
            String id = tfid.getText();
            String price = tfprice.getText();
            String category = (String) cbfood.getSelectedItem();



            try {

                Conn conn = new Conn();

                String query = "insert into allfood values( '" + id + "', '" + name + "', '" + price + "','" + category +"')";

                conn.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Food Added Successfully!!");

                setVisible(false);

            } catch (Exception e) {
                e.printStackTrace();
            }

            setVisible(false);
        } catch (ValidationException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    */

    }


    public static void main(String[] args) {

        new AddFood();
    }

}
