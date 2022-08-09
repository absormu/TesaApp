package tesaapp.menu;

import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import tesaapp.koneksi.Koneksi;

public class Master_Pegawai extends javax.swing.JDialog {
    private DefaultTableModel modelTabel;
    private String[] arrMP;
    Connection con;
    Statement st;
    Koneksi kon = new Koneksi();
    String query, JK;
    String nama_pengguna = "0";
    public Master_Pegawai(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents(); 
        setLocationRelativeTo(this); 
        BuatTabel();
        LoadTabel();
    }

    private void BuatTabel(){ 
        modelTabel=new DefaultTableModel(); 
        modelTabel.addColumn("Id Pegawai");
        modelTabel.addColumn("No. Ktp");
        modelTabel.addColumn("Nama Pegawai");  
        modelTabel.addColumn("Jabatan"); 
        modelTabel.addColumn("Pengguna");   
        modelTabel.addColumn("Sandi");   
        Table.setModel(modelTabel);
        lebarKolom();
        desaintabel();
    }    
     
    private void LoadTabel(){
      removeTable();        
      try{
          con=kon.open();
          st=con.createStatement();
          query="SELECT * FROM tb_pegawai ORDER BY id_pegawai";
          ResultSet rs=st.executeQuery(query);
          while(rs.next()){
              String a=rs.getString("id_pegawai");
              String b=rs.getString("ktp");
              String c=rs.getString("nama_pegawai"); 
              String d=rs.getString("id_jabatan");
              String e=rs.getString("nama_pengguna"); 
              String f=rs.getString("password"); 
              String data[]={a,b,c,d,e,f};       
              modelTabel.addRow(data);         
          }
          con.close();
          st.close();
          rs.close();
      }catch(SQLException sqle){
          JOptionPane.showMessageDialog(null,"Data Gagal Masuk Tabel"+sqle);
      }    
        Rows();
    }
    
    private void LoadTabelByName(){
      removeTable();        
      try{
          con=kon.open();
          st=con.createStatement();
          query="SELECT * FROM tb_pegawai WHERE nama_pegawai LIKE '%"+txtCari.getText()+"%' ORDER BY id_pegawai";
          ResultSet rs=st.executeQuery(query);
          while(rs.next()){
              String a=rs.getString("id_pegawai");
              String b=rs.getString("ktp");
              String c=rs.getString("nama_pegawai"); 
              String d=rs.getString("id_jabatan");
              String e=rs.getString("nama_pengguna"); 
              String f=rs.getString("password"); 
              String data[]={a,b,c,d,e,f};              
              modelTabel.addRow(data);         
          } 
          con.close();
          st.close();
          rs.close();
      }catch(SQLException sqle){
          JOptionPane.showMessageDialog(null,"Data Gagal Masuk Tabel"+sqle);
      }  
        Rows();
    }
    
    private void Rows(){
        int b=Table.getRowCount();
        lblRows.setText(""+b);
   }
       
    public void removeTable(){
        try{for(int t=modelTabel.getRowCount();t>0;t--) {modelTabel.removeRow(0);}
        }catch(Exception ex){ System.out.println(ex);}
    }

    private void lebarKolom(){ 
        TableColumn column;
        Table.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF); 
        column = Table.getColumnModel().getColumn(0); 
        column.setPreferredWidth(87);
        column = Table.getColumnModel().getColumn(1); 
        column.setPreferredWidth(150); 
        column = Table.getColumnModel().getColumn(2); 
        column.setPreferredWidth(200); 
        column = Table.getColumnModel().getColumn(3); 
        column.setPreferredWidth(100);
        column = Table.getColumnModel().getColumn(4); 
        column.setPreferredWidth(120);
        column = Table.getColumnModel().getColumn(5); 
        column.setPreferredWidth(100);
    }
    private void desaintabel(){
        Table.getTableHeader().setReorderingAllowed(false); 
        Table.getTableHeader().setBackground(Color.pink); 
        Table.getTableHeader().setFont(new Font("Times New Roman", Font.BOLD,18));  
        Table.setRowHeight(30);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        Table.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        Table.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        Table.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
        Table.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
        Table.getColumnModel().getColumn(4).setCellRenderer(centerRenderer); 
        Table.getColumnModel().getColumn(5).setCellRenderer(centerRenderer);
    }
       
private void Clear(){
    txtIdPegawai.setText("");
    txtNoKtp.setText("");
    txtNamaPegwai.setText("");
    txtUsername.setText("");
    txtPassword.setText("");
    txtIdPegawai.requestFocus();
}

