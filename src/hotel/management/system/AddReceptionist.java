package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class AddReceptionist extends JFrame implements ActionListener {
    String name, age, gender, job, salary, phone, email, nid,degree,languageSkillsStr;
    JTextField tfname, tfage, tfsalary, tfphone, tfnid, tfemail;
    JRadioButton rbmale, rbfemale;
    JButton save;
    JComboBox cbjob;

    JCheckBox cbEnglish, cbBangla, cbFrench, cbGerman, cbOther;

    AddReceptionist() {

        setLayout(null);

        JLabel text = new JLabel("ADD RECEPTIONIST");
        text.setFont(new Font("Tahoma", Font.BOLD, 20));
        text.setBounds(450, 10, 250, 30);
        add(text);

        JLabel lblname = new JLabel("Name");
        lblname.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblname.setBounds(60, 70, 120, 30);
        add(lblname);

        tfname = new JTextField();
        tfname.setBounds(200, 70, 150, 30);
        tfname.setBackground(new Color(255,242,215));
        add(tfname);

        JLabel lblage = new JLabel("Age");
        lblage.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblage.setBounds(60, 120, 150, 30);
        add(lblage);

        tfage = new JTextField();
        tfage.setBounds(200, 120, 150, 30);
        tfage.setBackground(new Color(255,242,215));
        add(tfage);

        JLabel lblgender = new JLabel("Gender");
        lblgender.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblgender.setBounds(60, 170, 150, 30);
        add(lblgender);

        rbmale = new JRadioButton("Male");
        rbmale.setBackground(new Color(255,242,215));
        rbmale.setBounds(200, 170, 70, 30);
        add(rbmale);

        rbfemale = new JRadioButton("Female");
        rbfemale.setBackground(new Color(255,242,215));
        rbfemale.setBounds(280, 170, 70, 30);
        add(rbfemale);

        ButtonGroup bg = new ButtonGroup();
        bg.add(rbmale);
        bg.add(rbfemale);

        JLabel lbldgree = new JLabel("Degree");
        lbldgree.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lbldgree.setBounds(60, 220, 150, 30);
        add(lbldgree);

        String course[] = {"BSc", "MSc","BBA","MBA","BA","MA","HSC"};
        cbjob = new JComboBox(course);
        cbjob.setBackground(new Color(255,242,215));
        cbjob.setBounds(200, 220, 150, 30);
        add(cbjob);

        JLabel lblslary = new JLabel("Salary");
        lblslary.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblslary.setBounds(60, 270, 120, 30);
        add(lblslary);

        tfsalary = new JTextField();
        tfsalary.setBounds(200, 270, 150, 30);
        tfsalary.setBackground(new Color(255,242,215));
        add(tfsalary);

        JLabel lblphone = new JLabel("Phone");
        lblphone.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblphone.setBounds(60, 320, 150, 30);
        add(lblphone);

        tfphone = new JTextField();
        tfphone.setBounds(200, 320, 150, 30);
        tfphone.setBackground(new Color(255,242,215));
        add(tfphone);

        JLabel lblnid = new JLabel("NID");
        lblnid.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblnid.setBounds(60, 420, 120, 30);
        add(lblnid);

        tfnid = new JTextField();
        tfnid.setBounds(200, 420, 150, 30);
        tfnid.setBackground(new Color(255,242,215));
        add(tfnid);

        JLabel lblemail = new JLabel("Email");
        lblemail.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblemail.setBounds(60, 370, 150, 30);
        add(lblemail);

        tfemail = new JTextField();
        tfemail.setBounds(200, 370, 150, 30);
        tfemail.setBackground(new Color(255,242,215));
        add(tfemail);


        JLabel lblLanguages = new JLabel("Language Skills");
        lblLanguages.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblLanguages.setBounds(60, 470, 150, 30);
        add(lblLanguages);

        cbEnglish = new JCheckBox("English");
        cbEnglish.setBackground(new Color(255,242,215));
        cbEnglish.setBounds(200, 470, 80, 30);
        add(cbEnglish);

        cbBangla = new JCheckBox("Bangla");
        cbBangla.setBackground(new Color(255,242,215));
        cbBangla.setBounds(300, 470, 80, 30);
        add(cbBangla);

        cbFrench = new JCheckBox("Arabic");
        cbFrench.setBackground(new Color(255,242,215));
        cbFrench.setBounds(400, 470, 80, 30);
        add(cbFrench);

        cbGerman = new JCheckBox("Spanish");
        cbGerman.setBackground(new Color(255,242,215));
        cbGerman.setBounds(500, 470, 80, 30);
        add(cbGerman);

        cbOther = new JCheckBox("Others");
        cbOther.setBackground(new Color(255,242,215));
        cbOther.setBounds(600, 470, 80, 30);
        add(cbOther);



        save = new JButton("Save");
        save.setBounds(450, 530, 150, 30);
        save.addActionListener(this);
        save.setBackground(new Color(141,155,106));
        save.setForeground(Color.WHITE);

        add(save);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/Receptionist.jpg"));
        Image i3 = i1.getImage().getScaledInstance(612, 408, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel image = new JLabel(i2);
        image.setBounds(380, 60, 612, 408);
        add(image);

        getContentPane().setBackground(new Color(255,242,215));
        setBounds(300, 150, 1050, 650);
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

         degree = (String) cbjob.getSelectedItem();

        StringBuilder languageSkills = new StringBuilder();
        if (cbEnglish.isSelected()) {
            languageSkills.append("English, ");
        }
        if (cbBangla.isSelected()) {
            languageSkills.append("Bangla, ");
        }
        if (cbFrench.isSelected()) {
            languageSkills.append("Arabic, ");
        }
        if (cbGerman.isSelected()) {
            languageSkills.append("Spanish, ");
        }
        if (cbOther.isSelected()) {
            languageSkills.append("Others, ");
        }

        // Remove trailing comma and space
         languageSkillsStr = languageSkills.toString().replaceAll(", $", "");

     Receptionist r=new Receptionist(  name,  age,  gender,  degree,  salary,  phone,  email,  nid,  languageSkillsStr);

     r.add();
     r.addToEmployeeList();
     setVisible(false);

    }*/
    @Override
    public void actionPerformed(ActionEvent ae) {

        try {
            ValidityCheck.validateFields(tfname, tfage, rbmale, rbfemale, tfsalary, tfphone, tfemail, tfnid);
            name = tfname.getText();
            age = tfage.getText();
            gender = rbmale.isSelected() ? "Male" : (rbfemale.isSelected() ? "Female" : "");
            StringBuilder languageSkills = new StringBuilder();
            if (cbEnglish.isSelected()) {
                languageSkills.append("English, ");
            }
            if (cbBangla.isSelected()) {
                languageSkills.append("Bangla, "); // Note: Changed to match checkbox
            }
            if (cbFrench.isSelected()) {
                languageSkills.append("Arabic, "); // Note: Changed to match checkbox
            }
            if (cbGerman.isSelected()) {
                languageSkills.append("Spanish, ");
            }
            if (cbOther.isSelected()) {
                languageSkills.append("Others, ");
            }

            // Remove trailing comma and space
            if (!languageSkills.isEmpty()) {
                languageSkillsStr = languageSkills.substring(0, languageSkills.length() - 2);
            } else {
                languageSkillsStr = "";
            }
//            time = (String) cbtime.getSelectedItem();
//            assingedTable= (String) cbtable.getSelectedItem();

            salary = tfsalary.getText();
            phone = tfphone.getText();
            email = tfemail.getText();
            nid = tfnid.getText();
            degree = (String) cbjob.getSelectedItem();

            Receptionist r=new Receptionist( name,  age,  gender,  degree,  salary,  phone,  email,  nid,  languageSkillsStr);
            r.add();
            r.addToEmployeeList();
            setVisible(false);
            setVisible(false);
        } catch (ValidationException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }


    }



    public static void main(String[] args) {
        new AddReceptionist();
        //am.add(name, age, gender, "Manager", salary, phone, email, nid);
    }

}