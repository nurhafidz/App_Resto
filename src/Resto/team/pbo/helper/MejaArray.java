/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Resto.team.pbo.helper;

import Resto.team.pbo.connection.DataBaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author nurha
 */
public class MejaArray {
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
    
    
    public String[][] GetAllMeja(){
        DataBaseConnection connect = new DataBaseConnection();
        try{
            Connection con = connect.getConnection();
            String query = "SELECT * FROM `table`";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            int size =0;
            if (rs != null) 
            {
              rs.last();    // moves cursor to the last row
              size = rs.getRow(); // get row id 
            }
            this.setRows(size);
            this.setColumns(4);
            String[][] newArray = new String[rows][columns];
            ResultSet xs = ps.executeQuery();
            int count = 0;
            while (xs.next()) {
                count = xs.getRow()-1;
                String id = xs.getString("table_code");
                String name = xs.getString("name");
                String status = xs.getString("status");
                
                
                
                newArray[count][0] = id;
                newArray[count][1] = name;
                newArray[count][2] = status;
                
            }
            
            connect.CloseConnection();
            return newArray;
            }catch (Exception ex) {
                String[][] newArray = new String[0][0];
                System.out.println(ex); 
                return newArray;
        }
    }
    public String[][] GetAllMejaTersedia(){
        DataBaseConnection connect = new DataBaseConnection();
        try{
            Connection con = connect.getConnection();
            String query = "SELECT * FROM `table` WHERE status = 'Tersedia'";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            int size =0;
            if (rs != null) 
            {
              rs.last();    // moves cursor to the last row
              size = rs.getRow(); // get row id 
            }
            this.setRows(size);
            this.setColumns(4);
            String[][] newArray = new String[rows][columns];
            ResultSet xs = ps.executeQuery();
            int count = 0;
            while (xs.next()) {
                count = xs.getRow()-1;
                String id = xs.getString("table_code");
                String name = xs.getString("name");
                String status = xs.getString("status");
                
                
                
                newArray[count][0] = id;
                newArray[count][1] = name;
                newArray[count][2] = status;
                
            }
            
            connect.CloseConnection();
            return newArray;
            }catch (Exception ex) {
                String[][] newArray = new String[0][0];
                System.out.println(ex); 
                return newArray;
        }
    }
    public String[][] GetSelectedMejaByName(String namaMeja){
        DataBaseConnection connect = new DataBaseConnection();
        try{
            Connection con = connect.getConnection();
            String query = "SELECT * FROM `table` WHERE name = '"+namaMeja+"'";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            int size =0;
            if (rs != null) 
            {
              rs.last();    // moves cursor to the last row
              size = rs.getRow(); // get row id 
            }
            this.setRows(size);
            this.setColumns(4);
            String[][] newArray = new String[rows][columns];
            ResultSet xs = ps.executeQuery();
            int count = 0;
            while (xs.next()) {
                count = xs.getRow()-1;
                String id = xs.getString("table_code");
                String name = xs.getString("name");
                String status = xs.getString("status");
                newArray[count][0] = id;
                newArray[count][1] = name;
                newArray[count][2] = status;
                
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
