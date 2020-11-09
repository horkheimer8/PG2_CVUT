/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brickBraker;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SpringLayout;
import java.awt.event.*;
//import brickBraker.Game.java;
/**
 *
 * @author chaejiyeong
 */
public class Menu extends JFrame implements ActionListener {
    JFrame f;
    Level l;
    JLabel title, bSpeed, sLength;
    JSlider b, s;
    JButton okay; // closes current frame and create Level instance, passing values from Slider
    
    public static void main(String[] args){    
        
        Menu m = new Menu();
    }
    
    public Menu() {
        SpringLayout layout = new SpringLayout();
        Container cp = getContentPane();
        setLayout(layout);
        
        title = new JLabel("BrickBreaker");
        Font font = new Font("serif", Font.BOLD, 45);
        title.setFont(font);
        
        add(title);
        //layout.putConstraint(SpringLayout.WEST, title, 210, SpringLayout.WEST, cp);
        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, title, 0, SpringLayout.HORIZONTAL_CENTER, cp);
        layout.putConstraint(SpringLayout.NORTH, title, 20, SpringLayout.NORTH, cp);
        
        font = new Font("Arial", Font.PLAIN, 20);
        bSpeed = new JLabel("Ball Speed");
        bSpeed.setFont(font);
        sLength = new JLabel("Slider Length");
        sLength.setFont(font);
        
        add(bSpeed);
        add(sLength);
        layout.putConstraint(SpringLayout.WEST, bSpeed, 40, SpringLayout.WEST, cp);
        layout.putConstraint(SpringLayout.NORTH, bSpeed, -40, SpringLayout.VERTICAL_CENTER, cp);
        layout.putConstraint(SpringLayout.WEST, sLength, 40, SpringLayout.WEST, cp);
        layout.putConstraint(SpringLayout.NORTH, sLength, 20, SpringLayout.VERTICAL_CENTER, cp);
        
        b = new JSlider(1, 5);
        b.setPaintTicks(true);
        b.setPaintLabels(true);
        b.setMajorTickSpacing(1);
        s = new JSlider(50, 100, 100);
        s.setPaintTicks(true);
        s.setPaintLabels(true);
        s.setMajorTickSpacing(10);
       
        add(b);
        layout.putConstraint(SpringLayout.WEST, b, -20, SpringLayout.HORIZONTAL_CENTER, cp);
        layout.putConstraint(SpringLayout.NORTH, b, -45, SpringLayout.VERTICAL_CENTER, cp);
        add(s);
        layout.putConstraint(SpringLayout.WEST, s, -20, SpringLayout.HORIZONTAL_CENTER, cp);
        layout.putConstraint(SpringLayout.NORTH, s, 18, SpringLayout.VERTICAL_CENTER, cp);
        
        okay = new JButton("Save and Play");
        okay.addActionListener(this);
        
        add(okay);
        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, okay, 0, SpringLayout.HORIZONTAL_CENTER, cp);
        layout.putConstraint(SpringLayout.NORTH, okay, 80, SpringLayout.VERTICAL_CENTER, cp);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 400, 300);
        setVisible(true);

        //Box.createVerticalStrut(HEIGHT)
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        l = new Level();
        l.passParam(b.getValue(), s.getValue());
        
        
        dispose();
    }
    
}
