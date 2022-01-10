/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dicka.service;

import com.dicka.entity.Kategori;
import java.util.List;

public interface KategoriService {
    void insertKategori(Kategori kategori);
    void updateKategori(Kategori kategori);
    void deleteKategori(Kategori kategori);
    Kategori getByid(String id);
    List<Kategori> getkatKategori();
}
