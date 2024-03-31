package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class MiniStatement extends JFrame implements ActionListener{
    JButton logout,back;
    String pinnumber;
    MiniStatement(String pinnumber){
        
        this.pinnumber = pinnumber;
        
        setTitle("Mini Statement");
        setLayout(null);
        
        JLabel mini =  new JLabel();
        mini.setBounds(20, 140, 400, 200);
        add(mini);
        
        JLabel bank =  new JLabel("Kare Bank");
        bank.setBounds(150,20,150,20);
        bank.setFont(new Font("Railway",Font.BOLD,22));
        add(bank);
        
        JLabel card =  new JLabel();
        card.setBounds(20,80,300,20);
        add(card);
        
        JLabel balance =  new JLabel();
        balance.setBounds(20, 400, 300, 20);
        add(balance);
        
        back= new JButton("Back To Main Menu");
        back.setBounds(15, 500, 200, 22);
        back.addActionListener(this);
        add(back);

        logout = new JButton("Logout");
        logout.setBounds(250, 500, 100, 22);
        logout.addActionListener(this);
        add(logout);
        
                
        try{
            Conn c = new Conn();
            
            ResultSet rs=c.s.executeQuery("select * from login where pin='"+pinnumber+"'");
            
            while (rs.next()) {
                card.setText("Card Number"+rs.getString("cardnumber").substring(0,4)+"XXXXXXXX"+rs.getString("cardnumber").substring(12));
                
            }
        }catch(Exception e){
            System.out.println(e);
        }
        try{
            Conn c = new Conn();
            int bal=0;
            ResultSet rs=c.s.executeQuery("select * from bank where pin='"+pinnumber+"'");
            
            while(rs.next()){
                mini.setText(mini.getText()+"<html>"+rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("type") +"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("amount")+"<br><br><html>");
                
                if(rs.getString("type").equals("deposite"))
                    {
                        bal+=Integer.parseInt(rs.getString("amount"));          
                    }
                    else{
                         bal-=Integer.parseInt(rs.getString("amount"));
                    }
            }
            balance.setText("Your current account balance is Rs "+bal);
        }catch(Exception e){
            System.out.println(e);
        }
            
        getContentPane().setBackground(Color.WHITE);
        setSize(400, 600);
        setLocation(20,20);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        
            if(ae.getSource() == back){
                setVisible(false);
                new Transaction(pinnumber).setVisible(true);
                
            }
            else if(ae.getSource() == logout){
                setVisible(false);
                new Transaction(pinnumber).setVisible(false);
                new Login().setVisible(true);
                
            }
        
        }
    public static void main(String args[]) {
        new MiniStatement("");
    }
}
