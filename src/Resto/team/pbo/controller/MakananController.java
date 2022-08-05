/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Resto.team.pbo.controller;

import Resto.team.pbo.model.ListMakanan;
import Resto.team.pbo.model.MakananModel;
import Resto.team.pbo.view.makanan.MakananIndex;
import Resto.team.pbo.view.makanan.TambahMakanan;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class MakananController {
    private MakananModel model;
    
    public MakananController(){
        model = new MakananModel();    
    }
    
    public void tampilSemuaMakanan(MakananIndex view){
      DefaultTableModel tblMakanan = (DefaultTableModel) view.getTblMakanan().getModel();
      
      List<ListMakanan> SemuaMakanan =  model.ListSemuaMakanan();
       for (int i = 0;i < SemuaMakanan.size();i++){
            tblMakanan.addRow(new Object[]{SemuaMakanan.get(i).Food_Code,SemuaMakanan.get(i).Name,SemuaMakanan.get(i).Stock,SemuaMakanan.get(i).Category,SemuaMakanan.get(i).Price});
            
       }
      
    }
    
    public void tambahMakanan(TambahMakanan view){
        String codeMakanan = view.getTfCodeMakanan().getText();
        String namaMakanan = view.getTfNamaMakanan().getText();
        String kategory = view.getCbKategory().getSelectedItem().toString();
        String stockMakanan = view.getTfStock().getText();
        String hargaMakanan = view.getTfHarga().getText();
        String gambarMakanan = view.getTfGambar().getText();
        String deskripsiMakanan = view.getTaDeskripsi().getText();
        
        ListMakanan makananBaru = new ListMakanan();
        makananBaru.Food_Code = codeMakanan;
        makananBaru.Name = namaMakanan;
        makananBaru.Category = kategory;
        makananBaru.Stock = Integer.valueOf(stockMakanan);
        makananBaru.Price = Integer.valueOf(hargaMakanan);
        makananBaru.Image = gambarMakanan;
        makananBaru.Description = deskripsiMakanan;
        
        model.tambahMakanan(makananBaru);
          JOptionPane.showMessageDialog(view,"DATA BERHASIL DISIMPAN");
    }
}
