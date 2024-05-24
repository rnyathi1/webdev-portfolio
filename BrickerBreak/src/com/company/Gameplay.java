package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Gameplay extends JPanel implements KeyListener, ActionListener {
    private boolean play = false;
    private int score = 0;

    private int totalBricks = 21;
    private Timer timer;
    private int delay = 8;

    private int ballPosX = 120;
    private int ballPosY = 350;
    private int ballXDir = -1;
    private int ballYDir = -2;

    private int paddlePosX = 320;

    public Gameplay(){
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        timer = new Timer(delay,this);
        timer.start();

    }

    public void paint(Graphics g){
        //background
        g.setColor(Color.black);
        g.fillRect(1,1,692,392);

        g.setColor(Color.yellow);
        g.fillRect(0,0,3,592);
        g.fillRect(0,0,692,3);
        g.fillRect(691,0,3,592);

        g.setColor(Color.green);
        g.fillRect(paddlePosX, 550, 100,3);

        g.setColor(Color.yellow);
        g.fillOval(ballPosX,ballPosY,20,20);



    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            if(paddlePosX >= 600){
                paddlePosX = 600;
            } else {
                moveLeft();
            }
        }
        if(e.getKeyCode() == KeyEvent.VK_LEFT){
            if(paddlePosX >= 600){
                paddlePosX = 600;
            } else {
                moveRight();
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
