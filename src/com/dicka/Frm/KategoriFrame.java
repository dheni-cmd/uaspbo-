/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dicka.Frm;

import com.dicka.Dao.KategoriDao;
import com.dicka.Tabelmodel.TabelModelKategori;
import com.dicka.entity.Kategori;
import com.dicka.service.KategoriService;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;

public class KategoriFrame extends javax.swing.JFrame {

    
    private KategoriService kategoriDao=new KategoriDao();
    private TabelModelKategori tabelModelKategori=new TabelModelKategori();
    private Kategori k;
    
    public KategoriFrame() {
        initComponents();
        setLocationRelativeTo(null);
        tabel_kategori.setModel(tabelModelKategori);
        loadData();
    }
    
    private void loadData(){
        List<Kategori> kategoris=kategoriDao.getkatKategori();
        tabelModelKategori.setData(kategoris);
    }

    class TampilWorker extends SwingWorker{

        @Override
        protected Object doInBackground() throws Exception {
            for(int i=0; i<=100; i++){
                try {
                    Thread.sleep(10);
                } catch (Exception e) {
                }
            }
            return null;
        }

        @Override
        protected void done() {
            String kode=txt_kodekategori.getText();
            String kategorii=txt_kategori.getText();
            JOptionPane.showMessageDialog(null, "Success..");
            resetForm();
        }
       
    }
    
    private boolean validasiInput(){
        boolean valid=false;
        if(txt_kategori.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(null, "kode kategori tidak boleh kosong!");
        }else if(txt_kategori.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(null, "kategori tidak boleh kosong!");
        }else{
            valid=true;
        }
        return valid;
    }
    
    private void resetForm(){
        txt_kategori.setText("");
        txt_kodekategori.setText("");
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_kodekategori = new javax.swing.JTextField();
        txt_kategori = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel_kategori = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        btn_simpan = new javax.swing.JButton();
        btn_update = new javax.swing.JButton();
        btn_delete = new javax.swing.JButton();
        btn_ambilData = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(0, 0, 102));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Kd_Kategori :");

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Kategori :");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Form Input Kategori Obat");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_kodekategori)
                            .addComponent(txt_kategori, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 312, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(txt_kodekategori, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_kategori, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

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

        jPanel3.setBackground(new java.awt.Color(0, 0, 102));

        btn_simpan.setText("Simpan");
        btn_simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_simpanActionPerformed(evt);
            }
        });
        jPanel3.add(btn_simpan);

        btn_update.setText("Update");
        btn_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updateActionPerformed(evt);
            }
        });
        jPanel3.add(btn_update);

        btn_delete.setText("Delete");
        btn_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteActionPerformed(evt);
            }
        });
        jPanel3.add(btn_delete);

        btn_ambilData.setText("Ambil Data");
        btn_ambilData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ambilDataActionPerformed(evt);
            }
        });
        jPanel3.add(btn_ambilData);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_simpanActionPerformed
        // TODO add your handling code here:
        TampilWorker tampilWorker=new TampilWorker();
        if(validasiInput()==true){
            String kode=txt_kodekategori.getText();
            String kateoris=txt_kategori.getText();
            Kategori k=new Kategori();
            k.setKategori(kateoris);
            k.setKategoriKd(kode);
            
            kategoriDao.insertKategori(k);
            tabelModelKategori.insertKategori(k);
            tampilWorker.execute();
            loadData();
            resetForm();
        }
    }//GEN-LAST:event_btn_simpanActionPerformed

    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed
        // TODO add your handling code here:
        TampilWorker tampilWorker=new TampilWorker();
        int index=tabel_kategori.getSelectedRow();
        if(index!=-1){
           Kategori k=tabelModelKategori.getKategori(tabel_kategori.convertRowIndexToModel(index));
           if(JOptionPane.showConfirmDialog(null, "apakah anda yakin ingin menghapus data ini?", 
                   "konfirmasi", JOptionPane.OK_CANCEL_OPTION)==JOptionPane.OK_OPTION){
               kategoriDao.deleteKategori(k);
               tampilWorker.execute();
               tabelModelKategori.deleteKategori(index);
               loadData();
           }
        }else{
            JOptionPane.showMessageDialog(null, "seleksi salah satu baris!");
        }
    }//GEN-LAST:event_btn_deleteActionPerformed

    private void btn_ambilDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ambilDataActionPerformed
        // TODO add your handling code here:
        int index=tabel_kategori.getSelectedRow();
        if(index!=-1){
            Kategori k=tabelModelKategori.getKategori(tabel_kategori.convertRowIndexToModel(index));
            txt_kategori.setText(k.getKategori());
            txt_kodekategori.setText(k.getKategoriKd());
        }else{
            JOptionPane.showMessageDialog(null, "seleksi salah satu baris!");
        }
    }//GEN-LAST:event_btn_ambilDataActionPerformed

    private void btn_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateActionPerformed
        // TODO add your handling code here:
        TampilWorker tw=new TampilWorker();
        int index=tabel_kategori.getSelectedRow();
        if(index!=-1){
            Kategori k=tabelModelKategori.getKategori(tabel_kategori.convertRowIndexToModel(index));
            if(validasiInput()==true){
                String kode=txt_kodekategori.getText();
                String kategorii=txt_kategori.getText();
                
                k.setKategori(kategorii);
                k.setKategoriKd(kode);
                kategoriDao.updateKategori(k);
                tw.execute();
                tabelModelKategori.updateKategori(index, k);
                resetForm();
                loadData();
                
            }
        }else{
            JOptionPane.showMessageDialog(null, "tekan button AMBIL DATA terlebih dahulu!");
        }
    }//GEN-LAST:event_btn_updateActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_ambilData;
    private javax.swing.JButton btn_delete;
    private javax.swing.JButton btn_simpan;
    private javax.swing.JButton btn_update;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabel_kategori;
    private javax.swing.JTextField txt_kategori;
    private javax.swing.JTextField txt_kodekategori;
    // End of variables declaration//GEN-END:variables
}
