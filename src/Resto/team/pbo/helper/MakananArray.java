/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Resto.team.pbo.helper;

import Resto.team.pbo.connection.DataBaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MakananArray {
    private DataBaseConnection connect = new DataBaseConnection();
    private int columns,rows;

    public int getColumns() {
        return columns;
    }
    public void setColumns(int columns) {
        this.columns = columns;
    }

    public int getRows() {
        return rows;
    }
    public void setRows(int rows) {
        this.rows = rows;
    }
    
    
    public String[][] GetAllMakanan(){
        DataBaseConnection connect = new DataBaseConnection();
        try{
            Connection con = connect.getConnection();
            String query = "SELECT * FROM `food`";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            int size =0;
            if (rs != null) 
            {
              rs.last();    // moves cursor to the last row
              size = rs.getRow(); // get row id 
            }
            this.setRows(size);
            this.setColumns(7);
            String[][] newArray = new String[rows][columns];
            ResultSet xs = ps.executeQuery();
            int count = 0;
            while (xs.next()) {
                count = xs.getRow()-1;
                String id = xs.getString("food_code");
                String name = xs.getString("name");
                String description = xs.getString("description");
                String image = xs.getString("image");
                String price = xs.getString("price");
                String category = xs.getString("category");
                String stock = xs.getString("stock");
                
                
                newArray[count][0] = id;
                newArray[count][1] = name;
                newArray[count][2] = description;
                newArray[count][3] = image;
                newArray[count][4] = price;
                newArray[count][5] = category;
                newArray[count][6] = stock;
            }
            
            connect.CloseConnection();
            return newArray;
            }catch (Exception ex) {
                String[][] newArray = new String[0][0];
                System.out.println(ex); 
                return newArray;
        }
    }
    
    public String[][] GetSelectedMakanan(String Code_food){
        DataBaseConnection connect = new DataBaseConnection();
        try{
            Connection con = connect.getConnection();
            String query = "SELECT * FROM `food` WHERE food_code = '"+Code_food+"'";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            int size =0;
            if (rs != null) 
            {
              rs.last();    // moves cursor to the last row
              size = rs.getRow(); // get row id 
            }
            this.setRows(size);
            this.setColumns(7);
            String[][] newArray = new String[rows][columns];
            ResultSet xs = ps.executeQuery();
            int count = 0;
            while (xs.next()) {
                count = xs.getRow()-1;
                String id = xs.getString("food_code");
                String name = xs.getString("name");
                String description = xs.getString("description");
                String image = xs.getString("image");
                String price = xs.getString("price");
                String category = xs.getString("category");
                String stock = xs.getString("stock");
                
                
                newArray[count][0] = id;
                newArray[count][1] = name;
                newArray[count][2] = description;
                newArray[count][3] = image;
                newArray[count][4] = price;
                newArray[count][5] = category;
                newArray[count][6] = stock;
            }
            
            connect.CloseConnection();
            return newArray;
            }catch (Exception ex) {
                String[][] newArray = new String[0][0];
                System.out.println(ex); 
                return newArray;
        }
    }
    public String[][] CustomQueryMakanan(String sql){
        DataBaseConnection connect = new DataBaseConnection();
        try{
            Connection con = connect.getConnection();
            String query = sql;
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            int size =0;
            if (rs != null) 
            {
              rs.last();    // moves cursor to the last row
              size = rs.getRow(); // get row id 
            }
            this.setRows(size);
            this.setColumns(7);
            String[][] newArray = new String[rows][columns];
            ResultSet xs = ps.executeQuery();
            int count = 0;
            while (xs.next()) {
                count = xs.getRow()-1;
                String id = xs.getString("food_code");
                String name = xs.getString("name");
                String description = xs.getString("description");
                String image = xs.getString("image");
                String price = xs.getString("price");
                String category = xs.getString("category");
                String stock = xs.getString("stock");
                
                
                newArray[count][0] = id;
                newArray[count][1] = name;
                newArray[count][2] = description;
                newArray[count][3] = image;
                newArray[count][4] = price;
                newArray[count][5] = category;
                newArray[count][6] = stock;
            }
            
            connect.CloseConnection();
            return newArray;
            }catch (Exception ex) {
                String[][] newArray = new String[0][0];
                System.out.println(ex); 
                return newArray;
        }
    }

    
}
