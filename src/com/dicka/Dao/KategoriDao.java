/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dicka.Dao;

import com.dicka.databases.DBConnection;
import com.dicka.entity.Kategori;
import com.dicka.service.KategoriService;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class KategoriDao implements KategoriService{
    
    private Connection connection;
    
    public KategoriDao(){
        connection= DBConnection.getConnection();
    }

    @Override
    public void insertKategori(Kategori kategori) {
        PreparedStatement statement=null;
        String sql="insert into kategori (kategori_kd, kategori) values (?, ?)";
        try {
            statement=connection.prepareStatement(sql);
            statement.setString(1, kategori.getKategoriKd());
            statement.setString(2, kategori.getKategori());
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(KategoriDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(KategoriDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public void updateKategori(Kategori kategori) {
       PreparedStatement statement=null;
       String sql="update kategori set kategori=? where kategori_kd=?";
        try {
            statement=connection.prepareStatement(sql);
            statement.setString(1, kategori.getKategori());
            statement.setString(2, kategori.getKategoriKd());
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(KategoriDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(KategoriDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public void deleteKategori(Kategori kategori) {
        PreparedStatement statement=null;
        String sql="delete from kategori where kategori_kd=?";
        try {
            statement=connection.prepareStatement(sql);
            statement.setString(1, kategori.getKategoriKd());
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(KategoriDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(KategoriDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public Kategori getByid(String id) {
      PreparedStatement statement=null;
        ResultSet rs=null;
        Kategori k=null;
        String sql="select * from kategori where kategori_kd=?";
        try {
            statement=connection.prepareStatement(sql);
            statement.setString(1, id);
            rs=statement.executeQuery();
            while(rs.next()){
                k=new Kategori();
                k.setKategoriKd(rs.getString("kategori_kd"));
                k.setKategori(rs.getString("kategori"));
            }
            return k;
        } catch (SQLException ex) {
            Logger.getLogger(KategoriDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(KategoriDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(KategoriDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public List<Kategori> getkatKategori() {
        PreparedStatement statement=null;
        List list=new ArrayList();
        ResultSet rs=null;
        String sql="select * from kategori";
        try {
            statement=connection.prepareStatement(sql);
            rs=statement.executeQuery();
            while(rs.next()){
                Kategori k=new Kategori();
                k.setKategoriKd(rs.getString("kategori_kd"));
                k.setKategori(rs.getString("kategori"));
                list.add(k);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(KategoriDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(KategoriDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(KategoriDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
}
