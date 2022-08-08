/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Resto.team.pbo.controller;

import Resto.team.pbo.model.ListPesanan;
import Resto.team.pbo.model.PesananModel;
import Resto.team.pbo.view.listPesanan.DetailListPesanan;
import Resto.team.pbo.view.listPesanan.ListPesananIndex;
import static java.lang.Integer.parseInt;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author nurha
 */
public class ListPesananController {
    private PesananModel model ;
    
    public ListPesananController(){
        model = new PesananModel();
    }
    
    public void GetDataIndex(ListPesananIndex view){
        List<ListPesanan> data = model.orderSelected();
        DefaultTableModel tabelRow = (DefaultTableModel) view.getTblPesanan().getModel();
        int hitung = tabelRow.getRowCount();
        while (hitung > 0){
            tabelRow.removeRow(hitung-1);
            hitung--;
        }
        if(hitung == 0){
            int count = 1;
            for(int i = 0;i< model.getManyData();i++){
                tabelRow.addRow(new Object[]{String.valueOf(count),data.get(i).Status,String.valueOf(data.get(i).Jumlah),data.get(i).Meja});
                count ++;
            }
        }
    }
    public void EditData(ListPesananIndex view){
        try{
            int row = view.getTblPesanan().getSelectedRow();
            List<ListPesanan> data = model.orderSelected();
            int value = data.get(row).ID ;
            DetailListPesanan viewDetail = new DetailListPesanan(value);
            viewDetail.setVisible(true);
        }catch(Exception ex){
            JOptionPane.showMessageDialog(view,"Silahkan Pilih Baris Pada Tabel Terlebih Dahulu");
        }
        
    }
    public void hapusData(ListPesananIndex view){
        int row = view.getTblPesanan().getSelectedRow();
        List<ListPesanan> data = model.orderSelected();
        int value = data.get(row).ID ;
        int input = JOptionPane.showConfirmDialog(view, "Apakah Anda Ingin Menghapus Data ini ?","Konfirmasi Penghapusan",JOptionPane.YES_NO_CANCEL_OPTION);
        if(input == 0){
            try{
                model.deletePesanan(value);
                model.deletePesananMakanan(value);
                this.GetDataIndex(view);
                JOptionPane.showMessageDialog(view,"Data Berhasil Di Hapus");
            }catch(Exception ex){
                System.out.println("ex");
            }
        }
    }
    
    
    
}
