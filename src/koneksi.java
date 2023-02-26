import java.sql.*;
import javax.swing.JOptionPane;

public class koneksi {
 private String url="jdbc:mysql://localhost/uh_202062";
 private String username_laragon = "root";
 private String password_laragon = "";
 private Connection con;
 
 
 public void connect(){
     try {
         con = DriverManager.getConnection(url, username_laragon, password_laragon);
         System.out.println("Databases Connect Success!");
     } catch (Exception e) {
         JOptionPane.showMessageDialog(null, e.getMessage());
     }
 
 }

    public Connection getCon() {
        return con;
    }
    
}