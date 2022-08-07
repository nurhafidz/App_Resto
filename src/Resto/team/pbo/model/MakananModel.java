/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Resto.team.pbo.model;

import Resto.team.pbo.connection.DataBaseConnection;
import Resto.team.pbo.helper.MakananArray;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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
    public List<ListMakanan> ListSemuaMakanan(){
        
          try{
            DataBaseConnection connect = new DataBaseConnection();
            List<ListMakanan> food = new ArrayList<ListMakanan>();
        
        String query = "SELECT * FROM `food` ";
        Connection consts = connect.getConnection();
       
        this.setPs(consts.prepareCall(query));
            this.ps.execute();
            this.setRs(ps.executeQuery());
            while (rs.next()){
                ListMakanan hasil = new ListMakanan();
                hasil.Food_Code = rs.getString("food_code");
                hasil.Name = rs.getString("name");
                hasil.Description = rs.getString("description");
                hasil.Image = rs.getString("image");
                hasil.Price = rs.getInt("price");
                hasil.Category = rs.getString("category");
                hasil.Stock = rs.getInt("stock");
                food.add(hasil);
                
            }    
            return food;
        }catch(Exception e){
            System.out.println(e);
            return null;
        }
          
    }
    public void tambahMakanan(ListMakanan dataMakanan){
        try{
            DataBaseConnection connect = new DataBaseConnection();
            String valuequery="('"+dataMakanan.Food_Code+"','"+dataMakanan.Name+"','"+dataMakanan.Description+"','"+dataMakanan.Image+"','"+dataMakanan.Price+"','"+dataMakanan.Category+"','"+dataMakanan.Stock+"')";
        String query = "INSERT INTO `food`(`food_code`, `name`, `description`, `image`, `price`, `category`, `stock`) VALUES  "+valuequery;
        Connection consts = connect.getConnection();
       
        this.setPs(consts.prepareCall(query));
        this.ps.execute();
        }catch(Exception e){
            System.out.println(e);
    
        }
    }
    public List<ListMakanan>ListDetail(String kode){
          try{
            DataBaseConnection connect = new DataBaseConnection();
            List<ListMakanan> food = new ArrayList<ListMakanan>();
        
        String query = "SELECT * FROM `food` WHERE food_code ='"+kode+"'";
        Connection consts = connect.getConnection();
       
        this.setPs(consts.prepareCall(query));
            this.ps.execute();
            this.setRs(ps.executeQuery());
            while (rs.next()){
                ListMakanan hasil = new ListMakanan();
                hasil.Food_Code = rs.getString("food_code");
                hasil.Name = rs.getString("name");
                hasil.Description = rs.getString("description");
                hasil.Image = rs.getString("image");
                hasil.Price = rs.getInt("price");
                hasil.Category = rs.getString("category");
                hasil.Stock = rs.getInt("stock");
                food.add(hasil);
                
            }    
            return food;
        }catch(Exception e){
            System.out.println(e);
            return null;
        }
    }
        
    public void editMakanan(ListMakanan editbaru,String kode) {
      try{

          DataBaseConnection connect = new DataBaseConnection();
          String valuequery = "('"+editbaru.Food_Code+"','"+editbaru.Name+"','"+editbaru.Description+"',"+editbaru.Image+"',"+editbaru.Price+"','"+editbaru.Category+"','"+editbaru.Stock+"')";
        String query ="UPDATE `food`SET `food_code`='"+editbaru.Food_Code+"',`name`='"+editbaru.Name+"',`description`='"+editbaru.Description+"',`image`='"+editbaru.Image+"',`price`='"+editbaru.Price+"',`category`='"+editbaru.Category+"',`stock`='"+editbaru.Stock+"'WHERE `food_code`='" +kode+"';";
       Connection consts = connect.getConnection();
       
       this.setPs(consts.prepareCall(query));
       this.ps.execute();
      }  catch(Exception e){
          System.out.println(e);
      }
    }
}
