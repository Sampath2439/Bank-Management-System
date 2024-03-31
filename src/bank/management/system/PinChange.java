
package bank.management.system;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class PinChange extends JFrame implements ActionListener{
    JPasswordField pin,repin;
    JButton change,back;
    String pinnumber;
    PinChange(String pinnumber){
        this.pinnumber = pinnumber;
        setLayout(null);
        
        JLabel text = new JLabel("SELECT WITHDRAWL AMOUNT");
        text.setBounds(140, 200, 600, 50);
        text.setForeground(Color.BLACK);
        text.setFont(new Font("System",Font.BOLD,38));
        add(text);
        
        JLabel pintext = new JLabel("New Pin");
        pintext.setBounds(100, 300, 300, 50);
        pintext.setForeground(Color.BLACK);
        pintext.setFont(new Font("System",Font.BOLD,28));
        add(pintext);
        
        pin = new JPasswordField();
        pin.setBounds(420, 310, 180, 25);
        pin.setFont(new Font("System",Font.BOLD,25));
        add(pin);
        
        JLabel repintext = new JLabel("Re-Enter New Pin");
        repintext.setBounds(100, 350, 250, 50);
        repintext.setForeground(Color.BLACK);
        repintext.setFont(new Font("System",Font.BOLD,28));
        add(repintext);
        
        repin = new JPasswordField();
        repin.setBounds(420, 370, 180, 25);
        repin.setFont(new Font("System",Font.BOLD,25));
        add(repin);
        
        change = new JButton("CHANGE");
        change.setBounds(420, 470, 180, 20);
        change.addActionListener(this);
        add(change);
        
        back = new JButton("BACK");
        back.setBounds(420, 520, 180, 20);
        back.addActionListener(this);
        add(back);
        
        getContentPane().setBackground(Color.WHITE);
        setSize(850, 800);
        setLocation(350,10);
        setUndecorated(true);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == change){
            try
        {
           String npin = pin.getText();
           String rpin = repin.getText();
           
           if(!npin.equals(rpin))
           {
               JOptionPane.showMessageDialog(null, "Entered PIN dosen't match");
               return;
           }
           
           if(npin.equals("")){
               JOptionPane.showMessageDialog(null, "Please enter PIN");
               return;
           }
           
           if(rpin.equals("")){
               JOptionPane.showMessageDialog(null, "Please re-enter new PIN");
               return;
           }
           
           Conn c = new Conn();
           String query1 = "update bank set pin = '"+rpin+"' where pin='"+pinnumber+"'";
           String query2 = "update login set pin = '"+rpin+"' where pin='"+pinnumber+"'";
           String query3 = "update signupthree set pin = '"+rpin+"' where pin='"+pinnumber+"'";
           c.s.executeUpdate(query1);
           c.s.executeUpdate(query2);
           c.s.executeUpdate(query3);
           
           JOptionPane.showMessageDialog(null, "Sucessfully Changed");
           
            setVisible(false);
            new Transaction(rpin).setVisible(true);
        }
        catch(Exception e){
            System.out.println(e);
        }
        }
        else{
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);
        }
        
    }
    
    public static void main(String args[]) {
        new PinChange("").setVisible(true);
    }
}
