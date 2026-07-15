package com.helder.randevu.collision;

import com.helder.randevu.entity.Entity;

import java.awt.Rectangle;
import java.util.List;

/**
 * Valida se uma entidade pode ocupar uma posicao dentro dos limites da tela.
 */
public class CollisionChecker {

    public boolean canMove(Entity entity, int nextX, int nextY, int worldWidth, int worldHeight,
                           List<? extends Entity> obstacles) {
        boolean insideWorld = nextX >= 0
                && nextY >= 0
                && nextX + entity.getWidth() <= worldWidth
                && nextY + entity.getHeight() <= worldHeight;

        if (!insideWorld) {
            return false;
        }

        Rectangle nextBounds = new Rectangle(
                nextX + entity.getCollisionOffsetX(),
                nextY + entity.getCollisionOffsetY(),
                entity.getCollisionWidth(),
                entity.getCollisionHeight());
        for (Entity obstacle : obstacles) {
            Rectangle obstacleBounds = new Rectangle(
                    obstacle.getX() + obstacle.getCollisionOffsetX(),
                    obstacle.getY() + obstacle.getCollisionOffsetY(),
                    obstacle.getCollisionWidth(), obstacle.getCollisionHeight());

            if (nextBounds.intersects(obstacleBounds)) {
                return false;
            }
        }

        return true;
    }
}
