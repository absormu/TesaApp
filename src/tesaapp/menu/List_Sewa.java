package tesaapp.menu;

import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;
import tesaapp.koneksi.Koneksi;

public class List_Sewa extends javax.swing.JFrame {

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
    public List_Sewa() {
        initComponents(); 
        Date date = new Date();
        jDateAwal.setDate(date); 
        jDateAkhir.setDate(date); 
        BuatTabel();
        LoadTabel();
    }

     private void BuatTabel(){ 
        modelTabel=new DefaultTableModel(); 
        modelTabel.addColumn("Id Sewa");
        modelTabel.addColumn("Tgl Sewa");
        modelTabel.addColumn("Awal Sewa");  
        modelTabel.addColumn("Akhir Sewa"); 
        modelTabel.addColumn("Hari");
        modelTabel.addColumn("Harga");
        modelTabel.addColumn("Total Sewa");
        modelTabel.addColumn("Nama Ruang");
        modelTabel.addColumn("Nama Penyewa");
        Table.setModel(modelTabel);
        lebarKolom();
        desaintabel();
    }   
private void Cetak_Data() throws SQLException{
    try { 
        con=kon.open();
//        File file = new File("src/tesaapp/report/Lap_Sewa_List.jrxml"); 
        File file = new File("C://tesaapp/report/Lap_Sewa_List.jrxml"); 
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

    private void LoadTabel(){
      removeTable();        
      try{
          con=kon.open();
          st=con.createStatement();
          query="SELECT * FROM tb_sewa s JOIN tb_ruang r ON s.ruang_id=r.id JOIN tb_penyewa p ON s.penyewa_id=p.id "
                  + "WHERE STR_TO_DATE (s.tgl_sewa, '%d/%m/%Y') BETWEEN  STR_TO_DATE('"+tgl1+"', '%d/%m/%Y') AND STR_TO_DATE('"+tgl2+"', '%d/%m/%Y') "
                  + "ORDER BY s.no_sewa";
          ResultSet rs=st.executeQuery(query);
          while(rs.next()){
              String a=rs.getString("s.no_sewa");
              String b=rs.getString("s.tgl_sewa");
              String c=rs.getString("s.periode_awal"); 
              String d=rs.getString("s.periode_akhir");
              String e=rs.getString("s.periode_total"); 
              String f=rs.getString("s.harga"); 
              String g=rs.getString("s.total");
              String h=rs.getString("r.nama");
              String i=rs.getString("p.nama");
              String data[]={a,b,c,d,e,f,g,h,i};       
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
        int total=0;
        for (int i = 0; i < Table.getRowCount(); i++){
            total +=Integer.parseInt( Table.getValueAt(i,6).toString() );// 3rd column . row column indexes are 0 based
        } 
        
        NumberFormat formatter = new DecimalFormat("Rp #0,000.00");    
        lblTotal.setText(""+ formatter.format(total));
        
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
        column.setPreferredWidth(100); 
        column = Table.getColumnModel().getColumn(2); 
        column.setPreferredWidth(100); 
        column = Table.getColumnModel().getColumn(3); 
        column.setPreferredWidth(100);
        column = Table.getColumnModel().getColumn(4); 
        column.setPreferredWidth(50); 
        column = Table.getColumnModel().getColumn(5); 
        column.setPreferredWidth(100);
        column = Table.getColumnModel().getColumn(6); 
        column.setPreferredWidth(100);
        column = Table.getColumnModel().getColumn(7); 
        column.setPreferredWidth(150);
        column = Table.getColumnModel().getColumn(8); 
        column.setPreferredWidth(150);
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
        Table.getColumnModel().getColumn(5).setCellRenderer(centerRenderer);  
        Table.getColumnModel().getColumn(6).setCellRenderer(centerRenderer);
        Table.getColumnModel().getColumn(7).setCellRenderer(centerRenderer);
        Table.getColumnModel().getColumn(7).setCellRenderer(centerRenderer);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        Table = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jDateAwal = new com.toedter.calendar.JDateChooser();
        jLabel13 = new javax.swing.JLabel();
        jDateAkhir = new com.toedter.calendar.JDateChooser();
        jPanel5 = new javax.swing.JPanel();
        lblRows = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        btnView = new javax.swing.JButton();
        btnPrint = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Daftar Sewa Ruang");
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

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 940, 470));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Menu Daftar Sewa Ruangan");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 940, 40));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 170, -1, -1));

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
        jPanel1.add(jDateAwal, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 20, 150, 30));

        jLabel13.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Sd");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 20, 40, 30));

        jDateAkhir.setDateFormatString("dd/MM/yyyy");
        jDateAkhir.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jDateAkhir.setOpaque(false);
        jDateAkhir.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jDateAkhirPropertyChange(evt);
            }
        });
        jPanel1.add(jDateAkhir, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 20, 150, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 570, 70));

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Data", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 11))); // NOI18N
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblRows.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblRows.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblRows.setText("0");
        jPanel5.add(lblRows, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, 180, 30));

        lblTotal.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblTotal.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblTotal.setText("0");
        jPanel5.add(lblTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 40, 180, 30));

        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Jumlah Data :");
        jPanel5.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 100, 30));

        jLabel10.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Total :");
        jPanel5.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, 100, 30));

        getContentPane().add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 590, 360, 80));

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Proses", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 11))); // NOI18N
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnView.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnView.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tesaapp/img/doc_refresh.png"))); // NOI18N
        btnView.setText("Lihat Data");
        btnView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewActionPerformed(evt);
            }
        });
        jPanel6.add(btnView, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 140, 50));

        btnPrint.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnPrint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tesaapp/img/print toolbar.png"))); // NOI18N
        btnPrint.setText("Cetak Data");
        btnPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintActionPerformed(evt);
            }
        });
        jPanel6.add(btnPrint, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 20, 140, 50));

        getContentPane().add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 590, 360, 80));

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
           Id=kolom1;
             System.out.println(Id);
        } catch (Exception e) {
            System.out.println("TableMouseClicked "+e);
        }
    }//GEN-LAST:event_TableMouseClicked

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
            Logger.getLogger(List_Sewa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnPrintActionPerformed

    private void btnViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewActionPerformed
         LoadTabel();
    }//GEN-LAST:event_btnViewActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        dispose();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

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
            java.util.logging.Logger.getLogger(List_Sewa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(List_Sewa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(List_Sewa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(List_Sewa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new List_Sewa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Table;
    private javax.swing.JButton btnPrint;
    private javax.swing.JButton btnView;
    private com.toedter.calendar.JDateChooser jDateAkhir;
    private com.toedter.calendar.JDateChooser jDateAwal;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblRows;
    private javax.swing.JLabel lblTotal;
    // End of variables declaration//GEN-END:variables


}
