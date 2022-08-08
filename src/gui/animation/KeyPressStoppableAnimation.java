//208388140
package gui.animation;
/**
 * @author Dvir Landau
 * @version 1.00 20/06/2021
 */

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

/**
 * KeyPressStoppableAnimation Class.
 */
public class KeyPressStoppableAnimation implements Animation {
    private KeyboardSensor keyboardSensor;
    private String key;
    private Animation animation;
    private boolean stop;
    private boolean isAlreadyPressed;

    /**
     * A constructor.
     *
     * @param sensor    - KeyboardSensor
     * @param key       - String
     * @param animation - Animation
     */
    public KeyPressStoppableAnimation(KeyboardSensor sensor, String key, Animation animation) {
        this.animation = animation;
        this.key = key;
        this.keyboardSensor = sensor;
        this.stop = false;
        this.isAlreadyPressed = true;
    }


    @Override
    public void doOneFrame(DrawSurface d) {
        this.animation.doOneFrame(d);
        if (this.keyboardSensor.isPressed(KeyboardSensor.SPACE_KEY)) {
            if (this.isAlreadyPressed) {
                return;
            }
            this.stop = true;
        }
        this.isAlreadyPressed = false;
    }

    @Override
    public boolean shouldStop() {
        return this.stop;
    }
}
