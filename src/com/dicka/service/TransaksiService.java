/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dicka.service;

import com.dicka.entity.ReportTransaksi;
import com.dicka.entity.Transaksi;
import java.util.List;

public interface TransaksiService {
    boolean insertTransaksi(Transaksi transaksi);
    List<ReportTransaksi> getReportTransaksis(String idtransaksi);
    String KodeTransaksi();
}
