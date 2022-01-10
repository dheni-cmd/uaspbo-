/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dicka.dialog;

import com.dicka.Dao.KategoriDao;
import com.dicka.Tabelmodel.TabelModelKategori;
import com.dicka.entity.Kategori;
import com.dicka.service.KategoriService;
import java.util.List;
import javax.swing.JOptionPane;

public class KategoriDialog extends javax.swing.JDialog {

    private TabelModelKategori tabelModelKategori=new TabelModelKategori();
    private KategoriService kategoriDao=new KategoriDao();
    private Kategori k;
    
    public KategoriDialog() {
        setModal(true);
        initComponents();
        setLocationRelativeTo(null);
        loadData();
        tabel_kategori.setModel(tabelModelKategori);
    }

    public Kategori ambilKategori(){
        setLocationRelativeTo(getParent());
        setVisible(true);
        return k;
    }
    
    private void loadData(){
        List<Kategori> kategoris=kategoriDao.getkatKategori();
        tabelModelKategori.setData(kategoris);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabel_kategori = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tabel_kategori.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tabel_kategori);

        jButton1.setText("Ambil");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);

        jButton2.setText("Batal");
        jPanel1.add(jButton2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        int index=tabel_kategori.getSelectedRow();
        if(index!=-1){
            k=tabelModelKategori.getKategori(tabel_kategori.convertRowIndexToModel(index));
            dispose();
        }else{
            JOptionPane.showMessageDialog(null, "seleksi salah satu baris!");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabel_kategori;
    // End of variables declaration//GEN-END:variables
}
