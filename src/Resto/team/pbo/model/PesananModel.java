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
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author nurha
 */
public class PesananModel {
    private DataBaseConnection connect = new DataBaseConnection();
    private ResultSet rs;
    private PreparedStatement ps;

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
            String query = "INSERT INTO `order`(`table_code`, `total`, `cash`, `status`) VALUES ('"+insert_Order[0]+"','"+Integer.valueOf(insert_Order[1])+"','"+Integer.valueOf(insert_Order[2])+"','"+insert_Order[3]+"')";
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

    
}
