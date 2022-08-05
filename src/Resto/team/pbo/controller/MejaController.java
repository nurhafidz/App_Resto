/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Resto.team.pbo.controller;

import Resto.team.pbo.model.ListMeja;
import Resto.team.pbo.model.MejaModel;
import Resto.team.pbo.view.table.editTable;
import Resto.team.pbo.view.table.indexTable;
import Resto.team.pbo.view.table.tambahTable;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Satria Bakti Kusuma
 */
public class MejaController {
    public MejaModel model;
 
    public MejaController(){
        model = new MejaModel();
        
        
    }
    
    public void tampilTabelMeja(indexTable view){
        DefaultTableModel table =(DefaultTableModel) view.getTableMeja().getModel();
        
//        

        List<ListMeja> dataMeja = model.tampilMeja();
        for (int i = 0;i < dataMeja.size();i++){
            table.addRow(new Object[]{dataMeja.get(i).TableCode,dataMeja.get(i).Name,dataMeja.get(i).Status});
        }
    }
    
    public void tambahDataMeja(tambahTable view){
        try{
        ListMeja dataMeja = new ListMeja();
        dataMeja.TableCode = view.getTableCode().getText();
        dataMeja.Name = view.getTableName().getText();
        dataMeja.Status =(String) view.getComboStatus().getSelectedItem();
        
        model.tambahMeja(dataMeja);
        JOptionPane.showMessageDialog(view,"DATA BERHASIL DISIMPAN");
        }
        catch (Exception e){
            System.out.println(e);
            JOptionPane.showMessageDialog(view,"CEK KEMBALI INPUT DATA");
        }
    }
    public String getEditMeja(indexTable view){
        int row = view.getTableMeja().getSelectedRow();
        String id = (String) view.getTableMeja().getModel().getValueAt(row, 0);
        return id;
    }
    public void editMeja(String id,editTable edit){
        ListMeja dataEdit = model.ambilDataEdit(id);
        edit.getTableCode().setText(dataEdit.TableCode);
        edit.getTableName().setText(dataEdit.Name);
    }
    
    public void updateDataMeja(String id,editTable update) {
        try{
        ListMeja updateData = new ListMeja();
        updateData.TableCode = update.getTableCode().getText();
        updateData.Name = update.getTableName().getText();
        updateData.Status = (String) update.getComboStatus().getSelectedItem();
        model.updateDataMeja(id,updateData);
        JOptionPane.showMessageDialog(update,"DATA BERHASIL DI EDIT");
        }
        catch(Exception e){
            System.out.println(e);
            JOptionPane.showMessageDialog(update,"EDIT DATA GAGAL");
        }
    }
    
}
