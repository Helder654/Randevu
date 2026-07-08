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

    private BufferedImage[] downImages = new BufferedImage[7];
    private BufferedImage[] upImages = new BufferedImage[7];
    private BufferedImage[] leftImages = new BufferedImage[7];
    private BufferedImage[] rightImages = new BufferedImage[7];

    private int spriteCounter = 0;
    private int spriteNum = 0;

    public Player(KeyHandler keyHandler) {
        this.keyHandler = keyHandler;

        this.x = 100;
        this.y = 100;
        this.width = 64;
        this.height = 64;
        this.speed = 2;
        this.direction = "down";

        loadImages();
    }

    private void loadImages() {
        for (int i = 0; i < 7; i++) {
            downImages[i] = loadImage("src/main/resources/sprites/player/South/south" + (i + 1) + ".png");
            upImages[i] = loadImage("src/main/resources/sprites/player/North/north" + (i + 1) + ".png");
            leftImages[i] = loadImage("src/main/resources/sprites/player/West/west" + (i + 1) + ".png");
            rightImages[i] = loadImage("src/main/resources/sprites/player/East/east" + (i + 1) + ".png");
        }
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
        boolean moving = false;

        if (keyHandler.upPressed) {
            direction = "up";
            y -= speed;
            moving = true;
        }

        if (keyHandler.downPressed) {
            direction = "down";
            y += speed;
            moving = true;
        }

        if (keyHandler.leftPressed) {
            direction = "left";
            x -= speed;
            moving = true;
        }

        if (keyHandler.rightPressed) {
            direction = "right";
            x += speed;
            moving = true;
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

        if (moving) {
            spriteCounter++;

            if (spriteCounter > 8) {
                spriteNum++;

                if (spriteNum > 6) {
                    spriteNum = 0;
                }

                spriteCounter = 0;
            }
        } else {
            spriteNum = 0;
            spriteCounter = 0;
        }
    }

    public void draw(Graphics2D g2) {
        BufferedImage imageToDraw = null;

        switch (direction) {
            case "up":
                imageToDraw = upImages[spriteNum];
                break;

            case "down":
                imageToDraw = downImages[spriteNum];
                break;

            case "left":
                imageToDraw = leftImages[spriteNum];
                break;

            case "right":
                imageToDraw = rightImages[spriteNum];
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