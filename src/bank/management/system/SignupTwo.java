package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
public class SignupTwo extends JFrame implements ActionListener{

        
        JTextField pan,Aadhar;
        JButton next;
        JRadioButton syes,sno,eyes,eno;
        JComboBox religion,category,occupation,education,income;
        String formno;
     SignupTwo(String formno) {
         this.formno = formno;
        setLayout(null);
         
         setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
        
  
        
        JLabel additionalDetails =  new JLabel("Page 2: Aditional Details" );
        additionalDetails.setFont(new Font("Railway",Font.BOLD,22));
        additionalDetails.setBounds(290, 80, 400, 30);
        add(additionalDetails);
        
        JLabel name =  new JLabel("Religion" );
        name.setFont(new Font("Railway",Font.BOLD,20));
        name.setBounds(100, 140, 200, 30);
        add(name);
        
        String valReligion[] = {"","Hindu","Muslim","Sikh","Christian","Other"};
        religion = new JComboBox(valReligion);
        religion.setBounds(300, 140, 400, 30);
        religion.setBackground(Color.white);
        add(religion);
  
       
        
                
        JLabel fname =  new JLabel("Category" );
        fname.setFont(new Font("Railway",Font.BOLD,20));
        fname.setBounds(100, 190, 200, 30);
        add(fname);
        
        String valcategory[] = {"","General","OBC","SC","St","Other"};
        category = new JComboBox(valcategory);
        category.setBounds(300, 190, 400, 30);
        category.setBackground(Color.white);
        add(category);
        
        
        JLabel dob =  new JLabel("Income" );
        dob.setFont(new Font("Railway",Font.BOLD,20));
        dob.setBounds(100, 240, 200, 30);
        add(dob);
        
        String incomecategory[] = {"","<1,50,000","<2,50,000","5,00,00","10,00,000"};
        income = new JComboBox(incomecategory);
        income.setBounds(300, 240, 400, 30);
        income.setBackground(Color.white);
        add(income);
        
        JLabel gender =  new JLabel("Education" );
        gender.setFont(new Font("Railway",Font.BOLD,20));
        gender.setBounds(100, 290, 200, 30);
        add(gender);
        JLabel email =  new JLabel("Qualification" );
        email.setFont(new Font("Railway",Font.BOLD,20));
        email.setBounds(100, 315, 200, 30);
        add(email);
        
        String educationvalues[] = {"","Non-Graduate","Graduate","Post Graduate","Doctrate","Other"};
        education = new JComboBox(educationvalues);
        education.setBounds(300, 315, 400, 30);
        education.setBackground(Color.white);
        add(education);
        
        
        JLabel marital =  new JLabel("Occupation" );
        marital.setFont(new Font("Railway",Font.BOLD,20));
        marital.setBounds(100, 390, 200, 30);
        add(marital);
        
        String occupationvalues[] = {"","Saaried","Self-Employed","Bussiness","Student","Retired","Other"};
        occupation = new JComboBox(occupationvalues);
        occupation.setBounds(300, 390, 400, 30);
        occupation.setBackground(Color.white);
        add(occupation);
   
        JLabel adderss =  new JLabel("PAN NO" );
        adderss.setFont(new Font("Railway",Font.BOLD,20));
        adderss.setBounds(100, 440, 200, 30);
        add(adderss);
        
        pan = new JTextField();
        pan.setFont(new Font("Railway",Font.BOLD,14));
        pan.setBounds(300, 440, 400, 30);
        add(pan);
        
        JLabel city =  new JLabel("Aadhar No" );
        city.setFont(new Font("Railway",Font.BOLD,20));
        city.setBounds(100, 490, 200, 30);
        add(city);
        
        Aadhar = new JTextField();
        Aadhar.setFont(new Font("Railway",Font.BOLD,14));
        Aadhar.setBounds(300, 490, 400, 30);
        add(Aadhar);
        
        JLabel state =  new JLabel("Senior Citizon" );
        state.setFont(new Font("Railway",Font.BOLD,20));
        state.setBounds(100, 540, 200, 30);
        add(state);
        
        syes = new JRadioButton("Yes");
        syes.setBounds(300,540,100,30);
        syes.setBackground(Color.white);
        add(syes);
        
        sno = new JRadioButton("No");
        sno.setBounds(450,540,100,30);
        sno.setBackground(Color.white);
        add(sno);
        
        ButtonGroup seniorcitizen = new ButtonGroup();
        seniorcitizen.add(syes);
        seniorcitizen.add(sno);
        
        JLabel pincode =  new JLabel("Existing Account" );
        pincode.setFont(new Font("Railway",Font.BOLD,20));
        pincode.setBounds(100, 590, 200, 30);
        add(pincode);
        
        eyes = new JRadioButton("Yes");
        eyes.setBounds(300,590,100,30);
        eyes.setBackground(Color.white);
        add(eyes);
        
        eno = new JRadioButton("No");
        eno.setBounds(450,590,100,30);
        eno.setBackground(Color.white);
        add(eno);
        
        ButtonGroup exeaccount = new ButtonGroup();
        exeaccount.add(eyes);
        exeaccount.add(eno);
        
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
         
         String sreligion = (String)religion.getSelectedItem();
         String scategory = (String)category.getSelectedItem();
         String sincome = (String)income.getSelectedItem();
         String seducation = (String)education.getSelectedItem();
         String soccupation = (String)occupation.getSelectedItem();
         String seniorcitizon = null;
         if(syes.isSelected()){
            seniorcitizon = "yes";
         }
         else if(sno.isSelected()){
             seniorcitizon= "no";
         }
         
         String existingaccount = null;
         if(eyes.isSelected()){
            existingaccount = "yes";
         }
         else if(eno.isSelected()){
             existingaccount= "no";
         }
         
         String span = pan.getText();
         String saadhar  = Aadhar.getText();
         
         
         try{
             Conn c = new Conn();
             String query = "Insert into signuptwo values('"+formno+"','"+sreligion+"','"+scategory+"','"+sincome+"','"+seducation+"','"+soccupation+"','"+span+"','"+saadhar+"','"+seniorcitizon+"','"+existingaccount+"')";
             c.s.executeUpdate(query);
             
             //signup3 object
             setVisible(false);
             new SignupThree(formno).setVisible(true);
             
         } catch (Exception e){
             System.out.println(e);
         }
         
     }
     public static void main(String[] args) {
         new SignupTwo("");
     }

 }
