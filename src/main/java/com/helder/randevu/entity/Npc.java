package com.helder.randevu.entity;

import java.awt.Color;
import java.awt.Graphics2D;

public class Npc extends Entity {
    private final String name;
    private final String dialogue;
    private final Color color;

    public Npc(String name, String dialogue, int x, int y, Color color) {
        this.name = name;
        this.dialogue = dialogue;
        this.color = color;
        this.x = x;
        this.y = y;
        this.width = 48;
        this.height = 64;
        this.collisionOffsetX = 12;
        this.collisionOffsetY = 40;
        this.collisionWidth = 24;
        this.collisionHeight = 20;
    }

    public void draw(Graphics2D g2) {
        g2.setColor(color);
        g2.fillOval(x + 12, y, 24, 24);
        g2.fillRoundRect(x + 8, y + 22, 32, 34, 8, 8);
        g2.setColor(Color.WHITE);
        g2.drawString(name, x, y - 6);
    }

    public String getName() {
        return name;
    }

    public String getDialogue() {
        return dialogue;
    }
}
