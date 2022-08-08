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
 * EndScreenWin Class.
 */
public class EndScreenWin implements Animation {
    private boolean stop;
    private Counter score;
    private KeyboardSensor keyboard;

    /**
     * A constructor.
     *
     * @param s - Counter
     * @param k - KeyboardSensor
     */
    public EndScreenWin(Counter s, KeyboardSensor k) {
        this.stop = false;
        this.score = s;
        this.keyboard = k;
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        Color color = new Color(0x8A73B4);
        d.setColor(color);
        d.drawRectangle(0, 0, 800, 600);
        d.fillRectangle(0, 0, 800, 600);
        d.setColor(Color.black);
        d.drawText(225, d.getHeight() / 2, "You Win!", 75);
        d.drawText(250, (d.getHeight() / 2) + 70, "Your score is:" + this.score.getValue(), 30);
    }

    @Override
    public boolean shouldStop() {
        return this.stop;
    }
}
