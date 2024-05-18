package hotel.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class SearchRoom extends JFrame implements ActionListener{
    
    JTable table;
    JButton back, submit;
    JComboBox bedType;
    JCheckBox available;

    SearchRoom(){

        getContentPane().setBackground(new Color(255,242,215));
        setLayout(null);

        JLabel text = new JLabel("SEARCH FOR ROOM");
        text.setFont(new Font("Tahoma", Font.BOLD, 20));
        text.setBounds(400, 30, 200, 30);
        add(text);

        JLabel lb1bed = new JLabel("Bed Type");
        lb1bed.setBounds(50, 100, 100, 20);
        add(lb1bed);

        bedType = new JComboBox(new String[]{"Single bed", "Double Bed"});
        bedType.setBounds(150, 100, 150, 25);
        bedType.setBackground(new Color(255,242,215));
        add(bedType);

        available = new JCheckBox("Only Display available");
        available.setBounds(650, 100, 150, 25);
        available.setBackground(new Color(255,242,215));
        add(available);

        JLabel l1 = new JLabel("Room Number");
        l1.setBounds(50, 160, 100, 20);
        add(l1);

        JLabel l2 = new JLabel("Availability");
        l2.setBounds(270, 160, 100, 20);
        add(l2);

        JLabel l3 = new JLabel("Status");
        l3.setBounds(450, 160, 100, 20);
        add(l3);

        JLabel l4 = new JLabel("Price");
        l4.setBounds(670, 160, 100, 20);
        add(l4);

        JLabel l5 = new JLabel("Bed Type");
        l5.setBounds(870, 160, 100, 20);
        add(l5);


        table = new JTable();
        table.setBounds(0, 200, 1000, 300);
        table.setBackground(new Color(255,242,215));
        add(table);

        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from room");
            table.setModel(DbUtils.resultSetToTableModel(rs));

        }
        catch(Exception e){
            e.printStackTrace();;
        }

        submit = new JButton("Submit");
        submit.setBackground(new Color(141,155,106));
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setBounds(500, 520, 120, 30);
        add(submit);


        back = new JButton("Back");
        back.setBackground(new Color(184,80,66));
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        back.setBounds(300, 520, 120, 30);
        add(back);

        setBounds(200, 150, 1000, 600);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if( ae.getSource() == submit ){
            try{
                String query1 = "select * from room where bed_type = '"+bedType.getSelectedItem()+"'";
                String query2 = "select * from room where availability = 'Available' AND bed_type = '"+bedType.getSelectedItem()+"'";

                Conn conn = new Conn();
                ResultSet rs;

                if( available.isSelected()){
                    rs = conn.s.executeQuery(query2);
                }
                else {
                    rs = conn.s.executeQuery(query1);
                }
                table.setModel(DbUtils.resultSetToTableModel(rs));
                

            }
            catch(Exception e ){
                e.printStackTrace();
            }
        }
        else {
            setVisible(false);
            new Reception();
        }
    }

    public static void main(String[] args) {
        new SearchRoom();
    }
}