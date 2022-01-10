/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dicka.entity;

import java.util.Date;
import java.util.List;

public class Transaksi {
    private String transaksiKd;
    private Date tanggal_transaksi;
    List<TransaksiDetil> getTransaksiDetils;

    public String getTransaksiKd() {
        return transaksiKd;
    }

    public void setTransaksiKd(String transaksiKd) {
        this.transaksiKd = transaksiKd;
    }

    public Date getTanggal_transaksi() {
        return tanggal_transaksi;
    }

    public void setTanggal_transaksi(Date tanggal_transaksi) {
        this.tanggal_transaksi = tanggal_transaksi;
    }

    public List<TransaksiDetil> getGetTransaksiDetils() {
        return getTransaksiDetils;
    }

    public void setGetTransaksiDetils(List<TransaksiDetil> getTransaksiDetils) {
        this.getTransaksiDetils = getTransaksiDetils;
    }

    @Override
    public String toString() {
        return "Transaksi{" + "transaksiKd=" + transaksiKd + ", tanggal_transaksi=" + tanggal_transaksi + ", getTransaksiDetils=" + getTransaksiDetils + '}';
    }
    
    
}
