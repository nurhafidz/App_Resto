/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Resto.team.pbo.connection;

import java.sql.DriverManager;
import java.sql.Connection;
/**
 *
 * @author nurha
 */

public class DataBaseConnection {
    private static String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static String DB_URL = "jdbc:mysql://localhost/db_resto";
    private static String USER  = "root";
    private static String PASS = "";
    
    private static Connection conn;
    
    public static Connection getConnection() {
        try {
            Class.forName(JDBC_DRIVER);
            try {
                conn = DriverManager.getConnection(DB_URL, USER, PASS);
            } catch (Exception ex) {
                // log an exception. fro example:
                System.out.println("Failed to create the database connection."); 
            }
        } catch (ClassNotFoundException ex) {
            // log an exception. for example:
            System.out.println("Driver not found."); 
        }
        return conn;
    }
    public void CloseConnection(){
        try{
           this.conn.close();
        }
        catch (Exception ex) {
                System.out.println(ex); 
            }
    }
        
    
    
}
