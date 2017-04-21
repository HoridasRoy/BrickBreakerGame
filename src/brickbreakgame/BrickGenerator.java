/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brickbreakgame;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Hori
 */
public class BrickGenerator {
    
    public int map[][];
    public int ballWidth;
    public int ballHeight;
    
    
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
        
        ballWidth = 710 /col;
        ballHeight = 220/row;
        
        
    
    }
    
    public void draw(Graphics g){
    
        for(int i = 0; i< map.length; i++)
        {
        
            for(int j = 0; j < map[0].length; j++)
            {
                if(map[i][j] > 0){
                
                    g.setColor(Color.white);
                    g.fillRect(j * ballWidth + 40, i * ballHeight + 50, ballWidth, ballHeight);
                
                }
            
            }
        
        }
    
    }
    
}


