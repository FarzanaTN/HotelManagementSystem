package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class AddRooms extends JFrame implements ActionListener{

    JButton add, cancel;
    JTextField tfroom, tfprice;
    JComboBox availableCombo, cleanCombo, tpyecombo;

    AddRooms(){

        getContentPane().setBackground(new Color(255,242,215));
        setLayout(null);

        JLabel heading = new JLabel("ADD ROOMS");
        heading.setFont(new Font("Tahoma", Font.BOLD, 25));
        heading.setBounds(400, 20, 200, 30);
        add(heading);

        JLabel lblroomNo = new JLabel("Room Number");
        lblroomNo.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblroomNo.setBounds(60, 80, 120, 30);
        add(lblroomNo);

        tfroom = new JTextField();
        tfroom.setBounds(200,80,150 , 30);
        tfroom.setBackground(new Color(255,242,215));
        add(tfroom);

        JLabel lblavailable = new JLabel("Available");
        lblavailable.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblavailable.setBounds(60, 130, 120, 30);
        add(lblavailable);

        String availableOptions[] = {"Available", "Occupied"};
        availableCombo = new JComboBox(availableOptions);
        availableCombo.setBounds(200,130 ,150 , 30);
        availableCombo.setBackground(new Color(255,242,215));
        add(availableCombo);

        JLabel lblclean = new JLabel("Cleaning Status");
        lblclean.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblclean.setBounds(60, 180, 120, 30);
        add(lblclean);

        String cleanOptions[] = {"Cleaned", "Not-Cleaned"};
        cleanCombo = new JComboBox(cleanOptions);
        cleanCombo.setBounds(200,180 ,150 , 30);
        cleanCombo.setBackground(new Color(255,242,215));
        add(cleanCombo);

        JLabel lblprice = new JLabel("Price");
        lblprice.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblprice.setBounds(60, 230, 120, 30);
        add(lblprice);

        tfprice = new JTextField();
        tfprice.setBounds(200,230,150,30);
        tfprice.setBackground(new Color(255,242,215));
        add(tfprice);

        JLabel lbltype = new JLabel("Bed Type");
        lbltype.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lbltype.setBounds(60, 280, 120, 30);
        add(lbltype);

        String typeOptions[] = {"Single Bed", "Double Bed"};
        tpyecombo = new JComboBox(typeOptions);
        tpyecombo.setBounds(200,280 ,150 , 30);
        tpyecombo.setBackground(new Color(255,242,215));
        add(tpyecombo);

         add = new JButton("Add Room");
        add.setForeground(Color.WHITE);
        add.setBackground(new Color(141,155,106));
        add.setBounds(230, 350, 130, 30);
        add.addActionListener(this);
        add(add);

        cancel = new JButton("Cancel");
        cancel.setForeground(Color.WHITE);
        cancel.setBackground(new Color(184,80,66));
        cancel.setBounds(60, 350, 130, 30);
        cancel.addActionListener(this);
        add(cancel);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/twelve.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(400,70, 500, 300);
        add(image);


        setBounds(330, 200, 940, 470);
        setVisible(true);
    }

    /*public void actionPerformed(ActionEvent ae){
        if( ae.getSource() == add ){
            String roomnumber = tfroom.getText();
            String availability = (String) availableCombo.getSelectedItem();
            String status = (String) cleanCombo.getSelectedItem();
            String price = tfprice.getText();
            String type = (String) tpyecombo.getSelectedItem();


            try{
                Conn conn = new Conn();
                String str = "insert into room values('"+roomnumber+"', '"+availability+"', '"+status+"', '"+price+"', '"+type+"')";
               
                conn.s.executeUpdate(str);

                JOptionPane.showMessageDialog(null, "New Room Added Successfully");

                setVisible(false);
            }
            catch (Exception e){
                e.printStackTrace();
            }
        } 
        else {
            setVisible(false);
        }
    }*/
    private void validateFields() throws ValidationException {
        StringBuilder missingFields = new StringBuilder();
        if (tfroom.getText().isEmpty() || !tfroom.getText().matches("\\d+")) {
            missingFields.append("Room Number, ");
        }
        if (tfprice.getText().isEmpty() || !tfprice.getText().matches("\\d+")) {
            missingFields.append("Price, ");
        }
        if (!missingFields.isEmpty()) {
            missingFields.delete(missingFields.length() - 2, missingFields.length());
            throw new ValidationException("The following fields must be filled properly: " + missingFields.toString());
        }
    }


    public void actionPerformed(ActionEvent ae){

        /*
        try {
            validateFields();
            if (ae.getSource() == add) {
                String roomnumber = tfroom.getText();
                String availability = (String) availableCombo.getSelectedItem();
                String status = (String) cleanCombo.getSelectedItem();
                String price = tfprice.getText();
                String type = (String) tpyecombo.getSelectedItem();


                try {
                    Conn conn = new Conn();
                    String str = "insert into room values('" + roomnumber + "', '" + availability + "', '" + status + "', '" + price + "', '" + type + "')";

                    conn.s.executeUpdate(str);

                    JOptionPane.showMessageDialog(null, "New Room Added Successfully");

                    setVisible(false);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            else {
                setVisible(false);
            }
        }catch (ValidationException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

         */
        if( ae.getSource() == add){
            try {
                validateFields();
                if (ae.getSource() == add) {
                    String roomnumber = tfroom.getText();
                    String availability = (String) availableCombo.getSelectedItem();
                    String status = (String) cleanCombo.getSelectedItem();
                    String price = tfprice.getText();
                    String type = (String) tpyecombo.getSelectedItem();


                    try {
                        Conn conn = new Conn();
                        String str = "insert into room values('" + roomnumber + "', '" + availability + "', '" + status + "', '" + price + "', '" + type + "')";

                        conn.s.executeUpdate(str);

                        JOptionPane.showMessageDialog(null, "New Room Added Successfully");

                        setVisible(false);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

            }catch (ValidationException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
        else {
            setVisible(false);
        }
    }


    public static void main(String[] args) {
        new AddRooms();
    }
}