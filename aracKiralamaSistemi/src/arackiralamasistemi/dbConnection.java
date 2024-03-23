/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arackiralamasistemi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class dbConnection {
    
    private String dbUser = "root";
    private String dbPass = "";
    private String dbUrl = "jdbc:mysql://localhost:3306/arac";
    
    public Connection getConnection() throws SQLException{
        return DriverManager.getConnection(dbUrl, dbUser, dbPass);
    }
}
    
    
  
