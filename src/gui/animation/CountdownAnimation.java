// 208388140
package gui.animation;

import biuoop.DrawSurface;
import gui.sprite.SpriteCollection;

import java.awt.Color;

/**
 * @author Dvir Landau
 * @version 1.00 17/06/2021
 */
public class CountdownAnimation implements Animation {
    private double numOfSec;
    private int countForm;
    private SpriteCollection gameScreen;
    private int frame;

    /**
     * Countdown Animation.
     *
     * @param numOfSeconds - double
     * @param countFrom    - int
     * @param gameScreen   - SpriteCollection
     */
    public CountdownAnimation(double numOfSeconds, int countFrom, SpriteCollection gameScreen) {
        this.countForm = countFrom;
        this.gameScreen = gameScreen;
        this.numOfSec = numOfSeconds;
        this.frame = 0;

    }

    @Override
    public void doOneFrame(DrawSurface d) {
        gameScreen.drawAllOn(d);
        double frameR = (this.numOfSec / this.countForm) * 60;
        d.setColor(Color.yellow);
        d.drawText(380, 280, String.valueOf(this.countForm - ((int) (frame / frameR))), 75);
        d.setColor(Color.orange);
        d.drawText(378, 282, String.valueOf(this.countForm - ((int) (frame / frameR))), 75);
        d.setColor(Color.red);
        d.drawText(376, 284, String.valueOf(this.countForm - ((int) (frame / frameR))), 75);
        frame++;
    }

    @Override
    public boolean shouldStop() {
        if (frame / 60 >= numOfSec) {
            return true;
        }
        return false;
    }
}
