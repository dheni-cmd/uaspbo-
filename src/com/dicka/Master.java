/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dicka;

import com.dicka.Frm.KategoriFrame;
import com.dicka.Frm.ObatFrame;
import com.dicka.Frm.PetugasFrame;
import com.dicka.Frm.TransaksiFrame;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;

public class Master extends javax.swing.JFrame {

    /**
     * Creates new form Master
     */
    public Master() {
        initComponents();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (dim.width-getWidth())/2;
        int y = (dim.height-getHeight())/2;
        setLocation(x, y);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        mnu_penjualan = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/dicka/picture/apotek.jpg"))); // NOI18N
        jPanel1.add(jLabel1, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        jMenu1.setText("Data Petugas");

        jMenuItem1.setText("Petugas");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Data Obat");

        jMenuItem2.setText("Input Kategori Obat");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuItem3.setText("Input Data Obat");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem3);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Data Transaksi");

        mnu_penjualan.setText("Transaksi Penjualan Obat");
        mnu_penjualan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnu_penjualanActionPerformed(evt);
            }
        });
        jMenu3.add(mnu_penjualan);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // Data Petugas;
        PetugasFrame petugasFrame=new PetugasFrame();
        petugasFrame.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        KategoriFrame kategoriFrame=new KategoriFrame();
        kategoriFrame.setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        ObatFrame obatFrame=new ObatFrame();
        obatFrame.setVisible(true);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void mnu_penjualanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnu_penjualanActionPerformed
        // TODO add your handling code here:
        TransaksiFrame frame=new TransaksiFrame();
        frame.setVisible(true);
    }//GEN-LAST:event_mnu_penjualanActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JMenuItem mnu_penjualan;
    // End of variables declaration//GEN-END:variables
}
