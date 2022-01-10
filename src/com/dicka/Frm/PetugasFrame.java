/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dicka.Frm;

import com.dicka.Dao.PetugasDao;
import com.dicka.Tabelmodel.TabelModelPetugas;
import com.dicka.entity.Petugas;
import com.dicka.service.PetugasService;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;

public class PetugasFrame extends javax.swing.JFrame {

    private PetugasService petugasDao=new PetugasDao();
    private TabelModelPetugas tabelModelPetugas=new TabelModelPetugas();
    private Petugas p;
    
    public PetugasFrame() {
        initComponents();
        tabel_petugas.setModel(tabelModelPetugas);
        setLocationRelativeTo(null);
        loadData();
    }

    private void loadData(){
        List<Petugas> petugases=petugasDao.petugase();
        tabelModelPetugas.setData(petugases);
    }
    
    private void resetForm(){
        txt_kodepetugas.setText("");
        txt_password.setText("");
        txt_username.setText("");
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
            String kode=txt_kodepetugas.getText();
            String username=txt_username.getText();
            String password=txt_password.getText();
            JOptionPane.showMessageDialog(null, "Success..");
        }
        
    }
    
    private boolean validasiInput(){
        boolean valid=false;
        if(txt_kodepetugas.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(null, "kode petugas tidak boleh kosong!");
        }else if(txt_password.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(null, "password tidak boleh kosong!");
        }else if(txt_username.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(null, "username tidak boleh kosong!");
        }else{
            valid=true;
        }
        return valid;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_kodepetugas = new javax.swing.JTextField();
        txt_username = new javax.swing.JTextField();
        txt_password = new javax.swing.JTextField();
        bt_code = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btn_simpan = new javax.swing.JButton();
        btn_update = new javax.swing.JButton();
        btn_delete = new javax.swing.JButton();
        btn_ambilData = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel_petugas = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(0, 0, 102));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Kd_Petugas :");

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Username :");

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Password :");

        bt_code.setText("Tambah");
        bt_code.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_codeActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Form Input Data Petugas");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_username)
                            .addComponent(txt_password)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txt_kodepetugas, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(bt_code)))))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(bt_code, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txt_kodepetugas)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txt_password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

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

        tabel_petugas.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tabel_petugas);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 397, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)
                .addGap(5, 5, 5)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_simpanActionPerformed
        // TODO add your handling code here:
        TampilWorker tampilWorker=new TampilWorker();
        if(validasiInput()==true){
            String kode=txt_kodepetugas.getText();
            String username=txt_username.getText();
            String password=txt_password.getText();
            
           Petugas p=new Petugas();
            p.setPassword(password);
            p.setPetugasKd(kode);
            p.setUsername(username);
            
            petugasDao.insertPetugas(p);
            tabelModelPetugas.insertPetugas(p);
            tampilWorker.execute();
            loadData();
            resetForm();
        }
    }//GEN-LAST:event_btn_simpanActionPerformed

    private void bt_codeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_codeActionPerformed
        // TODO add your handling code here:
        String kodepetugas=petugasDao.setAutoNumber();
        txt_kodepetugas.setText(kodepetugas);
    }//GEN-LAST:event_bt_codeActionPerformed

    private void btn_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateActionPerformed
        // TODO add your handling code here:
        TampilWorker tw=new TampilWorker();
        int index=tabel_petugas.getSelectedRow();
        if(index!=-1){
            Petugas p=tabelModelPetugas.getPetugas(tabel_petugas.convertRowIndexToModel(index));
            if(validasiInput()==true){
                String kode=txt_kodepetugas.getText();
                String username= txt_username.getText();
                String password=txt_password.getText();
                p.setPassword(password);
                p.setPetugasKd(kode);
                 p.setUsername(username);
                 
                 petugasDao.updatePetugas(p);
                 tw.execute();
                 tabelModelPetugas.updatePetugas(index, p);
                 resetForm();
                 loadData();
            }
        }else{
            JOptionPane.showMessageDialog(null, "tekan button AMBIL DATA terlebih dahulu!");
        }
    }//GEN-LAST:event_btn_updateActionPerformed

    private void btn_ambilDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ambilDataActionPerformed
        // TODO add your handling code here:
        int index=tabel_petugas.getSelectedRow();
        if(index!=-1){
            Petugas p=tabelModelPetugas.getPetugas(tabel_petugas.convertRowIndexToModel(index));
            txt_kodepetugas.setText(p.getPetugasKd());
            txt_password.setText(p.getPassword());
            txt_username.setText(p.getUsername());
        }else{
            JOptionPane.showMessageDialog(null, "seleksi salah satu baris!");
        }
    }//GEN-LAST:event_btn_ambilDataActionPerformed

    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed
        // TODO add your handling code here:
        TampilWorker tampilWorker=new TampilWorker();
        int index=tabel_petugas.getSelectedRow();
        if(index!=-1){
            Petugas p=tabelModelPetugas.getPetugas(tabel_petugas.convertRowIndexToModel(index));
            if(JOptionPane.showConfirmDialog(null, "apakah anda ingin menghapus data ini?", "konfirmasi", 
                    JOptionPane.OK_CANCEL_OPTION)==JOptionPane.OK_OPTION){
                petugasDao.deletePetugas(p);
                tabelModelPetugas.deletePetugas(index);
                loadData();
                tampilWorker.execute();
            }
        }else{
            JOptionPane.showMessageDialog(null, "seleksi salah satu baris!");
        }
    }//GEN-LAST:event_btn_deleteActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_code;
    private javax.swing.JButton btn_ambilData;
    private javax.swing.JButton btn_delete;
    private javax.swing.JButton btn_simpan;
    private javax.swing.JButton btn_update;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabel_petugas;
    private javax.swing.JTextField txt_kodepetugas;
    private javax.swing.JTextField txt_password;
    private javax.swing.JTextField txt_username;
    // End of variables declaration//GEN-END:variables
}
