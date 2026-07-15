package com.helder.randevu.interaction;

import com.helder.randevu.entity.Npc;
import com.helder.randevu.entity.Player;

import java.awt.Rectangle;
import java.util.List;
import java.util.Optional;

public class InteractionChecker {
    private static final int INTERACTION_DISTANCE = 24;

    public Optional<Npc> findNpc(Player player, List<Npc> npcs) {
        Rectangle interactionArea = createInteractionArea(player);

        for (Npc npc : npcs) {
            Rectangle npcBounds = new Rectangle(
                    npc.getX() + npc.getCollisionOffsetX(),
                    npc.getY() + npc.getCollisionOffsetY(),
                    npc.getCollisionWidth(), npc.getCollisionHeight());

            if (interactionArea.intersects(npcBounds)) {
                return Optional.of(npc);
            }
        }

        return Optional.empty();
    }

    private Rectangle createInteractionArea(Player player) {
        int x = player.getX() + player.getCollisionOffsetX();
        int y = player.getY() + player.getCollisionOffsetY();
        int width = player.getCollisionWidth();
        int height = player.getCollisionHeight();

        switch (player.getDirection()) {
            case "up":
                return new Rectangle(x, y - INTERACTION_DISTANCE, width, INTERACTION_DISTANCE);
            case "left":
                return new Rectangle(x - INTERACTION_DISTANCE, y, INTERACTION_DISTANCE, height);
            case "right":
                return new Rectangle(x + width, y, INTERACTION_DISTANCE, height);
            default:
                return new Rectangle(x, y + height, width, INTERACTION_DISTANCE);
        }
    }
}
