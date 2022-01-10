/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dicka.Frm;

import com.dicka.Dao.KategoriDao;
import com.dicka.Dao.ObatDao;
import com.dicka.TabekHeaderCheckBox.TableHeaderCheckBox;
import com.dicka.Tabelmodel.TabelModelKategori;
import com.dicka.Tabelmodel.TabelModelObat;
import com.dicka.dialog.KategoriDialog;
import com.dicka.entity.Kategori;
import com.dicka.entity.Obat;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;

public class ObatFrame extends javax.swing.JFrame {

    private TabelModelObat tabelModelObat=new TabelModelObat();
    private ObatDao obatDao=new ObatDao();
    private Obat o;
    private KategoriDao kategoriDao=new KategoriDao();
    private Kategori k;
    private TabelModelKategori tabelModelKategori=new TabelModelKategori();
   
    public ObatFrame() {
        initComponents();
        setLocationRelativeTo(null);
        tabel_obat.setModel(tabelModelObat);
        tabel_obat.getColumnModel().getColumn(6).setHeaderRenderer(new 
                TableHeaderCheckBox(tabel_obat.getTableHeader(), 6));
        loadData();
        loadKategori();
    }
    
    private void loadData(){
        List<Obat> obats=obatDao.getObat();
        tabelModelObat.setData(obats);
    }
    
    private void loadKategori(){
        List<Kategori> kategoris=kategoriDao.getkatKategori();
        for(Kategori k1 : kategoris){
            cbo_kategori.addItem(k1);
        }
    }
    
    private void isiKategori(Kategori kateg){
        txt_kodeKategori.setText(kateg.getKategoriKd());
        txt_kategori.setText(kateg.getKategori());
    }
    
    private boolean validasiInput(){
        boolean valid=false;
        if(txt_kodeObat.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(null, "kode obat tidak boleh kosong!");
        }else if(txt_namaObat.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(null, "nama obat tidak boleh kosong!");
        }else if(txt_jumlah.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(null, "jumlah obat tidak boleh kosong!");
        }else if(txt_kodeKategori.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(null, "kode kategori tidak boleh kosong!");
        }else if(txt_kategori.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(null, "kategori tidak boleh kosong!");
        }else if(txt_tanggal.getDate()==null){
            JOptionPane.showMessageDialog(null, "tanggal kadaluarsa masih kosong!");
        }else if(txt_harga.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(null, "harga masih kosong!");
        }else{
            valid=true;
        }
        return valid;
    }
    
    private void resetForm(){
        txt_jumlah.setText("");
        txt_kategori.setText("");
        txt_kodeKategori.setText("");
        txt_kodeObat.setText("");
        txt_namaObat.setText("");
        txt_tanggal.setDate(null);
        txt_harga.setText("");
        cbo_kategori.setSelectedIndex(0);
    }
    
    
    class tampilWorker extends SwingWorker{

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
        
