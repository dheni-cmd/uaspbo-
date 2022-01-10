/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dicka.databases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBConnection {
    private static Connection connection;
    
    public static Connection getConnection(){
        if(connection==null){
            try {
                String url="jdbc:mysql://localhost:3306/db_apotek";
                String usr="root";
                String pwd="";
                DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                connection=DriverManager.getConnection(url, usr, pwd);
            } catch (SQLException ex) {
                Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return connection;
    }
    
}
