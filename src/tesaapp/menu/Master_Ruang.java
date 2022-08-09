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

public class Master_Ruang extends javax.swing.JDialog {
    private DefaultTableModel modelTabel;
    private String[] arrMP;
    Connection con;
    Statement st;
    Koneksi kon = new Koneksi();
    String query, JK;
    String nama = "0";
    public Master_Ruang(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents(); 
        setLocationRelativeTo(this); 
        BuatTabel();
        LoadTabel();
        Clear();
    }

    private void BuatTabel(){ 
        modelTabel=new DefaultTableModel(); 
        modelTabel.addColumn("Id Ruang");
        modelTabel.addColumn("Nama");
        modelTabel.addColumn("Harga");  
        modelTabel.addColumn("Luas"); 
        modelTabel.addColumn("Deskripsi");  
        Table.setModel(modelTabel);
        lebarKolom();
        desaintabel();
    }    
     
    private void LoadTabel(){
      removeTable();        
      try{
          con=kon.open();
          st=con.createStatement();
          query="SELECT * FROM tb_ruang ORDER BY id";
          ResultSet rs=st.executeQuery(query);
          while(rs.next()){
              String a=rs.getString("id");
              String b=rs.getString("nama");
              String c=rs.getString("harga"); 
              String d=rs.getString("luas");
              String e=rs.getString("deskripsi"); 
              String data[]={a,b,c,d,e};       
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
          query="SELECT * FROM tb_ruang WHERE nama LIKE '%"+txtCari.getText()+"%' ORDER BY id";
          ResultSet rs=st.executeQuery(query);
          while(rs.next()){
              String a=rs.getString("id");
              String b=rs.getString("nama");
              String c=rs.getString("harga"); 
              String d=rs.getString("luas");
              String e=rs.getString("deskripsi"); 
              String data[]={a,b,c,d,e};      
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
        column.setPreferredWidth(100);
        column = Table.getColumnModel().getColumn(1); 
        column.setPreferredWidth(250); 
        column = Table.getColumnModel().getColumn(2); 
        column.setPreferredWidth(100); 
        column = Table.getColumnModel().getColumn(3); 
        column.setPreferredWidth(100);
        column = Table.getColumnModel().getColumn(4); 
        column.setPreferredWidth(400); 
    }
    private void desaintabel(){
        Table.getTableHeader().setReorderingAllowed(false); 
        Table.getTableHeader().setBackground(Color.pink); 
        Table.getTableHeader().setFont(new Font("Times New Roman", Font.PLAIN,14));  
        Table.setRowHeight(30);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        Table.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        Table.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        Table.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
        Table.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
        Table.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);  
    }
       
private void Clear(){
    txtId.setText("");
    txtNama.setText("");
    txtHarga.setText("");
    txtLuas.setText(""); 
    txtNama.requestFocus();
}

private void Simpan(){
    try{ 
        con=kon.open();
        st=con.createStatement();
        query = "INSERT INTO tb_ruang(nama,harga,luas,deskripsi) VALUES  "
        + "('"+txtNama.getText()+"','"+txtHarga.getText()+"','"+txtLuas.getText()+"','"+txtDeskripsi.getText()+"');";
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
        query = "UPDATE tb_ruang SET nama='"+txtNama.getText()+"',harga='"+txtHarga.getText()+"', "
                + "luas='"+txtLuas.getText()+"',deskripsi='"+txtDeskripsi.getText()+"' WHERE id='"+txtId.getText()+"'";
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
        query = "DELETE FROM tb_ruang WHERE id = '"+txtId.getText()+"';";
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

private void ViewName(){  
    try{
          con=kon.open();
          st=con.createStatement(); 
          query="SELECT nama FROM tb_ruang WHERE id='"+txtId.getText()+"'";
        try (ResultSet rs = st.executeQuery(query)) {
            while(rs.next()){
                nama=rs.getString("nama");  
            }
            con.close();
            st.close();
            rs.close();
        }
      }catch(SQLException sqle){
          JOptionPane.showMessageDialog(null,"Error ViewName "+sqle);
      }
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        Table = new javax.swing.JTable();
        lblRows = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        txtNama = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtHarga = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtLuas = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnSimpan = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        txtCari = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDeskripsi = new javax.swing.JTextArea();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Master Ruang");
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

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, 880, 310));

        lblRows.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblRows.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblRows.setText("0");
        getContentPane().add(lblRows, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 630, 90, 30));

        txtId.setEditable(false);
        txtId.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtId.setOpaque(false);
        txtId.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtIdKeyPressed(evt);
            }
        });
        getContentPane().add(txtId, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 50, 100, 30));

        txtNama.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtNama.setOpaque(false);
        txtNama.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNamaKeyPressed(evt);
            }
        });
        getContentPane().add(txtNama, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 90, 380, 30));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel4.setText("Nama");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 110, 30));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel6.setText("/Meter");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 170, 120, 30));

        txtHarga.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtHarga.setOpaque(false);
        txtHarga.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtHargaKeyPressed(evt);
            }
        });
        getContentPane().add(txtHarga, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 130, 180, 30));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel3.setText("Luas");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 110, 30));

        txtLuas.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtLuas.setOpaque(false);
        txtLuas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtLuasKeyPressed(evt);
            }
        });
        getContentPane().add(txtLuas, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 170, 100, 30));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel1.setText("Deskripsi");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 40, 110, 30));

        btnSimpan.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btnSimpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tesaapp/img/doc_new.png"))); // NOI18N
        btnSimpan.setText("SIMPAN");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });
        getContentPane().add(btnSimpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 240, 120, 50));

        jButton1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tesaapp/img/doc_delete.png"))); // NOI18N
        jButton1.setText("HAPUS");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 240, 120, 50));

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
        getContentPane().add(txtCari, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 280, 180, 30));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel7.setText("Id Ruang");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 110, 30));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Menu Data Ruang");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 0, 260, 30));

        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Jumlah Data :");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 630, 170, 30));

        jLabel10.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Cari berdasarkan nama");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, 140, 30));

        jLabel11.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel11.setText("Harga");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 110, 30));

        txtDeskripsi.setColumns(20);
        txtDeskripsi.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        txtDeskripsi.setRows(5);
        txtDeskripsi.setOpaque(false);
        jScrollPane2.setViewportView(txtDeskripsi);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 70, 370, 160));

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
        try {
            txtId.setText(kolom1);
            txtNama.setText(kolom2);
            txtHarga.setText(kolom3); 
            txtLuas.setText(kolom4);
            txtDeskripsi.setText(kolom5);
        } catch (Exception e) {
            System.out.println("TableMouseClicked "+e);
        }
    }//GEN-LAST:event_TableMouseClicked

    private void txtIdKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdKeyPressed
        if(evt.getKeyCode() == evt.VK_ENTER)
        txtNama.requestFocus();
    }//GEN-LAST:event_txtIdKeyPressed

    private void txtNamaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNamaKeyPressed
        if(evt.getKeyCode() == evt.VK_ENTER)
        txtHarga.requestFocus();
    }//GEN-LAST:event_txtNamaKeyPressed

    private void txtHargaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtHargaKeyPressed
        if(evt.getKeyCode() == evt.VK_ENTER)
        txtLuas.requestFocus();
    }//GEN-LAST:event_txtHargaKeyPressed

    private void txtLuasKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLuasKeyPressed
        if(evt.getKeyCode() == evt.VK_ENTER)
        txtDeskripsi.requestFocus();        
    }//GEN-LAST:event_txtLuasKeyPressed

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        ViewName();
        System.out.println(nama);
        if( nama.equals("0")){  
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
            Hapus();
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
            java.util.logging.Logger.getLogger(Master_Ruang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Master_Ruang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Master_Ruang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Master_Ruang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Master_Ruang dialog = new Master_Ruang(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblRows;
    private javax.swing.JTextField txtCari;
    private javax.swing.JTextArea txtDeskripsi;
    private javax.swing.JTextField txtHarga;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtLuas;
    private javax.swing.JTextField txtNama;
    // End of variables declaration//GEN-END:variables

}