            JOptionPane.showMessageDialog(null, "success..");
       }
        
    }
    

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_kodeObat = new javax.swing.JTextField();
        txt_namaObat = new javax.swing.JTextField();
        txt_jumlah = new javax.swing.JTextField();
        txt_kodeKategori = new javax.swing.JTextField();
        txt_kategori = new javax.swing.JTextField();
        txt_tanggal = new com.toedter.calendar.JDateChooser();
        jButton7 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txt_harga = new javax.swing.JTextField();
        btn_cari = new javax.swing.JButton();
        cbo_kategori = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        btn_tambah = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        btn_simpan = new javax.swing.JButton();
        btn_update = new javax.swing.JButton();
        btn_delete = new javax.swing.JButton();
        btn_reset = new javax.swing.JButton();
        btn_ambilData = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel_obat = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(0, 0, 102));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Kd_Obat :");

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Nama Obat :");

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Jumlah :");

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Kategori : ");

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Kadaluarsa :");

        txt_kodeObat.setEnabled(false);

        txt_kodeKategori.setEnabled(false);

        txt_kategori.setEnabled(false);

        jButton7.setText("Ambil");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Harga :");

        btn_cari.setText("Cari");
        btn_cari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cariActionPerformed(evt);
            }
        });

        cbo_kategori.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "- Cari -" }));
        cbo_kategori.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbo_kategoriActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Form Input Data Obat ");

        btn_tambah.setText("Tambah");
        btn_tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tambahActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txt_namaObat)
                                .addComponent(txt_jumlah)
                                .addComponent(txt_tanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(txt_kodeKategori, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txt_kategori, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                    .addComponent(txt_kodeObat)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btn_tambah)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txt_harga, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbo_kategori, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_cari)))
                        .addGap(50, 50, 50))
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_kodeObat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_tambah))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_namaObat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txt_jumlah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txt_kodeKategori, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_kategori, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton7))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(txt_tanggal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txt_harga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_cari)
                    .addComponent(cbo_kategori, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12))
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

        btn_reset.setText("Reset");
        btn_reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_resetActionPerformed(evt);
            }
        });
        jPanel3.add(btn_reset);

        btn_ambilData.setText("Ambil Data");
        btn_ambilData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ambilDataActionPerformed(evt);
            }
        });
        jPanel3.add(btn_ambilData);

        tabel_obat.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tabel_obat);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        KategoriDialog dialog=new KategoriDialog();
        k=dialog.ambilKategori();
        if(k!=null){
            isiKategori(k);
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void btn_tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tambahActionPerformed
        String setAutonumber=obatDao.setAutoNumber();
        txt_kodeObat.setText(setAutonumber);
    }//GEN-LAST:event_btn_tambahActionPerformed

    private void btn_simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_simpanActionPerformed
        // TODO add your handling code here:
        tampilWorker tw=new tampilWorker();
        if(validasiInput()==true){
            String kodeObat=txt_kodeObat.getText();
            String namaobat=txt_namaObat.getText();
            int jumlah=Integer.valueOf(txt_jumlah.getText());
            String kodekategori=txt_kodeKategori.getText();
            Date tangga=txt_tanggal.getDate();
            Double hargaa=Double.valueOf(txt_harga.getText());
            
            Kategori k=new Kategori();
            Obat o=new Obat();
            o.setJumlah(jumlah);
            o.setNama_obat(namaobat);
            o.setTanggal_kadaluarsa(tangga);
            o.setObatkd(kodeObat);
            k.setKategoriKd(kodekategori);
            o.setKategori(k);
            o.setHargaBarang(hargaa);
            obatDao.insertObat(o);
            tabelModelObat.insertObat(o);
            tw.execute();
            resetForm();
            loadData();
        }
    }//GEN-LAST:event_btn_simpanActionPerformed

    private void btn_ambilDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ambilDataActionPerformed
        // proses ambil data
        int index=tabel_obat.getSelectedRow();
        if(index!=-1){
            Obat o=tabelModelObat.getObat(tabel_obat.convertRowIndexToModel(index));
            txt_jumlah.setText(String.valueOf(o.getJumlah()));
            txt_kategori.setText(String.valueOf(o.getKategori()));
            txt_kodeKategori.setText(String.valueOf(o.getKategori().getKategoriKd()));
            txt_kodeObat.setText(o.getObatkd());
            txt_namaObat.setText(o.getNama_obat());
            txt_tanggal.setDate(o.getTanggal_kadaluarsa());
            txt_harga.setText(String.valueOf(o.getHargaBarang()));
        }else{
            JOptionPane.showMessageDialog(null, "seleksi salah satu baris!");
        }
    }//GEN-LAST:event_btn_ambilDataActionPerformed

    private void btn_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateActionPerformed
        // proses update data
        tampilWorker tw=new tampilWorker();
        int index=tabel_obat.getSelectedRow();
        if(index!=-1){
            Obat o=tabelModelObat.getObat(tabel_obat.convertRowIndexToModel(index));
            if(validasiInput()==true){
                String kodeObat=txt_kodeObat.getText();
                String namaObat=txt_namaObat.getText();
                int jumlah=Integer.valueOf(txt_jumlah.getText());
                String kodeKategori=txt_kodeKategori.getText();
                Date kadaluarsa=txt_tanggal.getDate();
                Double hargaBarang=Double.valueOf(txt_harga.getText());
                
                Kategori k=new Kategori();
                o.setJumlah(jumlah);
                k.setKategoriKd(kodeKategori);
                o.setKategori(k);
                o.setNama_obat(namaObat);
                o.setObatkd(kodeObat);
                o.setTanggal_kadaluarsa(kadaluarsa);
                o.setHargaBarang(hargaBarang);
                
                obatDao.updateObat(o);
                tabelModelObat.updateObat(index, o);
                loadData();
                resetForm();
                 tw.execute();
            }
        }else{
            JOptionPane.showMessageDialog(null, "seleksi salah satu baris!");
        }
    }//GEN-LAST:event_btn_updateActionPerformed

    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed
        // TODO add your handling code here:
        tampilWorker tw=new tampilWorker();
        int index=tabel_obat.getSelectedRow();
        if(index!=-1){
            Obat o=tabelModelObat.getObat(tabel_obat.convertRowIndexToModel(index));
            if(JOptionPane.showConfirmDialog(null, "apakah anda yakin ingin menghapus data ini?", "konfirmasi", 
                    JOptionPane.OK_CANCEL_OPTION)== JOptionPane.OK_OPTION){
                obatDao.deleteObat(o);
                tabelModelObat.deleteObat(index);
                loadData();
                tw.execute();
            }
        }else{
            JOptionPane.showMessageDialog(null, "seleksi salah satu baris!");
        }
    }//GEN-LAST:event_btn_deleteActionPerformed

    private void btn_resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_resetActionPerformed
        // TODO add your handling code here:
        resetForm();
    }//GEN-LAST:event_btn_resetActionPerformed

    private void btn_cariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cariActionPerformed
        // proses cari data
        if(cbo_kategori.getSelectedIndex()==0){
            JOptionPane.showMessageDialog(null, "Siilahkan piliih kategorii Obat");
        }else{
            
            Kategori k1=(Kategori) cbo_kategori.getSelectedItem();
            List<Obat> kategori = obatDao.getKategori(k1);
            
            if(!kategori.isEmpty()){
                tabelModelObat.setData(kategori);
            }else{
                JOptionPane.showMessageDialog(null, "Data Kategori not found");
            }
        }
        
    }//GEN-LAST:event_btn_cariActionPerformed

    private void cbo_kategoriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbo_kategoriActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_cbo_kategoriActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_ambilData;
    private javax.swing.JButton btn_cari;
    private javax.swing.JButton btn_delete;
    private javax.swing.JButton btn_reset;
    private javax.swing.JButton btn_simpan;
    private javax.swing.JButton btn_tambah;
    private javax.swing.JButton btn_update;
    private javax.swing.JComboBox cbo_kategori;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabel_obat;
    private javax.swing.JTextField txt_harga;
    private javax.swing.JTextField txt_jumlah;
    private javax.swing.JTextField txt_kategori;
    private javax.swing.JTextField txt_kodeKategori;
    private javax.swing.JTextField txt_kodeObat;
    private javax.swing.JTextField txt_namaObat;
    private com.toedter.calendar.JDateChooser txt_tanggal;
    // End of variables declaration//GEN-END:variables
}
