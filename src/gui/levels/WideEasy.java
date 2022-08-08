//208388140
package gui.levels;
/**
 * @author Dvir Landau
 * @version 1.00 20/06/2021
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
 * WideEasy class.
 */
public class WideEasy implements LevelInformation {
    @Override
    public int numberOfBalls() {
        return 10;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> ballVelocities = new ArrayList<>();
        for (int i = 0; i < numberOfBalls(); i++) {
            Velocity v1 = Velocity.fromAngleAndSpeed(10 * i - 45, 5);
            ballVelocities.add(v1);
        }
        return ballVelocities;
    }

    @Override
    public int paddleSpeed() {
        return 5;
    }

    @Override
    public int paddleWidth() {
        return 600;
    }

    @Override
    public String levelName() {
        return "Wide Easy";
    }

    @Override
    public Sprite getBackground() {
        Color color = new Color(0xFFE5C3C3, true);
        return new Block(new Rectangle(new Point(0, 0), 800, 600), color);
    }

    @Override
    public List<Block> blocks() {
        List<Block> blocks = new ArrayList<>();
        Color[] colors = {
                Color.red, Color.red, Color.orange, Color.orange, Color.YELLOW, Color.YELLOW, Color.GREEN, Color.GREEN,
                Color.GREEN, Color.blue, Color.blue, Color.pink, Color.pink, Color.CYAN, Color.CYAN
        };
        for (int i = 0; i < colors.length; i++) {
            Block b = new Block(new Rectangle(new Point(10 + 52 * i, 250), 52, 25),
                    colors[i]);
            blocks.add(b);
        }
        return blocks;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return 15;
    }
}
