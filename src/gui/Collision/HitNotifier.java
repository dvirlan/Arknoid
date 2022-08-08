//208388140
package gui.Collision;
/**
 * @version 1.00 23/05/2021
 * @author Dvir Landau
 */

public interface HitNotifier {
    /**
     * Add hl as a listener to hit events.
     *
     * @param hl - HitListener
     */
    void addHitListener(HitListener hl);
    /**
     * Remove hl from the list of listeners to hit events.
     *
     * @param hl - HitListener
     */
    void removeHitListener(HitListener hl);
}
