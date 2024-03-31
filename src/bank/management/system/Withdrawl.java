
package bank.management.system;

import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Withdrawl extends JFrame implements ActionListener{
    
      JTextField textfield;
      JButton withdrawl,back;
      String Pinnumber;
    Withdrawl(String Pinnumber){
        this.Pinnumber= Pinnumber;
        setLayout(null);
        
        JLabel text = new JLabel("Enter the amount you want to Withdrawl...");
        text.setBounds(80, 200, 600, 50);
        text.setForeground(Color.BLACK);
        text.setFont(new Font("System",Font.BOLD,20));
        add(text);
        
        textfield = new JTextField();
        textfield.setFont(new Font("Railway",Font.BOLD,22));
        textfield.setBounds(80, 250, 350, 25);
        add(textfield);
        
        withdrawl = new JButton("Withdrawl");
        withdrawl.setBounds(355, 385, 150, 30);
        withdrawl.addActionListener(this);
        add(withdrawl);
        
        back = new JButton("Back");
        back.setBounds(355, 420, 150, 30);
        back.addActionListener(this);
        add(back);
        
        
        getContentPane().setBackground(Color.WHITE);
        setSize(850, 800);
        setLocation(350,10);
        setVisible(true);
        
        setSize(760,760);
        setLocation(300, 0);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == withdrawl)
        {
            String number = textfield.getText();
            Date date = new Date();
            if(number.equals(""))
            {
                JOptionPane.showMessageDialog(null, "Please enter the amount you want to withdrawl");
            }
            else
            {
                try
                {
                    Conn conn = new Conn();
                    String query ="insert into bank values('"+Pinnumber+"','"+date+"','withdrawl','"+number+"')";
                    conn.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Rs"+number+"Withdrawl Sucessfully");
                    setVisible(false);
                    new Transaction(Pinnumber).setVisible(true);
                }
                catch(Exception e)
                {
                    System.out.println(e);
                }
            }
        }
        else if(ae.getSource() == back){
            setVisible(false);
            new Transaction(Pinnumber).setVisible(true);
        }
    }
    public static void main(String args[]) {
       new Withdrawl("");
    }
}
