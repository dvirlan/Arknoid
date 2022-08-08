// 208388140
package gui.game;

import gui.shapes.Point;

/**
 * @author Dvir Landau
 * @version 1.00 12/04/2021
 */
public class Velocity {
    private double dx;
    private double dy;

    /**
     * This function updating the speed of the ball (constructor).
     *
     * @param dx - x position
     * @param dy - y position
     */
    public Velocity(double dx, double dy) {
        this.dx = dx;
        this.dy = dy;
    }

    /**
     * This function updating the speed of the ball.
     *
     * @return dx - the change in the X.
     */
    public double getDx() {
        return this.dx;
    }

    /**
     * This function updating the speed of the ball.
     *
     * @return dx - the change in the X.
     */
    public double getDy() {
        return this.dy;
    }

    /**
     * This function updating the speed of the ball.
     *
     * @param x - the change in the X.
     */
    public void setDx(double x) {
        this.dx = x;
    }

    /**
     * This function updating the speed of the ball.
     *
     * @param y - the change in the Y.
     */
    public void setDy(double y) {
        this.dy = y;
    }

    /**
     * This function takes a point with position (x,y) and return a new point
     * with position (x+dx, y+dy).
     *
     * @param p - position point.
     * @return - a new point with position (x+dx, y+dy).
     */
    public Point applyToPoint(Point p) {
        return new Point(p.getX() + dx, p.getY() + dy);
    }

    /**
     * This function updating the speed of the ball.
     *
     * @param angle - angle for the velocity.
     * @param speed - the velocity
     * @return velocity - the change in the center point of the ball.
     */
    public static Velocity fromAngleAndSpeed(double angle, double speed) {
        double dx = (Math.sin(Math.toRadians(angle))) * speed;
        double dy = -(Math.cos(Math.toRadians(angle))) * speed;
        return new Velocity(dx, dy);
    }
    /**
     * @return the speed of the ball.
     */
    public double getSpeed() {
        return Math.sqrt(this.dx * this.dx + this.dy * this.dy);
    }
}

