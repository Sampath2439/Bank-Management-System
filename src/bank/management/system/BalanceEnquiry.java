
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class BalanceEnquiry extends JFrame implements ActionListener{
    String pinnumber;
    JButton back;
    BalanceEnquiry(String pinnumber){
        
        this.pinnumber = pinnumber;
        setLayout(null);
        
        back = new JButton("Back");
        back.setBounds(500, 600, 180, 20);
        back.addActionListener(this);
        add(back);
        
        Conn c = new Conn();
        int balance=0;
            try{
                ResultSet rs= c.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
                
                while(rs.next())
                {
                    if(rs.getString("type").equals("deposite"))
                    {
                        balance+=Integer.parseInt(rs.getString("amount"));          
                    }
                    else{
                         balance-=Integer.parseInt(rs.getString("amount"));
                    }
                }
            }catch(Exception e){
                System.out.println(e);
            }
        
        JLabel text = new JLabel("Your current account balance is RS "+balance);
        text.setBounds(100, 140, 500, 30);
        text.setFont(new Font("System",Font.BOLD,22));
        add(text);
            
        getContentPane().setBackground(Color.WHITE);
        setSize(850, 800);
        setLocation(350,10);
        
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Transaction(pinnumber).setVisible(true);
    }
    public static void main(String args[]) {
        new BalanceEnquiry("");
    }
}
