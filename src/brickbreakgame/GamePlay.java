/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brickbreakgame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Hori
 */
public class GamePlay extends JPanel implements KeyListener, ActionListener {

    private boolean play = false;
    private int score = 0;
    
    private int totalBricks = 21;
    
    
    
    private Timer timer;
    private int delay = 8;

    private int playerX = 310;

    private int ballposX = 120;
    private int ballposY = 350;

    private int ballXdir = -1;
    private int ballYdir = -2;
    
    private BrickGenerator map;

    

    public GamePlay() {
        
        map = new  BrickGenerator(3, 7);

        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        timer = new Timer(delay, this);
        timer.start();
    }

    public void paint(Graphics g) {

        //background
        g.setColor(Color.black);
        g.fillRect(1, 1, 792, 592);
        
        
        // drawing ball
        map.draw((Graphics2D)g);

        //boders
        g.setColor(Color.red);
        g.fillRect(0, 0, 3, 592);
        g.fillRect(0, 0, 792, 3);
        g.fillRect(791, 0, 3, 592);

        //padle
        g.setColor(Color.green);
        g.fillRect(playerX, 550, 100, 8);

        //ball
        g.setColor(Color.red);
        g.fillOval(ballposX, ballposY, 20, 20);
        
        g.dispose();

    }

    @Override
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {

        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {

            if (playerX >= 700) {

                playerX = 700;
            } else {

                moveRight();
            }
        }

        if (e.getKeyCode() == KeyEvent.VK_LEFT) {

            if (playerX <= 10) {
                playerX = 10;
            } else {

                moveLeft();
            }
        }

    }
    
    public void moveRight(){
        
        play = true;
        playerX += 20;
    
    }
    
    public void moveLeft(){
    
        play = true;
        playerX -=20;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        timer.start();
        
        if(play)
        {
            
            
            
            if(new Rectangle(ballposX, ballposY, 20, 20).intersects(playerX,550,100,8)){
            
                ballYdir = - ballYdir;
            }
        
            ballposX += ballXdir;
            ballposY += ballYdir;
            
            if(ballposX < 0)
            {
                ballXdir = - ballXdir;
            }
            if(ballposY < 0)
            {
            
                ballYdir = - ballYdir;
            }
            
            if(ballposX > 770)
            {
                ballXdir = - ballXdir;
            }
        }
        
        repaint();
    }

}
