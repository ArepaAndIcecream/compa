/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.sql.Statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;

/**
 *
 * @author muzu
 */
public class Conn {
    String[] symbolsEspeciales = new String[142];
    String[] symbolsLetras = new String[52];
    String[] symbolsNumeros = new String[10];
    String[] symbolsOperadores = new String[7];
    String[] symbolsSeparadores = new String[8];
    
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
 
    
    // Save
    public void generateSymbols(){
        String sql = 
                "SELECT Symbol FROM Especiales UNION ALL "
                + "SELECT Symbol FROM Letras UNION ALL "
                + "SELECT Symbol FROM Numeros UNION ALL "
                + "SELECT Symbol FROM Operadores UNION ALL "
                + "SELECT Symbol FROM Separadores";
        
        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            
            
            short j = 0;
            for(int i=0; rs.next(); i++){
                if(i<142) {
                    symbolsEspeciales[i] = rs.getString("Symbol");
                } else if(i<194) {
                    symbolsLetras[j] = rs.getString("Symbol");
                    j++;
                } else if(i<204) {
                    if(i <= 194) j=0;
                    symbolsNumeros[j] = rs.getString("Symbol");
                    j++;
                } else if(i<211) {
                    if(i <= 204) j=0;
                    symbolsOperadores[j] = rs.getString("Symbol");
                    j++;
                } else if(i<219) {
                    if(i <= 211) j=0;
                    symbolsSeparadores[j] = rs.getString("Symbol");
                    j++;
                }
                
            }
            //System.out.println(symbolsLetras[0]);
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    
    }
}
