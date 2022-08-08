//208388140
package gui.animation;
/**
 * @author Dvir Landau
 * @version 1.00 20/06/2021
 */
import biuoop.DrawSurface;

/**
 * Animation Interface.
 */
public interface Animation {
    /**
     * Do one frame.
     * @param d - DrawSurface
     */
    void doOneFrame(DrawSurface d);

    /**
     * shouldStop.
     * @return - boolean
     */
    boolean shouldStop();
}
