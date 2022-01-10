/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dicka.Tabelmodel;

import com.dicka.entity.Kategori;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class TabelModelKategori extends AbstractTableModel{
    
    private List<Kategori> list=new ArrayList<>();
    
    public TabelModelKategori(){
        
    }

    @Override
    public int getRowCount() {
      return list.size();
    }

    @Override
    public int getColumnCount() {
     return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
      switch(columnIndex){
          case 0 : return list.get(rowIndex).getKategoriKd();
              case 1 : return list.get(rowIndex).getKategori();
                  default: return null;
      }  
    }

    @Override
    public String getColumnName(int column) {
      switch(column){
          case 0 :  return  "kd_kategori";
              case 1 : return "kategori";
                   default:return null;
      }  
    }
    
    public void insertKategori(Kategori kategori){
        this.list.add(kategori);
         fireTableDataChanged();
    }
    
    public void updateKategori(int index, Kategori kategori){
        this.list.set(index, kategori);
         fireTableDataChanged();
    }
    
    public void deleteKategori(int index){
        this.list.remove(index);
        fireTableDataChanged();
    }
    
    public void setData(List<Kategori> list){
        this.list=list;
        fireTableDataChanged();
    }
    
    public Kategori getKategori(int index){
        return list.get(index);
    }
    
    public void clear(){
        list.clear();
    }
    
}
