/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tesaapp.menu.cetak;

import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
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

/**
 *
 * @author dell
 */
public class Cetak_Sewa extends javax.swing.JFrame {

    JasperReport jasperReport; 
    JasperDesign jasperDesign;
    JasperPrint jasperPrint; 
    Map <String,Object> parham = new HashMap<String,Object>();
    private DefaultTableModel modelTabel;
    private String[] arrMP;
    Connection con;
    Statement st;
    Koneksi kon = new Koneksi();
    String query, JK;
    String Id = "0";
    private String tgl1;
    private String tgl2;
    public Cetak_Sewa() {
        initComponents();
         Date date = new Date();
        jDateAwal.setDate(date); 
        jDateAkhir.setDate(date);  
    }

    private void Cetak_Data() throws SQLException{
    try { 
        con=kon.open();
        File file = new File("src/tesaapp/report/Lap_Sewa_List.jrxml"); 
//        File file = new File("C://tesaapp/report/Lap_Sewa_List.jrxml"); 
        jasperDesign = JRXmlLoader.load(file);  
        parham.put("TGL1",tgl1); 
        parham.put("TGL2",tgl2);   
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
        jLabel8 = new javax.swing.JLabel();
        jDateAwal = new com.toedter.calendar.JDateChooser();
        jLabel13 = new javax.swing.JLabel();
        jDateAkhir = new com.toedter.calendar.JDateChooser();
        btnPrint = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Periode", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 11))); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel8.setText("Cari berdasarkan tanggal transaksi :");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 220, 30));

        jDateAwal.setDateFormatString("dd/MM/yyyy");
        jDateAwal.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jDateAwal.setOpaque(false);
        jDateAwal.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jDateAwalPropertyChange(evt);
            }
        });
        jPanel1.add(jDateAwal, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 150, 30));

        jLabel13.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Sd");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 50, 40, 30));

        jDateAkhir.setDateFormatString("dd/MM/yyyy");
        jDateAkhir.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jDateAkhir.setOpaque(false);
        jDateAkhir.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jDateAkhirPropertyChange(evt);
            }
        });
        jPanel1.add(jDateAkhir, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 50, 150, 30));

        btnPrint.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnPrint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tesaapp/img/print toolbar.png"))); // NOI18N
        btnPrint.setText("Cetak Data");
        btnPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintActionPerformed(evt);
            }
        });
        jPanel1.add(btnPrint, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 90, 140, 50));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 370, 150));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Menu Cetak Sewa Ruangan");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 370, 40));

        jMenu1.setText("Wisma Mandiri");
        jMenu1.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, 0));
        jMenuItem1.setText("Close");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        dispose();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jDateAwalPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jDateAwalPropertyChange
        if (jDateAwal.getDate() != null) {
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            tgl1 = format.format(jDateAwal.getDate());
        }
    }//GEN-LAST:event_jDateAwalPropertyChange

    private void jDateAkhirPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jDateAkhirPropertyChange
        if (jDateAkhir.getDate() != null) {
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            tgl2 = format.format(jDateAkhir.getDate());
        }
    }//GEN-LAST:event_jDateAkhirPropertyChange

    private void btnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintActionPerformed
 
        try { 
            Cetak_Data();
        } catch (SQLException ex) {
            Logger.getLogger(Cetak_Sewa.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.dispose();
    }//GEN-LAST:event_btnPrintActionPerformed

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
            java.util.logging.Logger.getLogger(Cetak_Sewa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cetak_Sewa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cetak_Sewa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cetak_Sewa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Cetak_Sewa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPrint;
    private com.toedter.calendar.JDateChooser jDateAkhir;
    private com.toedter.calendar.JDateChooser jDateAwal;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
