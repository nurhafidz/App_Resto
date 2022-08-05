/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Resto.team.pbo.controller;

import Resto.team.pbo.model.LoginModel;
import Resto.team.pbo.view.login.Dashboard;
import Resto.team.pbo.view.login.Login;
import java.awt.Component;
import java.security.MessageDigest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.xml.bind.DatatypeConverter;



/**
 *
 * @author User
 */
public class LoginController {
    
    Connection conn =null;
    Statement st = null;
    
    private LoginModel model;
    private Component rootPane;

    public LoginModel getModel() {
        return model;
    }

    public void setModel(LoginModel model) {
        this.model = model;
    }
    
    public void tampilForm(Login view){
       try {
            Class.forName("com.mysql.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql://localhost/db_resto","root","");
            st=conn.createStatement();
            }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null,"Gagal terkoneksi Karena " + ex);
            }
    
    
      String user = view.getTxtusername().getText();
      String password = view.getTxtpassword().getText();
      String value = null;
        try{
            if(user.trim ().equals("") ||password.trim ().equals("")){
            JOptionPane.showMessageDialog(rootPane, "Data Tidak Boleh Kosong", "Pesan", JOptionPane.ERROR_MESSAGE);
             //user.trim().requestFocus();
            //HapusLayar();
        }else{
            st = conn.createStatement();
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(password.trim().getBytes());
            byte[] digest = md.digest();
            String myHash = DatatypeConverter.printHexBinary(digest).toUpperCase();
            String sql = ("SELECT * FROM user WHERE username ='"+user.trim()+"' AND password ='"+String.valueOf(myHash)+"'");
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
            Dashboard dashboard = new Dashboard();
            dashboard.setVisible(true);
            view.setVisible(false);
        }else{
            JOptionPane.showMessageDialog(rootPane, "UserName dan Password Salah\nAtau Akun Belum Terdaftar", "Pesan",
            JOptionPane.ERROR_MESSAGE);
     
            }
            }
        }catch(Exception e){
            e.printStackTrace();
                }
       }
}



