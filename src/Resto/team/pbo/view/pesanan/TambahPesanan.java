/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Resto.team.pbo.view.pesanan;

import Resto.team.pbo.controller.PesananController;
import Resto.team.pbo.model.MakananModel;
import Resto.team.pbo.view.pesanan.EditPesanan;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/**
 *
 * @author nurha
 */
public class TambahPesanan extends javax.swing.JFrame {

    /**
     * Creates new form TambahPesanan
     */
    private MakananModel model;
    private PesananController controller;
    public TambahPesanan() {
        model = new MakananModel();
        controller = new PesananController();
        
        initComponents();
        
        controller.setModel(model);
        
        cbMenuMakanan.setModel(new DefaultComboBoxModel<>(controller.setMakanan()));
        cbTDuduk.setModel(new DefaultComboBoxModel<>(controller.setTDuduk()));
        controller.scaleImage(this,"picture-1550652957.jpg");
    }

    public JComboBox<String> getCbMenuMakanan() {
        return cbMenuMakanan;
    }
    
    public JLabel getTxtDesc() {
        return txtDesc;
    }

    public JLabel getTxtGambar() {
        return txtGambar;
    }

    public JLabel getTxtNamaMakanan() {
        return txtNamaMakanan;
    }

    public JLabel getTxtHarga() {
        return txtHarga;
    }

    public JLabel getTxtStatus() {
        return txtStatus;
    }

    public JTextArea getTaCatatan() {
        return taCatatan;
    }

    public JTextField getTfBanyak() {
        return tfBanyak;
    }

    public JTable getTblListPesanan() {
        return tblListPesanan;
    }
    
    public String[][] getListPesanan() {
        return controller.getListPesanan();
    }
    public void setListPesanan(String[][] listPesanan) {
        controller.setListPesanan(listPesanan);
        SwingUtilities.updateComponentTreeUI(this);
        
        controller.setValueTabel(this);
    }

    public JComboBox<String> getCbTDuduk() {
        return cbTDuduk;
    }

    public JLabel getTxtJumlahBayar() {
        return txtJumlahBayar;
    }
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        cbMenuMakanan = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        txtNamaMakanan = new javax.swing.JLabel();
        txtGambar = new javax.swing.JLabel();
        txtDesc = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtHarga = new javax.swing.JLabel();
        txtStatus = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        tfBanyak = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        taCatatan = new javax.swing.JTextArea();
        btnTambah = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblListPesanan = new javax.swing.JTable();
        txtJumlahBayar = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        btnHapusPesanan = new javax.swing.JButton();
        btnEditPesanan = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        cbTDuduk = new javax.swing.JComboBox<>();
        btnLoadData = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Menu Makanan");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 25, 970, -1));

