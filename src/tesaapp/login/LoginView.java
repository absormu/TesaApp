package tesaapp.login;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date; 
import javax.swing.JOptionPane;
import javax.swing.Timer; 
import tesaapp.menu.Menu_Utama;
import tesaapp.koneksi.Koneksi;


public class LoginView extends javax.swing.JFrame {
    private final LoginImplements loginImplements = new LoginImplements(); 
    Connection con;
    Statement st;
    String query;
    Koneksi kon=new Koneksi(); 
    private final String pattern = "dd/MM/yyyy";
    private final SimpleDateFormat format;
    private final Timer timer;
    private final Date date;
    
    private final ActionListener taskPerformer = new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
            date.setTime(System.currentTimeMillis());
            lblTanggal.setText(format.format(date)); 
        }
    };
    public LoginView() {
        initComponents();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (dim.width-getWidth())/2;
        int y = (dim.height-getHeight())/2;
        setLocation(x, y);
        timer = new Timer(1000, taskPerformer);
        format = new SimpleDateFormat(pattern);
        date = new Date();
        timer.start();   
    }    
    
private void LogicLogin(){
    try{            
        String namaPengguna = textNamaPengguna.getText();
        String password = textPassword.getText();
        Login login = loginImplements.getLogin(namaPengguna, password);
            
        if(login.getIdPegawai().equals("TIDAK ADA")){ 
            JOptionPane.showMessageDialog(this, "Nama Pengguna atau Kata Sandi Salah !!!");
        }else{  
        this.dispose();
        Menu_Utama menu = new Menu_Utama();
        menu.lblJabatan.setText(login.getJabatanPegawai());
        menu.lblNamaPegawai.setText(login.getNamaPegawai()); 
        menu.lblIdPegawai.setText(login.getIdPegawai()); 
        
        menu.setVisible(true);  
        } 
    }catch(Exception exception){
        System.out.println("Terjadi kesalahan LogicLogin: "+exception);
        System.exit(0);
    }
} 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        textPassword = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        lblTanggal1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lblNama = new javax.swing.JLabel();
        lblShift = new javax.swing.JLabel();
        lblPos = new javax.swing.JLabel();
        lblIP = new javax.swing.JLabel();
        lblTanggal = new javax.swing.JLabel();
        textNamaPengguna = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menu Login");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        textPassword.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        textPassword.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        textPassword.setOpaque(false);
        textPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textPasswordActionPerformed(evt);
            }
        });
        getContentPane().add(textPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 100, 270, 30));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel1.setText("Kata Sandi");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 170, 30));

        lblTanggal1.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        lblTanggal1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tesaapp/img/Logo-1.png"))); // NOI18N
        getContentPane().add(lblTanggal1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 240, 60));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 430, 10));
        getContentPane().add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 430, 10));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel6.setText("Menu Login");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 10, 180, 40));

        jPanel1.setBackground(new java.awt.Color(255, 0, 102));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblNama.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lblNama.setText("lblNama");
        jPanel1.add(lblNama, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 90, 30));

        lblShift.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblShift.setText("lblShift");
        jPanel1.add(lblShift, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 90, 20));

        lblPos.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lblPos.setText("1");
        jPanel1.add(lblPos, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 70, 30));

        lblIP.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lblIP.setText("lblIP");
        jPanel1.add(lblIP, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 50, 30));

        lblTanggal.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lblTanggal.setText("lblTanggal");
        jPanel1.add(lblTanggal, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 40, 50, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 10, 0));

        textNamaPengguna.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        textNamaPengguna.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        textNamaPengguna.setOpaque(false);
        textNamaPengguna.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textNamaPenggunaActionPerformed(evt);
            }
        });
        getContentPane().add(textNamaPengguna, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 70, 270, -1));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel7.setText("Nama Pengguna");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 170, 30));

        jMenuBar1.setBorder(null);

        jMenu1.setText("Wisma Mandiri");
        jMenu1.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_UP, 0));
        jMenuItem1.setText("Up");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_DOWN, 0));
        jMenuItem2.setText("Down");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, 0));
        jMenuItem3.setText("Exit");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void textPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textPasswordActionPerformed
        if( textPassword.getText().equals("")){ 
            JOptionPane.showMessageDialog(null, "TIDAK BOLEH KOSONG", "KATA SANDI", JOptionPane.ERROR_MESSAGE); 
            textPassword.requestFocus();
        }else{
            LogicLogin();
        }
    }//GEN-LAST:event_textPasswordActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        textNamaPengguna.requestFocus(); 
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        textPassword.requestFocus(); 
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
         System.exit(0);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void textNamaPenggunaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textNamaPenggunaActionPerformed
         if( textNamaPengguna.getText().equals("")){ 
            JOptionPane.showMessageDialog(null, "TIDAK BOLEH KOSONG", "NAMA PENGGUNA", JOptionPane.ERROR_MESSAGE); 
            textNamaPengguna.requestFocus();
        }else{
            textPassword.requestFocus(); 
        }
    }//GEN-LAST:event_textNamaPenggunaActionPerformed

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
            java.util.logging.Logger.getLogger(LoginView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblIP;
    private javax.swing.JLabel lblNama;
    private javax.swing.JLabel lblPos;
    private javax.swing.JLabel lblShift;
    private javax.swing.JLabel lblTanggal;
    private javax.swing.JLabel lblTanggal1;
    private javax.swing.JTextField textNamaPengguna;
    private javax.swing.JPasswordField textPassword;
    // End of variables declaration//GEN-END:variables
}
