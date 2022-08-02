/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Resto.team.pbo.model;

import Resto.team.pbo.connection.DataBaseConnection;
import Resto.team.pbo.helper.MakananArray;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author nurha
 */
public class PesananModel {
    private DataBaseConnection connect = new DataBaseConnection();
    private ResultSet rs;
    private PreparedStatement ps;
    private int manyData;
    
    private Connection conn = null;
	
    public PesananModel()  {
        try{
	conn = connect.getConnection();
        }
        catch(Exception ex){
            System.out.println(ex);
        }
    }

    public DataBaseConnection getConnect() {
        return connect;
    }

    public void setConnect(DataBaseConnection connect) {
        this.connect = connect;
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

    public int getManyData() {
        return manyData;
    }

    public void setManyData(int manyData) {
        this.manyData = manyData;
    }
    
    
    
    public void insertOrderFoodAndOrder(String[] insert_Order, String[][] inserOrder_Food){
        int getIdOrder = this.insertOrder(insert_Order);
        
        this.insertOrderFood(getIdOrder,inserOrder_Food);
    }
    public void insertOrderFood(int orderId,String[][] inserOrder_Food){
        try{
            Connection con = connect.getConnection();
            String valueQuery = "";
            for(int i = 0; i < inserOrder_Food.length; i++){
                String ChildValueQuery = "('"+orderId+"','"+inserOrder_Food[i][1]+"','"+inserOrder_Food[i][3]+"','"+inserOrder_Food[i][4]+"')";
                if(i < inserOrder_Food.length-1) valueQuery = valueQuery+ChildValueQuery+",";
                else valueQuery = valueQuery+ChildValueQuery;
                
            }
            String query = "INSERT INTO `order_food`( `order_code`, `food_code`, `qty`, `note`) VALUES "+valueQuery;
            this.setPs(con.prepareStatement(query));
            this.ps.execute();
            connect.CloseConnection();
        }catch(SQLException ex){
            System.out.println(ex);
        }
    }
    public int insertOrder(String[] insert_Order){
        try{
            Connection con = connect.getConnection();
            String query = "INSERT INTO `order`(`table_code`, `total`, `status`) VALUES ('"+insert_Order[0]+"','"+Integer.valueOf(insert_Order[1])+"','"+insert_Order[2]+"')";
            this.updateStatusMeja(insert_Order[0]);
            this.setPs(con.prepareStatement(query,Statement.RETURN_GENERATED_KEYS));
            this.ps.execute();
            this.setRs(this.ps.getGeneratedKeys());
            int generatedKey = 0;
            if (this.rs.next()) {
                generatedKey = this.rs.getInt(1);
            }
            connect.CloseConnection();
            return generatedKey;
        }catch(SQLException ex){
            System.out.println(ex);
            return 0;
        }
    }
    public void updateStatusMeja(String idMeja){
        try{
            Connection con = connect.getConnection();
            String query = "UPDATE `table` SET `status`='Tidak Tersedia' WHERE `table_code` = '"+idMeja+"'";
            this.setPs(con.prepareStatement(query));
            this.ps.execute();
            connect.CloseConnection();
        }catch(SQLException ex){
            System.out.println(ex);
        }
    }
    
    
    public List<ListPesanan> orderSelected() {
        try{
            PreparedStatement stmt = conn.prepareStatement("SELECT o.order_code,o.status, (select count(*) from `order_food` f where f.`order_code` = o.`order_code`) jumlah,t.`name`,o.`total`,o.`timestamp` from `order` o,`table` t WHERE t.`table_code`=o.`table_code` ORDER BY o.`order_code` DESC;");
	    ResultSet rs = stmt.executeQuery();	   
	    List<ListPesanan> matches = new ArrayList<ListPesanan>(); 
            int count = 0;
	    while ( rs.next() ) {
	        ListPesanan listed = new ListPesanan();
	        listed.ID = rs.getInt("order_code");
	        listed.Status = rs.getString("status");
	        listed.Jumlah = rs.getInt("jumlah");
	        listed.Meja = rs.getString("name");
	        listed.Total = rs.getInt("total");
                listed.Tgl = rs.getString("timestamp");
                count ++;
	        matches.add(listed);
	    }
	    this.setManyData(count);
	    return matches;
        }
        
        catch(Exception ex){
            System.out.println(ex);
            return null;
        }
    }
    public List<ListPesanan> orderSelectedByID(int id) {
        try{
            PreparedStatement stmt = conn.prepareStatement("SELECT * ,(select name from `table` t where t.`table_code` = o.`table_code`) name FROM `order`o WHERE o.order_code = '"+id+"';");
	    ResultSet rs = stmt.executeQuery();	   
	    List<ListPesanan> matches = new ArrayList<ListPesanan>(); 
	    while ( rs.next() ) {
	        ListPesanan listed = new ListPesanan();
	        listed.ID = rs.getInt("order_code");
	        listed.Status = rs.getString("status");
	        listed.Jumlah = 0;
	        listed.Meja = rs.getString("name");
	        listed.Total = rs.getInt("total");
                listed.Tgl = rs.getString("timestamp");
	        matches.add(listed);
	    }
	    return matches;
        }
        catch(Exception ex){
            System.out.println(ex);
            return null;
        }
    }
    public List<ListPesananMakanan> getPesananMakananByIdOrder(int idOrder) {
        try{
            PreparedStatement stmt = conn.prepareStatement("SELECT *,(SELECT f.`name` FROM `food` f WHERE of.food_code = f.food_code)menuMakanan FROM `order_food`of WHERE order_code ='"+idOrder+"';");
	    ResultSet rs = stmt.executeQuery();	   
	    List<ListPesananMakanan> matches = new ArrayList<ListPesananMakanan>(); 
	    while ( rs.next() ) {
	        ListPesananMakanan listed = new ListPesananMakanan();
	        listed.ID = rs.getInt("order_food_code");
	        listed.Order_Code = rs.getInt("order_code");
	        listed.Food_Code = rs.getString("food_code");
	        listed.Nama_Menu = rs.getString("menuMakanan");
	        listed.Qty = rs.getInt("qty");
                listed.Note = rs.getString("note");
	        matches.add(listed);
	    }
	    return matches;
        }
        catch(Exception ex){
            System.out.println(ex);
            return null;
        }
    }
    
    public void updateStatusPesanan(int idOrder, String message) throws SQLException{
        PreparedStatement stmt = conn.prepareStatement("UPDATE `order` SET `status` = '"+message+"' WHERE `order_code`='"+idOrder+"'");
        stmt.execute();
    }
    public void deletePesanan(int idOrder) throws SQLException{
        PreparedStatement stmt = conn.prepareStatement("DELETE FROM `order` WHERE `order_code` = '"+idOrder+"'");
        stmt.execute();
    }
    public void deletePesananMakanan(int idOrder) throws SQLException{
        PreparedStatement stmt = conn.prepareStatement("DELETE FROM `order_food` WHERE `order_code` = '"+idOrder+"'");
        stmt.execute();
    }
	    
}
