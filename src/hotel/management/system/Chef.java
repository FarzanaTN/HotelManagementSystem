package hotel.management.system;

import javax.swing.*;


public class Chef extends Employee {

    String designation;


    Chef(){

    }
    public Chef(String name, String age, String gender, String designation, String salary, String phone, String email, String nid){

        super(name, age, gender, "Chef", salary, phone, email, nid);
        this.designation = designation;
    }
    public void add(){
        try {

            Conn conn = new Conn();

            String query = "insert into chef values( '" + name + "', '" + age + "', '" + gender + "', '" + designation + "', '" + salary + "', '" + phone + "','" + email + "', '" + nid + "')";

            conn.s.executeUpdate(query);

            JOptionPane.showMessageDialog(null, "Chef Added Successfully!!");



        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(String nid){

        try {
            Conn conn = new Conn();
            String query = "delete from chef where nid = '" + nid + "'";
            int rowsAffected = conn.s.executeUpdate(query);
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Chef Deleted Successfully!!");
            } else {
                JOptionPane.showMessageDialog(null, "Chef Not Found!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void show(){
        new ShowChefInfo();
    }
}