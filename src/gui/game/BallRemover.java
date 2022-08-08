// 208388140
package gui.game;

import gui.Collision.Block;
import gui.Collision.HitListener;
import gui.shapes.Ball;

/**
 * @author Dvir Landau
 * @version 1.00 16/04/2021
 */
public class BallRemover implements HitListener {
    private GameLevel gameLevel;
    private Counter remainingBalls;

    /**
     * Remove Ball from the game.
     *
     * @param gameLevel           - Game
     * @param remainingBalls - Counter
     */
    public BallRemover(GameLevel gameLevel, Counter remainingBalls) {
        this.gameLevel = gameLevel;
        this.remainingBalls = remainingBalls;
    }

    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        this.gameLevel.removeSprite(hitter);
        this.remainingBalls.decrease(1);
    }
}
