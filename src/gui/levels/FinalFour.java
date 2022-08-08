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
 * FinalFour Class.
 */
public class FinalFour implements LevelInformation {
    @Override
    public int numberOfBalls() {
        return 3;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> ballvelocities = new ArrayList<>();
        for (int i = 0; i < numberOfBalls(); i++) {
            Velocity v1 = Velocity.fromAngleAndSpeed(45 * i - 45, 5);
            ballvelocities.add(v1);
        }
        return ballvelocities;
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
        return "Final Four";
    }

    @Override
    public Sprite getBackground() {
        Color color = new Color(0x1B7580);
        return new Block(new Rectangle(new Point(0, 0), 800, 600), color);
    }

    @Override
    public List<Block> blocks() {
        double width = 52;
        double height = 25;
        double startX = 739;
        double startY = 150;
        List<Block> blocks = new ArrayList<>();
        Color[] colors = {
                Color.gray, Color.red, Color.YELLOW, Color.green, Color.white, Color.pink, Color.CYAN
        };
        // loops that creates the blocks
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 15; j++) {
                Block block = new Block(new Rectangle(new Point(startX - width * j, startY + i * height),
                        width, height), colors[i]);
                blocks.add(block);
            }
        }
        return blocks;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return 105;
    }
}
