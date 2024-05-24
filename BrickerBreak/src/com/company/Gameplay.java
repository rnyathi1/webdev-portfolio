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
        g.fillRect(1,1,692,592);

        g.setColor(Color.yellow);
        g.fillRect(0,0,3,592);
        g.fillRect(0,0,692,3);
        g.fillRect(691,0,3,592);

        g.setColor(Color.green);
        g.fillRect(paddlePosX, 550, 100,3);

        g.setColor(Color.yellow);
        g.fillOval(ballPosX,ballPosY,20,20);

        g.dispose();


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        timer.start();
        if(new Rectangle(ballPosX,ballPosY,20,20).intersects(new Rectangle(paddlePosX,550,100,3))){
            ballYDir = -ballYDir;
        }

        if(play){
            ballPosX += ballXDir;
            ballPosY += ballYDir;
            if(ballPosX < 0){
                ballXDir = -ballXDir;
            }
            if(ballPosY < 0){
                ballYDir = -ballYDir;
            }
            if(ballPosX > 670){
                ballXDir = -ballXDir;
            }
        }

        repaint();

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            if(paddlePosX >= 580){
                paddlePosX = 580;
            } else {
                moveRight();
            }
        }
        if(e.getKeyCode() == KeyEvent.VK_LEFT){
            if(paddlePosX <= 10){
                paddlePosX = 10;
            } else {
                moveLeft();
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
    public void moveRight(){
        play = true;
        paddlePosX += 20;
    }
    public void moveLeft(){
        play = true;
        paddlePosX -= 20;
    }


}
