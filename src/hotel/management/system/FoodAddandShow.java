/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class FoodAddandShow extends JFrame  implements ActionListener {
    
    JButton add, show , back;
    
     FoodAddandShow(){
         getContentPane().setBackground(new Color(255,242,215));
        setLayout(null);
        
        JLabel text = new JLabel("FOOD ITEMS");
        text.setFont(new Font("Tahoma", Font.BOLD, 20));
        text.setBounds(350, 10, 200, 30);
        add(text);



         add = new JButton("ADD FOOD ITEMS");
         add.setBounds(60, 230, 200, 30);
         add.setBackground(new Color(141,155,106));
         add.setForeground(Color.WHITE);
        add.addActionListener(this);
        add(add);







         show = new JButton("SHOW FOOD ITEMS");
         show.setBounds(60, 300, 200, 30);
         show.setBackground(new Color(141,155,106));
         show.setForeground(Color.WHITE);
        show.addActionListener(this);
        add(show);

       

        back = new JButton("Back");
        back.setBounds(350, 470, 100, 30);
        back.setBackground(new Color(184,80,66));
        back.setForeground(Color.WHITE);
       back.addActionListener(this);
        add(back);

       

       ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/food1.jpg"));
        Image i3 = i1.getImage().getScaledInstance(450, 450, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel image = new JLabel(i2);
        image.setBounds(300, 60, 450, 370);
        add(image);

        setBounds(350, 200, 800, 570);
        setVisible(true);
         
     }
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == add) {
            setVisible(false);
            new AddFood();

        } else if (ae.getSource() == show) {
            setVisible(false);
            new ShowFoodList();

        } else if (ae.getSource() == back) {
            setVisible(false);


        }
    }




    public static void main(String[]args){
        
        new FoodAddandShow();
        
    }
    
    
}
