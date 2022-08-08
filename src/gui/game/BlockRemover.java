//208388140
package gui.game;
/**
 * @author Dvir Landau
 * @version 1.00 16/04/2021
 */

import gui.Collision.Block;
import gui.Collision.HitListener;
import gui.shapes.Ball;

/**
 * BlockRemover Class.
 */
public class BlockRemover implements HitListener {
    private GameLevel gameLevel;
    private Counter remainingBlocks;

    /**
     * Remove block from game.
     *
     * @param gameLevel          - Game
     * @param removedBlocks - Counter
     */
    public BlockRemover(GameLevel gameLevel, Counter removedBlocks) {
        this.gameLevel = gameLevel;
        this.remainingBlocks = removedBlocks;
    }

    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        this.gameLevel.removeSprite(beingHit);
        this.gameLevel.removeCollidable(beingHit);
        this.remainingBlocks.decrease(1);
        beingHit.removeHitListener(this);

    }
}
