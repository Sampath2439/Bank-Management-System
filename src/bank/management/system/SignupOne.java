package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
public class SignupOne extends JFrame implements ActionListener{

        long random;
        JTextField nameTextField,fnameTextField,dobTextField,emailTextField,addressTextField,cityTextField,stateTextField,pincodeTextField;
        JButton next;
        JRadioButton male,female,married,unmarried,others;
        JDateChooser dateChooser;
     SignupOne() {
         
        setLayout(null);
        Random ran = new Random();
        random = Math.abs((ran.nextLong()% 9000L) + 1000L);
         
        JLabel formno =  new JLabel("APPLICATION FORM NO." +random);
        formno.setFont(new Font("Railway",Font.BOLD,38));
        formno.setBounds(140, 20, 600, 40);
        add(formno);
        
        JLabel personlDetails =  new JLabel("Page 1: Personal Details" );
        personlDetails.setFont(new Font("Railway",Font.BOLD,22));
        personlDetails.setBounds(290, 80, 400, 30);
        add(personlDetails);
        
        JLabel name =  new JLabel("Name" );
        name.setFont(new Font("Railway",Font.BOLD,20));
        name.setBounds(100, 140, 200, 30);
        add(name);
        
        nameTextField = new JTextField();
        nameTextField.setFont(new Font("Railway",Font.BOLD,14));
        nameTextField.setBounds(300, 140, 400, 30);
        add(nameTextField);
        
        JLabel fname =  new JLabel("Father's Name" );
        fname.setFont(new Font("Railway",Font.BOLD,20));
        fname.setBounds(100, 190, 200, 30);
        add(fname);
        
        fnameTextField = new JTextField();
        fnameTextField.setFont(new Font("Railway",Font.BOLD,14));
        fnameTextField.setBounds(300, 190, 400, 30);
        add(fnameTextField);
        
        JLabel dob =  new JLabel("Date Of Birth" );
        dob.setFont(new Font("Railway",Font.BOLD,20));
        dob.setBounds(100, 240, 200, 30);
        add(dob);
        
        dateChooser = new JDateChooser();
        dateChooser.setBounds(300, 240, 200, 30);
        add(dateChooser);
        
        JLabel gender =  new JLabel("Gender" );
        gender.setFont(new Font("Railway",Font.BOLD,20));
        gender.setBounds(100, 290, 200, 30);
        add(gender);
        
        male = new JRadioButton("Male");
        male.setBounds(300, 290, 60, 30);
        male.setBackground(Color.WHITE);
        add(male);
        
        female = new JRadioButton("female");
        female.setBounds(450, 290, 120, 30);
        female.setBackground(Color.WHITE);
        add(female);
        
         ButtonGroup gendergroup = new ButtonGroup();
         gendergroup.add(male);
         gendergroup.add(female);
        
        JLabel email =  new JLabel("Email Id" );
        email.setFont(new Font("Railway",Font.BOLD,20));
        email.setBounds(100, 340, 200, 30);
        add(email);
        
        emailTextField = new JTextField();
        emailTextField.setFont(new Font("Railway",Font.BOLD,14));
        emailTextField.setBounds(300, 340, 400, 30);
        add(emailTextField);
        
        JLabel marital =  new JLabel("Marital Status" );
        marital.setFont(new Font("Railway",Font.BOLD,20));
        marital.setBounds(100, 390, 200, 30);
        add(marital);
        
        married = new JRadioButton("Married");
        married.setBounds(300, 390, 100, 30);
        married.setBackground(Color.WHITE);
        add(married);
        
        unmarried = new JRadioButton("Unmarried");
        unmarried.setBounds(450, 390, 100, 30);
        unmarried.setBackground(Color.WHITE);
        add(unmarried);
        
        others = new JRadioButton("other");
        others.setBounds(630, 390, 100, 30);
        others.setBackground(Color.WHITE);
        add(others);
        
         ButtonGroup maritalgroup = new ButtonGroup();
         maritalgroup.add(married);
         maritalgroup.add(unmarried);
         maritalgroup.add(others);
        
        
        JLabel adderss =  new JLabel("Address" );
        adderss.setFont(new Font("Railway",Font.BOLD,20));
        adderss.setBounds(100, 440, 200, 30);
        add(adderss);
        
         addressTextField = new JTextField();
        addressTextField.setFont(new Font("Railway",Font.BOLD,14));
        addressTextField.setBounds(300, 440, 400, 30);
        add(addressTextField);
        
        JLabel city =  new JLabel("City" );
        city.setFont(new Font("Railway",Font.BOLD,20));
        city.setBounds(100, 490, 200, 30);
        add(city);
        
        cityTextField = new JTextField();
        cityTextField.setFont(new Font("Railway",Font.BOLD,14));
        cityTextField.setBounds(300, 490, 400, 30);
        add(cityTextField);
        
        JLabel state =  new JLabel("state" );
        state.setFont(new Font("Railway",Font.BOLD,20));
        state.setBounds(100, 540, 200, 30);
        add(state);
        
         stateTextField = new JTextField();
        stateTextField.setFont(new Font("Railway",Font.BOLD,14));
        stateTextField.setBounds(300, 540, 400, 30);
        add(stateTextField);
        
        JLabel pincode =  new JLabel("pincode" );
        pincode.setFont(new Font("Railway",Font.BOLD,20));
        pincode.setBounds(100, 590, 200, 30);
        add(pincode);
        
        pincodeTextField = new JTextField();
        pincodeTextField.setFont(new Font("Railway",Font.BOLD,14));
        pincodeTextField.setBounds(300, 590, 400, 30);
        add(pincodeTextField);
        
        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setBounds(620, 660, 80, 30);
        next.setFont(new Font("Railway",Font.BOLD,14));
        next.addActionListener(this);
        add(next);
      
        getContentPane().setBackground(Color.WHITE);
        
         setSize(850, 800);
         setLocation(350,10);
         setVisible(true);
    }
     public void actionPerformed(ActionEvent ae){
         String formno = "" + random;
         String name = nameTextField.getText();
         String fname = fnameTextField.getText();
         String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
         String gender = null;
         if(male.isSelected()){
            gender = "Male";
         }
         else if(female.isSelected()){
             gender= "Female";
         }
         
         String email = emailTextField.getText();
         String marital  = null;
         if(married.isSelected()){
             marital = "Married";
         }
         else if(unmarried.isSelected()){
             marital = "Unmarried";
         }
         else if(others.isSelected()){
          marital = "other";
         }
         
         String address = addressTextField.getText();
         String city  = cityTextField.getText();
         String state = stateTextField.getText();
         String pin = pincodeTextField.getText();
         
         try{
             if (name.equals("")){
                 JOptionPane.showMessageDialog(null, "namme is requried");
             }
             else{
             Conn c = new Conn();
             String query = "Insert into signup values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+pin+"','"+state+"')";
             c.s.executeUpdate(query);
             
                 setVisible(false);
                 new SignupTwo(formno).setVisible(true);
             
             }
         } catch (Exception e){
             System.out.println(e);
         }
         
     }
     public static void main(String[] args) {
         new SignupOne();
     }

 }
