/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brickBraker;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import javax.swing.JPanel;
import javax.swing.Timer;
import brickBraker.Menu;
/**
 *
 * @author chaejiyeong
 */
public class Game extends JPanel implements KeyListener, ActionListener {
    
    // Random init
    Random rand = new Random();
    
    // Level number
    private int level;

    // properties for game play itself
    private boolean play = false;
    private int score = 0;
    private Timer timer;
    private int delay = 8;
  
    // properties of bricks
    private int totalBricks = 10*8;
    /* + size, state of bricks */
    
    // properties of slider
    private int sLength = 100;
    private int sliderX = 300; // starting point of slider
    /* + length of slider */
    
    // properties of ball(s)
    private int ballposX = 340;
    private int ballposY = 530;
    private double ballXdir = Math.pow(-1.0, (double) rand.nextInt(3));
    private int ballYdir; // + random
    private int ballSpeed;
    
    //Menu m = new Menu();
    /* + size, speed, number of balls */
    //System.out.println(""+ballSpeed);
    
    private MakeBricks gameset;
     
    public Game(int level, int ballSpeed, int sLength) {
        this.ballSpeed = ballSpeed;
        this.sLength = sLength;
        
        this.level = level;
        sliderX = (700-sLength)/2;
        
        ballYdir = ballSpeed;
        
        gameset = new MakeBricks(10, 8, level);
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false); // TAB, SHIFT+TAB, etc
        timer = new Timer(delay, this);
        timer.start();
    }
    
    public void paint(Graphics gr) {
        
        // background
        gr.setColor(Color.black);
        gr.fillRect(1, 1, 692, 592);
        
        // borders
        gr.setColor(Color.red);
        gr.fillRect(0, 0, 3, 592);
        gr.fillRect(0, 0, 692, 3);
        gr.fillRect(691, 0, 3, 592);
        
        // the ball(s)
        gr.setColor(Color.pink);
        gr.fillOval(ballposX, ballposY, 20, 20);
        
        // when you finish the  game
        if (totalBricks <= 0) {
            play = false;
            ballXdir = 0;
            ballYdir = 0;
            gr.setColor(Color.green);
            gr.setFont(new Font("serif", Font.BOLD, 30));
            gr.drawString("Congratulations, you won! Score: " + score, 90, 370);
            
            gr.setFont(new Font("serif", Font.BOLD, 20));
            gr.drawString("Press Enter to Restart", 260, 410);
        }
        
        // when you failed the game
        if (ballposY > 570 && totalBricks > 0) {
            play = false;
            ballXdir = 0;
            ballYdir = 0;
            gr.setColor(Color.red);
            gr.setFont(new Font("serif", Font.BOLD, 30));
            gr.drawString("Game Over, Score: " + score, 220, 370);
            
            gr.setFont(new Font("serif", Font.BOLD, 20));
            gr.drawString("Press Enter to Restart", 260, 410);
        }
        
        // bricks(map)
        gameset.draw((Graphics2D)gr); 
        
        // slider
        gr.setColor(Color.green);
        // System.out.println("***"+this.sLength);
        gr.fillRect(sliderX, 550, this.sLength/*length of slider*/, 8);
        
        // scores
        gr.setColor(Color.white);
        gr.setFont(new Font("serif", Font.BOLD, 25));
        gr.drawString("" + score, 590, 30);
        
        gr.dispose();
    }

    public void moveRight() {
        play = true;
        sliderX += 20; // later, vary the speed of slider
    }
    public void moveLeft() {
        play = true;
        sliderX -= 20;
    }
    
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            if (sliderX >= 600) { // adjusting slider into border range
                sliderX = 600;
            } else {
                moveRight();
                repaint();
            }
          
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            if (sliderX < 10) { // adjusting slider into border range
                sliderX = 10;
            } else {
                moveLeft(); 
                repaint();
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            if (!play) {
                play = true;
                // reset variables into default values.
                ballposX = 360;
                ballposY = 530;
                // (ballXdir)^2 + (ballYdir)^2 must be consistent so that direction value wouldn't affect speed
                ballXdir = Math.pow(-1.0, (double) rand.nextInt(3)); 
                ballYdir = ballSpeed;                
                sliderX = 310;
                score = 0;
                totalBricks = 10*8;
                gameset = new MakeBricks(10, 8, level);
                
                repaint();
                   
            }
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override // no need 
    public void keyTyped(KeyEvent e) {}
    
    @Override // no need
    public void keyReleased(KeyEvent e) {}

    @Override
    public void actionPerformed(ActionEvent e) {
        timer.start();
        if (play) { // during play
            if (new Rectangle(ballposX, ballposY, 20, 20).intersects(new Rectangle(sliderX, 550, 100, 8))) { // when the ball hits the slider
                ballYdir = -ballYdir;
            }
            
            // create variables to deal with ball(s) crashing bricks
            A: for (int i = 0; i < gameset.map.length; i++) {
                for (int j = 0; j < gameset.map[0].length; j++) {
                    if (gameset.map[i][j] > 0 /* default value = 1*/) {
                        int brickX = j * gameset.brickWidth + 80;
                        int brickY = i * gameset.brickHeight + 50;
                        int brickWidth = gameset.brickWidth;
                        int brickHeight = gameset.brickHeight;
                        
                        // rectangle around bricks - not graphically but area in coordinate space
                        Rectangle rect = new Rectangle(brickX, brickY, brickWidth, brickHeight);
                        // rectangle around ball(s) - to detect intersections
                        Rectangle ballRect = new Rectangle(ballposX, ballposY, 20, 20);
                        Rectangle brickRect = rect;
                        
                        if (ballRect.intersects(brickRect)) {
                            gameset.setBrickValue(0, i, j); // set value to 0
                            totalBricks--; // reduce the total number of bricks
                            score += 3; // 3 points per bricks
                            
                            if (ballposX + 19 <= brickRect.x || ballposX + 1 >= brickRect.x + brickRect.width) {
                                ballXdir = - ballXdir;
                            } else {
                                ballYdir = - ballYdir;
                            }
                            
                            break A;
                        }
                    }
                }
            }
            
            ballposX += (double) ballXdir; /* * ballSpeed;*/
            ballposY += (double) ballYdir; /*ballSpeed; */
            if (ballposX < 0) { // when the ball is crushed to left border
                ballXdir = -ballXdir; 
            }
            if (ballposX > 670) { // when crushed to the right border
                ballXdir = -ballXdir; 
            }
            if (ballposY < 0) { // when crushed to the upper border 
                ballYdir = -ballYdir; 
            } 
        }

        repaint();
    }
     
}
