/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dicka.entity;

import java.util.Date;

public class Obat {
    private String Obatkd;
    private String nama_obat;
    private int jumlah;
    private Kategori kategori;
    private Date tanggal_kadaluarsa;
    private Double hargaBarang;
    private boolean cek;

    public Double getHargaBarang() {
        return hargaBarang;
    }

    public void setHargaBarang(Double hargaBarang) {
        this.hargaBarang = hargaBarang;
    }

    
    
    public boolean isCek() {
        return cek;
    }

    public void setCek(boolean cek) {
        this.cek = cek;
    }
    
    

    public String getObatkd() {
        return Obatkd;
    }

    public void setObatkd(String Obatkd) {
        this.Obatkd = Obatkd;
    }

    public String getNama_obat() {
        return nama_obat;
    }

    public void setNama_obat(String nama_obat) {
        this.nama_obat = nama_obat;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public Kategori getKategori() {
        return kategori;
    }

    public void setKategori(Kategori kategori) {
        this.kategori = kategori;
    }

    public Date getTanggal_kadaluarsa() {
        return tanggal_kadaluarsa;
    }

    public void setTanggal_kadaluarsa(Date tanggal_kadaluarsa) {
        this.tanggal_kadaluarsa = tanggal_kadaluarsa;
    }

    @Override
    public String toString() {
        return nama_obat;
    }
    
    
    
}
