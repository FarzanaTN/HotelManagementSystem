package hotel.management.system;

import javax.swing.*;


public class Driver extends Employee {

    String license;


    Driver(){

    }
    public Driver(String name, String age, String gender, String license, String salary, String phone, String email, String nid){

        super(name, age, gender, "Driver", salary, phone, email, nid);
        this.license = license;
    }
    public void add(){
        try {

            Conn conn = new Conn();

            String query = "insert into driver values( '" + name + "', '" + age + "', '" + gender + "', '" + license + "', '" + salary + "', '" + phone + "','" + email + "', '" + nid + "')";

            conn.s.executeUpdate(query);

            JOptionPane.showMessageDialog(null, "Driver Added Successfully!!");



        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(String nid){

        try {
            Conn conn = new Conn();
            String query = "delete from driver where nid = '" + nid + "'";
            int rowsAffected = conn.s.executeUpdate(query);
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Driver Deleted Successfully!!");
            } else {
                JOptionPane.showMessageDialog(null, "Driver Not Found!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void show(){
        new ShowDriverInfo();
    }
}