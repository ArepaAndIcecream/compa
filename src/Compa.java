/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author snoopi
 */
public class Compa {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Conn BDD = new Conn();
        BDD.generateSymbols();
        //printDatabase(BDD);
        CompoJFrame frame = new CompoJFrame();
        frame.setDefaultCloseOperation(CompoJFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    
    public static void printSymbols(Conn Database) {
        
        for (String Simbolos: Database.symbolsEspeciales) {
            System.out.println(Simbolos);
        }
        for (String Simbolos: Database.symbolsLetras) {
            System.out.println(Simbolos);
        }
        for (String Simbolos: Database.symbolsNumeros) {
            System.out.println(Simbolos);
        }
        for (String Simbolos: Database.symbolsOperadores) {
            System.out.println(Simbolos);
        }
        for (String Simbolos: Database.symbolsSeparadores) {
            System.out.println(Simbolos);
        }
        
    }
    
}
