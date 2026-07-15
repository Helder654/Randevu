package com.helder.randevu.entity;

import java.awt.Color;
import java.awt.Graphics2D;

/**
 * Obstaculo solido temporario usado para testar colisao com o cenario.
 */
public class Wall extends Entity {

    public Wall(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.collisionWidth = width;
        this.collisionHeight = height;
    }

    public void draw(Graphics2D g2) {
        g2.setColor(Color.GRAY);
        g2.fillRect(x, y, width, height);
    }
}
