/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brickbreakgame;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

/**
 *
 * @author Hori
 */
public class BrickGenerator {
    
    public int map[][];
    public int brickWidth;
    public int brickHeight;
    
    
    public BrickGenerator(int row, int col){
        
        map = new int[row][col];
        
        //System.out.println(map.length);
        //System.out.println(map[0].length);
        for(int i = 0; i< map.length; i++)
        {
        
            for(int j = 0; j < map[0].length; j++)
            {
            
                map[i][j] = 1;
            }
        }
        
        brickWidth = 710 /col;
        brickHeight = 180/row;
        
        
    
    }
    
    public void draw(Graphics2D g){
    
        for(int i = 0; i< map.length; i++)
        {
        
            for(int j = 0; j < map[0].length; j++)
            {
                if(map[i][j] > 0){
                
                    g.setColor(Color.white);
                    g.fillRect(j * brickWidth + 40, i * brickHeight + 50, brickWidth, brickHeight);
                    
                    g.setStroke(new BasicStroke(4));
                    g.setColor(Color.black);
                    
                    g.drawRect(j * brickWidth + 40, i * brickHeight + 50, brickWidth, brickHeight);
                
                }
            
            }
        
        }
    
    }
    
    public void setBrickValue(int value, int row , int col){
   
        map[row][col] = value; 
    }
    
}


