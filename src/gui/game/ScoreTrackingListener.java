//208388140
package gui.game;
/**
 * @version 1.00 06/06/2021
 * @author Dvir Landau
 */
import gui.Collision.Block;
import gui.Collision.HitListener;
import gui.shapes.Ball;
/**
 * ScoreTrackingListener Class.
 */
public class ScoreTrackingListener implements HitListener {
    private Counter currentScore;

    /**
     * A constructor.
     * @param scoreCounter - Counter
     */
    public ScoreTrackingListener(Counter scoreCounter) {
        this.currentScore = scoreCounter;
    }

    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        this.currentScore.increase(5);
    }
}
