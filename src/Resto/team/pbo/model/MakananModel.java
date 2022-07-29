/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Resto.team.pbo.model;

import Resto.team.pbo.helper.MakananArray;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author nurha
 */
public class MakananModel {
    private Connection con;
    private ResultSet rs;
    private PreparedStatement ps;
    private MakananArray makanan = new MakananArray();

    public Connection getCon() {
        return con;
    }
    public void setCon(Connection con) {
        this.con = con;
    }

    public ResultSet getRs() {
        return rs;
    }
    public void setRs(ResultSet rs) {
        this.rs = rs;
    }

    public PreparedStatement getPs() {
        return ps;
    }
    public void setPs(PreparedStatement ps) {
        this.ps = ps;
    }

    public MakananArray getMakanan() {
        return makanan;
    }
    public void setMakanan(MakananArray makanan) {
        this.makanan = makanan;
    }
    public String[][] customQuery(String query){
        String [][]newArray = this.makanan.CustomQueryMakanan(query);
        return newArray;
    
    }
    
    
//    public void select(){
//        String [][]newArray = makanan.GetAllMakanan();
//        for(int i = 0; i < makanan.getRows(); i++){
//            for(int j = 0; j < makanan.getColumns(); j++){
//                System.out.println(newArray[i][j]);
//            }
//        }
//    }
}
