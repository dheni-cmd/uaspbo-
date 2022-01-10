/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dicka.Dao;

import com.dicka.databases.DBConnection;
import com.dicka.entity.Obat;
import com.dicka.entity.ReportTransaksi;
import com.dicka.entity.Transaksi;
import com.dicka.entity.TransaksiDetil;
import com.dicka.service.ObatService;
import com.dicka.service.TransaksiService;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class TransaksiDao implements TransaksiService{
    
    private Connection connection;
    private ObatService obatDao;
    
    public TransaksiDao(){
        connection= DBConnection.getConnection();
        obatDao=new ObatDao();
    }

    @Override
    public boolean insertTransaksi(Transaksi transaksi) {
        PreparedStatement statement=null;
        boolean valid=false;
        String sql ="insert into transaksi (transaksi_kd, tanggal_transaksi) "
                + "values (?, ?)";
        try {
            statement=connection.prepareStatement(sql);
            connection.setAutoCommit(false);
            statement.setString(1, transaksi.getTransaksiKd());
            statement.setDate(2, new Date(transaksi.getTanggal_transaksi().getTime()));
            statement.executeUpdate();
            
            //proses insert transaksi_detil
            String TRANSAKSI_SQL="insert into transaksi_detil (transaksi_kd, obat_kd, jumlah, harga) "
                    + "values (?, ?, ?, ?)";
            List<TransaksiDetil> detilTransaksii=transaksi.getGetTransaksiDetils();
            
            int validJumlah=0;
            for(TransaksiDetil transaksiDetil : detilTransaksii){
                statement=connection.prepareStatement(TRANSAKSI_SQL);
                statement.setString(1, transaksiDetil.getTransaksi().getTransaksiKd());
                statement.setString(2, transaksiDetil.getObat().getObatkd());
                statement.setInt(3, transaksiDetil.getJumlah());
                statement.setDouble(4,transaksiDetil.getHarga());
                statement.executeUpdate();
                
                
                //proses update stok jumlah barang
                obatDao=new ObatDao();
                if(transaksiDetil.getObat().getJumlah() < transaksiDetil.getJumlah()){
                    JOptionPane.showMessageDialog(null, "maaf jumlah stok obat "+ transaksiDetil.getObat().getNama_obat()+
                            " tidak mencukupi!");
                    validJumlah=transaksiDetil.getObat().getJumlah() - transaksiDetil.getJumlah();
                    valid=false;
                }else{
                    obatDao.kurangJumlahStokObat(transaksiDetil.getJumlah(), transaksiDetil.getObat());
                }
            }
            
            //proses validasi stok obat
            if(validJumlah<0){
                connection.rollback();
                connection.setAutoCommit(true);
            }else{
                connection.commit();
                connection.setAutoCommit(true);
                valid=true;
            }
            
            
        } catch (SQLException ex) {
            try {
                connection.rollback();
                connection.setAutoCommit(true);
                Logger.getLogger(TransaksiDao.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex1) {
                Logger.getLogger(TransaksiDao.class.getName()).log(Level.SEVERE, null, ex1);
            }finally{
                if(statement!=null){
                    try {
                        statement.close();
                    } catch (SQLException ex1) {
                        Logger.getLogger(TransaksiDao.class.getName()).log(Level.SEVERE, null, ex1);
                    }
                }
            }
        }
        return valid;
    }

    @Override
    public String KodeTransaksi() {
      PreparedStatement statement=null;
        ResultSet rs=null;
        String s, s1;
        String kode=null;
        Integer j;
        Integer panjang=5;
        String sql="select max(right(transaksi_kd, 5)) from transaksi";
        try {
            statement=connection.prepareStatement(sql);
            rs=statement.executeQuery();
            if(rs.first()==false){
                kode="KT/00001";
            }else{
                rs.last();
                s=Integer.toString(rs.getInt(1)+1);
                j=s.length();
                s1="";
                for(int i=0; i<=panjang-j; i++){
                    s1=s1+"0";
                }
                kode="KT/"+s1+s;
            }
            return kode;
        } catch (SQLException ex) {
            Logger.getLogger(TransaksiDao.class.getName()).log(Level.SEVERE, null, ex);
            return kode;
        }finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(TransaksiDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public List<ReportTransaksi> getReportTransaksis(String idtransaksi) {
        PreparedStatement statement=null;
        ResultSet rs=null;
        List list=new ArrayList();
        String sql = "select * from transaksi inner join transaksi_detil on "
                + "(transaksi.transaksi_kd=transaksi_detil.transaksi_kd) where transaksi.transaksi_kd=?";
        try {
            statement=connection.prepareStatement(sql);
            statement.setString(1, idtransaksi);
            rs=statement.executeQuery();
            while(rs.next()){
                ReportTransaksi rt=new ReportTransaksi();
                    Transaksi t1=new Transaksi();
                    t1.setTransaksiKd(rs.getString("transaksi_kd"));
                    t1.setTanggal_transaksi(rs.getDate("tanggal_transaksi"));
                rt.setTransaksi(t1);
                    TransaksiDetil td=new TransaksiDetil();
                    String idobat = rs.getString("obat_kd");
                    Obat byid = obatDao.getByid(idobat);
                    td.setObat(byid);
                    td.setJumlah(rs.getInt("jumlah"));
                    td.setHarga(rs.getDouble("harga"));
                rt.setTransaksiDetil(td);
                list.add(rt);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(TransaksiDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(TransaksiDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(TransaksiDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
    }
    
}
