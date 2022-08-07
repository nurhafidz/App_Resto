/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Resto.team.pbo.controller;

import Resto.team.pbo.connection.DataBaseConnection;
import Resto.team.pbo.model.ListMakanan;
import Resto.team.pbo.model.MakananModel;
import Resto.team.pbo.view.makanan.EditMakanan;
import Resto.team.pbo.view.makanan.MakananDetail;
import Resto.team.pbo.view.makanan.MakananIndex;
import Resto.team.pbo.view.makanan.TambahMakanan;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class MakananController {
    private MakananModel model;
    
    public MakananController(){
        model = new MakananModel();    
    }
    
    public void tampilSemuaMakanan(MakananIndex view){
      DefaultTableModel tblMakanan = (DefaultTableModel) view.getTblMakanan().getModel();
      int hitung = tblMakanan.getRowCount();
      while (hitung > 0){
            tblMakanan.removeRow(hitung-1);
            hitung--;
        }
      List<ListMakanan> SemuaMakanan =  model.ListSemuaMakanan();
       for (int i = 0;i < SemuaMakanan.size();i++){
            tblMakanan.addRow(new Object[]{SemuaMakanan.get(i).Food_Code,SemuaMakanan.get(i).Name,SemuaMakanan.get(i).Stock,SemuaMakanan.get(i).Category,SemuaMakanan.get(i).Price});
            
       }
      
    }
    
    public void tambahMakanan(TambahMakanan view){
        String codeMakanan = null;
        String namaMakanan = null;
        String kategory = null;
        String stockMakanan = null;
        String hargaMakanan = null ;
        String gambarMakanan = null ;
        String deskripsiMakanan = null;
        try{
             codeMakanan = view.getTfCodeMakanan().getText();
             namaMakanan = view.getTfNamaMakanan().getText();
             kategory = view.getCbKategory().getSelectedItem().toString();
             stockMakanan = view.getTfStock().getText();
             hargaMakanan = view.getTfHarga().getText();
             gambarMakanan = view.getTfGambar().getText();
             deskripsiMakanan = view.getTaDeskripsi().getText();
        } catch (Exception ex){
            JOptionPane.showMessageDialog(view,"Cek kembali Field");
        }
        

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
    public void editMakanan(EditMakanan view,String kode){
        String code = view.getTfCodeMakanan().getText();
        String makanan = view.getTfNamaMakanan().getText();
        String kategori = view.getCbKategori().getSelectedItem().toString();
        String stok = view.getTfStock().getText();
        String harga = view.getTfHarga().getText();
        String gambar = view.getTfGambar().getText();
        String deskripsi = view.getTaDeskripsi().getText();
        
        ListMakanan editbaru = new ListMakanan();
        editbaru.Food_Code = code;
        editbaru.Name = makanan;
        editbaru.Category = kategori;
        editbaru.Stock = Integer.valueOf(stok); 
        editbaru.Price = Integer.valueOf(harga);
        editbaru.Image = gambar;
        editbaru.Description = deskripsi;
            model.editMakanan(editbaru,kode);
             JOptionPane.showMessageDialog(view,"Data Berhasil Disinpan");
}
    public void editbaru(EditMakanan view,String kode){
     try{
            
        Statement stm = DataBaseConnection.getConnection().createStatement();
        ResultSet data = stm.executeQuery("SELECT * FROM food WHERE food_code = '"+kode+"'");
        String kode_m ="";
        String name = "";
        String kategory = "";
        String stock = "";
        String harga = "";
        String gambar = "";
        String deskripsi = "";
        while(data.next()){
            kode_m = data.getString("food_code");
                view.getTfCodeMakanan().setText(kode_m);
            name = data.getString("name");
                view.getTfNamaMakanan().setText(name);
            kategory = data.getString("category");
            int kat=0;
            if(kategory == "makanan")kat=0;
            if(kategory == "minuman")kat=1;
            if(kategory == "snack")kat=2;
            if(kategory == "paket")kat=3;
                view.getCbKategori().setSelectedIndex(kat);
            stock = data.getString("stock");
                view.getTfStock().setText(stock);
            harga = data.getString("price");
                view.getTfHarga().setText(harga);
            gambar = data.getString("image");
                view.getTfGambar().setText(gambar);
            deskripsi = data.getString("description");
                view.getTaDeskripsi().setText(deskripsi);
        }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
     
    }
    public void hapus(String kode){
        try {
        Statement stm = DataBaseConnection.getConnection().createStatement();
            stm.executeUpdate("DELETE FROM food WHERE food_code ='"+kode+"'");
        } catch (SQLException ex) {
            Logger.getLogger(MakananController.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
    public void detail(MakananDetail view,String kode){
        List<ListMakanan> Makanan =  model.ListDetail(kode);
        view.setTxCodeMakanan(Makanan.get(0).Food_Code);
        view.setTxlNamaMakanan(Makanan.get(0).Name);
        view.setTxKategori(Makanan.get(0).Category);
        view.setTxtStock(String.valueOf(Makanan.get(0).Stock));
        view.setTxtHarga(String.valueOf(Makanan.get(0).Price));
        view.setTxtGambar(Makanan.get(0).Image);
        view.setTxDeskripsi("<html>" + Makanan.get(0).Description + "</html>");
     
    }
}
