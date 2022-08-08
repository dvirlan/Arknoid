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
 * Green3 Class.
 */
public class Green3 implements LevelInformation {
    @Override
    public int numberOfBalls() {
        return 2;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> ballVelocities = new ArrayList<>();
        for (int i = 0; i < numberOfBalls(); i++) {
            Velocity v1 = Velocity.fromAngleAndSpeed(90 * i - 45, 5);
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
        return 150;
    }

    @Override
    public String levelName() {
        return "Green 3";
    }

    @Override
    public Sprite getBackground() {
        Color color = new Color(0x316C11);
        return new Block(new Rectangle(new Point(0, 0), 800, 600), color);
    }

    @Override
    public List<Block> blocks() {
        double width = 50;
        double height = 25;
        double startX = 740;
        double startY = 150;
        List<Block> blocks = new ArrayList<>();
        Color[] colors = {
                Color.gray, Color.red, Color.YELLOW, Color.blue, Color.white,
        };
        // loops that creates the blocks
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 10 - i; j++) {
                Block block = new Block(new Rectangle(new Point(startX - width * j, startY + i * height),
                        width, height), colors[i]);
                blocks.add(block);
            }
        }
        return blocks;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return 30;
    }
}
