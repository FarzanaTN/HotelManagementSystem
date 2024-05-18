package hotel.management.system;

import javax.swing.*;

public class HouseKeeper extends Employee{

    String shift;


    HouseKeeper(){

    }
    public HouseKeeper(String name, String age, String gender, String shift, String salary, String phone, String email, String nid){

        super(name, age, gender, "HoseKeeper", salary, phone, email, nid);
        this.shift = shift;
    }
    public void add(){
        try {

            Conn conn = new Conn();

            String query = "insert into housekeeper values( '" + name + "', '" + age + "', '" + gender + "', '" + shift + "', '" + salary + "', '" + phone + "','" + email + "', '" + nid + "')";

            conn.s.executeUpdate(query);

            JOptionPane.showMessageDialog(null, "HoseKeeper Added Successfully!!");



        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(String nid){

        try {
            Conn conn = new Conn();
            String query = "delete from housekeeper where nid = '" + nid + "'";
            int rowsAffected = conn.s.executeUpdate(query);
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "HoseKeeper Deleted Successfully!!");
            } else {
                JOptionPane.showMessageDialog(null, "HoseKeeper Not Found!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void show(){
        new ShowHouseKeeperInfo();
    }
}