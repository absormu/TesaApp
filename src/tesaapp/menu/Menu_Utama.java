package tesaapp.menu;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;
import tesaapp.koneksi.Koneksi;
import tesaapp.menu.cetak.Cetak_Pembayaran_Sewa;
import tesaapp.menu.cetak.Cetak_Perjanjian;
import tesaapp.menu.cetak.Cetak_Sewa;

public class Menu_Utama extends javax.swing.JFrame {
    
    JasperReport jasperReport; 
    JasperDesign jasperDesign;
    JasperPrint jasperPrint; 
    Map <String,Object> parham = new HashMap<String,Object>(); 
    Connection con;
    Statement st;
    Koneksi kon = new Koneksi();
    String query; 
    public Menu_Utama() {
        initComponents();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds(0, 0, screenSize.width, screenSize.height); 
    }

private void Cetak_Data_Pegawai() throws SQLException{
    try { 
        con=kon.open();
//        File file = new File("src/tesaapp/report/Lap_Pegawai.jrxml"); 
        File file = new File("C://tesaapp/report/Lap_Pegawai.jrxml"); 
        jasperDesign = JRXmlLoader.load(file);  
        jasperReport = JasperCompileManager.compileReport(jasperDesign);
        jasperPrint = JasperFillManager.fillReport(jasperReport,parham,con);
        JasperViewer.viewReport(jasperPrint, false);    
        parham.clear();        
    } catch (JRException e) {
        System.err.println("Error "+e);
    }
      con.close(); 
}  

private void Cetak_Data_Ruang() throws SQLException{
    try { 
        con=kon.open();
//        File file = new File("src/tesaapp/report/Lap_Ruang.jrxml"); 
        File file = new File("C://tesaapp/report/Lap_Ruang.jrxml"); 
        jasperDesign = JRXmlLoader.load(file);  
        jasperReport = JasperCompileManager.compileReport(jasperDesign);
        jasperPrint = JasperFillManager.fillReport(jasperReport,parham,con);
        JasperViewer.viewReport(jasperPrint, false);    
        parham.clear();        
    } catch (JRException e) {
        System.err.println("Error "+e);
    }
      con.close(); 
} 

private void Cetak_Data_Penyewa() throws SQLException{
    try { 
        con=kon.open();
//        File file = new File("src/tesaapp/report/Lap_Penyewa.jrxml"); 
        File file = new File("C://tesaapp/report/Lap_Penyewa.jrxml"); 
        jasperDesign = JRXmlLoader.load(file);  
        jasperReport = JasperCompileManager.compileReport(jasperDesign);
        jasperPrint = JasperFillManager.fillReport(jasperReport,parham,con);
        JasperViewer.viewReport(jasperPrint, false);    
        parham.clear();        
    } catch (JRException e) {
        System.err.println("Error "+e);
    }
      con.close(); 
} 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblNamaPegawai = new javax.swing.JLabel();
        lblJabatan = new javax.swing.JLabel();
        lblNamaPegawai2 = new javax.swing.JLabel();
        lblNamaPegawai3 = new javax.swing.JLabel();
        lblNamaPegawai4 = new javax.swing.JLabel();
        lblNamaPegawai10 = new javax.swing.JLabel();
        lblIdPegawai = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem13 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem14 = new javax.swing.JMenuItem();
        jMenuItem15 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenuItem16 = new javax.swing.JMenuItem();
        jMenuItem17 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem9 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Wisma Mandiri");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblNamaPegawai.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lblNamaPegawai.setForeground(new java.awt.Color(255, 51, 51));
        lblNamaPegawai.setText("lblNamaPegawai");
        jPanel1.add(lblNamaPegawai, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, 240, 30));

        lblJabatan.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lblJabatan.setForeground(new java.awt.Color(0, 0, 255));
        lblJabatan.setText("lblJabatan");
        jPanel1.add(lblJabatan, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 170, 30));

        lblNamaPegawai2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lblNamaPegawai2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tesaapp/img/contact3.png"))); // NOI18N
        lblNamaPegawai2.setText("Hai, Selamat Datang ");
        jPanel1.add(lblNamaPegawai2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 1360, 570));

        lblNamaPegawai3.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
        lblNamaPegawai3.setText("Sistem Informasi Sewa Ruang Serbaguna");
        jPanel1.add(lblNamaPegawai3, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 0, 930, 90));

        lblNamaPegawai4.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
        lblNamaPegawai4.setText("Wisma Mandiri Jakarta Pusat");
        jPanel1.add(lblNamaPegawai4, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 80, 690, 60));

        lblNamaPegawai10.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lblNamaPegawai10.setText("Hai, Selamat Datang ");
        jPanel1.add(lblNamaPegawai10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 170, 30));

        lblIdPegawai.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lblIdPegawai.setText("lblIdPegawai");
        jPanel1.add(lblIdPegawai, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 170, 0));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1360, 720));

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tesaapp/img/ico_alpha_Cube_16x16.png"))); // NOI18N
        jMenu1.setText("Master Data");
        jMenu1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, 0));
        jMenuItem1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tesaapp/img/ico_alpha_Nav_Right_16x16.png"))); // NOI18N
        jMenuItem1.setText("Data Pegawai");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem7.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, 0));
        jMenuItem7.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jMenuItem7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tesaapp/img/ico_alpha_Nav_Right_16x16.png"))); // NOI18N
        jMenuItem7.setText("Data Ruangan");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem7);

        jMenuItem13.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_W, 0));
        jMenuItem13.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jMenuItem13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tesaapp/img/ico_alpha_Nav_Right_16x16.png"))); // NOI18N
        jMenuItem13.setText("Data Penyewa");
        jMenuItem13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem13ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem13);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, 0));
        jMenuItem2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tesaapp/img/ico_alpha_Nav_Right_16x16.png"))); // NOI18N
        jMenuItem2.setText("Keluar");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tesaapp/img/ico_alpha_Cube_16x16.png"))); // NOI18N
        jMenu2.setText("Transaksi");
        jMenu2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        jMenuItem6.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jMenuItem6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tesaapp/img/ico_alpha_Nav_Right_16x16.png"))); // NOI18N
        jMenuItem6.setText("Input Sewa Ruang");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem6);

        jMenuItem14.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jMenuItem14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tesaapp/img/ico_alpha_Nav_Right_16x16.png"))); // NOI18N
        jMenuItem14.setText("Daftar Sewa Ruang");
        jMenuItem14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem14ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem14);

        jMenuItem15.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jMenuItem15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tesaapp/img/ico_alpha_Nav_Right_16x16.png"))); // NOI18N
        jMenuItem15.setText("Pembayaran Sewa Ruang");
        jMenuItem15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem15ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem15);

        jMenuBar1.add(jMenu2);

        jMenu3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tesaapp/img/ico_alpha_Cube_16x16.png"))); // NOI18N
        jMenu3.setText("Laporan");
        jMenu3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        jMenuItem8.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jMenuItem8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tesaapp/img/ico_alpha_Nav_Right_16x16.png"))); // NOI18N
        jMenuItem8.setText("Cetak Data Pegawai");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem8);

        jMenuItem10.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jMenuItem10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tesaapp/img/ico_alpha_Nav_Right_16x16.png"))); // NOI18N
        jMenuItem10.setText("Cetak Data Ruang");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem10);

        jMenuItem11.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jMenuItem11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tesaapp/img/ico_alpha_Nav_Right_16x16.png"))); // NOI18N
        jMenuItem11.setText("Cetak Data Penyewa");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem11);

        jMenuItem12.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jMenuItem12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tesaapp/img/ico_alpha_Nav_Right_16x16.png"))); // NOI18N
        jMenuItem12.setText("Cetak Data Sewa");
        jMenuItem12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem12ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem12);

        jMenuItem16.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jMenuItem16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tesaapp/img/ico_alpha_Nav_Right_16x16.png"))); // NOI18N
        jMenuItem16.setText("Cetak Data Perjanjian");
        jMenuItem16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem16ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem16);

        jMenuItem17.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jMenuItem17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tesaapp/img/ico_alpha_Nav_Right_16x16.png"))); // NOI18N
        jMenuItem17.setText("Cetak Data Pembayaran");
        jMenuItem17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem17ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem17);

        jMenuBar1.add(jMenu3);

        jMenu4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tesaapp/img/ico_alpha_Cube_16x16.png"))); // NOI18N
        jMenu4.setText("Lain");
        jMenu4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        jMenuItem9.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jMenuItem9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tesaapp/img/ico_alpha_Nav_Right_16x16.png"))); // NOI18N
        jMenuItem9.setText("Tentang Saya");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem9);

        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        new Master_Pegawai(this, rootPaneCheckingEnabled).show();  
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        int confirm = JOptionPane.showConfirmDialog(this,
            "Apakah anda yakin akan keluar dari program ini ?",
            "Konfirmasi",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE);
        if (confirm == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        UpdateConfig();
        try {  
            new Input_Sewa(this, rootPaneCheckingEnabled).show();
        } catch (SQLException ex) {
            Logger.getLogger(Menu_Utama.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
         new Master_Ruang(this, rootPaneCheckingEnabled).show();  
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
         try {
             Cetak_Data_Pegawai();
         } catch (SQLException ex) {
             Logger.getLogger(Menu_Utama.class.getName()).log(Level.SEVERE, null, ex);
         }
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
         try {
             Cetak_Data_Ruang();
         } catch (SQLException ex) {
             Logger.getLogger(Menu_Utama.class.getName()).log(Level.SEVERE, null, ex);
         }
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
         try {
             Cetak_Data_Penyewa();
         } catch (SQLException ex) {
             Logger.getLogger(Menu_Utama.class.getName()).log(Level.SEVERE, null, ex);
         }
    }//GEN-LAST:event_jMenuItem11ActionPerformed

    private void jMenuItem12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem12ActionPerformed
        Cetak_Sewa frame = new Cetak_Sewa(); 
        frame.setDefaultCloseOperation(2);
        frame.setSize(375, 250);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
    }//GEN-LAST:event_jMenuItem12ActionPerformed

    private void jMenuItem13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem13ActionPerformed
        new Master_Penyewa(this, rootPaneCheckingEnabled).show();  
    }//GEN-LAST:event_jMenuItem13ActionPerformed

    private void jMenuItem14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem14ActionPerformed
        List_Sewa frame = new List_Sewa(); 
        frame.setDefaultCloseOperation(2);
        frame.setSize(950, 730);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
    }//GEN-LAST:event_jMenuItem14ActionPerformed

    private void jMenuItem15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem15ActionPerformed
        Pembayaran_Sewa frame = new Pembayaran_Sewa(); 
        frame.setDefaultCloseOperation(2);
        frame.setSize(1190, 470);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
    }//GEN-LAST:event_jMenuItem15ActionPerformed

    private void jMenuItem16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem16ActionPerformed
       Cetak_Perjanjian frame = new Cetak_Perjanjian(); 
        frame.setDefaultCloseOperation(2);
        frame.setSize(375, 250);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
    }//GEN-LAST:event_jMenuItem16ActionPerformed

    private void jMenuItem17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem17ActionPerformed
        Cetak_Pembayaran_Sewa frame = new Cetak_Pembayaran_Sewa(); 
        frame.setDefaultCloseOperation(2);
        frame.setSize(375, 250);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
    }//GEN-LAST:event_jMenuItem17ActionPerformed

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
            java.util.logging.Logger.getLogger(Menu_Utama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu_Utama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu_Utama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu_Utama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu_Utama().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem15;
    private javax.swing.JMenuItem jMenuItem16;
    private javax.swing.JMenuItem jMenuItem17;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JLabel lblIdPegawai;
    public javax.swing.JLabel lblJabatan;
    public javax.swing.JLabel lblNamaPegawai;
    public javax.swing.JLabel lblNamaPegawai10;
    public javax.swing.JLabel lblNamaPegawai2;
    public javax.swing.JLabel lblNamaPegawai3;
    public javax.swing.JLabel lblNamaPegawai4;
    // End of variables declaration//GEN-END:variables

private void UpdateConfig(){
    try{ 
        con=kon.open();
        st=con.createStatement();
        query = "UPDATE `tb_config` SET nama='"+lblNamaPegawai.getText()+"' , pegawai_id='"+lblIdPegawai.getText()+"' WHERE id='1'";
        st.executeUpdate(query); 
        con.close();
        st.close();  
    }catch (Exception sqle){ 
        System.out.println(sqle);
    } 
}
}
