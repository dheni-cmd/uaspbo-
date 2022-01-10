/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dicka.Frm;

import com.dicka.Dao.TransaksiDao;
import com.dicka.Tabelmodel.TabelModelTransaksiDetil;
import com.dicka.dialog.ObatDialog;
import com.dicka.entity.Obat;
import com.dicka.entity.ReportTransaksi;
import com.dicka.entity.Transaksi;
import com.dicka.entity.TransaksiDetil;
import com.dicka.report.TampilReport;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.swing.JRViewer;

public class TransaksiFrame extends javax.swing.JFrame {

    private TabelModelTransaksiDetil tabelModelTransaksiDetil=new TabelModelTransaksiDetil();
    private TransaksiDao transaksiDao=new TransaksiDao();
    private Transaksi transaksi;
    private Obat obat;
    List<Transaksi>listTransaksi=new ArrayList<>();
    private Date tanggal=new Date();
    
    public TransaksiFrame() {
        initComponents();
        setLocationRelativeTo(null);
        tabel_transaksiDetil.setModel(tabelModelTransaksiDetil);
        txt_tanggal.setDate(tanggal);
    }

    private void resetForm(){
        txt_kodeTransaksi.setText("");
        txt_tanggal.setDate(tanggal);
        txt_total.setText("");
        tabelModelTransaksiDetil.clear();
        btn_kode.setEnabled(true);
        btn_ambil.setEnabled(false);
        btn_hitung.setEnabled(false);
        btn_simpan.setEnabled(true);
        btn_cetak.setEnabled(false);
    }
    
    private boolean validasiInput(){
        
        boolean valid=false;
        if(txt_kodeTransaksi.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(null, "kode transaksi tidak boleh kosong!");
        }else if(txt_total.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(null, "Jumlah total Tidak boleh kosong!");
        }else if(tabel_transaksiDetil.getRowCount()==0){
            JOptionPane.showMessageDialog(null, "obat belum dipilih!");
        }else{
            valid=true;
        }
        return valid;
    }
    
    private int validasiHitung(){
        int jumlah = 0;
        for(int i=0; i<tabel_transaksiDetil.getRowCount(); i++){
            jumlah = (int) tabel_transaksiDetil.getValueAt(i, 1);
        }
        return jumlah;
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_kodeTransaksi = new javax.swing.JTextField();
        txt_tanggal = new com.toedter.calendar.JDateChooser();
        btn_kode = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel_transaksiDetil = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        btn_ambil = new javax.swing.JButton();
        btn_simpan = new javax.swing.JButton();
        btn_cetak = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txt_total = new javax.swing.JTextField();
        btn_hitung = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(0, 0, 102));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Kd_Transaksi :");

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Tanggal :");

        txt_kodeTransaksi.setEnabled(false);

        txt_tanggal.setEnabled(false);

