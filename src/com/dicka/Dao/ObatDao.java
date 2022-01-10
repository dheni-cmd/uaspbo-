/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dicka.Dao;

import com.dicka.databases.DBConnection;
import com.dicka.entity.Kategori;
import com.dicka.entity.Obat;
import com.dicka.service.KategoriService;
import com.dicka.service.ObatService;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ObatDao implements ObatService{
    
    private Connection connection;
    private KategoriService kategoriDao;
    
    public ObatDao(){
        connection= DBConnection.getConnection();
        kategoriDao=new KategoriDao();
    }

    @Override
    public void insertObat(Obat obat) {
        PreparedStatement statement=null;
        String sql="insert into obat (obat_kd, obat, jumlah, kategori_kd, tgl_kadaluarsa, harga) "
                + "values (?, ?, ?, ?, ?, ?)";
        try {
            statement=connection.prepareStatement(sql);
            statement.setString(1, obat.getObatkd());
            statement.setString(2, obat.getNama_obat());
            statement.setInt(3, obat.getJumlah());
            statement.setString(4, obat.getKategori().getKategoriKd());
            statement.setDate(5, new Date(obat.getTanggal_kadaluarsa().getTime()));
            statement.setDouble(6, obat.getHargaBarang());
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ObatDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ObatDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public void updateObat(Obat obat) {
      PreparedStatement statement=null;
      String sql="update obat set obat=?, jumlah=?, kategori_kd=?, tgl_kadaluarsa=?, harga=? where obat_kd=?";
        try {
            statement=connection.prepareStatement(sql);
            statement.setString(1, obat.getNama_obat());
            statement.setInt(2, obat.getJumlah());
            statement.setString(3, obat.getKategori().getKategoriKd());
            statement.setDate(4, new Date(obat.getTanggal_kadaluarsa().getTime()));
            statement.setDouble(5, obat.getHargaBarang());
            statement.setString(6, obat.getObatkd());
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ObatDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ObatDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public void deleteObat(Obat obat) {
      PreparedStatement statement=null;
      String sql="delete from obat where obat_kd=?";
        try {
            statement=connection.prepareStatement(sql);
            statement.setString(1, obat.getObatkd());
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ObatDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ObatDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public Obat getByid(String id) {
     PreparedStatement statement=null;
        ResultSet rs=null;
        Obat o=null;
        String sql="select * from obat where obat_kd=?";
        try {
            statement=connection.prepareStatement(sql);
            statement.setString(1, id);
            rs=statement.executeQuery();
            while(rs.next()){
                o=new Obat();
                o.setObatkd(rs.getString("obat_kd"));
                o.setNama_obat(rs.getString("obat"));
                o.setJumlah(rs.getInt("jumlah"));
                String kategoriId=rs.getString("kategori_kd");
                Kategori byid=kategoriDao.getByid(kategoriId);
                o.setKategori(byid);
                o.setTanggal_kadaluarsa(rs.getDate("tgl_kadaluarsa"));
                o.setHargaBarang(rs.getDouble("harga"));
            }
            return o;
        } catch (SQLException ex) {
            Logger.getLogger(ObatDao.class.getName()).log(Level.SEVERE, null, ex);
            return  null;
        }finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ObatDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ObatDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public List<Obat> getObat() {
      PreparedStatement statement=null;
      List list=new ArrayList();
      ResultSet rs=null;
      String sql="select * from obat";
        try {
            statement=connection.prepareStatement(sql);
            rs=statement.executeQuery();
            while(rs.next()){
                 Obat o=new Obat();
                 o.setObatkd(rs.getString("obat_kd"));
                 o.setNama_obat(rs.getString("obat"));
                 o.setJumlah(rs.getInt("jumlah"));
                 String kategoriId=rs.getString("kategori_kd");
                 Kategori byid=kategoriDao.getByid(kategoriId);
                 o.setKategori(byid);
                 list.add(o);
                 o.setTanggal_kadaluarsa(rs.getDate("tgl_kadaluarsa"));
                 o.setHargaBarang(rs.getDouble("harga"));
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(ObatDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ObatDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ObatDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public String setAutoNumber() {
      PreparedStatement statement=null;
      ResultSet rs=null;
      String kode=null;
      String s, s1;
      Integer j;
      Integer panjang = 5;
      String sql="select max(right(obat_kd, 5)) from obat";
        try {
            statement=connection.prepareStatement(sql);
            rs=statement.executeQuery();
            if(rs.first()==false){
                kode="K_O/00001";
            }else{
                rs.last();
                s=Integer.toString(rs.getInt(1)+1);
                j=s.length();
                s1="";
                for(int i=0; i<=panjang-j; i++){
                    s1=s1+"0";
                }
                return kode="K_O/"+s1+s;
            }
            return kode;
        } catch (SQLException ex) {
            Logger.getLogger(ObatDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ObatDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ObatDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public List<Obat> getKategori(Kategori kategori) {
      PreparedStatement statement=null;
      ResultSet rs=null;
      List list=new ArrayList();
      String sql="select * from obat where kategori_kd=?";
        try {
            statement=connection.prepareStatement(sql);
            statement.setString(1, kategori.getKategoriKd());
            rs=statement.executeQuery();
            while(rs.next()){
                Obat o=new Obat();
                o.setObatkd(rs.getString("obat_kd"));
                o.setNama_obat(rs.getString("obat"));
                o.setJumlah(rs.getInt("jumlah"));
                String kategoriId=rs.getString("kategori_kd");
                Kategori byid=kategoriDao.getByid(kategoriId);
                o.setKategori(byid);
                o.setTanggal_kadaluarsa(rs.getDate("tgl_kadaluarsa"));
                list.add(o);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(ObatDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ObatDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ObatDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public void kurangJumlahStokObat(int jumlah, Obat obat) {
     PreparedStatement statement=null;
     String sql="update obat set jumlah=jumlah-? where obat_kd=?";
        try {
            statement=connection.prepareStatement(sql);
            statement.setInt(1, jumlah);
            statement.setString(2, obat.getObatkd());
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ObatDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ObatDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
}
