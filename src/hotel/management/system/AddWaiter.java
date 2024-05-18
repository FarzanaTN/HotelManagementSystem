package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class AddWaiter extends JFrame implements ActionListener {

    String name, age, gender, job, salary, phone, email, nid,assingedTable,time;
    JTextField tfname, tfage, tfsalary, tfphone, tfnid, tfemail;
    JRadioButton rbmale, rbfemale;
    JButton save;
    JComboBox cbtime, cbtable;

    AddWaiter() {

        JLabel heading = new JLabel("ADD WAITER");
        heading.setFont(new Font("Tahoma", Font.BOLD, 25));
        heading.setBounds(450, 0, 300, 30);
        heading.setForeground(Color.BLACK);
        add(heading);

        setLayout(null);

        JLabel lblname = new JLabel("Name");
        lblname.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblname.setBounds(60, 40, 120, 30);
        add(lblname);

        tfname = new JTextField();
        tfname.setBounds(200, 40, 150, 30);
        tfname.setBackground(new Color(255, 242, 215));
        add(tfname);

        JLabel lblage = new JLabel("Age");
        lblage.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblage.setBounds(60, 80, 150, 30);
        add(lblage);

        tfage = new JTextField();
        tfage.setBounds(200, 80, 150, 30);
        tfage.setBackground(new Color(255, 242, 215));
        add(tfage);

        JLabel lblgender = new JLabel("Gender");
        lblgender.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblgender.setBounds(60, 130, 150, 30);
        add(lblgender);

        rbmale = new JRadioButton("Male");
        rbmale.setBackground(new Color(255, 242, 215));
        rbmale.setBounds(200, 130, 70, 30);//200, 130, 70, 30
        add(rbmale);

        rbfemale = new JRadioButton("Female");
        rbfemale.setBackground(new Color(255, 242, 215));
        rbfemale.setBounds(270, 130, 90, 30);//280 130, 70, 30
        add(rbfemale);

        ButtonGroup bg = new ButtonGroup();
        bg.add(rbmale);
        bg.add(rbfemale);

        JLabel lbljob = new JLabel("Shift");
        lbljob.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lbljob.setBounds(60, 180, 150, 30);
        add(lbljob);

        String dutyTime[] = {"Day", "Night"};
        cbtime = new JComboBox(dutyTime);
        cbtime.setBackground(new Color(255, 242, 215));
        cbtime.setBounds(200, 180, 150, 30);
        add(cbtime);

        JLabel lbljob2 = new JLabel("Assigned Table");
        lbljob2.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lbljob2.setBounds(60, 230, 150, 30);
        add(lbljob2);

        String tableNo[] = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20"};
        cbtable = new JComboBox(tableNo);
        cbtable.setBackground(new Color(255, 242, 215));
        cbtable.setBounds(200, 230, 150, 30);
        add(cbtable);

        JLabel lblslary = new JLabel("Salary");
        lblslary.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblslary.setBounds(60, 280, 120, 30);
        add(lblslary);

        tfsalary = new JTextField();
        tfsalary.setBounds(200, 280, 150, 30);
        tfsalary.setBackground(new Color(255, 242, 215));
        add(tfsalary);

        JLabel lblphone = new JLabel("Phone");
        lblphone.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblphone.setBounds(60, 320, 150, 30);
        add(lblphone);

        tfphone = new JTextField();
        tfphone.setBounds(200, 320, 150, 30);
        tfphone.setBackground(new Color(255, 242, 215));
        add(tfphone);

        JLabel lblnid = new JLabel("NID");
        lblnid.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblnid.setBounds(60, 360, 120, 30);
        add(lblnid);

        tfnid = new JTextField();
        tfnid.setBounds(200, 360, 150, 30);
        tfnid.setBackground(new Color(255, 242, 215));

        add(tfnid);

        JLabel lblemail = new JLabel("Email");
        lblemail.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblemail.setBounds(60, 400, 150, 30);
        add(lblemail);

        tfemail = new JTextField();
        tfemail.setBounds(200, 400, 150, 30);
        tfemail.setBackground(new Color(255, 242, 215));

        add(tfemail);

        save = new JButton("SAVE");
        save.setBounds(450, 500, 150, 30);
        save.addActionListener(this);
        save.setBackground(new Color(141, 155, 106));
        save.setForeground(Color.WHITE);

        add(save);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/waiter.jpg"));
        Image i3 = i1.getImage().getScaledInstance(612, 408, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel image = new JLabel(i2);
        image.setBounds(400, 60, 612, 408);
        add(image);

        getContentPane().setBackground(new Color(255, 242, 215));
        setBounds(200, 200, 1050, 600);
        setVisible(true);

    }

    /*@Override
    public void actionPerformed(ActionEvent ae) {
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

         time = (String) cbtime.getSelectedItem();
        assingedTable= (String) cbtime.getSelectedItem();

        Waiter waiter = new Waiter(name, age, gender, time, assingedTable, salary, phone, email, nid);

        waiter.add();
        waiter.addToEmployeeList();


        setVisible(false);

    }*/
    @Override
    public void actionPerformed(ActionEvent ae) {

        try {
            ValidityCheck.validateFields(tfname, tfage, rbmale, rbfemale, tfsalary, tfphone, tfemail, tfnid);
            name = tfname.getText();
            age = tfage.getText();
            gender = rbmale.isSelected() ? "Male" : (rbfemale.isSelected() ? "Female" : "");
            time = (String) cbtime.getSelectedItem();
            assingedTable= (String) cbtable.getSelectedItem();

            salary = tfsalary.getText();
            phone = tfphone.getText();
            email = tfemail.getText();
            nid = tfnid.getText();

            Waiter waiter = new Waiter(name, age, gender, time, assingedTable, salary, phone, email, nid);

            waiter.add();
            waiter.addToEmployeeList();
            setVisible(false);
            setVisible(false);
        } catch (ValidationException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }


    }




    public static void main(String[] args) {
        new AddWaiter();

    }

}
