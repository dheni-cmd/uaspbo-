/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dicka.service;

import com.dicka.entity.Kategori;
import com.dicka.entity.Obat;
import java.util.List;

public interface ObatService {
    void insertObat(Obat obat);
    void updateObat(Obat obat);
    void deleteObat(Obat obat);
    Obat getByid(String id);
    List<Obat> getObat();
    String setAutoNumber();
    List<Obat> getKategori(Kategori kategori);
    void kurangJumlahStokObat(int jumlah, Obat obat);
}
