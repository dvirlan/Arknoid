//208388140
package gui.animation;
/**
 * @author Dvir Landau
 * @version 1.00 20/06/2021
 */

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

import java.awt.Color;

/**
 * PauseScreen Class.
 */
public class PauseScreen implements Animation {
    private KeyboardSensor keyboard;
    private boolean stop;

    /**
     * A constructor.
     *
     * @param k - KeyboardSensor
     */
    public PauseScreen(KeyboardSensor k) {
        this.keyboard = k;
        this.stop = false;
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        Color color = new Color(0xDB3618);
        d.setColor(color);
        d.drawRectangle(0, 0, 800, 600);
        d.fillRectangle(0, 0, 800, 600);
        d.setColor(Color.black);
        d.drawText(115, d.getHeight() / 2, "paused -- press space to continue", 40);
    }

    @Override
    public boolean shouldStop() {
        return this.stop;
    }
}

