package tesaapp.menu;

import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import tesaapp.koneksi.Koneksi;
import tesaapp.utils.SelisihDateTime;

public class Input_Sewa extends javax.swing.JDialog {
    private DefaultTableModel modelTabel;
    private String[] arrMP;
    Connection con;
    Statement st;
    Koneksi kon = new Koneksi();
    String query, JK;
    String nama = "0";
    private String tgl1;
    private String tgl2;
    private String idRuang, idPenyewa;
    private String namaConfig;
    private String IDConfig;
    private int total;
    public Input_Sewa(java.awt.Frame parent, boolean modal) throws SQLException {
        super(parent, modal);
        initComponents(); 
        setLocationRelativeTo(this); 
        Date date = new Date();
        jDateAwal.setDate(date); 
        jDateAkhir.setDate(date); 
        viewRuang();
        viewPenyewa();
        ViewConfig();
        AutoNumberSewa();
    }
    private void viewRuang(){
        try{
          con=kon.open();
          st=con.createStatement(); 
          query="SELECT nama FROM tb_ruang ORDER BY id";
            try (ResultSet rs = st.executeQuery(query)) {
            while(rs.next()){
                cbRuang.addItem(rs.getString("nama"));  
            }
            con.close();
            st.close();
            rs.close();
            }
        }catch(SQLException sqle){
          JOptionPane.showMessageDialog(null,"Error viewRuang "+sqle);
        }  
    }
    
