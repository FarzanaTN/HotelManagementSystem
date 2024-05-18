
package hotel.management.system;


import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.util.Date;
import java.awt.event.*;

public class AddCustomer extends JFrame implements ActionListener{
    JComboBox comboid;
    JTextField tfnumber, tfname,tfcountry,tfdeposit;
    JRadioButton rmale,rfemale;
    Choice croom;
    JLabel checkintime;
    JButton add,back;

    AddCustomer() {

        getContentPane().setBackground(new Color(255,242,215));
        setLayout(null);

        JLabel text = new JLabel("NEW CUSTOMER FORM");
        text.setBounds(300, 20, 260, 30);
        text.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(text);

        JLabel lblid = new JLabel("ID");
        lblid.setBounds(35, 80, 100, 20);

        lblid.setFont(new Font("Raleway", Font.PLAIN, 20));
        add(lblid);

        String options[] = { "NID", "Passport", "Driving License" };
        comboid = new JComboBox(options);
        comboid.setBounds(200, 80, 150, 25);
        comboid.setBackground(new Color(255,242,215));
        add(comboid);

        JLabel lblnumber = new JLabel("Number");
        lblnumber.setBounds(35, 120, 100, 20);
        lblnumber.setFont(new Font("Raleway", Font.PLAIN, 20));
        add(lblnumber);

        tfnumber = new JTextField();
        tfnumber .setBounds(200, 120, 150, 25);
        tfnumber.setBackground(new Color(255,242,215));
        add(tfnumber);

        JLabel lblname = new JLabel("Name");
        lblname.setBounds(35, 160, 100, 20);
        lblname.setFont(new Font("Raleway", Font.PLAIN, 20));
        add(lblname);



        tfname = new JTextField();
        tfname.setBounds(200, 160, 150, 25);
        tfname.setBackground(new Color(255,242,215));
        add(tfname);


        JLabel lblgender = new JLabel("Gender");
        lblgender.setBounds(35, 200, 100, 20);
        lblgender.setFont(new Font("Raleway", Font.PLAIN, 20));
        add(lblgender);



        rmale=new JRadioButton("Male");
        rmale.setBackground(new Color(255,242,215));
        rmale.setBounds(200, 200, 60, 25);
        add(rmale);

        rfemale=new JRadioButton("Female");
        rfemale.setBackground(new Color(255,242,215));
        rfemale.setBounds(270, 200, 100, 25);
        add(rfemale);




        JLabel lblcountry = new JLabel("Country");
        lblcountry.setBounds(35, 240, 100, 20);
        lblcountry.setFont(new Font("Raleway", Font.PLAIN, 20));
        add(lblcountry);



        tfcountry = new JTextField();
        tfcountry.setBounds(200, 240, 150, 25);
        tfcountry.setBackground(new Color(255,242,215));
        add(tfcountry);




        JLabel lblroom = new JLabel("Room Number");
        lblroom.setBounds(35, 280, 150, 20);
        lblroom.setFont(new Font("Raleway", Font.PLAIN, 20));
        add(lblroom);

        croom = new Choice();

        try{

       Conn conn=new Conn();
       String query="select * from room where availability = 'Available' ";
       ResultSet rs=conn.s.executeQuery(query);

       while(rs.next()){
           croom.add(rs.getString("roomnumber"));
       }




        }catch(Exception e){
            e.printStackTrace();
        }



        croom.setBounds(200, 280, 150, 25);
        croom.setBackground(new Color(255,242,215));
        add(croom);


        JLabel lbltime = new JLabel("Check in Time");
        lbltime.setBounds(35, 360, 150, 20);
        lbltime.setFont(new Font("Raleway", Font.PLAIN, 20));
        add(lbltime);

        Date date=new Date();



         checkintime = new JLabel(""+date);
         checkintime.setBounds(200, 360, 250, 25);
         checkintime.setFont(new Font("Raleway", Font.PLAIN, 16));
         checkintime.setBackground(new Color(255,242,215));
        add(checkintime);



        JLabel lbldeposit = new JLabel("Deposit");
        lbldeposit.setBounds(35, 320, 100, 20);
        lbldeposit.setFont(new Font("Raleway", Font.PLAIN, 20));
        add(lbldeposit);



        tfdeposit = new JTextField();
        tfdeposit.setBounds(200, 320, 150, 25);
        tfdeposit.setBackground(new Color(255,242,215));
        add(tfdeposit);


        add=new JButton("Add");
        add.setBounds(230, 410, 120, 30);
        add.setBackground(new Color(141,155,106));
        add.setForeground(Color.WHITE);
        add.addActionListener(this);
        add(add);

        back=new JButton("Back");
        back.setBounds(50, 410, 120, 30);
        back.setBackground(new Color(184,80,66));
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/customer.jpg"));
        Image i2=i1.getImage().getScaledInstance(500, 450, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(450, 70, 500, 420);
        add(image);





        setBounds(350, 200, 1000, 550);
        setVisible(true);

    }

    private void validateFields() throws ValidationException {
        StringBuilder missingFields = new StringBuilder();
        if (tfnumber.getText().isEmpty() || !tfnumber.getText().matches("\\d+")) {
            missingFields.append("Number, ");
        }
        if (tfname.getText().isEmpty()) {
            missingFields.append("Name, ");
        }
        if (tfcountry.getText().isEmpty() || !tfcountry.getText().matches("[a-zA-Z]+")) {
            missingFields.append("Country, ");
        }
        if (tfdeposit.getText().isEmpty() || !tfdeposit.getText().matches("\\d+")) {
            missingFields.append("Deposite, ");
        }
        if (!missingFields.isEmpty()) {
            missingFields.delete(missingFields.length() - 2, missingFields.length());
            throw new ValidationException("The following fields must be filled properly: " + missingFields.toString());
        }
    }



    public void actionPerformed(ActionEvent ae){

        /*if(ae.getSource()==add){
            String id= (String) comboid.getSelectedItem();
            String number=tfnumber.getText();
            String name=tfname.getText();

            String gender=null;

            if(rmale.isSelected()){
                gender="Male";
            }else if(rfemale.isSelected()){
                gender="Female";
            }

            String country=tfcountry.getText();
            String room=croom.getSelectedItem();
            String time=checkintime.getText();
            String deposit=tfdeposit.getText();

            try{
                String query= "insert into customer values('"+id+"','"+number+"','"+name+"','"+gender+"','"+country+"','"+room+"','"+time+"','"+deposit+"')";
                String query2="update room set availability='Occupied' where room_Number= '" + room + "'";

                Conn conn=new Conn();
                conn.s.executeUpdate(query);
                conn.s.executeUpdate(query2);
                JOptionPane.showMessageDialog(null, "Customer Added Successfully");
                setVisible(false);
                new Reception();


            }catch(Exception e){
                e.printStackTrace();

            }



        }else if(ae.getSource()==back){

            setVisible(false);
            new Reception();


        }


         */
        if(ae.getSource() == add){
            try{
                validateFields();

                String id= (String) comboid.getSelectedItem();
                String number=tfnumber.getText();
                String name=tfname.getText();

                String gender=null;

                if(rmale.isSelected()){
                    gender="Male";
                }else if(rfemale.isSelected()){
                    gender="Female";
                }

                String country=tfcountry.getText();
                String room=croom.getSelectedItem();
                String time=checkintime.getText();
                String deposit=tfdeposit.getText();

                try{
                    String query= "insert into customer values('"+id+"','"+number+"','"+name+"','"+gender+"','"+country+"','"+room+"','"+time+"','"+deposit+"')";
                    String query2="update room set availability='Occupied' where roomnumber= '" + room + "'";

                    Conn conn=new Conn();
                    conn.s.executeUpdate(query);
                    conn.s.executeUpdate(query2);
                    JOptionPane.showMessageDialog(null, "Customer Added Successfully");
                    setVisible(false);
                    new Reception();


                }catch(Exception e){
                    e.printStackTrace();

                }
            } catch (ValidationException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
        else {
            setVisible(false);
            new Reception();
        }
    }

    public static void main(String[] args) {
        new AddCustomer();
    }
}
