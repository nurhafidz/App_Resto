/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Resto.team.pbo.model;

import Resto.team.pbo.connection.DataBaseConnection;
import Resto.team.pbo.helper.MejaArray;
import Resto.team.pbo.view.table.indexTable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nurha
 */
public class MejaModel {
    private indexTable tableMeja;
    private Connection con;
    private ResultSet rs;
    private PreparedStatement ps;
    private MejaArray mejaHelper = new MejaArray();
    public MejaModel(){
        DataBaseConnection connect = new DataBaseConnection();
        con = DataBaseConnection.getConnection();
    }

    public MejaArray getMejaHelper() {
        return mejaHelper;
    }

    public void setMejaHelper(MejaArray mejaHelper) {
        this.mejaHelper = mejaHelper;
    }
    

    public Connection getCon() {
        return con;
    }

    public void setCon(DataBaseConnection con) {
        this.con = (Connection) con;
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
    

    
    
    
    public List<ListMeja> tampilMeja(){
        
        try{
            DataBaseConnection connect = new DataBaseConnection();
            List<ListMeja> ListSemuaMeja = new ArrayList<ListMeja>();
        
        String query = "SELECT * FROM `table`";
        Connection consts = connect.getConnection();
       
        this.setPs(consts.prepareCall(query));
            this.ps.execute();
            this.setRs(ps.executeQuery());
            while (rs.next()){
                ListMeja hasil = new ListMeja();
                hasil.TableCode = rs.getString("table_code");
                hasil.Name = rs.getString("name");
                hasil.Status = rs.getString("status");
                ListSemuaMeja.add(hasil);
                
            }    
            return ListSemuaMeja;
        }catch(Exception e){
            System.out.println(e);
            return null;
        }
    }
    public void tambahMeja(ListMeja tambah){
        try{
        DataBaseConnection connect = new DataBaseConnection();
        String query = "INSERT INTO `table`(`table_code`, `name`, `status`) VALUES ('"+tambah.TableCode+"','"+tambah.Name+"','"+tambah.Status+"')";
        Connection consts = connect.getConnection();
       
        this.setPs(consts.prepareCall(query));
            this.ps.execute();
        }
        catch(Exception e){
            System.out.println(e);
        }

        
    }
    public ListMeja ambilDataEdit(String id){
        try{
            DataBaseConnection connect = new DataBaseConnection();
        
        String query = "SELECT * FROM `table` WHERE `table_code`='"+id+"'";
        Connection consts = connect.getConnection();
       
        this.setPs(consts.prepareCall(query));
            this.ps.execute();
            this.setRs(ps.executeQuery());
            ListMeja hasil = new ListMeja();
            while (rs.next()){
                
                hasil.TableCode = rs.getString("table_code");
                hasil.Name = rs.getString("name");
                hasil.Status = rs.getString("status");
                
            }    
            return  hasil;
        }catch(Exception e){
            System.out.println(e);
            return null;
        }
    }
    
    
    public void updateDataMeja(String table_code, ListMeja update){
        try{
            DataBaseConnection connect = new DataBaseConnection();
        
        String query = "UPDATE `table` SET `name`='"+update.Name+"',`status`='"+update.Status+"' WHERE `table_code`='"+table_code+"'";
        Connection consts = connect.getConnection();
       
        this.setPs(consts.prepareCall(query));
            this.ps.execute();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    }
