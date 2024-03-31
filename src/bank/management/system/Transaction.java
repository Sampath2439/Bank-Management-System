
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Transaction extends JFrame implements ActionListener{
    
    JButton deposite,withdrawal,ministatement,fastcash,balanceenquiry,exit,pinchange;
    String pinnumber;
    Transaction(String pinnumber)  {
        setLayout(null);
        this.pinnumber=pinnumber;
        JLabel text = new JLabel("Please select your Transaction");
        text.setBounds(140, 200, 600, 50);
        text.setForeground(Color.BLACK);
        text.setFont(new Font("System",Font.BOLD,38));
        add(text);
        
        deposite = new JButton("Deposite");
        deposite.setBounds(170, 415 ,150,30);
        deposite.addActionListener(this);
        add(deposite);
        
        withdrawal = new JButton("Cash Withdrawl");
        withdrawal.setBounds(420, 415 ,150,30);
        withdrawal.addActionListener(this);
        add(withdrawal);
        
        fastcash = new JButton("Fast Cash");
        fastcash.setBounds(170, 490 ,150,30);
        fastcash.addActionListener(this);
        add(fastcash);
        
        ministatement = new JButton("Ministatement");
        ministatement.setBounds(420, 490 ,150,30);
        ministatement.addActionListener(this);
        add(ministatement);
        
        pinchange = new JButton("Pinchange");
        pinchange.setBounds(170, 570 ,150,30);
        pinchange.addActionListener(this);
        add(pinchange);
        
        balanceenquiry = new JButton("Balance Enquiry");
        balanceenquiry.setBounds(420, 570 ,150,30);
        balanceenquiry.addActionListener(this);
        add(balanceenquiry);
        
        exit = new JButton("Exit");
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
            System.exit(0);
        }else if(ae.getSource() == deposite){
            new Deposite(pinnumber).setVisible(true);
        }else if(ae.getSource() == withdrawal){
            setVisible(false);
            new Withdrawl(pinnumber).setVisible(true);
        }else if(ae.getSource()==fastcash){
            setVisible(false);
            new Fastcash(pinnumber).setVisible(true);
        }else if(ae.getSource()==pinchange){
            setVisible(false);
            new PinChange(pinnumber).setVisible(true);
        }
        else if(ae.getSource()==balanceenquiry){
            setVisible(false);
            new BalanceEnquiry(pinnumber).setVisible(true);
        }
        else if(ae.getSource()==ministatement){
            setVisible(false);
            new MiniStatement(pinnumber).setVisible(true);
        }
        
    }
    
    
    public static void main(String args[]) {
       new Transaction("");
    }
}
