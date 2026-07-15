package com.helder.randevu.entity;

import java.awt.image.BufferedImage;

public class Entity {
    protected int x;
    protected int y;
    protected int width;
    protected int height;
    protected int speed;

    protected int collisionOffsetX;
    protected int collisionOffsetY;
    protected int collisionWidth;
    protected int collisionHeight;

    protected String direction;

    protected BufferedImage downImage;
    protected BufferedImage upImage;
    protected BufferedImage leftImage;
    protected BufferedImage rightImage;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getCollisionOffsetX() {
        return collisionOffsetX;
    }

    public int getCollisionOffsetY() {
        return collisionOffsetY;
    }

    public int getCollisionWidth() {
        return collisionWidth;
    }

    public int getCollisionHeight() {
        return collisionHeight;
    }
}
