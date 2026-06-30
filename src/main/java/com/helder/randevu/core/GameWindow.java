package com.helder.randevu.core;

import javax.swing.JFrame;

public class GameWindow extends JFrame {
    public GameWindow() {
        GamePanel panel = new GamePanel();
        this.add(panel);
        this.setTitle("Randevu");
        this.setResizable(false);
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        panel.startGameThread();
    }
}