// 208388140
package gui.Collision;

import gui.game.GameLevel;
import gui.game.Velocity;
import gui.shapes.Ball;
import gui.shapes.Line;
import gui.shapes.Point;
import gui.shapes.Rectangle;
import gui.sprite.Sprite;
import biuoop.DrawSurface;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Dvir Landau
 * @version 1.00 16/04/2021
 */
public class Block implements Collidable, Sprite, HitNotifier {
    private Rectangle block;
    private Color color;
    private GameLevel g;
    private List<HitListener> hitListeners;


    /**
     * This method creates a new block.
     *
     * @param block - Gui.Shapes.Rectangle
     * @param color - block's color
     */
    public Block(Rectangle block, Color color) {
        this.block = block;
        this.color = color;
        this.hitListeners = new ArrayList();
    }

    /**
     * This method creates a new block.
     *
     * @param block - Gui.Shapes.Rectangle
     */
    public Block(Rectangle block) {
        this.block = block;
    }

    /**
     * draw the ball on the given DrawSurface.
     *
     * @param surface - the draw surface.
     */
    public void drawOn(DrawSurface surface) {
        double x = this.getCollisionRectangle().getUpperLeft().getX();
        double y = this.getCollisionRectangle().getUpperLeft().getY();
        double width = this.getCollisionRectangle().getWidth();
        double height = this.getCollisionRectangle().getHeight();
        surface.setColor(this.color);
        surface.fillRectangle((int) x, (int) y, (int) width, (int) height);
        surface.setColor(Color.black);
        surface.drawRectangle((int) x, (int) y, (int) width, (int) height);
    }

    @Override
    public void timePassed() {
    }

    /**
     * Return the "collision shape" of the object.
     *
     * @return - rectangle
     */
    public Rectangle getCollisionRectangle() {
        return this.block;
    }

    /**
     * @param collisionPoint  - the collision point with the block.
     * @param currentVelocity - the current velocity of the ball.
     * @param hitter          - Ball.
     * @return - The updated velocity after the collision.
     */
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        //Dividing the block into four sides
        Line up = this.block.getSidesOfRec()[0];
        Line down = this.block.getSidesOfRec()[1];
        Line right = this.block.getSidesOfRec()[2];
        Line left = this.block.getSidesOfRec()[3];
        //Collision with the upper side
        if ((up.inLine(collisionPoint)) && currentVelocity.getDy() != 0) {
            currentVelocity.setDy((-1) * currentVelocity.getDy());
        }
        //Collision with the down side
        if (down.inLine(collisionPoint) && currentVelocity.getDy() != 0) {
            currentVelocity.setDy((-1) * currentVelocity.getDy());
        }
        //Collision with the right side
        if ((right.inLine(collisionPoint)) && currentVelocity.getDx() != 0) {
            currentVelocity.setDx((-1) * currentVelocity.getDx());
        }
        //Collision with the left side
        if (left.inLine(collisionPoint) && currentVelocity.getDx() != 0) {
            currentVelocity.setDx((-1) * currentVelocity.getDx());
        }
        this.notifyHit(hitter);
        return currentVelocity;
    }

    /**
     * Add the block to the game.
     *
     * @param gameLevel - Gui.Game.Game
     */
    public void addToGame(GameLevel gameLevel) {
        gameLevel.addSprite(this);
        gameLevel.addCollidable(this);
    }

    /**
     * Remove the block from Game.
     *
     * @param gameLevel - Game
     */
    public void removeFromGame(GameLevel gameLevel) {
        return;
    }

    @Override
    public void addHitListener(HitListener hl) {
        this.hitListeners.add(hl);
    }

    @Override
    public void removeHitListener(HitListener hl) {
        this.hitListeners.remove(hl);
    }

    /**
     * @param hitter - Ball
     */
    private void notifyHit(Ball hitter) {
        // Make a copy of the hitListeners before iterating over them.
        List<HitListener> listeners = new ArrayList<HitListener>(this.hitListeners);
        // Notify all listeners about a hit event:
        for (HitListener hl : listeners) {
            hl.hitEvent(this, hitter);
        }
    }
}
