/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;

import javax.swing.JFrame;

/**
 *
 * @author vitoria
 */
public class Client {
    
    public static void main(String[] args) {
        TelaLogin tl = new TelaLogin();
        tl.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tl.setVisible(true);
    }
    
}
