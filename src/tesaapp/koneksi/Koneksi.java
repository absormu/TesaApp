package tesaapp.koneksi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
 
public class Koneksi {
    
    public Koneksi(){}
    
    Connection con=null;
    Statement st=null;

public Connection open(){
    try{
        Class.forName("com.mysql.jdbc.Driver");  
        con=DriverManager.getConnection("jdbc:mysql://localhost:3306/dbwisma_mandiri","root","");
     return con;
    }catch(SQLException sqle){
        System.out.print("Tidak Ada Koneksi Yang Terbuka "+sqle);    
        javax.swing.JOptionPane.showMessageDialog(null,"Tidak Ada Koneksi Yang Terbuka" +sqle.getMessage());
        return null;
    }catch(Exception e){
        javax.swing.JOptionPane.showMessageDialog(null,"koneksi gagal " +e.getMessage());
        System.out.print("Tidak Bisa Membuka Koneksi........"+e.getMessage());
        return null;
}
}
public void QUERY(String data , String option){
    try{        
        if(con==null) con=open();
        if(st==null) st=con.createStatement();
        st.executeUpdate(data);
        javax.swing.JOptionPane.showMessageDialog(null,"Data Berhasil "+option);
    }catch(SQLException sqle){
        sqle.printStackTrace();
        javax.swing.JOptionPane.showMessageDialog(null,"Data Gagal"+option+"SalahNya:"+sqle.getMessage());
    }
} 
}
