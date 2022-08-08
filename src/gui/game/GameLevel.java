// 208388140
package gui.game;
/**
 * @version 1.00 20/05/2021
 * @author Dvir Landau
 */

import biuoop.KeyboardSensor;
import gui.Collision.Block;
import gui.Collision.Collidable;
import gui.Collision.Paddle;
import gui.animation.Animation;
import gui.animation.AnimationRunner;
import gui.animation.CountdownAnimation;
import gui.animation.KeyPressStoppableAnimation;
import gui.animation.PauseScreen;
import gui.levels.LevelInformation;
import gui.shapes.Ball;
import gui.shapes.Point;
import gui.shapes.Rectangle;
import gui.sprite.Sprite;
import gui.sprite.SpriteCollection;
import biuoop.DrawSurface;
import biuoop.GUI;

import java.awt.Color;
import java.util.List;

/**
 * This class run the game.
 */
public class GameLevel implements Animation {
    private SpriteCollection sprites;
    private GameEnvironment environment;
    private GUI gui;
    private Counter blocksCounter;
    private Counter ballsCounter;
    private Counter score;
    private AnimationRunner runner;
    private boolean running;
    private biuoop.KeyboardSensor keyboard;
    private LevelInformation levelInformation;

    /**
     * Instantiates a new Gui.Game.Game.
     *
     * @param level - LevelInformation
     * @param ks    - KeyboardSensor
     * @param an    - AnimationRunner
     * @param g     - Gui
     * @param s     - s
     */
    public GameLevel(LevelInformation level, KeyboardSensor ks, AnimationRunner an, GUI g, Counter s) {
        sprites = new SpriteCollection();
        environment = new GameEnvironment();
        gui = g;
        blocksCounter = new Counter(0);
        ballsCounter = new Counter(0);
        score = s;
        keyboard = ks;
        levelInformation = level;
        runner = an;
    }

    /**
     * This method adds collidable to the game environment.
     *
     * @param c - collidable
     */
    public void addCollidable(Collidable c) {
        environment.addCollidable(c);
    }

    /**
     * This method adds sprite to the Sprites.
     *
     * @param s - Gui.Sprite.Sprite
     */
    public void addSprite(Sprite s) {
        sprites.addSprite(s);
    }

    /**
     * getBallsCounter.
     * @return - Counter
     */
    public Counter getBallsCounter() {
        return ballsCounter;
    }

    /**
     * getBlocksCounter.
     * @return - Counter
     */
    public Counter getBlocksCounter() {
        return blocksCounter;
    }

    /**
     * getScore.
     * @return - Counter
     */
    public Counter getScore() {
        return score;
    }

    /**
     * This method Initialize a new game: create the Blocks and Gui.Shapes.Ball (and Gui.Collision.Paddle)
     * and add them to the game.
     */
    public void initialize() {
        // initialize Background
        this.sprites.addSprite(this.levelInformation.getBackground());
        // initialization the frame blocks
        this.createFrame();
        // initialization the paddle and balls
        this.createPaddleAndBalls();
        // loops that creates the blocks
        this.createBlocks();
    }

    /**
     * Run the game -- start the animation loop.
     */
    public void run() {
        this.runner.run(new CountdownAnimation(2, 3, this.sprites));
        this.runner = new AnimationRunner(this.gui);
        this.running = true;
        this.runner.run(this);
    }


    /**
     * Remove collidable from environment.
     *
     * @param c - Collidable
     */
    public void removeCollidable(Collidable c) {
        this.environment.removeCollidable(c);
    }

    /**
     * Remove sprite from sprites list.
     *
     * @param s - Sprite
     */
    public void removeSprite(Sprite s) {
        this.sprites.removeSprite(s);
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        this.sprites.drawAllOn(d);
        // d.drawText(500, 16, "Level name:" + this.levelInformation.levelName(), 18);
        this.sprites.notifyAllTimePassed();
        if (this.ballsCounter.getValue() == 0) {
            // gui.close();
            this.running = false;
        }
        if (blocksCounter.getValue() == 0) {
            this.score.increase(100);
            //     gui.close();
            this.running = false;
        }
        if (this.keyboard.isPressed("p")) {
            //this.runner.run(new PauseScreen(this.keyboard));
            this.runner.run(new KeyPressStoppableAnimation(this.keyboard,
                    KeyboardSensor.SPACE_KEY, new PauseScreen(this.keyboard)));
        }

    }

    @Override
    public boolean shouldStop() {
        return !this.running;
    }

    /**
     * A method that creates paddle and balls.
     */
    public void createPaddleAndBalls() {
        LevelInformation information = this.levelInformation;
        biuoop.KeyboardSensor keyboardSensor = gui.getKeyboardSensor();
        // Create the paddle
        Paddle paddle = new Paddle(keyboardSensor, new Rectangle(new Point(
                390 - (0.5 * information.paddleWidth()), 580),
                information.paddleWidth(), 20), Color.orange, information.paddleSpeed());
        paddle.addToGame(this);
        // Create the balls
        for (Velocity vel : this.levelInformation.initialBallVelocities()) {
            Ball ball = new Ball(new Point(400, 573), 7, Color.white, this.environment, paddle);
            ball.setVelocity(vel);
            ball.addToGame(this);
            this.ballsCounter.increase(1);
        }
    }

    /**
     * A method that creates blocks.
     */
    public void createBlocks() {
        ScoreTrackingListener scoreTrackingListener = new ScoreTrackingListener(score);
        BlockRemover blockRemover = new BlockRemover(this, this.blocksCounter);
        LevelInformation information = this.levelInformation;
        List<Block> blocks = this.levelInformation.blocks();
        for (int i = 0; i < blocks.size(); i++) {
            blocks.get(i).addToGame(this);
            blocks.get(i).addHitListener(blockRemover);
            blocks.get(i).addHitListener(scoreTrackingListener);
            blocksCounter.increase(1);
        }
    }

    /**
     * A method that creates the general frame .
     */
    public void createFrame() {
        BallRemover ballRemover = new BallRemover(this, this.ballsCounter);
        Block up = new Block(new Rectangle(new Point(0, 0), 800, 20), Color.WHITE);
        Block down = new Block(new Rectangle(new Point(0, 600), 800, 10), Color.gray);
        Block left = new Block(new Rectangle(new Point(0, 0), 10, 600), Color.gray);
        Block right = new Block(new Rectangle(new Point(790, 0), 10, 600), Color.gray);
        Block up2 = new Block(new Rectangle(new Point(10, 10), 780, 20), Color.gray);
        down.addHitListener(ballRemover);
        up.addToGame(this);
        down.addToGame(this);
        right.addToGame(this);
        left.addToGame(this);
        up2.addToGame(this);
        ScoreIndicator scoreIndicator = new ScoreIndicator(up, score, this.levelInformation.levelName());
        scoreIndicator.addToGame(this);
    }
}


