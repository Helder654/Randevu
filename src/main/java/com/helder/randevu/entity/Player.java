package com.helder.randevu.entity;

import java.awt.Color;

import java.awt.Graphics2D;

import com.helder.randevu.input.KeyHandler;

public class Player {

    private int x;
    private int y;
    private int width;
    private int height;
    private int speed;
    private KeyHandler keyHandler;
    
    public Player(KeyHandler keyHandler) {
        this.keyHandler = keyHandler;
        this.x = 100;
        this.y = 100;
        this.width = 32;
        this.height = 32;
        this.speed = 4;
    }

    public void update(int screenWidth, int screenHeight) {
        if (keyHandler.upPressed) {
            y -= speed;
        }
        if (keyHandler.downPressed) {
            y += speed;
        }
        if (keyHandler.leftPressed) {
            x -= speed;
        }
        if (keyHandler.rightPressed) {
            x += speed;
        }
        if (x < 0) {
            x = 0;
        }
        if (y < 0) {
            y = 0;
        }
        if (x > screenWidth - width) {
            x = screenWidth - width;
        }
        if (y > screenHeight - height) {
            y = screenHeight - height;
        }
    }

    public void draw(Graphics2D g2) {
    g2.setColor(Color.WHITE);
    g2.fillRect(x, y, width, height);
}
}
