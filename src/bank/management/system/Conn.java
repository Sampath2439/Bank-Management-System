package bank.management.system;
import java.sql.*;

class Conn{
 Connection c;
 Statement s;
    Conn(){
        try{
            c = DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem", "root", "Gnana2439@");
            s=c.createStatement();
        } catch(Exception e){
            System.out.println(e);
        }
    }
}