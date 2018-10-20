/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compa;

import java.sql.Statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;

/**
 *
 * @author muzu, just kidding.
 */
public class Conn {
    
      private Connection connect() {
        // SQLite connection string
        String url = "jdbc:sqlite:ASCII3.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
 
    
    /**
     * select all rows in the warehouses table
     */
    public void selectAll(){
        String sql = "SELECT Symbol FROM Letras";
        
        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            
            // loop through the result set
            while (rs.next()) {
                System.out.println(rs.getString("Symbol"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
