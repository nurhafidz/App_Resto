/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Resto.team.pbo.controller;

import Resto.team.pbo.model.MakananModel;
import Resto.team.pbo.model.MejaModel;
import Resto.team.pbo.model.PesananModel;
import Resto.team.pbo.view.pesanan.EditPesanan;
import Resto.team.pbo.view.pesanan.MenuPesanan;
import Resto.team.pbo.view.pesanan.TambahPesanan;
import java.awt.Image;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListModel;

/**
 *
 * @author nurha
 */
public class PesananController {
    private MakananModel model;
    private MejaModel meja;
    private String[][] listPesanan;
    private PesananModel pesananModel;

    public PesananController() {
        this.pesananModel = new PesananModel();
        this.meja = new MejaModel();
    }

    public MakananModel getModel() {
        return model;
    }
    public void setModel(MakananModel model) {
        this.model = model;
    }

    public String[][] getListPesanan() {
        return listPesanan;
    }
    public void setListPesanan(String[][] listPesanan) {
        this.listPesanan = listPesanan;
    }
    public void editListPesanan(String[] listPesanan,int row){
        this.listPesanan[row] = listPesanan;
    }

    public void viewMenu(TambahPesanan view) {}
    
    public String[] setMakanan() {
        String[][] getMakanan = model.getMakanan().GetAllMakanan();

        String[] data = new String[model.getMakanan().getRows()];

        for (int i = 0; i < model.getMakanan().getRows(); i++) {
            String dat = getMakanan[i][1];
            data[i] = dat;
        }

        return data;

    }
    
    public String[] setTDuduk() {
        
        String[][] getMeja = meja.getMejaHelper().GetAllMejaTersedia();
        String[] data = new String[ meja.getMejaHelper().getRows()];
        for (int i = 0; i <  meja.getMejaHelper().getRows(); i++) {
            String dat = getMeja[i][1] + " - " + getMeja[i][2];
            data[i] = dat;
        }
        
        return data;

    }
    
    public void scaleImage(TambahPesanan view, String nama_Foto) {
        ImageIcon icon = new ImageIcon(getClass().getResource("../asset/image/" + nama_Foto));
        Image img = icon.getImage();
        Image imgScale = img.getScaledInstance(view.getTxtGambar().getWidth(), view.getTxtGambar().getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imgScale);
        view.getTxtGambar().setIcon(scaledIcon);
    }

    public void onMenuChange(TambahPesanan view) {
        String dataMakanan = view.getCbMenuMakanan().getSelectedItem().toString();
        String[][] newArray = this.model.customQuery("SELECT * FROM `food` WHERE name = '" + dataMakanan + "'");
        for (int i = 0; i < this.model.getMakanan().getRows(); i++) {
            view.getTxtNamaMakanan().setText(newArray[i][1]);
            view.getTxtHarga().setText("Rp " + newArray[i][4]);
            view.getTxtDesc().setText("<html>" + newArray[i][2] + "</html>");
            this.scaleImage(view, newArray[i][3]);
            int Stock = Integer.valueOf(newArray[i][6]);
            if (Stock <= 0) {
                view.getTxtStatus().setText("Tidak Tersedia");
            } else {
                view.getTxtStatus().setText("Tersedia");
            }
        }
    }
    
    public void onClickTambah(TambahPesanan view) {
        
        try{
            String dataMakanan = view.getCbMenuMakanan().getSelectedItem().toString();
            int qty = Integer.valueOf(view.getTfBanyak().getText());
            String catatan = view.getTaCatatan().getText();
            this.updateAndSetArr(dataMakanan,qty,catatan,getPanjangArray()+1,false);
            this.setValueTabel(view);
            this.resetInputPesan(view);
        }
        catch (Exception ex) {
            JOptionPane.showMessageDialog(view,ex);
        }
    }
    
    public int getPanjangArray(){
        int panjang = 0;
        try {
            panjang = listPesanan.length;
            return panjang;
        } catch (Exception ex) {
            panjang = 0;
            return panjang;
        }
    }
    
    public void updateAndSetArr(String dataMakanan, int qty, String catatan,int panjang,boolean isSelectRow){
        String[][] makananArr = this.model.customQuery("SELECT * FROM `food` WHERE name = '" + dataMakanan + "'");
        String[] listMakanan = new String[7];
        for (int i = 0; i < this.model.getMakanan().getRows(); i++) {
            int jumlah = Integer.valueOf(makananArr[i][4]) * qty ;
            if(isSelectRow)listMakanan[0] = String.valueOf(panjang+1);
            else listMakanan[0] = String.valueOf(panjang);
            listMakanan[1] = makananArr[i][0];
            listMakanan[2] = makananArr[i][1];
            listMakanan[3] = String.valueOf(qty);
            listMakanan[4] = catatan;
            listMakanan[5] = makananArr[i][4];
            listMakanan[6] = String.valueOf(jumlah);
            
        }
        
        if(isSelectRow){         
            listPesanan[panjang] = listMakanan;
        }
        else{
            String[][] getList = new String[panjang][7];
            if (panjang == 1) {
                getList[0] = listMakanan;
            } else {
                for (int i = 0; i < panjang - 1; i++) {
                    getList[i] = listPesanan[i];
                }
                getList[panjang - 1] = listMakanan;
            }
            this.setListPesanan(getList);
        }
        
        
        
    }

