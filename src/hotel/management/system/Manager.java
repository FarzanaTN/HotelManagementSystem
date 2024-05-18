
package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Manager extends Employee {

    String designation;


    Manager(){

    }
    public Manager(String name, String age, String gender, String designation, String salary, String phone, String email, String nid){

        super(name, age, gender, "Manager", salary, phone, email, nid);
        this.designation = designation;
    }
    public void add(){
        try {

            Conn conn = new Conn();

            String query = "insert into manager values( '" + name + "', '" + age + "', '" + gender + "', '" + designation + "', '" + salary + "', '" + phone + "','" + email + "', '" + nid + "')";

            conn.s.executeUpdate(query);

            JOptionPane.showMessageDialog(null, "Manager Added Successfully!!");



        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(String nid){

        try {
            Conn conn = new Conn();
            String query = "delete from manager where nid = '" + nid + "'";
            int rowsAffected = conn.s.executeUpdate(query);
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Manager Deleted Successfully!!");
            } else {
                JOptionPane.showMessageDialog(null, "Manager Not Found!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void show(){
        new ShowManagerInfo();
    }
}