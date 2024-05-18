package hotel.management.system;

import javax.swing.*;

public class Accountant extends Employee{

    String degree;
    String designation;


    Accountant(){

    }
    public Accountant(String name, String age, String gender, String degree, String designation, String salary, String phone, String email, String nid){

        super(name, age, gender, "Accountant", salary, phone, email, nid);
        this.degree = degree;
        this.designation = designation;
    }
    public void add(){
        try {

            Conn conn = new Conn();

            String query = "insert into accountant values( '" + name + "', '" + age + "', '" + gender + "', '" + degree + "', '" + designation + "', '" + salary + "', '" + phone + "','" + email + "', '" + nid + "')";

            conn.s.executeUpdate(query);

            JOptionPane.showMessageDialog(null, "Accountant Added Successfully!!");



        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(String nid){

        try {
            Conn conn = new Conn();
            String query = "delete from accountant where nid = '" + nid + "'";
            int rowsAffected = conn.s.executeUpdate(query);
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Accountant Deleted Successfully!!");
            } else {
                JOptionPane.showMessageDialog(null, "Accountant Not Found!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void show(){
        new ShowAccountantInfo();
    }


}