package tesaapp;

import com.jtattoo.plaf.aluminium.AluminiumLookAndFeel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import tesaapp.login.Loading;


public class TesaApp {

    public static void main(String[] args) {
       try { 
            UIManager.setLookAndFeel(new AluminiumLookAndFeel()); 
            new Loading().setVisible(true);
        } catch (UnsupportedLookAndFeelException ex) { 
            JOptionPane.showMessageDialog(null,"Sistem Operasi Anda Tidak Mendukung Tampilan Aplikasi ini, Tampilan Akan Berubah Menjadi Default..","Perhatian",JOptionPane.ERROR_MESSAGE);
        }   
    }
}
