package hotel.management.system;

import javax.swing.*;

public class Receptionist extends Employee{

    String degree;
    String skill;


    Receptionist(){

    }
    public Receptionist(String name, String age, String gender, String degree, String salary, String phone, String email, String nid, String skill){

        super(name, age, gender, "Receptionist", salary, phone, email, nid);
        this.degree = degree;
        this.skill = skill;
    }
    public void add(){
        try {

            Conn conn = new Conn();

            String query = "insert into receptionist values( '" + name + "', '" + age + "', '" + gender + "', '" + degree + "', '" + salary + "', '" + phone + "', '" + email + "','" + nid + "', '" + skill + "')";

            conn.s.executeUpdate(query);

            JOptionPane.showMessageDialog(null, "Receptionist Added Successfully!!");



        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(String nid){

        try {
            Conn conn = new Conn();
            String query = "delete from receptionist where nid = '" + nid + "'";
            int rowsAffected = conn.s.executeUpdate(query);
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Receptionist Deleted Successfully!!");
            } else {
                JOptionPane.showMessageDialog(null, "Receptionist Not Found!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void show(){
        new ShowReceptionistInfo();
    }


}