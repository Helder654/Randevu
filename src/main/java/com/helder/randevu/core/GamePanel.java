package com.helder.randevu.core;

import javax.swing.JPanel;
import java.awt.*;
import com.helder.randevu.entity.Player;
import com.helder.randevu.input.KeyHandler;

public class GamePanel extends JPanel implements Runnable {
    
    public static final int SCREEN_WIDTH = 800;
    public static final int SCREEN_HEIGHT = 600;
    
    private Thread gameThread;
    private boolean running;
    private Player player;
    private KeyHandler keyHandler;
   
    public GamePanel() {
        gameThread = new Thread(this);
        keyHandler = new KeyHandler();
        player = new Player(keyHandler);
       
        setFocusable(true);
        setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        setBackground(Color.BLACK);
        addKeyListener(keyHandler);
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
            if (delta >= 1) {
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
    player.update(getWidth(), getHeight());
}

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        player.draw(g2);
        g2.dispose();
    }
}
