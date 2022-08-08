package gui.game;

import gui.Collision.Block;
import gui.sprite.Sprite;
import biuoop.DrawSurface;

/**
 * ScoreIndicator class.
 */
public class ScoreIndicator implements Sprite {
    private Block block;
    private Counter score;
    private String levelName;

    /**
     * A constructor of ScoreIndicator.
     * @param block - Block
     * @param score - Counter
     * @param levelName - String
     */
    public ScoreIndicator(Block block, Counter score, String levelName) {
        this.block = block;
        this.score = score;
        this.levelName = levelName;
    }

    @Override
    public void drawOn(DrawSurface d) {
        this.block.drawOn(d);
        d.drawText(320, 16, "score: " + this.score.getValue(), 18);
        d.drawText(500, 16, "Level name:" + this.levelName, 18);
    }

    @Override
    public void timePassed() {

    }

    /**
     * Add the score indicator to the game.
     * @param g - Game
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }
}
