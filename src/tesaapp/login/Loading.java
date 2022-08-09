package tesaapp.login;

import com.jtattoo.plaf.aluminium.AluminiumLookAndFeel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Loading extends javax.swing.JFrame {
    Timer timer;
    ActionListener action;
    LoginView hm; 
     
public Loading() {
    initComponents();
    setLocationRelativeTo(this);
    aksipo(); 
    timer = new Timer(30, action);
    timer.start();
}
    
public void aksipo(){
    action = new ActionListener() {

    @Override
    public void actionPerformed(ActionEvent e) {
        progressBar.setValue(progressBar.getValue() + 1); //persen progress bar bertambah setiap 5 kali
        progressBar.setStringPainted(true);
            if (progressBar.getPercentComplete() == 1.0) {
                timer.stop();
                hm = new LoginView(); 
                try { 
                   UIManager.setLookAndFeel(new AluminiumLookAndFeel()); 
                   new LoginView().setVisible(true);
                } catch (UnsupportedLookAndFeelException ex) { 
                   JOptionPane.showMessageDialog(null,"Sistem Operasi Anda Tidak Mendukung Tampilan Aplikasi ini, Tampilan Akan Berubah Menjadi Default..","Perhatian",JOptionPane.ERROR_MESSAGE);
                   }    
                dispose(); 
                }   
            }
    };  
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        progressBar = new javax.swing.JProgressBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Selamat Datang . . .");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel2.setText("Loading . . .");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 100, 20));

        progressBar.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        progressBar.setForeground(new java.awt.Color(204, 0, 204));
        getContentPane().add(progressBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 710, 20));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Loading.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Loading.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Loading.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Loading.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Loading().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JProgressBar progressBar;
    // End of variables declaration//GEN-END:variables
}
