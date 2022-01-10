/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dicka.Tabelmodel;

import com.dicka.entity.Obat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class TabelModelObat extends AbstractTableModel{
    
    private List<Obat> list=new ArrayList<>();
    
    public TabelModelObat(){
        
    }

    @Override
    public int getRowCount() {
      return list.size();
    }

    @Override
    public int getColumnCount() {
     return 7;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
     switch(columnIndex){
         case 0 : return list.get(rowIndex).getObatkd();
         case 1 : return list.get(rowIndex).getNama_obat();
         case 2 : return list.get(rowIndex).getJumlah();
         case 3 : return list.get(rowIndex).getKategori();
         case 4 : return list.get(rowIndex).getTanggal_kadaluarsa();
         case 5 : return list.get(rowIndex).getHargaBarang();
         case 6 : return list.get(rowIndex).isCek();
             default:return null;
     }   
    }

    @Override
    public String getColumnName(int column) {
      switch(column){
          case 0 : return "kd_obat";
              case 1 : return "nama obat";
              case 2 : return "jumlah";
              case 3 : return "kategori";
              case 4 : return "kadaluarsa";
              case 5 : return "harga";
                  case 6 : return "centang";
                  default:return null;
      } 
    }
    
    public void insertObat(Obat obat){
        this.list.add(obat);
        fireTableDataChanged();
    }
   
    public void updateObat(int index, Obat obat){
        this.list.set(index, obat);
        fireTableDataChanged();
    }
    
    public void deleteObat(int index){
        this.list.remove(index);
        fireTableDataChanged();
    }
    
    public Obat getObat(int index){
        return list.get(index);
    }
    
    public void setData(List<Obat> list){
        this.list=list;
        fireTableDataChanged();
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
      return true;
    }
    
    public void clear(){
        list.clear();
    }
    
    public List<Obat> getObatCek(){
        List ls=new ArrayList();
        for(Obat o : list){
            if(o.isCek()){
                ls.add(o);
            }
        }
        return ls;
    }
    
    public boolean obatCek(boolean  cek){
        return list.equals(cek);
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
       if(columnIndex==6){
           return Boolean.class;
       }else{
           return super.getColumnClass(columnIndex);
       }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
     if(aValue!=null && aValue instanceof Boolean&&columnIndex==6){
         Boolean cek=(Boolean) aValue;
         list.get(rowIndex).setCek(cek);
     }  
    }
    
    
    
    
}
