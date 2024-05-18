package hotel.management.system;

import javax.swing.*;


public class SecurityGuard extends Employee {

    String dutyTime;
    String assignedGate;


    SecurityGuard(){

    }
    public SecurityGuard(String name, String age, String gender, String dutyTime, String assignedGate, String salary, String phone, String email, String nid){

        super(name, age, gender, "Security Guard", salary, phone, email, nid);
        this.dutyTime = dutyTime;
        this.assignedGate = assignedGate;
    }
    public void add(){
        try {

            Conn conn = new Conn();

            String query = "insert into securityguard values( '" + name + "', '" + age + "', '" + gender + "', '" + dutyTime + "', '" +assignedGate + "','" + salary + "', '" + phone + "','" + email + "', '" + nid + "')";

            conn.s.executeUpdate(query);

            JOptionPane.showMessageDialog(null, "Security Guard Added Successfully!!");



        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(String nid){

        try {
            Conn conn = new Conn();
            String query = "delete from securityguard where nid = '" + nid + "'";
            int rowsAffected = conn.s.executeUpdate(query);
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Security Guard Deleted Successfully!!");
            } else {
                JOptionPane.showMessageDialog(null, "Security Guard Not Found!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void show(){
        new ShowSecurityGuardInfo();
    }
}