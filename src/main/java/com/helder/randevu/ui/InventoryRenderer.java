package com.helder.randevu.ui;

import com.helder.randevu.inventory.Inventory;
import com.helder.randevu.inventory.Item;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.util.List;

public class InventoryRenderer {
    private static final int COLUMNS = 4;
    private static final int SLOT_SIZE = 72;
    private static final int PADDING = 16;

    public void draw(Graphics2D g2, Inventory inventory, int screenWidth, int screenHeight) {
        int panelWidth = COLUMNS * SLOT_SIZE + PADDING * 2;
        int panelHeight = SLOT_SIZE * 2 + 70;
        int panelX = (screenWidth - panelWidth) / 2;
        int panelY = (screenHeight - panelHeight) / 2;

        g2.setColor(new Color(20, 28, 42, 235));
        g2.fillRoundRect(panelX, panelY, panelWidth, panelHeight, 16, 16);
        g2.setColor(Color.WHITE);
        g2.drawRoundRect(panelX, panelY, panelWidth, panelHeight, 16, 16);
        g2.setFont(g2.getFont().deriveFont(Font.BOLD, 18f));
        g2.drawString("Inventario", panelX + PADDING, panelY + 28);

        List<Item> items = inventory.getItems();
        for (int index = 0; index < COLUMNS * 2; index++) {
            int column = index % COLUMNS;
            int row = index / COLUMNS;
            int slotX = panelX + PADDING + column * SLOT_SIZE;
            int slotY = panelY + 42 + row * SLOT_SIZE;

            g2.setColor(new Color(76, 92, 112));
            g2.fillRect(slotX, slotY, SLOT_SIZE - 8, SLOT_SIZE - 8);
            g2.setColor(Color.WHITE);
            g2.drawRect(slotX, slotY, SLOT_SIZE - 8, SLOT_SIZE - 8);

            if (index < items.size()) {
                g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 11f));
                g2.drawString(items.get(index).getName(), slotX + 5, slotY + 32);
            }
        }
    }
}