        cbMenuMakanan.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbMenuMakananItemStateChanged(evt);
            }
        });
        cbMenuMakanan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cbMenuMakananKeyReleased(evt);
            }
        });
        getContentPane().add(cbMenuMakanan, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 120, 460, -1));

        jLabel1.setText("Menu");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, -1, -1));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Keterangan"));

        txtNamaMakanan.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        txtNamaMakanan.setText("Nama Makanan");

        txtGambar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtGambar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resto/team/pbo/asset/image/picture-1550652957.jpg"))); // NOI18N
        txtGambar.setText("jLabel4");
        txtGambar.setAutoscrolls(true);

        txtDesc.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        jLabel3.setText("Harga");

        jLabel4.setText("Status");

        jLabel5.setText("Deskripsi");

        txtHarga.setText("Rp");

        txtStatus.setText("ketersediaan");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(txtGambar, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNamaMakanan)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(58, 58, 58)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtStatus)
                            .addComponent(txtHarga)))
                    .addComponent(txtDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtNamaMakanan)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtGambar, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtHarga))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtStatus))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(96, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 110, -1, 560));

        jLabel7.setText("Banyak");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, -1, -1));

        tfBanyak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfBanyakActionPerformed(evt);
            }
        });
        getContentPane().add(tfBanyak, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 160, 80, -1));

        jLabel8.setText("Catatan");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, -1, -1));

        taCatatan.setColumns(20);
        taCatatan.setRows(5);
        jScrollPane1.setViewportView(taCatatan);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 200, 460, 108));

        btnTambah.setText("Tambah");
        btnTambah.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTambahMouseClicked(evt);
            }
        });
        getContentPane().add(btnTambah, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 320, -1, -1));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("List Pesanan"));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblListPesanan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "No", "Nama Barang", "Banyak", "Harga", "Jumlah"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblListPesanan.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tblListPesanan.setFocusable(false);
        tblListPesanan.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tblListPesanan);
        if (tblListPesanan.getColumnModel().getColumnCount() > 0) {
            tblListPesanan.getColumnModel().getColumn(0).setResizable(false);
            tblListPesanan.getColumnModel().getColumn(0).setPreferredWidth(20);
            tblListPesanan.getColumnModel().getColumn(1).setResizable(false);
            tblListPesanan.getColumnModel().getColumn(1).setPreferredWidth(200);
            tblListPesanan.getColumnModel().getColumn(2).setResizable(false);
            tblListPesanan.getColumnModel().getColumn(2).setPreferredWidth(40);
            tblListPesanan.getColumnModel().getColumn(3).setResizable(false);
            tblListPesanan.getColumnModel().getColumn(3).setPreferredWidth(50);
            tblListPesanan.getColumnModel().getColumn(4).setResizable(false);
            tblListPesanan.getColumnModel().getColumn(4).setPreferredWidth(80);
        }

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 18, 520, 180));

        txtJumlahBayar.setText("Rp");
        jPanel2.add(txtJumlahBayar, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 210, 118, -1));

        jLabel10.setText("Total");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 210, -1, -1));

        jButton2.setText("Bayar");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 280, -1, -1));

        btnHapusPesanan.setText("Hapus");
        btnHapusPesanan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnHapusPesananMouseClicked(evt);
            }
        });
        btnHapusPesanan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusPesananActionPerformed(evt);
            }
        });
        jPanel2.add(btnHapusPesanan, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, -1, -1));

        btnEditPesanan.setText("Edit");
        btnEditPesanan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEditPesananMouseClicked(evt);
            }
        });
        jPanel2.add(btnEditPesanan, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 210, 70, -1));

        jLabel6.setText("Tempat Duduk");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 240, -1, -1));

        cbTDuduk.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel2.add(cbTDuduk, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 240, 130, -1));

        btnLoadData.setText("Load Data");
        btnLoadData.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLoadDataMouseClicked(evt);
            }
        });
        jPanel2.add(btnLoadData, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 210, -1, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, 530, 320));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cbMenuMakananKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbMenuMakananKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_cbMenuMakananKeyReleased

    private void cbMenuMakananItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbMenuMakananItemStateChanged
        // TODO add your handling code here:
        controller.onMenuChange(this);

    }//GEN-LAST:event_cbMenuMakananItemStateChanged

    private void tfBanyakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfBanyakActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfBanyakActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnHapusPesananActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusPesananActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnHapusPesananActionPerformed

    private void btnTambahMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTambahMouseClicked
        // TODO add your handling code here:
        controller.onClickTambah(this);
    }//GEN-LAST:event_btnTambahMouseClicked

    private void btnEditPesananMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditPesananMouseClicked
        // TODO add your handling code here:
        EditPesanan editPage = new EditPesanan();
        editPage.setListPesanan(controller.getListPesanan());
        controller.EditPesanan(editPage, this);
    }//GEN-LAST:event_btnEditPesananMouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        // TODO add your handling code here:
        controller.bayarPesanan(this);
    }//GEN-LAST:event_jButton2MouseClicked

    private void btnLoadDataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLoadDataMouseClicked
        // TODO add your handling code here:
        controller.setValueTabel(this);
    }//GEN-LAST:event_btnLoadDataMouseClicked

    private void btnHapusPesananMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHapusPesananMouseClicked
        // TODO add your handling code here:
        controller.HapusPesanan(this);
    }//GEN-LAST:event_btnHapusPesananMouseClicked

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
            java.util.logging.Logger.getLogger(TambahPesanan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TambahPesanan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TambahPesanan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TambahPesanan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TambahPesanan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditPesanan;
    private javax.swing.JButton btnHapusPesanan;
    private javax.swing.JButton btnLoadData;
    private javax.swing.JButton btnTambah;
    private javax.swing.JComboBox<String> cbMenuMakanan;
    private javax.swing.JComboBox<String> cbTDuduk;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea taCatatan;
    private javax.swing.JTable tblListPesanan;
    private javax.swing.JTextField tfBanyak;
    private javax.swing.JLabel txtDesc;
    private javax.swing.JLabel txtGambar;
    private javax.swing.JLabel txtHarga;
    private javax.swing.JLabel txtJumlahBayar;
    private javax.swing.JLabel txtNamaMakanan;
    private javax.swing.JLabel txtStatus;
    // End of variables declaration//GEN-END:variables
}
