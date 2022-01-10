/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dicka.service;

import com.dicka.entity.Petugas;
import java.util.List;

public interface PetugasService {
    void insertPetugas(Petugas petugas);
    void updatePetugas(Petugas petugas);
    void deletePetugas(Petugas petugas);
    Petugas getByid(String id);
    List<Petugas> petugase();
    String setAutoNumber();
    Petugas loginPetugas(String username, String password);
}
