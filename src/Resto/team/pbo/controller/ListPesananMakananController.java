/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Resto.team.pbo.controller;

import Resto.team.pbo.model.ListPesanan;
import Resto.team.pbo.model.ListPesananMakanan;
import Resto.team.pbo.model.ListPesananMakananWithHarga;
import Resto.team.pbo.model.PesananModel;
import Resto.team.pbo.view.listPesanan.DetailListPesanan;
import Resto.team.pbo.view.listPesanan.PrintPage;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterJob;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author nurha
 */
public class ListPesananMakananController {
    private int id;
    private PesananModel model;
    public String catatan;
    
    public ListPesananMakananController(int idData){
        model = new PesananModel();
        this.id = idData;
    }

    public int getId() {
        return id;
    }
    
    
    public void setValueTabel(DetailListPesanan view){
        List<ListPesananMakanan> data = model.getPesananMakananByIdOrder(id);
        DefaultTableModel tabelRow = (DefaultTableModel) view.getTblPesananM().getModel();
        int hitung = tabelRow.getRowCount();
        while (hitung > 0){
            tabelRow.removeRow(hitung-1);
            hitung--;
        }
        if(hitung == 0){
            int count = 1 ;
            for(int i = 0;i< data.size();i++){
                tabelRow.addRow(new Object[]{String.valueOf(count),String.valueOf(data.get(i).ID),data.get(i).Nama_Menu,String.valueOf(data.get(i).Qty) ,"<html>" + data.get(i).Note + "</html>"});
            }
        }
    }
    public void setDetailPesanan(DetailListPesanan view){
        List<ListPesanan> data = model.orderSelectedByID(id);
        view.getTxtBayar().setText("Rp "+String.valueOf(data.get(0).Total));
        view.getTxtStatus().setText(data.get(0).Status);
        view.getTxtMeja().setText(data.get(0).Meja);
        view.getTxtTgl().setText(data.get(0).Tgl);
        if(data.get(0).Status.equals("menunggu pembayaran")){
            view.getBtnBayarOrSelesai().setText("Bayar");
        } else if(data.get(0).Status.equals("proses")){
            view.getBtnBayarOrSelesai().setText("Selesai");
        } else {
            view.getBtnBayarOrSelesai().setVisible(false);
        }
    }
    public void checkTombol(DetailListPesanan view){
        if(view.getBtnBayarOrSelesai().getText().equals("Bayar")){
            this.bayarPesanan(view);
        }
        else if(view.getBtnBayarOrSelesai().getText().equals("Selesai")){
            this.selesaiPesanan(view);
        }
    }
    public void bayarPesanan(DetailListPesanan view){
        try{
            model.updateStatusPesanan(id, "proses");
            JOptionPane.showMessageDialog(view,"Data Berhasil di Update");
            this.setDetailPesanan(view);
        }
        catch(Exception ex){
            System.out.println(ex);
        }
    }
    public void selesaiPesanan(DetailListPesanan view){
        try{
            model.updateStatusPesanan(id, "selesai");
            JOptionPane.showMessageDialog(view,"Data Berhasil di Update");
            this.setDetailPesanan(view);
        }
        catch(Exception ex){
            System.out.println(ex);
        }
    }
    public void setValueTabelCetak(PrintPage view){
        List<ListPesananMakananWithHarga> data = model.getPesananMakananByIdOrderWithHarga(id);
        DefaultTableModel tabelRow = (DefaultTableModel) view.getTblMakanan().getModel();
        int hitung = tabelRow.getRowCount();
        while (hitung > 0){
            tabelRow.removeRow(hitung-1);
            hitung--;
        }
        int jml = 0;
        if(hitung == 0){
            for(int i = 0;i< data.size();i++){
                int jumlahHarga = data.get(i).Harga*data.get(i).Qty;
                jml += jumlahHarga;
                tabelRow.addRow(new Object[]{data.get(i).Nama_Menu,String.valueOf(data.get(i).Qty) ,String.valueOf(data.get(i).Harga),String.valueOf(jumlahHarga)});
            }
        }
        view.getLblId().setText(String.valueOf(id));
        view.getLblTgl().setText(data.get(0).Tgl);
        view.getLblTotal().setText(String.valueOf(jml));
        
        PrinterJob job = PrinterJob.getPrinterJob();
        job.setJobName("Print Data");
        job.setPrintable(new Printable(){
            public int print(Graphics pg,PageFormat pf,int pageNum){
                if(pageNum > 0){
                    return Printable.NO_SUCH_PAGE;
                }
                Graphics2D g2 = (Graphics2D)pg;
                g2.translate(pf.getImageableX(), pf.getImageableY());
                g2.scale(0.24, 0.24);
                return Printable.PAGE_EXISTS;
            }
        });
        try{
            job.print();
        }catch(Exception ex){
            System.out.println(ex);
        }
        
    }

}
