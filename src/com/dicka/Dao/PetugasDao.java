/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dicka.Dao;

import com.dicka.databases.DBConnection;
import com.dicka.entity.Petugas;
import com.dicka.service.PetugasService;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PetugasDao implements PetugasService{
    
    private Connection connection;
    
    public PetugasDao(){
        connection= DBConnection.getConnection();
    }

    @Override
    public void insertPetugas(Petugas petugas) {
        PreparedStatement statement=null;
        String sql="insert into petugas(petugas_kd, username, password) values(?, ?, ?)";
        try {
            statement=connection.prepareStatement(sql);
            statement.setString(1, petugas.getPetugasKd());
            statement.setString(2, petugas.getUsername());
            statement.setString(3, petugas.getPassword());
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PetugasDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PetugasDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public void updatePetugas(Petugas petugas) {
       PreparedStatement statement=null;
       String sql="update petugas set username=?, password=? where petugas_kd=?";
        try {
            statement=connection.prepareStatement(sql);
            statement.setString(1, petugas.getUsername());
            statement.setString(2, petugas.getPassword());
            statement.setString(3, petugas.getPetugasKd());
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PetugasDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PetugasDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public void deletePetugas(Petugas petugas) {
      PreparedStatement statement=null;
      String sql="delete from petugas where petugas_kd=?";
        try {
            statement=connection.prepareStatement(sql);
            statement.setString(1, petugas.getPetugasKd());
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PetugasDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PetugasDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public Petugas getByid(String id) {
      PreparedStatement statement=null;
        ResultSet rs=null;
        Petugas p=null;
        String sql="select * from petugas where petugas_kd=?";
        try {
            statement=connection.prepareStatement(sql);
            statement.setString(1, id);
            rs=statement.executeQuery();
            while(rs.next()){
                p=new Petugas();
                p.setPetugasKd(rs.getString("petugas_kd"));
                p.setUsername(rs.getString("username"));
                p.setPassword(rs.getString("password"));
            }
            return p;
        } catch (SQLException ex) {
            Logger.getLogger(PetugasDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PetugasDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PetugasDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public List<Petugas> petugase() {
      PreparedStatement statement=null;
        List list=new ArrayList();
        ResultSet rs=null;
        String sql="select * from petugas";
        try {
            statement=connection.prepareStatement(sql);
            rs=statement.executeQuery();
            while(rs.next()){
                Petugas p=new Petugas();
                p.setPetugasKd(rs.getString("petugas_kd"));
                p.setUsername(rs.getString("username"));
                p.setPassword(rs.getString("password"));
                list.add(p);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(PetugasDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PetugasDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PetugasDao.class.getName()).log(Level.SEVERE, null, ex);
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
      String sql="select max(right(petugas_kd, 5)) from petugas";
        try {
            statement=connection.prepareStatement(sql);
            rs=statement.executeQuery();
            if(rs.first()==false){
                kode="KP/00001";
            }else{
                rs.last();
                s=Integer.toString(rs.getInt(1)+1);
                j=s.length();
                s1="";
                for(int i=0; i<=panjang-j; i++){
                     s1=s1+"0";
                }
                kode="KP/"+s1+s;
            }
            return kode;
        } catch (SQLException ex) {
            Logger.getLogger(PetugasDao.class.getName()).log(Level.SEVERE, null, ex);
            return kode;
        }finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PetugasDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PetugasDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public Petugas loginPetugas(String username, String password) {
      PreparedStatement statement=null;
      ResultSet rs=null;
      Petugas p=null;
      String sql="select * from petugas where username=? and password=?";
        try {
            statement=connection.prepareStatement(sql);
            statement.setString(1, username);
            statement.setString(2, password);
            rs=statement.executeQuery();
            while(rs.next()){
                p=new Petugas();
                p.setPetugasKd(rs.getString("petugas_kd"));
                p.setUsername(rs.getString("username"));
                p.setPassword(rs.getString("password"));
            }
            return p;
        } catch (SQLException ex) {
            Logger.getLogger(PetugasDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PetugasDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
}
