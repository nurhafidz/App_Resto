/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Resto.team.pbo.view.table;

import Resto.team.pbo.connection.DataBaseConnection;
import Resto.team.pbo.controller.MejaController;
import Resto.team.pbo.model.MejaModel;
import Resto.team.pbo.view.login.Dashboard;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Satria Bakti Kusuma
 */
public class indexTable extends javax.swing.JFrame {

    /**
     * Creates new form indexTable
     */
   
    private MejaController controller;
    public indexTable()  {
        initComponents();
        this.setExtendedState(JFrame.MAXIMIZED_HORIZ);
        this.setVisible(true);
        this.setResizable(false);
        controller = new MejaController();
        try{
            controller.tampilTabelMeja(this);
        }catch(Exception ex){
            System.out.println(ex);   
        }
        
        
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableMeja = new javax.swing.JTable();
        btnEditmeja = new javax.swing.JButton();
        btnAddmeja = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel1.setText("TAMPIL MEJA");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 40, -1, -1));

        TableMeja.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        TableMeja.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "KODE MEJA", "NAMA MEJA", "STATUS"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(TableMeja);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 600, 310));

        btnEditmeja.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnEditmeja.setText("Edit Meja");
        btnEditmeja.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEditmejaMouseClicked(evt);
            }
        });
        btnEditmeja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditmejaActionPerformed(evt);
            }
        });
        jPanel1.add(btnEditmeja, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 480, 150, 60));

        btnAddmeja.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnAddmeja.setText("Tambah Meja");
        btnAddmeja.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAddmejaMouseClicked(evt);
            }
        });
        btnAddmeja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddmejaActionPerformed(evt);
            }
        });
        jPanel1.add(btnAddmeja, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 480, 140, 60));

        jButton1.setText("Dashboad");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 600));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnEditmejaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditmejaActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_btnEditmejaActionPerformed

    private void btnAddmejaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddmejaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAddmejaActionPerformed

    private void btnAddmejaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddmejaMouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        tambahTable tambah = new tambahTable();
        tambah.setVisible(true);
    }//GEN-LAST:event_btnAddmejaMouseClicked

    private void btnEditmejaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditmejaMouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        editTable edit = new editTable(controller.getEditMeja(this));
        edit.setVisible(true);
        
    }//GEN-LAST:event_btnEditmejaMouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
        Dashboard dashboard = new Dashboard();
        dashboard.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton1MouseClicked

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
            java.util.logging.Logger.getLogger(indexTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(indexTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(indexTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(indexTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new indexTable().setVisible(true);
            }
        });
    }
    

    public JTable getTableMeja() {
        return TableMeja;
    }

    public void setTableMeja(JTable TableMeja) {
        this.TableMeja = TableMeja;
    }

    public JButton getBtnAddmeja() {
        return btnAddmeja;
    }

    public void setBtnAddmeja(JButton btnAddmeja) {
        this.btnAddmeja = btnAddmeja;
    }

    public JButton getBtnEditmeja() {
        return btnEditmeja;
    }

    public void setBtnEditmeja(JButton btnEditmeja) {
        this.btnEditmeja = btnEditmeja;
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TableMeja;
    private javax.swing.JButton btnAddmeja;
    private javax.swing.JButton btnEditmeja;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    public void setTableMeja() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
