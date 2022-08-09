package tesaapp.menu;

import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;
import tesaapp.koneksi.Koneksi;
import tesaapp.utils.JavaTerbilang;

public class Pembayaran_Sewa extends javax.swing.JFrame {

    JasperReport jasperReport; 
    JasperDesign jasperDesign;
    JasperPrint jasperPrint; 
    Map <String,Object> parham = new HashMap<String,Object>();
    Connection con;
    Statement st;
    Koneksi kon = new Koneksi();
    String query, JK;
    public Pembayaran_Sewa() {
        initComponents();
        viewSewaByNo();
    }
private void viewSewaByNo(){
        try{
          con=kon.open();
          st=con.createStatement(); 
          query="SELECT no_sewa FROM tb_sewa s WHERE s.status_id != 1 ORDER BY s.created_at DESC";
            try (ResultSet rs = st.executeQuery(query)) {
            while(rs.next()){
                cbNoSewa.addItem(rs.getString("s.no_sewa"));  
            }
            con.close();
            st.close();
            rs.close();
            }
        }catch(SQLException sqle){
          JOptionPane.showMessageDialog(null,"Error viewRuang "+sqle);
        }  
    }
    private void ViewDetailSewaByNo(){  
    try{
          con=kon.open();
          st=con.createStatement(); 
          query="SELECT * FROM tb_sewa s JOIN tb_ruang r ON s.ruang_id=r.id JOIN tb_penyewa p ON s.penyewa_id=p.id WHERE s.no_sewa='"+cbNoSewa.getSelectedItem()+"' AND s.status_id != 1";
        try (ResultSet rs = st.executeQuery(query)) {
            while(rs.next()){ 
               lblNosewa.setText(rs.getString("s.no_sewa"));
               lblTglSewa.setText(rs.getString("s.tgl_sewa"));
               lblTglAwal.setText(rs.getString("s.periode_awal")); 
               lblTglAkhir.setText(rs.getString("s.periode_akhir"));
               lblJumlah.setText(rs.getString("s.periode_total"));
               lblHarga.setText(rs.getString("s.harga")); 
               lblTotal.setText(rs.getString("s.total"));
               terbilangTotal();
                
               lblNamaRuang.setText(rs.getString("r.nama")); 
               lblLuas.setText(rs.getString("r.luas")+" Meter");
               txtDescRuang.setText(rs.getString("r.deskripsi"));
               
                lblNamaPenyewa.setText(rs.getString("p.nama"));
                lblTelepon.setText(rs.getString("p.no_tlp"));
                txtEmail.setText(rs.getString("p.email"));
                txtAlamat.setText(rs.getString("p.alamat"));
            }
            con.close();
            st.close();
            rs.close();
        } 
      }catch(SQLException sqle){
          JOptionPane.showMessageDialog(null,"Error ViewDetailSewaByNo "+sqle);
      }
}
private void terbilangTotal(){
    int totyar =Integer.parseInt(lblTotal.getText()); 
    lblSayTotal.setText(new JavaTerbilang(totyar).toString());
}    
private void UpdatePembayaran(){
    try{ 
        con=kon.open();
        st=con.createStatement();
        query = "UPDATE tb_sewa SET status_id='1', tgl_pembayaran=DATE_FORMAT(NOW(),'%d/%m/%Y'), say_total='"+lblSayTotal.getText()+"' WHERE no_sewa='"+lblNosewa.getText()+"'";
        st.executeUpdate(query);
        con.close();
        st.close();   
        Cetak_Data_Kuitansi();
        viewSewaByNo();
    }catch (Exception sqle){
        JOptionPane.showMessageDialog(null,"Maaf, Proses Data Gagal "+sqle.getMessage());
    } 
}

private void Cetak_Data_Perjanjian() throws SQLException{
    try { 
        con=kon.open();
//        File file = new File("src/tesaapp/report/Lap_Perjanjian.jrxml"); 
        File file = new File("C://tesaapp/report/Lap_Perjanjian.jrxml"); 
        jasperDesign = JRXmlLoader.load(file);  
        parham.put("NO_SEWA",lblNosewa.getText());   
        jasperReport = JasperCompileManager.compileReport(jasperDesign);
        jasperPrint = JasperFillManager.fillReport(jasperReport,parham,con);
        JasperViewer.viewReport(jasperPrint, false);    
        parham.clear();        
    } catch (JRException e) {
        System.err.println("Error "+e);
    }
      con.close(); 
}

private void Cetak_Data_Kuitansi() throws SQLException{
    try { 
        con=kon.open();
//        File file = new File("src/tesaapp/report/Lap_Kuitansi.jrxml"); 
        File file = new File("C://tesaapp/report/Lap_Kuitansi.jrxml"); 
        jasperDesign = JRXmlLoader.load(file);  
        parham.put("NO_SEWA",lblNosewa.getText());   
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

        jLabel8 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel15 = new javax.swing.JLabel();
        cbNoSewa = new javax.swing.JComboBox();
        jPanel1 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        lblTelepon = new javax.swing.JLabel();
        lblNamaPenyewa = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtAlamat = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        lblTglSewa = new javax.swing.JLabel();
        lblTglAwal = new javax.swing.JLabel();
        lblTglAkhir = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        lblNosewa = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        lblHarga = new javax.swing.JLabel();
        lblJumlah = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        lblLuas = new javax.swing.JLabel();
        lblNamaRuang = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescRuang = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        lblSayTotal = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Menu Pembayaran & Perjanjian Sewa Ruang");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 0, 480, 30));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 1190, 10));

        jLabel15.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel15.setText("No. Sewa");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 110, 30));