        btn_kode.setText("Tambah");
        btn_kode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_kodeActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Form Input Transaksi Penjualan Obat");

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
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_tanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txt_kodeTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btn_kode))))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 424, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(11, 11, 11)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_kodeTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_kode)
                    .addComponent(jLabel2))
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(txt_tanggal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        tabel_transaksiDetil.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tabel_transaksiDetil);

        jPanel3.setBackground(new java.awt.Color(0, 0, 102));

        btn_ambil.setText("Ambil Obat");
        btn_ambil.setEnabled(false);
        btn_ambil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ambilActionPerformed(evt);
            }
        });
        jPanel3.add(btn_ambil);

        btn_simpan.setText("Save");
        btn_simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_simpanActionPerformed(evt);
            }
        });
        jPanel3.add(btn_simpan);

        btn_cetak.setText("Cetak");
        btn_cetak.setEnabled(false);
        btn_cetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cetakActionPerformed(evt);
            }
        });
        jPanel3.add(btn_cetak);

        jLabel4.setText("Total :");

        txt_total.setEnabled(false);

        btn_hitung.setText("Hitung");
        btn_hitung.setEnabled(false);
        btn_hitung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hitungActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(txt_total, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_hitung)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txt_total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_hitung))
                .addGap(5, 5, 5)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_ambilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ambilActionPerformed
        // proses ambil obat
       boolean valid=false;
       ObatDialog dialog=new ObatDialog();
       obat=dialog.ambilObat();
       if(obat!=null){
           List<Obat> obatCek =dialog.tabelModelObat.getObatCek();
           for(Obat o : obatCek){
               TransaksiDetil td=new TransaksiDetil();
               td.setObat(o);
               td.setJumlah(0);
               td.setHarga(o.getHargaBarang());
               
               for(int i=0; i<tabel_transaksiDetil.getRowCount(); i++){
                   TransaksiDetil td1=tabelModelTransaksiDetil.getTransaksiDetil(i);
                   if(td1.getObat().getNama_obat().equals(td.getObat().getNama_obat())){
                       valid=true;
                   }
               }
               if(valid==false){
                   tabelModelTransaksiDetil.insertTransaksiDetil(td);
               }else{
                   JOptionPane.showMessageDialog(null, "maaf nama barang sudah ada!");
               }
               btn_hitung.setEnabled(true);
           }
       }
    }//GEN-LAST:event_btn_ambilActionPerformed

    private void btn_kodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_kodeActionPerformed
        // TODO add your handling code here:
        String kodeTransaksi=transaksiDao.KodeTransaksi();
        txt_kodeTransaksi.setText(kodeTransaksi);
        btn_ambil.setEnabled(true);
        btn_kode.setEnabled(false);
    }//GEN-LAST:event_btn_kodeActionPerformed

    private void btn_hitungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hitungActionPerformed
        // proses hitung total belanja
        int jumlahbaris = tabel_transaksiDetil.getRowCount();
        double totalbiaya = 0;
        double jumlahBarang, hargaBarang;
        TableModel tabelModel;
        tabelModel = tabel_transaksiDetil.getModel();
        if(validasiHitung()==0){
            JOptionPane.showMessageDialog(null, "Maav anda belum bisa melakukan penghitungan total \n karena masih ada data barang yang jumlahnya 0");
        }else{
            for(int i=0; i<jumlahbaris; i++){
                   jumlahBarang = Double.parseDouble(tabelModel.getValueAt(i, 1).toString());
                   hargaBarang = Double.parseDouble(tabelModel.getValueAt(i, 2).toString());
                   totalbiaya = totalbiaya + (jumlahBarang*hargaBarang);
                   
            }
            txt_total.setText(String.valueOf(totalbiaya));
        }
       
        
    }//GEN-LAST:event_btn_hitungActionPerformed

    private void btn_simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_simpanActionPerformed
        // proses simpan transaksi
        if(validasiInput()==true){
            transaksi=new Transaksi();
            transaksi.setTransaksiKd(String.valueOf(txt_kodeTransaksi.getText()));
            transaksi.setTanggal_transaksi(txt_tanggal.getDate());
            
            List<TransaksiDetil> transaksiDetil=new ArrayList<>();
            for(int i=0; i<tabel_transaksiDetil.getRowCount(); i++){
                TransaksiDetil detil=new TransaksiDetil();
                detil.setTransaksi(transaksi);
                
                Obat o=(Obat) tabel_transaksiDetil.getValueAt(i, 0);
                int jumlah=(int) tabel_transaksiDetil.getValueAt(i, 1);
                Double harga=(Double) tabel_transaksiDetil.getValueAt(i, 2);
                
                detil.setHarga(harga);
                 detil.setJumlah(jumlah);
                 detil.setObat(o);
                 transaksiDetil.add(detil);
            }
            transaksi.setGetTransaksiDetils(transaksiDetil);
            if(transaksiDao.insertTransaksi(transaksi)==true){
                JOptionPane.showMessageDialog(null, "data berhasil disimpan!");
                listTransaksi.add(transaksi);
                btn_kode.setEnabled(true);
                btn_ambil.setEnabled(false);
                btn_hitung.setEnabled(false);
                btn_simpan.setEnabled(false);
                btn_cetak.setEnabled(true);
            }else{
                JOptionPane.showMessageDialog(null, "data gagal disimpan!");
            }
        }
    }//GEN-LAST:event_btn_simpanActionPerformed

    private void btn_cetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cetakActionPerformed
        try {
            // TODO add your handling code here:
            String idtransaksi = txt_kodeTransaksi.getText();
            List<ReportTransaksi> reportTransaksis = transaksiDao.getReportTransaksis(idtransaksi);
            JasperPrint jp= JasperFillManager.fillReport(this.getClass().getClassLoader().
                    getResourceAsStream("com/dicka/report/ReportTransaksi.jasper"),null,
                    new JRBeanCollectionDataSource(reportTransaksis));
            JRViewer jrv=new JRViewer(jp);
            TampilReport report=new TampilReport("Laporan Transaksi", jrv);
            resetForm();
        } catch (JRException ex) {
            Logger.getLogger(TransaksiFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_cetakActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_ambil;
    private javax.swing.JButton btn_cetak;
    private javax.swing.JButton btn_hitung;
    private javax.swing.JButton btn_kode;
    private javax.swing.JButton btn_simpan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabel_transaksiDetil;
    private javax.swing.JTextField txt_kodeTransaksi;
    private com.toedter.calendar.JDateChooser txt_tanggal;
    private javax.swing.JTextField txt_total;
    // End of variables declaration//GEN-END:variables
}
