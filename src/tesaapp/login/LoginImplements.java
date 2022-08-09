package tesaapp.login;

import com.mysql.jdbc.Statement;
import java.sql.ResultSet;
import java.sql.SQLException; 

public class LoginImplements {
    
    public Login getLogin(String namaPengguna, String password) throws Exception {
        String sqlSelect = "SELECT id_pegawai,nama_pegawai,id_jabatan FROM tb_pegawai WHERE id_jabatan = 'Administrasi'  AND nama_pengguna = '"+namaPengguna+"' AND password = '"+password+"'";
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            statement = (Statement) connect.getConnection().createStatement();
            resultSet = statement.executeQuery(sqlSelect);

            Login login = new Login();
           
            if(resultSet.next()) {
                login.setJabatanPegawai(resultSet.getString("id_jabatan"));
                login.setNamaPegawai(resultSet.getString("nama_pegawai"));
                login.setIdPegawai(resultSet.getString("id_pegawai"));
            }else{
                login.setIdPegawai("TIDAK ADA");
            }
            
            statement.close();
            resultSet.close();
            return login;
        } catch(SQLException exception) {
            System.out.println("Terjadi kesalahan : "+exception);
            return null;
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                    resultSet.close();
                } catch(SQLException exception) {
                    System.out.println("Terjadi kesalahan : "+exception);
                }
            }
        }
    }   
}