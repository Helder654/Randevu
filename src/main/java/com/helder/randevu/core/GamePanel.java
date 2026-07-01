package com.helder.randevu.core;

import javax.swing.JPanel;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable{
    private Thread gameThread;
    private boolean running;

    public GamePanel() {
       gameThread = new Thread(this);
    }

    @Override
    public void run() {
        double drawInterval = 1_000_000_000 / 60.0;
        long lastTime = System.nanoTime();
        double delta = 0.0;

        while (running) {

            long currentTime = System.nanoTime();
            long elapsedTime = currentTime - lastTime;
            delta += elapsedTime / drawInterval;
            if(delta >= 1) {
                update();
                repaint();
                delta--;
            }
            lastTime = currentTime;

        }
    }
    public void startGameThread() {
        running = true;
        gameThread.start();
    }
    private void update() {

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLUE);
        g.fillRect(100, 50, 200, 80);

    }
}
