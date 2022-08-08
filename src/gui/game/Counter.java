//208388140
package gui.game;

/**
 * Counter Class.
 */
public class Counter {
    private int number;

    /**
     * Constructor.
     *
     * @param number - int
     */
    public Counter(int number) {
        this.number = number;
    }


    /**
     * Add number to current count.
     *
     * @param num - int
     */
    void increase(int num) {
        this.number += num;
    }

    /**
     * subtract number from current count.
     *
     * @param num - int
     */
    void decrease(int num) {
        this.number -= num;

    }

    /**
     * get current count.
     *
     * @return - int
     */
    public int getValue() {
        return this.number;
    }
}
