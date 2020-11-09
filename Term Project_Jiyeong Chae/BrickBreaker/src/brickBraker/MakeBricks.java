/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brickBraker;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

/**
 *
 * @author chaejiyeong
 */
public class MakeBricks {
    public int map[][];
    public int brickWidth;
    public int brickHeight;
    public MakeBricks(int row, int col, int level) {
        map = new int[row][col];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                map[i][j] = 0;
            }
        }
        
        System.out.println(level);
        
        switch(level) {
            case(1):
               for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < map[0].length; j++) {
                        map[i][j] = 1;
                    }
                }
                break;
                
            case(2):
                for (int i = 0; i < col+1; i++) {
                    for (int j = 0; j < i; j++) {
                        map[i][j] = 1;
                    }
                }
                break;
                
            case(3):   
                for (int i = 0; i < map.length; i++) {
                    for (int j = 0; j < map[0].length; j++) {
                        if(i%2 == 0) {
                            map[i][j] = 1;
                        }
                    }
                }
                break;
                
            case(4):
                for (int i = 0; i < map.length; i++) {
                    for (int j = 0; j < map[0].length; j++) {
                        if(j != 3 && j != 4) {
                            map[i][j] = 1;
                        }
                    }
                }
                break;
            case(5):
                for (int i = 0; i < map.length-1; i++) {
                    for (int j = 1; j < map[0].length-1; j++) {
                        map[i][j] = 1;
                    }
                }
                for (int i = 7; i < 9; i++) {
                    for (int j = 3; j < 5; j++) {
                        map[i][j] = 0;
                    }
                }
                for (int i = 0; i < 3; i++) {
                    map[i][1] = 0;
                    map[i][6] = 0;
                }
                for (int i = 5; i < 7; i++) {
                    map[i][2] = 0;
                    map[i][5] = 0;
                }
                map[1][2] = 0;
                map[1][5] = 0;
                map[3][2] = 0;
                map[3][5] = 0;
                map[8][1] = 0;
                map[8][6] = 0;
                break;
            case(6): 
                for (int i = 0; i < map.length; i++) {
                    if (i % 2 == 0) {
                        for (int j = 0; j < map[0].length; j++) {
                            if (j % 2 != 0) {
                                map[i][j] = 1;
                            }
                        }
                    } else {
                        for (int j = 0; j < map[0].length; j++) {
                            if (j % 2 == 0) {
                                map[i][j] = 1;
                            }
                        }
                    }
                }
                break;
            case(7): 
                for (int i = 0; i < map.length - 1; i++) {
                    if (i <= map.length - 3) {
                        for (int j = 0; j < map[0].length; j++) {
                            map[i][j] = 1;
                            if (j == 1 || j == 6) {
                                map[i][j] = 0;
                            }
                        }
                    } else if (i == map.length - 2) {
                        for (int j = 1; j < map[0].length - 1; j++) {
                            map[i][j] = 0;
                        }
                    }
                }
                for (int j = 0; j < map[0].length; j++) {
                    map[map.length-1][j] = 1;
                }
                
                break;
            case(8): 
                for (int i = 0; i < map.length; i++) {
                    for (int j = 0; j < map[0].length; j++) {
                        if (j == 0 || j == 2 || j == 5 || j == 7) {
                            map[i][j] = 1;
                        }
                        if (j == 3 || j == 4) {
                            map[3][j] = 1;
                            map[4][j] = 1;
                            map[5][j] = 1;
                            map[6][j] = 1;

                        }
                    }
                }
                
            
                break;
            case(9): 
                for (int i = 0; i < map.length; i++) {
                    for (int j = 0; j < map[0].length; j++) {
                        if(j == 0 || j == map[0].length-1) {
                            map[i][j] = 1;
                        }
                        if (i == 0 || i == map.length - 1) {
                            map[i][j] = 1;
                        }
                        if (j == 2 || j == 5) {
                            map[2][j] = 1;
                            map[3][j] = 1;
                            map[4][j] = 1;
                            map[5][j] = 1;
                            map[6][j] = 1;
                            map[7][j] = 1;
                        }
                    }
                }
                break;
            
        }
                
                
        brickWidth = 540/col;
        brickHeight = 280/row;
    }
    public void draw(Graphics2D gr) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] > 0) {
                    gr.setColor(Color.white);
                    gr.fillRect(j * brickWidth + 80, i * brickHeight + 50, brickWidth, brickHeight);
                    // make line to distinguish each bricks
                    gr.setStroke(new BasicStroke(3));
                    gr.setColor(Color.black);
                    gr.drawRect(j * brickWidth + 80, i * brickHeight + 50, brickWidth, brickHeight);
                   
                }
            }
        }
    }
    
    public void setBrickValue(int value, int row, int col) {
        map[row][col] = value;
    }
    
}
