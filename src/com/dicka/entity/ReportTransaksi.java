/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dicka.entity;

public class ReportTransaksi {
    private Transaksi transaksi;
    private TransaksiDetil transaksiDetil;

    public Transaksi getTransaksi() {
        return transaksi;
    }

    public void setTransaksi(Transaksi transaksi) {
        this.transaksi = transaksi;
    }

    public TransaksiDetil getTransaksiDetil() {
        return transaksiDetil;
    }

    public void setTransaksiDetil(TransaksiDetil transaksiDetil) {
        this.transaksiDetil = transaksiDetil;
    }

    @Override
    public String toString() {
        return "ReportTransaksi{" + "transaksi=" + transaksi + ", transaksiDetil=" + transaksiDetil + '}';
    }
    
    
    
}
