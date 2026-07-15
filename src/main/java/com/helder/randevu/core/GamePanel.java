package com.helder.randevu.core;

import javax.swing.JPanel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import com.helder.randevu.camera.Camera;
import com.helder.randevu.collision.CollisionChecker;
import com.helder.randevu.entity.Player;
import com.helder.randevu.entity.Wall;
import com.helder.randevu.entity.Entity;
import com.helder.randevu.entity.Npc;
import com.helder.randevu.interaction.InteractionChecker;
import com.helder.randevu.inventory.Inventory;
import com.helder.randevu.inventory.Item;
import com.helder.randevu.input.KeyHandler;
import com.helder.randevu.ui.InventoryRenderer;
import com.helder.randevu.ui.DialogueRenderer;

public class GamePanel extends JPanel implements Runnable {
    
    public static final int SCREEN_WIDTH = 800;
    public static final int SCREEN_HEIGHT = 600;
    public static final int WORLD_WIDTH = 1600;
    public static final int WORLD_HEIGHT = 1200;
    
    private Thread gameThread;
    private boolean running;
    private Player player;
    private KeyHandler keyHandler;
    private CollisionChecker collisionChecker;
    private List<Wall> walls;
    private List<Npc> npcs;
    private List<Entity> solidEntities;
    private Camera camera;
    private Inventory inventory;
    private InventoryRenderer inventoryRenderer;
    private boolean inventoryOpen;
    private InteractionChecker interactionChecker;
    private DialogueRenderer dialogueRenderer;
    private Npc activeNpc;
   
    public GamePanel() {
        gameThread = new Thread(this);
        keyHandler = new KeyHandler();
        player = new Player(keyHandler);
        collisionChecker = new CollisionChecker();
        walls = new ArrayList<>();
        npcs = new ArrayList<>();
        solidEntities = new ArrayList<>();
        addWall(new Wall(350, 250, 160, 64));
        addWall(new Wall(120, 400, 240, 64));
        addWall(new Wall(560, 130, 64, 210));
        addWall(new Wall(780, 500, 300, 64));
        addWall(new Wall(1180, 250, 64, 280));
        addNpc(new Npc("Lia", "Ola! Este e um dialogo de teste.", 250, 150,
                new Color(206, 91, 125)));
        addNpc(new Npc("Theo", "As paredes tambem bloqueiam NPCs.", 700, 380,
                new Color(74, 156, 204)));
        addNpc(new Npc("Maya", "Pressione I para abrir o inventario.", 1040, 700,
                new Color(215, 164, 72)));

        camera = new Camera(WORLD_WIDTH, WORLD_HEIGHT);
        inventory = new Inventory();
        inventory.add(new Item("Pocao"));
        inventory.add(new Item("Mapa"));
        inventory.add(new Item("Chave"));
        inventoryRenderer = new InventoryRenderer();
        interactionChecker = new InteractionChecker();
        dialogueRenderer = new DialogueRenderer();
       
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
        if (keyHandler.consumeInventoryToggle()) {
            inventoryOpen = !inventoryOpen;
        }

        boolean interactionRequested = keyHandler.consumeInteractionRequest();
        if (!inventoryOpen && interactionRequested) {
            if (activeNpc == null) {
                activeNpc = interactionChecker.findNpc(player, npcs).orElse(null);
            } else {
                activeNpc = null;
            }
        }

        if (!inventoryOpen && activeNpc == null) {
            player.update(WORLD_WIDTH, WORLD_HEIGHT, collisionChecker, solidEntities);
        }

        camera.follow(player, getWidth(), getHeight());
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        Graphics2D worldGraphics = (Graphics2D) g2.create();
        worldGraphics.translate(-camera.getX(), -camera.getY());
        drawWorld(worldGraphics);
        worldGraphics.dispose();

        g2.setColor(Color.WHITE);
        g2.drawString("I - Inventario | E - Interagir", 12, 20);

        if (inventoryOpen) {
            inventoryRenderer.draw(g2, inventory, getWidth(), getHeight());
        }
        if (activeNpc != null) {
            dialogueRenderer.draw(g2, activeNpc, getWidth(), getHeight());
        }
        g2.dispose();
    }

    private void drawWorld(Graphics2D g2) {
        g2.setColor(new Color(28, 54, 38));
        g2.fillRect(0, 0, WORLD_WIDTH, WORLD_HEIGHT);

        g2.setColor(new Color(45, 78, 55));
        for (int x = 0; x <= WORLD_WIDTH; x += 64) {
            g2.drawLine(x, 0, x, WORLD_HEIGHT);
        }
        for (int y = 0; y <= WORLD_HEIGHT; y += 64) {
            g2.drawLine(0, y, WORLD_WIDTH, y);
        }

        for (Wall wall : walls) {
            wall.draw(g2);
        }
        for (Npc npc : npcs) {
            npc.draw(g2);
        }
        player.draw(g2);
    }

    private void addWall(Wall wall) {
        walls.add(wall);
        solidEntities.add(wall);
    }

    private void addNpc(Npc npc) {
        npcs.add(npc);
        solidEntities.add(npc);
    }
}
