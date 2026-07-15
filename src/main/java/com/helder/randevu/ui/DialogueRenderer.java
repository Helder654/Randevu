package com.helder.randevu.ui;

import com.helder.randevu.entity.Npc;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

public class DialogueRenderer {
    public void draw(Graphics2D g2, Npc npc, int screenWidth, int screenHeight) {
        int panelX = 24;
        int panelY = screenHeight - 132;
        int panelWidth = screenWidth - 48;
        int panelHeight = 108;

        g2.setColor(new Color(20, 28, 42, 235));
        g2.fillRoundRect(panelX, panelY, panelWidth, panelHeight, 16, 16);
        g2.setColor(Color.WHITE);
        g2.drawRoundRect(panelX, panelY, panelWidth, panelHeight, 16, 16);
        g2.setFont(g2.getFont().deriveFont(Font.BOLD, 18f));
        g2.drawString(npc.getName(), panelX + 18, panelY + 30);
        g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 16f));
        g2.drawString(npc.getDialogue(), panelX + 18, panelY + 62);
        g2.drawString("E - Fechar", panelX + 18, panelY + 88);
    }
}
