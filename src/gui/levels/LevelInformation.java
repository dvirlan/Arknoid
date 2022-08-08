//208388140
package gui.levels;
/**
 * @author Dvir Landau
 * @version 1.00 20/06/2021
 */

import gui.Collision.Block;
import gui.game.Velocity;
import gui.sprite.Sprite;

import java.util.List;

/**
 * Interface LevelInformation.
 */
public interface LevelInformation {
    /**
     * numberOfBalls.
     *
     * @return - int
     */
    int numberOfBalls();

    /**
     * The initial velocity of each ball.
     *
     * @return - List<Velocity>
     */
    List<Velocity> initialBallVelocities();

    /**
     * paddleSpeed.
     *
     * @return - int
     */
    int paddleSpeed();

    /**
     * paddleWidth.
     *
     * @return - int
     */
    int paddleWidth();

    /**
     * the level name will be displayed at the top of the screen.
     *
     * @return - String
     */
    String levelName();


    /**
     * Returns a sprite with the background of the level.
     *
     * @return - Sprite
     */
    Sprite getBackground();


    /**
     * The Blocks that make up this level, each block contains
     * its size, color and location.
     *
     * @return -  List<Block>
     */
    List<Block> blocks();


    /**
     * Number of blocks that should be removed
     * before the level is considered to be "cleared".
     *
     * @return - int
     */
    int numberOfBlocksToRemove();
}
