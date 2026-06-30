package com.helder.randevu.core;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable{
    private Thread gameThread;
    private boolean running;

    public GamePanel() {
       gameThread = new Thread(this);
    }

    @Override
    public void run() {
        while (running) {
            System.out.println("Game is running...");
        }
    }
    public void startGameThread() {
        running = true;
        gameThread.start();
    }
    
}
