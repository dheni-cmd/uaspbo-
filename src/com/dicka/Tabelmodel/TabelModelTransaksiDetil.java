/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dicka.Tabelmodel;

import com.dicka.entity.TransaksiDetil;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class TabelModelTransaksiDetil extends AbstractTableModel{
    
    List<TransaksiDetil> list=new ArrayList<>();
    
    public TabelModelTransaksiDetil(){
        
    }

    @Override
    public int getRowCount() {
     return list.size();
    }

    @Override
    public int getColumnCount() {
      return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
      switch(columnIndex){
          case 0 : return list.get(rowIndex).getObat();
              case 1 : return list.get(rowIndex).getJumlah();
                  case 2 : return list.get(rowIndex).getHarga();
                  default:return null;
      }  
    }

    @Override
    public String getColumnName(int column) {
       switch(column){
           case 0 : return "obat";
               case 1 : return "jumlah";
                   case 2 : return "harga satuan";
                   default:return null;
       } 
    }
    
    public void insertTransaksiDetil(TransaksiDetil transaksiDetil){
        this.list.add(transaksiDetil);
        fireTableDataChanged();
    }
    
    public TransaksiDetil getTransaksiDetil(int index){
        return list.get(index);
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
     switch(columnIndex){
          case 1 : return Integer.class;
              default:return Object.class;
     }  
    }
    
    public void clear(){
        list.clear();
        fireTableDataChanged();
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
      if(aValue!=null && aValue instanceof Integer&&columnIndex==1){
          int jumlah=(int) aValue;
          list.get(rowIndex).setJumlah(jumlah);
      }  
    }
    
    
}
