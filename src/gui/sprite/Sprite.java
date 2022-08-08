// 208388140
package gui.sprite;

/**
 * @author Dvir Landau
 * @version 2.00 26/04/2021
 */
import biuoop.DrawSurface;

/**
 * The interface Gui.Sprite.Sprite.
 */
public interface Sprite {
    /**
     * Draw the sprite to the screen.
     *
     * @param d - Drawsuface.
     */
    void drawOn(DrawSurface d);

    /**
     * Notify the sprite that time has passed.
     */
    void timePassed();
}