private void Simpan(){
    try{ 
        con=kon.open();
        st=con.createStatement();
        query = "INSERT INTO tb_pegawai(id_pegawai,ktp,nama_pegawai,id_jabatan,nama_pengguna,password) VALUES  "
        + "('"+txtIdPegawai.getText()+"','"+txtNoKtp.getText()+"','"+txtNamaPegwai.getText()+"','"+cbJabatan.getSelectedItem()+"','"+txtUsername.getText()+"','"+txtPassword.getText()+"');";
        st.executeUpdate(query);
        JOptionPane.showMessageDialog(null,"Data Sukses Simpan");
        con.close();
        st.close();                               
        Clear();
        LoadTabel();
        }catch(Exception sqle){
            JOptionPane.showMessageDialog(null,"Data Gagal Simpan "+sqle.getMessage());
    } 
}

private void Ubah(){
    try{ 
        con=kon.open();
        st=con.createStatement();
        query = "UPDATE tb_pegawai SET ktp='"+txtNoKtp.getText()+"',nama_pegawai='"+txtNamaPegwai.getText()+"', id_jabatan='"+cbJabatan.getSelectedItem()+"', "
                + "nama_pengguna='"+txtUsername.getText()+"',password='"+txtPassword.getText()+"' WHERE id_pegawai='"+txtIdPegawai.getText()+"'";
        st.executeUpdate(query);
        JOptionPane.showMessageDialog(null,"Data Sukses Ubah");
        con.close();
        st.close(); 
        LoadTabel();
    }catch (Exception sqle){
        JOptionPane.showMessageDialog(null,"Data Gagal Ubah"+sqle.getMessage());
    } 
}

private void Hapus(){
    try{
        con=kon.open();
        st=con.createStatement();
        query = "DELETE FROM tb_pegawai WHERE id_pegawai = '"+txtIdPegawai.getText()+"';";
        st.executeUpdate(query);
        JOptionPane.showMessageDialog(null,"Data Sukses Hapus");
        con.close();
        st.close();
        Clear(); 
        LoadTabel(); 
        }catch (Exception sqle){
            JOptionPane.showMessageDialog(null,"Data Gagal Hapus "+sqle.getMessage());
    } 
}    

