package hotel.management.system;

import javax.swing.*;

public abstract class Employee {
    String name;
    String age;
    String gender;
    String job;
    String salary;
    String phone;
    String email;
    String nid;

    public Employee() {

    }

    public Employee(String name, String age, String gender, String job, String salary, String phone, String email, String nid) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.job = job;
        this.salary = salary;
        this.phone = phone;
        this.email = email;
        this.nid = nid;
    }

//    public void addToEmployeeList(Employee employee) {
//        try {
//            Conn conn = new Conn();
//            System.out.println("Name " + this.name);
//            System.out.println("hii");
//
//            String query = "insert into employee values('" + this.name + "', '" + this.age + "', '" + this.gender + "','" + this.job + "', '" + this.salary + "', '" + this.phone + "','" + this.email + "', '" + this.nid + "')";
//
//            conn.s.executeUpdate(query);
//            System.out.println("employee");
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

    public void addToEmployeeList() {
        try {
            Conn conn = new Conn();

            String query = "insert into employee values('" + name + "', '" + age + "', '" + gender + "','" + job + "', '" + salary + "', '" + phone + "','" + email + "', '" + nid + "')";

            conn.s.executeUpdate(query);



        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteEmployee() {
        try {
            Conn conn = new Conn();
            String query = "delete from employee where nid = '" + nid + "'";
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

    public void showEmployeeList() {
        new ShowAllEmployeeInfo();
    }

    public String getName(){
        return this.name;
    }

    public abstract void add();
    public abstract void delete(String nid);



}