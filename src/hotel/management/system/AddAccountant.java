package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class AddAccountant extends JFrame implements ActionListener {
    String name, age, gender,degree,designation,salary, phone, email, nid;
    JTextField tfname, tfage, tfsalary, tfphone, tfnid, tfemail;
    JRadioButton rbmale, rbfemale;
    JButton save;
    JComboBox cbdesignation,cbdegree;

    AddAccountant() {
        
        JLabel heading=new JLabel("ADD ACCOUNTANT");
        heading.setFont(new Font("Tahoma",Font.BOLD,25));
        heading.setBounds(450,0,300,30);
        heading.setForeground(Color.black);
        add(heading);

        setLayout(null);

        JLabel lblname = new JLabel("Name");
        lblname.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblname.setBounds(60, 50, 120, 30);
        add(lblname);

        tfname = new JTextField();
        tfname.setBounds(200, 50, 150, 30);
        tfname.setBackground(new Color(255,242,215));
        add(tfname);

        JLabel lblage = new JLabel("Age");
        lblage.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblage.setBounds(60, 100, 150, 30);
        add(lblage);

        tfage = new JTextField();
        tfage.setBounds(200, 100, 150, 30);
        tfage.setBackground(new Color(255,242,215));
        add(tfage);

        JLabel lblgender = new JLabel("Gender");
        lblgender.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblgender.setBounds(60, 150, 150, 30);
        add(lblgender);

        rbmale = new JRadioButton("Male");
        rbmale.setBackground(new Color(255,242,215));
        rbmale.setBounds(200, 150, 70, 30);
        add(rbmale);

        rbfemale = new JRadioButton("Female");
        rbfemale.setBackground(new Color(255,242,215));
        rbfemale.setBounds(270, 150, 90, 30);
        add(rbfemale);

        ButtonGroup bg = new ButtonGroup();
        bg.add(rbmale);
        bg.add(rbfemale);
        
        JLabel lbldegree = new JLabel("Degree");
        lbldegree.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lbldegree.setBounds(60, 200, 150, 30);
        add(lbldegree);

        String list[] = {"BSc", "MSc","MBA","BBA","Others"};
        cbdegree = new JComboBox(list);
        cbdegree.setBackground(new Color(255,242,215));
        cbdegree.setBounds(200, 200, 150, 30);
        add(cbdegree);

        JLabel lbljob = new JLabel("Designation");
        lbljob.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lbljob.setBounds(60, 250, 150, 30);
        add(lbljob);

        String course[] = {"Senior", "Junior"};
        cbdesignation = new JComboBox(course);
        cbdesignation.setBackground(new Color(255,242,215));
        cbdesignation.setBounds(200, 250, 150, 30);
        add(cbdesignation);

        JLabel lblslary = new JLabel("Salary");
        lblslary.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblslary.setBounds(60, 300, 120, 30);
        add(lblslary);

        tfsalary = new JTextField();
        tfsalary.setBounds(200, 300, 150, 30);
        tfsalary.setBackground(new Color(255,242,215));
        add(tfsalary);

        JLabel lblphone = new JLabel("Phone");
        lblphone.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblphone.setBounds(60, 350, 150, 30);
        add(lblphone);

        tfphone = new JTextField();
        tfphone.setBounds(200, 350, 150, 30);
        tfphone.setBackground(new Color(255,242,215));
        add(tfphone);

        JLabel lblnid = new JLabel("NID");
        lblnid.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblnid.setBounds(60, 400, 120, 30);
        add(lblnid);

        tfnid = new JTextField();
        tfnid.setBounds(200, 400, 150, 30);
        tfnid.setBackground(new Color(255,242,215));
        add(tfnid);

        JLabel lblemail = new JLabel("Email");
        lblemail.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblemail.setBounds(60, 450, 150, 30);
        add(lblemail);

        tfemail = new JTextField();
        tfemail.setBounds(200, 450, 150, 30);
        tfemail.setBackground(new Color(255,242,215));
        add(tfemail);

        save = new JButton("Save");
        save.setBounds(450, 500, 150, 30);
        save.addActionListener(this);
        save.setBackground(new Color(141,155,106));
        save.setForeground(Color.WHITE);

        add(save);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/accountant.jpg"));
        Image i3 = i1.getImage().getScaledInstance(612, 408, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel image = new JLabel(i2);
        image.setBounds(380, 60, 612, 408);
        add(image);

        getContentPane().setBackground(new Color(255,242,215));
        setBounds(250, 200, 1050, 590);
        setVisible(true);

    }
    //@Override
    /*public void actionPerformed(ActionEvent ae) {
        name = tfname.getText();
        age = tfage.getText();
        salary = tfsalary.getText();
        phone = tfphone.getText();
        nid = tfnid.getText();
        email = tfemail.getText();

         gender = null;

        if (rbmale.isSelected()) {
            gender = "Male";

        } else if (rbfemale.isSelected()) {
            gender = "Female";

        }

         degree = (String) cbdegree.getSelectedItem();
         designation = (String) cbdesignation.getSelectedItem();

      Accountant ac=new Accountant( name,  age,  gender,  degree,  designation,  salary,  phone,  email,  nid);
      ac.add();
      ac.addToEmployeeList();
      setVisible(false);
    }*/
    @Override
    public void actionPerformed(ActionEvent ae) {

        try {
            ValidityCheck.validateFields(tfname, tfage, rbmale, rbfemale, tfsalary, tfphone, tfemail, tfnid);
            name = tfname.getText();
            age = tfage.getText();
            gender = rbmale.isSelected() ? "Male" : (rbfemale.isSelected() ? "Female" : "");
            degree = (String) cbdegree.getSelectedItem();
            designation = (String) cbdesignation.getSelectedItem();

            salary = tfsalary.getText();
            phone = tfphone.getText();
            email = tfemail.getText();
            nid = tfnid.getText();

            Accountant ac = new Accountant(name, age, gender,degree,designation, salary, phone, email, nid);
            ac.add();
            ac.addToEmployeeList();
            setVisible(false);
            setVisible(false);
        } catch (ValidationException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }


    }


    public static void main(String[] args) {
        new AddAccountant();
        //am.add(name, age, gender, "Manager", salary, phone, email, nid);
    }

}