    private void viewPenyewa(){
        try{
          con=kon.open();
          st=con.createStatement(); 
          query="SELECT nama FROM tb_penyewa ORDER BY id";
            try (ResultSet rs = st.executeQuery(query)) {
            while(rs.next()){
                cbPenyewa.addItem(rs.getString("nama"));  
            }
            con.close();
            st.close();
            rs.close();
            }
        }catch(SQLException sqle){
          JOptionPane.showMessageDialog(null,"Error viewRuang "+sqle);
        }  
    }

private void ViewDatilRuangByName(){  
    try{
          con=kon.open();
          st=con.createStatement(); 
          query="SELECT * FROM tb_ruang WHERE nama='"+cbRuang.getSelectedItem()+"'";
        try (ResultSet rs = st.executeQuery(query)) {
            while(rs.next()){
               idRuang=rs.getString("id");
               txtHarga.setText(rs.getString("harga"));
               txtLuas.setText(rs.getString("luas"));
               txtDeskripsi.setText(rs.getString("deskripsi")); 
            }
            con.close();
            st.close();
            rs.close();
        } 
      }catch(SQLException sqle){
          JOptionPane.showMessageDialog(null,"Error ViewDatilRuangByName "+sqle);
      }
}

private void ViewDatilPenyewaByName(){  
    try{
          con=kon.open();
          st=con.createStatement(); 
          query="SELECT * FROM tb_penyewa WHERE nama='"+cbPenyewa.getSelectedItem()+"'";
        try (ResultSet rs = st.executeQuery(query)) {
            while(rs.next()){
               idPenyewa=rs.getString("id");
               lblTelepon.setText(rs.getString("no_tlp"));
               txtEmail.setText(rs.getString("email"));
               txtAlamat.setText(rs.getString("alamat")); 
            }
            con.close();
            st.close();
            rs.close();
        }
        System.out.println("idPenyewa "+idPenyewa);
      }catch(SQLException sqle){
          JOptionPane.showMessageDialog(null,"Error ViewDatilPenyewaByName "+sqle);
      }
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel6 = new javax.swing.JLabel();
        txtHarga = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtLuas = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDeskripsi = new javax.swing.JTextArea();
        cbRuang = new javax.swing.JComboBox();
        jDateAwal = new com.toedter.calendar.JDateChooser();
        lblNosewa = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jDateAkhir = new com.toedter.calendar.JDateChooser();
        jSeparator1 = new javax.swing.JSeparator();
        lblTelepon = new javax.swing.JLabel();
        cbPenyewa = new javax.swing.JComboBox();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtAlamat = new javax.swing.JTextArea();
        txtEmail = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jButton1 = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        lblDurasi = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        lblTotalView = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Input Data Sewa Ruang");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel6.setText("/Meter");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 130, 120, 30));

        txtHarga.setEditable(false);
        txtHarga.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtHarga.setText("0");
        txtHarga.setOpaque(false);
        txtHarga.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtHargaKeyPressed(evt);
            }
        });
        getContentPane().add(txtHarga, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 90, 180, 30));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel3.setText("Luas");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 110, 30));

        txtLuas.setEditable(false);
        txtLuas.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtLuas.setText("0");
        txtLuas.setOpaque(false);
        txtLuas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtLuasKeyPressed(evt);
            }
        });
        getContentPane().add(txtLuas, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 130, 100, 30));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel7.setText("Periode");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 80, 110, 30));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Input Data Sewa Ruang");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 0, 260, 30));

        jLabel11.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel11.setText("Harga");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 110, 30));

        txtDeskripsi.setEditable(false);
        txtDeskripsi.setColumns(20);
        txtDeskripsi.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        txtDeskripsi.setRows(5);
        txtDeskripsi.setOpaque(false);
        jScrollPane2.setViewportView(txtDeskripsi);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 410, 140));

        cbRuang.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        cbRuang.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Pilih" }));
        cbRuang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbRuangActionPerformed(evt);
            }
        });
        getContentPane().add(cbRuang, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 50, 170, 30));

        jDateAwal.setDateFormatString("dd/MM/yyyy");
        jDateAwal.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jDateAwal.setOpaque(false);
        jDateAwal.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jDateAwalPropertyChange(evt);
            }
        });
        getContentPane().add(jDateAwal, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 80, 150, 30));

        lblNosewa.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblNosewa.setText("lblNosewa");
        getContentPane().add(lblNosewa, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 40, 140, 30));

        jLabel13.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Sd");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 80, 40, 30));

        jDateAkhir.setDateFormatString("dd/MM/yyyy");
        jDateAkhir.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jDateAkhir.setOpaque(false);
        jDateAkhir.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jDateAkhirPropertyChange(evt);
            }
        });
        getContentPane().add(jDateAkhir, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 80, 150, 30));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 910, 10));

        lblTelepon.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lblTelepon.setText("-");
        getContentPane().add(lblTelepon, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 120, 180, 30));

        cbPenyewa.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        cbPenyewa.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Pilih" }));
        cbPenyewa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbPenyewaActionPerformed(evt);
            }
        });
        getContentPane().add(cbPenyewa, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 120, 170, 30));

        jLabel15.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel15.setText("Nama Ruang");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 110, 30));

        jLabel16.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel16.setText("No Sewa");
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 40, 110, 30));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel5.setText("Email");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 160, 90, 30));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel2.setText("Alamat");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 200, 90, 30));

        txtAlamat.setEditable(false);
        txtAlamat.setColumns(20);
        txtAlamat.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        txtAlamat.setRows(5);
        txtAlamat.setOpaque(false);
        jScrollPane3.setViewportView(txtAlamat);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 200, 380, 110));

        txtEmail.setEditable(false);
        txtEmail.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtEmail.setOpaque(false);
        txtEmail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtEmailKeyPressed(evt);
            }
        });
        getContentPane().add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 160, 210, 30));

        jLabel17.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel17.setText("Nama Penyewa");
        getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 120, 110, 30));
        getContentPane().add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 322, 910, 10));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tesaapp/img/doc_refresh.png"))); // NOI18N
        jButton1.setText("Lihat Estimasi Harga");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 330, 220, 60));

        jLabel18.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel18.setText("Hari");
        getContentPane().add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 330, 70, 30));

        lblDurasi.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblDurasi.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDurasi.setText("lblDurasi");
        getContentPane().add(lblDurasi, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 330, 80, 30));

        jLabel19.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel19.setText("Periode Sewa");
        getContentPane().add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, 110, 30));

        jLabel20.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel20.setText("Total Harga");
        getContentPane().add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, 110, 30));

        lblTotalView.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblTotalView.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblTotalView.setText("lblTotalView");
        getContentPane().add(lblTotalView, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 360, 120, 30));

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tesaapp/img/icons8-bullet-list-48.png"))); // NOI18N
        jButton3.setText("Lihat Daftar Sewa");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 330, 220, 60));

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

    private void txtHargaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtHargaKeyPressed
        if(evt.getKeyCode() == evt.VK_ENTER)
        txtLuas.requestFocus();
    }//GEN-LAST:event_txtHargaKeyPressed

    private void txtLuasKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLuasKeyPressed
        if(evt.getKeyCode() == evt.VK_ENTER)
        txtDeskripsi.requestFocus();        
    }//GEN-LAST:event_txtLuasKeyPressed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        dispose();        
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void cbRuangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbRuangActionPerformed
        ViewDatilRuangByName();
    }//GEN-LAST:event_cbRuangActionPerformed

    private void jDateAwalPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jDateAwalPropertyChange
        if (jDateAwal.getDate() != null) {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            tgl1 = format.format(jDateAwal.getDate());
        }
    }//GEN-LAST:event_jDateAwalPropertyChange

    private void jDateAkhirPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jDateAkhirPropertyChange
        if (jDateAkhir.getDate() != null) {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            tgl2 = format.format(jDateAkhir.getDate());
        }
    }//GEN-LAST:event_jDateAkhirPropertyChange

    private void cbPenyewaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbPenyewaActionPerformed
        ViewDatilPenyewaByName();
    }//GEN-LAST:event_cbPenyewaActionPerformed

    private void txtEmailKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEmailKeyPressed
       
    }//GEN-LAST:event_txtEmailKeyPressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        Dapatkan_Durasi();
        HitungBiayaSewa();
            int confirm = JOptionPane.showConfirmDialog(this,
            "Anda yakin benar & ingin simpan ???",
            "MOHON CEK KEMBALI",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE);
                if (confirm == JOptionPane.YES_OPTION) { 
                    Simpan();
            }
        try {
            AutoNumberSewa();
        } catch (SQLException ex) {
            Logger.getLogger(Input_Sewa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.dispose();
        List_Sewa frame = new List_Sewa(); //[940, 670]
        frame.setDefaultCloseOperation(2);
        frame.setSize(950, 730);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(Input_Sewa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Input_Sewa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Input_Sewa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Input_Sewa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Input_Sewa dialog = null;
                try {
                    dialog = new Input_Sewa(new javax.swing.JFrame(), true);
                } catch (SQLException ex) {
                    Logger.getLogger(Input_Sewa.class.getName()).log(Level.SEVERE, null, ex);
                }
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cbPenyewa;
    private javax.swing.JComboBox cbRuang;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private com.toedter.calendar.JDateChooser jDateAkhir;
    private com.toedter.calendar.JDateChooser jDateAwal;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblDurasi;
    private javax.swing.JLabel lblNosewa;
    private javax.swing.JLabel lblTelepon;
    private javax.swing.JLabel lblTotalView;
    private javax.swing.JTextArea txtAlamat;
    private javax.swing.JTextArea txtDeskripsi;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtHarga;
    private javax.swing.JTextField txtLuas;
    // End of variables declaration//GEN-END:variables
  
    public String tglNmor(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        return sdf.format(new Date());
       
    }
    
    private void AutoNumberSewa() throws SQLException{
        boolean addno = false;
        con=kon.open();
        st=con.createStatement();
        try {            
             String sql = "SELECT MAX(RIGHT(no_sewa,3)) AS NOMOR FROM tb_sewa "
                        + " WHERE YEAR(LEFT(no_sewa,8))+ MONTH(LEFT(no_sewa,8)) + "
                        + " DAY(LEFT(no_sewa,8))= YEAR(CURDATE()) + MONTH(CURDATE()) + DAY(CURDATE()) "
                        + " ORDER BY RIGHT(no_sewa,5) DESC";
                          
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                String number = rs.getString("NOMOR");
                int nom =Integer.parseInt(number) + 1;
                
                //membuat Panjang Karakter nomor menjadi 3 Karakter
                String num=Integer.toString(nom);
                int panjang=num.length();
                for (int i = 1; i <= (3 - panjang); i++) {
                  num = "0" + num;
                } 
                // di jalankan jika kondisi Tabel yang di jumlahkan tidak dalam kondisi nol
                lblNosewa.setText(tglNmor() +num);
                addno = true;
            }
            con.close();
            st.close();
            rs.close();
        }catch(SQLException | NumberFormatException ex){       
        }
        
        // di jalankan jika kondisi Tabel yang di jumlahkan dalam kondisi nol
        if(addno == false){
            lblNosewa.setText(tglNmor() + "001");
            System.out.println(lblNosewa.getText());
        }   
    } 
    
    private void Dapatkan_Durasi(){  
        try{
          con=kon.open();
          st=con.createStatement();    
          query="SELECT DATEDIFF('"+tgl2+" 23:59:59','"+tgl1+" 00:00:00')+1 AS durasi"; 
            try (ResultSet rs = st.executeQuery(query)) {
            while(rs.next()){ 
                System.out.println("tgl1 "+tgl1);
                System.out.println("tgl2 "+tgl2);
                    lblDurasi.setText(rs.getString("durasi")); 
                }
                con.close();
                st.close();
                rs.close();
            } 
        }catch(SQLException sqle){
          System.out.println(sqle);
          JOptionPane.showMessageDialog(null,"Error Dapatkan_Durasi "+sqle);
        }   
    }
    
    private void HitungBiayaSewa(){
        int vHarga, vDurasi, vTotal; 
        vHarga=Integer.parseInt(txtHarga.getText());
        vDurasi=Integer.parseInt(lblDurasi.getText());
        vTotal=(vHarga*vDurasi); 
        total=vTotal; 
        NumberFormat formatter = new DecimalFormat("Rp #0,000.00");   
        lblTotalView.setText(formatter.format(vTotal));  
    }
    
    private void Simpan(){
        try{ 
            con=kon.open();
            st=con.createStatement();
            query = "INSERT INTO tb_sewa(`no_sewa`, `tgl_sewa`, `periode_awal`, `periode_akhir`, `periode_total`, `harga`, `total`, `created_by`,`pegawai_id`,`penyewa_id`,`ruang_id`) VALUES  "
            + "('"+lblNosewa.getText()+"',DATE_FORMAT(NOW(),'%d/%m/%Y'),'"+tgl1+"','"+tgl2+"','"+lblDurasi.getText()+"','"+txtHarga.getText()+"','"+total+"','"+namaConfig+"','"+IDConfig+"','"+idPenyewa+"','"+idRuang+"');";
            st.executeUpdate(query);
            JOptionPane.showMessageDialog(null,"Data Sukses Simpan");
            con.close();
            st.close();   
            }catch(Exception sqle){
                JOptionPane.showMessageDialog(null,"Data Gagal Simpan "+sqle.getMessage());
        } 
    }
    
    private void ViewConfig(){ 
        try{
          con=kon.open();
          st=con.createStatement(); 
          query="SELECT * FROM `tb_config` WHERE id='1'";
        try (ResultSet rs = st.executeQuery(query)) {
            while(rs.next()){ 
               namaConfig=rs.getString("nama");
               IDConfig=rs.getString("pegawai_id");
            }
            con.close();
            st.close();
            rs.close();
        } 
      }catch(SQLException sqle){
          JOptionPane.showMessageDialog(null,"Error ViewConfig "+sqle);
      }
}
    // buat validasi apakah ruangan sudah dibooking
    private void CekBookingRuang(){  
        try{
          con=kon.open();
          st=con.createStatement();    
          query="SELECT  no_sewa FROM `tb_sewa` WHERE periode_akhir BETWEEN '2022-08-01' AND '2022-08-01'";
            try (ResultSet rs = st.executeQuery(query)) {
            while(rs.next()){ 
                    System.out.println("CekBookingRuang "+rs.getString("no_sewa")); 
                }
            
                con.close();
                st.close();
                rs.close();
            } 
        }catch(SQLException sqle){
          System.out.println(sqle);
          JOptionPane.showMessageDialog(null,"Error Dapatkan_Durasi "+sqle);
        }   
    }
}