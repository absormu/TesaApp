package tesaapp.login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class connect {
    private static Connection connection;
    
    public static Connection getConnection() {
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/dbwisma_mandiri"; 
        String user = "root";
        String password = ""; 

        if (connection == null){
            try{
            Class.forName(driver);
            connection = DriverManager.getConnection(url, user, password); 
            }catch(ClassNotFoundException | SQLException error){
                JOptionPane.showMessageDialog(null, "Terjadi kesalahan : "+error, "Koneksi", JOptionPane.ERROR_MESSAGE); 
            }         
        } 
        return connection;  
    }
}

