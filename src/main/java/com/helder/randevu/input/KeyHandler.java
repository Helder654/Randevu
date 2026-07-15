package com.helder.randevu.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

    public boolean upPressed;
    public boolean downPressed;
    public boolean leftPressed;
    public boolean rightPressed;
    private boolean inventoryKeyPressed;
    private boolean inventoryToggleRequested;
    private boolean interactionKeyPressed;
    private boolean interactionRequested;

    public boolean consumeInventoryToggle() {
        boolean toggleRequested = inventoryToggleRequested;
        inventoryToggleRequested = false;
        return toggleRequested;
    }

    public boolean consumeInteractionRequest() {
        boolean requested = interactionRequested;
        interactionRequested = false;
        return requested;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();

        if (code == KeyEvent.VK_W) {
            upPressed = true;
        }
        if (code == KeyEvent.VK_S) {
            downPressed = true;
        }
        if (code == KeyEvent.VK_A) {
            leftPressed = true;
        }
        if (code == KeyEvent.VK_D) {
            rightPressed = true;
        }
        if (code == KeyEvent.VK_I && !inventoryKeyPressed) {
            inventoryKeyPressed = true;
            inventoryToggleRequested = true;
        }
        if (code == KeyEvent.VK_E && !interactionKeyPressed) {
            interactionKeyPressed = true;
            interactionRequested = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();

        if (code == KeyEvent.VK_W) {
            upPressed = false;
        }
        if (code == KeyEvent.VK_S) {
            downPressed = false;
        }
        if (code == KeyEvent.VK_A) {
            leftPressed = false;
        }
        if (code == KeyEvent.VK_D) {
            rightPressed = false;
        }
        if (code == KeyEvent.VK_I) {
            inventoryKeyPressed = false;
        }
        if (code == KeyEvent.VK_E) {
            interactionKeyPressed = false;
        }

    }
}
