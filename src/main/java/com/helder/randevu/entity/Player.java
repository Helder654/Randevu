package com.helder.randevu.entity;

import com.helder.randevu.input.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Player extends Entity {

    private KeyHandler keyHandler;

    public Player(KeyHandler keyHandler) {
        this.keyHandler = keyHandler;
        this.x = 100;
        this.y = 100;
        this.width = 64;
        this.height = 64;
        this.speed = 4;
        this.direction = "down";

        loadImages();
    }

    private void loadImages() {
        downImage = loadImage("src/main/resources/sprites/player/player_down.png");
        upImage = loadImage("src/main/resources/sprites/player/player_up.png");
        leftImage = loadImage("src/main/resources/sprites/player/player_left.png");
        rightImage = loadImage("src/main/resources/sprites/player/player_right.png");
    }

    private BufferedImage loadImage(String path) {
        try {
            return ImageIO.read(new File(path));
        } catch (IOException e) {
            System.out.println("Erro ao carregar imagem: " + path);
            e.printStackTrace();
            return null;
        }
    }

    public void update(int screenWidth, int screenHeight) {
        if (keyHandler.upPressed) {
            direction = "up";
            y -= speed;
        }
        if (keyHandler.downPressed) {
            direction = "down";
            y += speed;
        }
        if (keyHandler.leftPressed) {
            direction = "left";
            x -= speed;
        }
        if (keyHandler.rightPressed) {
            direction = "right";
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
        BufferedImage imageToDraw = null;

        switch (direction) {
            case "up":
                imageToDraw = upImage;
                break;
            case "down":
                imageToDraw = downImage;
                break;
            case "left":
                imageToDraw = leftImage;
                break;
            case "right":
                imageToDraw = rightImage;
                break;
        }

        if (imageToDraw != null) {
            g2.drawImage(imageToDraw, x, y, width, height, null);
        } else {
            g2.setColor(Color.WHITE);
            g2.fillRect(x, y, width, height);
            g2.drawString(direction, x, y - 5);
        }
    }
}