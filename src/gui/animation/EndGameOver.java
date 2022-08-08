//208388140
package gui.animation;
/**
 * @author Dvir Landau
 * @version 1.00 20/06/2021
 */

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
import gui.game.Counter;

import java.awt.Color;

/**
 * EndGameOver Class.
 */
public class EndGameOver implements Animation {
    private boolean stop;
    private Counter score;
    private KeyboardSensor keyboard;

    /**
     * A constructor.
     * @param s - Counter
     * @param k - KeyboardSensor
     */
    public EndGameOver(Counter s, KeyboardSensor k) {
        this.stop = false;
        this.score = s;
        this.keyboard = k;
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        d.setColor(Color.orange);
        d.drawRectangle(0, 0, 800, 600);
        d.fillRectangle(0, 0, 800, 600);
        d.setColor(Color.black);
        d.drawText(210, d.getHeight() / 2, "Game Over! Your score is: " + this.score.getValue(), 30);
        // if (this.keyboard.isPressed(KeyboardSensor.SPACE_KEY)) { this.stop = true; }
    }

    @Override
    public boolean shouldStop() {
        return this.stop;
    }
}