    public void setValueTabel(TambahPesanan view) {
        try{
            String[][] listPesan = listPesanan;
            int julmahsma = 0;
            this.resetTable(view);
            for (int i = 0; i < listPesan.length; i++) {
    //            System.out.println(listPesanan[i][0]+"-"+listPesanan[i][1]+"-"+listPesanan[i][2]+"-"+listPesanan[i][3]+"-"+listPesanan[i][4]+"-"+listPesanan[i][5]+"-"+listPesanan[i][6]);
                view.getTblListPesanan().setValueAt(listPesan[i][0], i, 0);
                view.getTblListPesanan().setValueAt(listPesan[i][2], i, 1);
                view.getTblListPesanan().setValueAt(listPesan[i][3], i, 2);
                view.getTblListPesanan().setValueAt(listPesan[i][5], i, 3);
                view.getTblListPesanan().setValueAt(listPesan[i][6], i, 4);
                julmahsma += Integer.valueOf(listPesan[i][6]);
            }
            view.getTxtJumlahBayar().setText("Rp "+ julmahsma);
        }
        catch (Exception ex) {
            JOptionPane.showMessageDialog(view,"Tidak ada data");
        }
    }
    
    public void EditPesanan(EditPesanan viewEdit, TambahPesanan viewPesan){
        try{
            int row = viewPesan.getTblListPesanan().getSelectedRow();
            viewEdit.setRow(row);
            viewEdit.setVisible(true);
            String[][] listPesan = listPesanan;
            viewEdit.getTfBanyakEdit().setText(listPesan[row][3]);
            viewEdit.getTaCatatanEdit().setText(listPesan[row][4]);
        }catch (Exception ex) {
            viewEdit.setVisible(false);
            JOptionPane.showMessageDialog(viewPesan,"Pilih baris yang memiliki data");
        }
    }
    
    public void UpdatePesanan(EditPesanan viewEdit,TambahPesanan viewPesan){
        try{
            String dataMakanan = viewEdit.getCbMenuEdit().getSelectedItem().toString();
            int qty = Integer.valueOf(viewEdit.getTfBanyakEdit().getText());
            String catatan = viewEdit.getTaCatatanEdit().getText();
            this.updateAndSetArr(dataMakanan,qty,catatan,viewEdit.getRow(),true);
            this.setValueTabel(viewPesan);
            viewEdit.setVisible(false);
        }
        catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public void bayarPesanan(TambahPesanan view){
        try{
            int panjang = this.getPanjangArray();
            String mejaCb = (String) view.getCbTDuduk().getSelectedItem();
            String[] mejaCbSplit = mejaCb.split(" - ", 2);
            String[] jumlahPembayaran = view.getTxtJumlahBayar().getText().split(" ", 2);
            if(panjang >= 1 && mejaCb != null){
                String[][] mejaData = meja.getMejaHelper().GetSelectedMejaByName(mejaCbSplit[0]);
                String[] dataOrder = new String[4];
                dataOrder[0]=mejaData[0][0].toString();
                dataOrder[1]=jumlahPembayaran[1];
                dataOrder[2]="waiting payment";
                
                pesananModel.insertOrderFoodAndOrder(dataOrder,listPesanan);
                this.resetInputPesan(view);
                this.resetTable(view);
                JOptionPane.showMessageDialog(view,"Berhasil, Silahkan Menu Ke kasir Untuk Pembayaran");
                MenuPesanan menuView = new MenuPesanan();
                menuView.setVisible(true);
                view.setVisible(false);
            }
            else{
                if(panjang < 1)JOptionPane.showMessageDialog(view,"Isi Pesanan Terlebih dahulu");
                else JOptionPane.showMessageDialog(view,"Pilih Tempat duduk Terlebih dahulu");
            }
            
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
    
    public void HapusPesanan(TambahPesanan view){
        if(this.getPanjangArray() != 0){
            int row = view.getTblListPesanan().getSelectedRow();
            String[][] getList = new String[this.getPanjangArray()-1][7];
            if(this.getPanjangArray()-1> 0){
                for(int i=0;i<this.getPanjangArray();i++){
                    
                    if(i==row){
                        continue;
                    }
                    else if(i>row){
                        getList[i-1] = listPesanan[i];
                        getList[i-1][0] = String.valueOf(i);
                    }
                    else{
                        getList[i] = listPesanan[i];
                    }
                }
            }
            this.setListPesanan(getList);
            this.setValueTabel(view);
        }
        else{
            JOptionPane.showMessageDialog(view,"tidak ada pesanan");
        }
    }
    
    public void resetInputPesan(TambahPesanan view){
        view.getTfBanyak().setText("");
        view.getTaCatatan().setText("");
    }
    
    public void resetTable(TambahPesanan view){
        for (int i = 0; i < 100; i++) {
                view.getTblListPesanan().setValueAt("", i, 0);
                view.getTblListPesanan().setValueAt("", i, 1);
                view.getTblListPesanan().setValueAt("", i, 2);
                view.getTblListPesanan().setValueAt("", i, 3);
                view.getTblListPesanan().setValueAt("", i, 4);
            }
    }
}