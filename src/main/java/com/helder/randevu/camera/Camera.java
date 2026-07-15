package com.helder.randevu.camera;

import com.helder.randevu.entity.Entity;

public class Camera {
    private final int worldWidth;
    private final int worldHeight;
    private int x;
    private int y;

    public Camera(int worldWidth, int worldHeight) {
        this.worldWidth = worldWidth;
        this.worldHeight = worldHeight;
    }

    public void follow(Entity target, int viewportWidth, int viewportHeight) {
        int targetCenterX = target.getX() + target.getWidth() / 2;
        int targetCenterY = target.getY() + target.getHeight() / 2;
        int desiredX = targetCenterX - viewportWidth / 2;
        int desiredY = targetCenterY - viewportHeight / 2;

        x = clamp(desiredX, 0, worldWidth - viewportWidth);
        y = clamp(desiredY, 0, worldHeight - viewportHeight);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    private int clamp(int value, int min, int max) {
        return Math.max(min, Math.min(value, max));
    }
}
