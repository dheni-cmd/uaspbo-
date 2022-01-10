/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dicka.entity;

public class Kategori {
    private String kategoriKd;
    private String kategori;

    public String getKategoriKd() {
        return kategoriKd;
    }

    public void setKategoriKd(String kategoriKd) {
        this.kategoriKd = kategoriKd;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    @Override
    public String toString() {
        return kategori;
    }
    
    
}
