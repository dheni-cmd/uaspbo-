/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dicka.entity;

public class Petugas {
    private String petugasKd;
    private String username;
    private String password;

    public String getPetugasKd() {
        return petugasKd;
    }

    public void setPetugasKd(String petugasKd) {
        this.petugasKd = petugasKd;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return username;
    }
    
    
    
}
