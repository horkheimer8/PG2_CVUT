/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brickBraker;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 *
 * @author chaejiyeong
 */
public class Level extends JFrame implements ActionListener {
    
    private int ballSpeed;
    private int sLength;
    
    JButton l1 = new JButton("1");
    JButton l2 = new JButton("2");
    JButton l3 = new JButton("3");
    JButton l4 = new JButton("4");
    JButton l5 = new JButton("5");
    JButton l6 = new JButton("6");
    JButton l7 = new JButton("7");
    JButton l8 = new JButton("8");
    JButton l9 = new JButton("9");
    JButton back = new JButton("MENU");

    Font font = new Font("serif", Font.BOLD, 20);
    
    Menu mm;
    
    public Level() {
        
        l1.addActionListener(this);
        l2.addActionListener(this);
        l3.addActionListener(this);
        l4.addActionListener(this);
        l5.addActionListener(this);
        l6.addActionListener(this);
        l7.addActionListener(this);
        l8.addActionListener(this);
        l9.addActionListener(this);
        back.addActionListener(this);
        
        setLayout(new GridLayout(3, 3));
        add(l1); add(l2); add(l3); 
        add(l4); add(l5); add(l6);
        add(l7); add(l8); add(l9); 
        add(back);
        
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == l1) {
            JFrame f = new JFrame();
            f.setBounds(0, 0, 700, 600);
            f.setTitle("Break Bricks with ball");
      
            Game g = new Game(1, ballSpeed, sLength);
            f.add(g);
        
            f.setResizable(false);
            f.setVisible(true); //you nnow, the f
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        } else if (e.getSource() == l2) {
            JFrame f = new JFrame();
            f.setBounds(0, 0, 700, 600);
            f.setTitle("Break Bricks with ball");
        
            Game g = new Game(2, ballSpeed, sLength);
            f.add(g);
        
            f.setResizable(false);
            f.setVisible(true);
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        } else if (e.getSource() == l3) {
            JFrame f = new JFrame();
            f.setBounds(0, 0, 700, 600);
            f.setTitle("Break Bricks with ball");
        
            Game g = new Game(3, ballSpeed, sLength);
            f.add(g);
        
            f.setResizable(false);
            f.setVisible(true);
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        } else if (e.getSource() == l4) {
            JFrame f = new JFrame();
            f.setBounds(0, 0, 700, 600);
            f.setTitle("Break Bricks with ball");
        
            Game g = new Game(4, ballSpeed, sLength);
            f.add(g);
        
            f.setResizable(false);
            f.setVisible(true);
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        } else if (e.getSource() == l5) {
            JFrame f = new JFrame();
            f.setBounds(0, 0, 700, 600);
            f.setTitle("Break Bricks with ball");
        
            Game g = new Game(5, ballSpeed, sLength);
            f.add(g);
        
            f.setResizable(false);
            f.setVisible(true);
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        } else if (e.getSource() == l6) {
            JFrame f = new JFrame();
            f.setBounds(0, 0, 700, 600);
            f.setTitle("Break Bricks with ball");
        
            Game g = new Game(6, ballSpeed, sLength);
            f.add(g);
        
            f.setResizable(false);
            f.setVisible(true);
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        } else if (e.getSource() == l7) {
            JFrame f = new JFrame();
            f.setBounds(0, 0, 700, 600);
            f.setTitle("Break Bricks with ball");
        
            Game g = new Game(7, ballSpeed, sLength);
            f.add(g);
        
            f.setResizable(false);
            f.setVisible(true);
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        } else if (e.getSource() == l8) {
            JFrame f = new JFrame();
            f.setBounds(0, 0, 700, 600);
            f.setTitle("Break Bricks with ball");
        
            Game g = new Game(8, ballSpeed, sLength);
            f.add(g);
        
            f.setResizable(false);
            f.setVisible(true);
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        } else if (e.getSource() == l9) {
            JFrame f = new JFrame();
            f.setBounds(0, 0, 700, 600);
            f.setTitle("Break Bricks with ball");
        
            Game g = new Game(9, ballSpeed, sLength);
            f.add(g);
        
            f.setResizable(false);
            f.setVisible(true);
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        } else if (e.getSource() == back) {
            // open 'MENU'
            dispose();
            
            
            mm = new Menu();
            mm.setVisible(true);
            
        }
    }
    
    void passParam(int ballSpeed, int sLength) {
        this.ballSpeed = ballSpeed;
        this.sLength = sLength;
    }
    
}
