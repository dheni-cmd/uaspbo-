/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dicka.Tabelmodel;

import com.dicka.entity.Petugas;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class TabelModelPetugas extends AbstractTableModel{
    
    private List<Petugas> list=new ArrayList<>();
    
    public TabelModelPetugas(){
        
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
          case 0 : return list.get(rowIndex).getPetugasKd();
          case 1 : return list.get(rowIndex).getUsername();
              case 2 : return list.get(rowIndex).getPassword();
                  default:return null;
      }  
    }

    @Override
    public String getColumnName(int column) {
       switch(column){
           case 0 : return "kd_petugas";
               case 1 : return "username";
                   case 2 :return "password";
                       default:return null;
       }
    }
    
    
    
    public void insertPetugas(Petugas petugas){
        this.list.add(petugas);
        fireTableDataChanged();
    }
    
    public void updatePetugas(int index, Petugas petugas){
        this.list.set(index, petugas);
        fireTableDataChanged();
    }
    
    public void deletePetugas(int index){
       this.list.remove(index);
       fireTableDataChanged();
    }
    
    public void setData(List<Petugas> list){
        this.list=list;
        fireTableDataChanged();
    }
    
    public Petugas getPetugas(int index){
        return list.get(index);
        
    }
    
    public void clear(){
        list.clear();
    }
    
}