private void ViewUsername(){  
    try{
          con=kon.open();
          st=con.createStatement(); 
          query="SELECT nama_pengguna FROM tb_pegawai WHERE id_pegawai='"+txtIdPegawai.getText()+"'";
        try (ResultSet rs = st.executeQuery(query)) {
            while(rs.next()){
                nama_pengguna=rs.getString("nama_pengguna");  
            }
            con.close();
            st.close();
            rs.close();
        }
      }catch(SQLException sqle){
          JOptionPane.showMessageDialog(null,"Error ViewUsername "+sqle);
      }
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        Table = new javax.swing.JTable();
        lblRows = new javax.swing.JLabel();
        txtIdPegawai = new javax.swing.JTextField();
        txtNoKtp = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtNamaPegwai = new javax.swing.JTextField();
        cbJabatan = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        txtPassword = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnSimpan = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        txtCari = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Master Pegawai");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Table.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        Table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Table);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 40, 660, 310));

        lblRows.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblRows.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblRows.setText("0");
        getContentPane().add(lblRows, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 350, 90, 30));

        txtIdPegawai.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtIdPegawai.setOpaque(false);
        txtIdPegawai.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtIdPegawaiKeyPressed(evt);
            }
        });
        getContentPane().add(txtIdPegawai, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 50, 210, 30));

        txtNoKtp.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtNoKtp.setOpaque(false);
        txtNoKtp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNoKtpKeyPressed(evt);
            }
        });
        getContentPane().add(txtNoKtp, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 90, 210, 30));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel4.setText("No. Ktp");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 110, 30));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel6.setText("Nama Pegawai");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 110, 30));

        txtNamaPegwai.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtNamaPegwai.setOpaque(false);
        txtNamaPegwai.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNamaPegwaiKeyPressed(evt);
            }
        });
        getContentPane().add(txtNamaPegwai, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 130, 210, 30));

        cbJabatan.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        cbJabatan.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Administrasi" }));
        cbJabatan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbJabatanActionPerformed(evt);
            }
        });
        getContentPane().add(cbJabatan, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 170, 210, 30));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel5.setText("Jabatan");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 110, 30));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel3.setText("Nama Pengguna");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 110, 30));

        txtUsername.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtUsername.setOpaque(false);
        txtUsername.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtUsernameKeyPressed(evt);
            }
        });
        getContentPane().add(txtUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 210, 210, 30));

        txtPassword.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtPassword.setOpaque(false);
        txtPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPasswordKeyPressed(evt);
            }
        });
        getContentPane().add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 250, 210, 30));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel1.setText("Kata Sandi");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 110, 30));

        btnSimpan.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btnSimpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tesaapp/img/doc_new.png"))); // NOI18N
        btnSimpan.setText("SIMPAN");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });
        getContentPane().add(btnSimpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, 120, 50));

        jButton1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tesaapp/img/doc_delete.png"))); // NOI18N
        jButton1.setText("HAPUS");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 300, 120, 50));

        txtCari.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtCari.setOpaque(false);
        txtCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCariActionPerformed(evt);
            }
        });
        txtCari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCariKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCariKeyReleased(evt);
            }
        });
        getContentPane().add(txtCari, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 10, 210, 30));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel7.setText("Id Pegawai");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 110, 30));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Menu Data Pegawai");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 260, 30));

        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Jumlah Data :");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 350, 170, 30));

        jLabel10.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Cari berdasarkan nama");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 10, 170, 30));

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

    private void TableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableMouseClicked
        int baris = Table.getSelectedRow();
        int kolom = Table.getSelectedColumn();
        String data   = Table.getValueAt(baris, kolom).toString();
        String kolom1 = Table.getValueAt(baris, 0).toString();
        String kolom2 = Table.getValueAt(baris, 1).toString();
        String kolom3 = Table.getValueAt(baris, 2).toString();
        String kolom4 = Table.getValueAt(baris, 3).toString();
        String kolom5 = Table.getValueAt(baris, 4).toString();
        String kolom6 = Table.getValueAt(baris, 5).toString();
        try {
            txtIdPegawai.setText(kolom1);
            txtNoKtp.setText(kolom2);
            txtNamaPegwai.setText(kolom3);
//            cbJabatan.addItem(kolom4);
            txtUsername.setText(kolom5);
            txtPassword.setText(kolom6);
        } catch (Exception e) {
            System.out.println("TableMouseClicked "+e);
        }
    }//GEN-LAST:event_TableMouseClicked

    private void txtIdPegawaiKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdPegawaiKeyPressed
        if(evt.getKeyCode() == evt.VK_ENTER)
        txtNoKtp.requestFocus();
    }//GEN-LAST:event_txtIdPegawaiKeyPressed

    private void txtNoKtpKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNoKtpKeyPressed
        if(evt.getKeyCode() == evt.VK_ENTER)
        txtNamaPegwai.requestFocus();
    }//GEN-LAST:event_txtNoKtpKeyPressed

    private void txtNamaPegwaiKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNamaPegwaiKeyPressed
        if(evt.getKeyCode() == evt.VK_ENTER)
        cbJabatan.requestFocus();
    }//GEN-LAST:event_txtNamaPegwaiKeyPressed

    private void cbJabatanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbJabatanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbJabatanActionPerformed

    private void txtUsernameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUsernameKeyPressed
        if(evt.getKeyCode() == evt.VK_ENTER)
        txtPassword.requestFocus();        
    }//GEN-LAST:event_txtUsernameKeyPressed

    private void txtPasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPasswordKeyPressed
        if(evt.getKeyCode() == evt.VK_ENTER)
        btnSimpan.requestFocus();        
    }//GEN-LAST:event_txtPasswordKeyPressed

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        ViewUsername();
        System.out.println(nama_pengguna);
        if( nama_pengguna.equals("0")){  
            Simpan(); 
        }else{
            Ubah();    
        }
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int confirm = JOptionPane.showConfirmDialog(this,
            "Anda yakin ingin hapus ?",
            "Konfirmasi",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE);
        if (confirm == JOptionPane.YES_OPTION) {
            if( txtIdPegawai.getText().equals("001")){ 
            JOptionPane.showMessageDialog(null, "TIDAK BOLEH DIHAPUS", "AKUN MASTER", JOptionPane.ERROR_MESSAGE); 
            txtIdPegawai.requestFocus();
            }else{
                Hapus();
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        dispose();        
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void txtCariKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCariKeyPressed
       
    }//GEN-LAST:event_txtCariKeyPressed

    private void txtCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCariActionPerformed

    }//GEN-LAST:event_txtCariActionPerformed

    private void txtCariKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCariKeyReleased
 LoadTabelByName();
    }//GEN-LAST:event_txtCariKeyReleased

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
            java.util.logging.Logger.getLogger(Master_Pegawai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Master_Pegawai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Master_Pegawai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Master_Pegawai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Master_Pegawai dialog = new Master_Pegawai(new javax.swing.JFrame(), true);
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
    private javax.swing.JTable Table;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JComboBox cbJabatan;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblRows;
    private javax.swing.JTextField txtCari;
    private javax.swing.JTextField txtIdPegawai;
    private javax.swing.JTextField txtNamaPegwai;
    private javax.swing.JTextField txtNoKtp;
    private javax.swing.JTextField txtPassword;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables

}
