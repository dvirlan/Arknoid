//208388140
package gui.levels;

/**
 * @version 1.00 06/06/2021
 * @author Dvir Landau
 */
import gui.Collision.Block;
import gui.game.Velocity;
import gui.shapes.Point;
import gui.shapes.Rectangle;
import gui.sprite.Sprite;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * DirectHit Class.
 */
public class DirectHit implements LevelInformation {
    @Override
    public int numberOfBalls() {
        return 1;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> ballVelocities = new ArrayList<>();
        Velocity v1 = new Velocity(0, -5);
        ballVelocities.add(v1);
        return ballVelocities;
    }

    @Override
    public int paddleSpeed() {
        return 5;
    }

    @Override
    public int paddleWidth() {
        return 150;
    }

    @Override
    public String levelName() {
        return "Direct Hit";
    }

    @Override
    public Sprite getBackground() {
        Color color = new Color(0x1E1E2D);
        return new Block(new Rectangle(new Point(0, 0), 800, 600), color);
    }

    @Override
    public List<Block> blocks() {
        List<Block> blocks = new ArrayList<>();
        Color color = new Color(0x951515);
        Block b1 = new Block(new Rectangle(new Point(380, 125), 50, 50), color);
        blocks.add(b1);
        return blocks;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return 1;
    }
}
