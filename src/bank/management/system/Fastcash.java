
package bank.management.system;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;
public class Fastcash extends JFrame implements ActionListener{
    
    JButton deposite,withdrawal,ministatement,fastcash,balanveenquriey,exit,pinchange;
    String pinnumber;
    Fastcash(String pinnumber)  {
        setLayout(null);
        this.pinnumber=pinnumber;
        JLabel text = new JLabel("SELECT WITHDRAWL AMOUNT");
        text.setBounds(140, 200, 600, 50);
        text.setForeground(Color.BLACK);
        text.setFont(new Font("System",Font.BOLD,38));
        add(text);
        
        deposite = new JButton("Rs 100");
        deposite.setBounds(170, 415 ,150,30);
        deposite.addActionListener(this);
        add(deposite);
        
        withdrawal = new JButton("Rs 500");
        withdrawal.setBounds(420, 415 ,150,30);
        withdrawal.addActionListener(this);
        add(withdrawal);
        
        fastcash = new JButton("Rs 1000");
        fastcash.setBounds(170, 490 ,150,30);
        fastcash.addActionListener(this);
        add(fastcash);
        
        ministatement = new JButton("Rs 2000");
        ministatement.setBounds(420, 490 ,150,30);
        ministatement.addActionListener(this);
        add(ministatement);
        
        pinchange = new JButton("Rs 5000");
        pinchange.setBounds(170, 570 ,150,30);
        pinchange.addActionListener(this);
        add(pinchange);
        
        balanveenquriey = new JButton("Rs 10000");
        balanveenquriey.setBounds(420, 570 ,150,30);
        balanveenquriey.addActionListener(this);
        add(balanveenquriey);
        
        exit = new JButton("BACK");
        exit.setBounds(550, 650 ,150,30);
        exit.addActionListener(this);
        add(exit);
        
        
        getContentPane().setBackground(Color.WHITE);
        setSize(850, 800);
        setLocation(350,10);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==exit){
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);
        }else
        {
            String amount = ((JButton)ae.getSource()).getText().substring(3);
            Conn conn = new Conn();
            try{
                ResultSet rs= conn.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
                int balance=0;
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
                
                if(ae.getSource() != exit && balance < Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null, "Insufficient Balance");
                    return;
                }
                
                Date date = new Date();
                String query = "insert into bank values('"+pinnumber+"','"+date+"','withdrawl','"+amount+"')";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Rs "+ amount +"Debited Sucessfully");
                setVisible(false);
                new Transaction(pinnumber).setVisible(true);
            }catch(Exception e){
                System.out.println(e);
            }
        }
    }
    
    
    public static void main(String args[]) {
       new Fastcash("");
    }
}
