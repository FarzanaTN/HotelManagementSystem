package hotel.management.system;

import javax.swing.*;

public class Waiter extends Employee{

    String shift;
    String assignedtable;


    Waiter(){

    }
    public Waiter(String name, String age, String gender, String shift, String assignedtable, String salary, String phone, String email, String nid){

        super(name, age, gender, "Waiter", salary, phone, email, nid);
        this.shift = shift;
        this.assignedtable = assignedtable;
    }
    public void add(){
        try {

            Conn conn = new Conn();

            String query = "insert into waiter values( '" + name + "', '" + age + "', '" + gender + "', '" + shift + "', '" + assignedtable + "', '" + salary + "', '" + phone + "','" + email + "', '" + nid + "')";

            conn.s.executeUpdate(query);

            JOptionPane.showMessageDialog(null, "Waiter Added Successfully!!");



        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(String nid){

        try {
            Conn conn = new Conn();
            String query = "delete from waiter where nid = '" + nid + "'";
            int rowsAffected = conn.s.executeUpdate(query);
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Waiter Deleted Successfully!!");
            } else {
                JOptionPane.showMessageDialog(null, "Waiter Not Found!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void show(){
        new ShowWaiterInfo();
    }


}