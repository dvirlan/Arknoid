// 208388140
package gui.sprite;
/**
 * @author Dvir Landau
 * @version 2.00 03/06/2021
 */

import biuoop.DrawSurface;

import java.util.ArrayList;
import java.util.List;

/**
 * SpriteCollection Class.
 */
public class SpriteCollection {
    private List<Sprite> spriteCollections;

    /**
     * Instantiates a new Gui.Sprite.Sprite collection.
     */
    public SpriteCollection() {
        spriteCollections = new ArrayList<Sprite>();
    }

    /**
     * Add sprite to the list.
     *
     * @param s the s
     */
    public void addSprite(Sprite s) {
        spriteCollections.add(s);
    }

    /**
     * Remove sprite to the list.
     *
     * @param s the s
     */
    public void removeSprite(Sprite s) {
        spriteCollections.remove(s);
    }


    /**
     * call timePassed() on all sprites.
     */
    public void notifyAllTimePassed() {
        for (int i = 0; i < spriteCollections.size(); i++) {
            spriteCollections.get(i).timePassed();
        }
    }

    /**
     * call drawOn(d) on all sprites.
     *
     * @param d the drawsurface.
     */
    public void drawAllOn(DrawSurface d) {
        for (Sprite s : this.spriteCollections) {
            s.drawOn(d);
        }

    }
}
