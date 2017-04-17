/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brickbreakgame;

import javax.swing.JFrame;

/**
 *
 * @author Hori
 */
public class BrickBreakGame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        JFrame ob = new JFrame();
        GamePlay ob1 = new GamePlay();
        ob.setBounds(10, 20, 800, 600);
        ob.setVisible(true);
        ob.setResizable(false);
        ob.setTitle("BrickBreakGame");
        
        ob.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ob.add(ob1);
    }
    
}
