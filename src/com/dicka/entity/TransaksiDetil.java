/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dicka.entity;

public class TransaksiDetil {
    private Transaksi transaksi;
    private Obat obat;
    private int jumlah;
    private Double harga;

    public Double getHarga() {
        return harga;
    }

    public void setHarga(Double harga) {
        this.harga = harga;
    }
    
    

    public Transaksi getTransaksi() {
        return transaksi;
    }

    public void setTransaksi(Transaksi transaksi) {
        this.transaksi = transaksi;
    }

    public Obat getObat() {
        return obat;
    }

    public void setObat(Obat obat) {
        this.obat = obat;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }
    
    
}