        cbNoSewa.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        cbNoSewa.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Pilih" }));
        cbNoSewa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbNoSewaActionPerformed(evt);
            }
        });
        getContentPane().add(cbNoSewa, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 50, 170, 30));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Detail Penyewa"));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel24.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel24.setText("Nama Penyewa");
        jPanel1.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 110, 30));

        jLabel25.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel25.setText("No. Telepon");
        jPanel1.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 110, 30));

        lblTelepon.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblTelepon.setText("lblTelepon");
        jPanel1.add(lblTelepon, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 50, 140, 30));

        lblNamaPenyewa.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblNamaPenyewa.setText("lblNamaPenyewa");
        jPanel1.add(lblNamaPenyewa, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 20, 140, 30));

        txtEmail.setEditable(false);
        txtEmail.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtEmail.setOpaque(false);
        txtEmail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtEmailKeyPressed(evt);
            }
        });
        jPanel1.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 90, 210, 30));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel5.setText("Email");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 90, 30));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel2.setText("Alamat");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 90, 30));

        txtAlamat.setEditable(false);
        txtAlamat.setColumns(20);
        txtAlamat.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        txtAlamat.setRows(5);
        txtAlamat.setOpaque(false);
        jScrollPane3.setViewportView(txtAlamat);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 130, 310, 90));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 90, 450, 240));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Detail Sewa"));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel17.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel17.setText("Tgl. Sewa");
        jPanel2.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 110, 30));

        lblTglSewa.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblTglSewa.setText("lblTglSewa");
        jPanel2.add(lblTglSewa, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, 140, 30));

        lblTglAwal.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblTglAwal.setText("lblTglAwal");
        jPanel2.add(lblTglAwal, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 80, 140, 30));

        lblTglAkhir.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblTglAkhir.setText("lblTglAkhir");
        jPanel2.add(lblTglAkhir, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 110, 140, 30));

        jLabel19.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel19.setText("Tgl. Akhir");
        jPanel2.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 110, 30));

        jLabel18.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel18.setText("Tgl. Awal");
        jPanel2.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 110, 30));

        lblNosewa.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblNosewa.setText("lblNosewa");
        jPanel2.add(lblNosewa, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 170, 30));

        jLabel20.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel20.setText("Jumlah");
        jPanel2.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 110, 30));

        jLabel21.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel21.setText("Harga");
        jPanel2.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 110, 30));

        lblTotal.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblTotal.setText("lblTotal");
        jPanel2.add(lblTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 200, 140, 30));

        lblHarga.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblHarga.setText("lblHarga");
        jPanel2.add(lblHarga, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 170, 140, 30));

        lblJumlah.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblJumlah.setText("lblJumlah");
        jPanel2.add(lblJumlah, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 140, 140, 30));

        jLabel26.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel26.setText("Total");
        jPanel2.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 110, 30));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 280, 240));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Detail Ruang"));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel16.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel16.setText("Nama Ruang");
        jPanel3.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 110, 30));

        jLabel23.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel23.setText("Luas");
        jPanel3.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 110, 30));

        lblLuas.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblLuas.setText("lblLuas");
        jPanel3.add(lblLuas, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, 140, 30));

        lblNamaRuang.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblNamaRuang.setText("lblNamaRuang");
        jPanel3.add(lblNamaRuang, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, 290, 30));

        txtDescRuang.setEditable(false);
        txtDescRuang.setColumns(20);
        txtDescRuang.setRows(5);
        txtDescRuang.setOpaque(false);
        jScrollPane1.setViewportView(txtDescRuang);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 80, 290, 140));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 90, 420, 240));

        jButton1.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tesaapp/img/icons8-escrow-process-50.png"))); // NOI18N
        jButton1.setText("Proses");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 340, 260, 70));

        lblSayTotal.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lblSayTotal.setText("lblSayTotal");
        getContentPane().add(lblSayTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, 410, 30));

        jButton4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tesaapp/img/print toolbar.png"))); // NOI18N
        jButton4.setText("Cetak Surat Perjanjian");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 340, 260, 70));

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

    private void cbNoSewaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbNoSewaActionPerformed
        ViewDetailSewaByNo();
    }//GEN-LAST:event_cbNoSewaActionPerformed

    private void txtEmailKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEmailKeyPressed

    }//GEN-LAST:event_txtEmailKeyPressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        // update status, tgl_pembayaran tb_sewa
        UpdatePembayaran();
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        try {
            // perjanjian sewa
            Cetak_Data_Perjanjian();
        } catch (SQLException ex) {
            Logger.getLogger(Pembayaran_Sewa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    
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
            java.util.logging.Logger.getLogger(Pembayaran_Sewa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Pembayaran_Sewa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Pembayaran_Sewa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Pembayaran_Sewa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Pembayaran_Sewa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cbNoSewa;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblHarga;
    private javax.swing.JLabel lblJumlah;
    private javax.swing.JLabel lblLuas;
    private javax.swing.JLabel lblNamaPenyewa;
    private javax.swing.JLabel lblNamaRuang;
    private javax.swing.JLabel lblNosewa;
    private javax.swing.JLabel lblSayTotal;
    private javax.swing.JLabel lblTelepon;
    private javax.swing.JLabel lblTglAkhir;
    private javax.swing.JLabel lblTglAwal;
    private javax.swing.JLabel lblTglSewa;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JTextArea txtAlamat;
    private javax.swing.JTextArea txtDescRuang;
    private javax.swing.JTextField txtEmail;
    // End of variables declaration//GEN-END:variables
}
