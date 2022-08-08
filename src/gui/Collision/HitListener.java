// 208388140
package gui.Collision;

import gui.shapes.Ball;

/**
 * @author Dvir Landau
 * @version 1.00 06/06/2021
 */
public interface HitListener {
    /**
     * This method is called whenever the beingHit object is hit.
     * The hitter parameter is the Ball that's doing the hitting.
     *
     * @param beingHit - Block
     * @param hitter - Ball
     */
    void hitEvent(Block beingHit, Ball hitter);
}
