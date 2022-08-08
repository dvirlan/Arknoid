// 208388140
package gui.Collision;

/**
 * @author Dvir Landau
 * @version 2.00 26/04/2021
 */

import gui.game.Velocity;
import gui.shapes.Ball;
import gui.shapes.Point;
import gui.shapes.Rectangle;
import biuoop.DrawSurface;

/**
 * The interface Gui.Collision.Collidable.
 */
public interface Collidable {
    /**
     * Return the "collision shape" of the object.
     *
     * @return - collision rectangle
     */
    Rectangle getCollisionRectangle();

    /**
     * Notify the object that we collided with it at collisionPoint with
     * a given velocity.
     * The return is the new velocity expected after the hit (based on
     * the force the object inflicted on us).
     *
     * @param collisionPoint  - collision Gui.Shapes.Point
     * @param currentVelocity - current velocity.
     * @param hitter - Ball
     * @return - new velocity
     */
    Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity);

    /**
     * Draw on the collidable.
     *
     * @param d - DrawSurface
     */
    void drawOn(DrawSurface d);
}
