/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brickbreakgame;

import java.awt.Color;
import java.awt.Graphics;
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
    private int totalBrick = 21;

    private int ballposX = 233;
    private int ballposY = 350;
    private int playerX = 380;

    private int ballXdir = -1;
    private int ballYdir = -2;

    private int delay = 8;
    private Timer timer;

    public GamePlay() {

        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        timer = new Timer(delay, this);
        timer.start();

    }

    public void paint(Graphics g) {

        //background
        g.setColor(Color.DARK_GRAY);
        g.fillRect(1, 1, 799, 599);

        //borders
        g.setColor(Color.red);
        g.fillRect(0, 0, 3, 599);
        g.fillRect(792, 3, 3, 592);
        g.fillRect(0, 0, 792, 3);

        //padle
        g.setColor(Color.green);
        g.fillRect(playerX, 540, 100, 8);

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
            if (playerX >= 600) {
                playerX = 600;

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

    public void moveRight() {

        play = true;
        playerX += 20;
    }

    public void moveLeft() {

        play = true;
        playerX -= 20;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        timer.start();

        repaint();
    }

}
