/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compa;

/**
 *
 * @author snoopi
 */
public class Compa {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Conn app = new Conn();
        app.selectAll();
        CompoJFrame frame = new CompoJFrame();
        frame.setDefaultCloseOperation(CompoJFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    
    
    
}
