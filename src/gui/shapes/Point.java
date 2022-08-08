// 208388140
package gui.shapes;

/**
 * @author Dvir Landau
 * @version 1.00 12/04/2021
 */
public class Point {
    private double x;
    private double y;

    /**
     * This function is the constructor.
     *
     * @param x - the x value.
     * @param y - the y value.
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * This function returns the distance from one point to another.
     *
     * @param other - point
     * @return - double
     */
    public double distance(Point other) {
        double sqrt = ((this.x - other.x) * (this.x - other.x)) + ((this.y - other.y) * (this.y - other.y));
        double distanceOfPoints = Math.sqrt(sqrt);
        return distanceOfPoints;
    }

    /**
     * This function checks if two points are equal.
     *
     * @param other - point
     * @return - true or false
     */
    public boolean equals(Point other) {
        double epsilon = Math.pow(10, -12);
        if (Math.abs(this.x - other.x) + Math.abs(this.y - other.y) < 2 * epsilon) {
            return true;
        }
        return false;
    }

    /**
     * Get the x value.
     *
     * @return double
     */
    public double getX() {
        return this.x;
    }

    /**
     * Get the y value.
     *
     * @return double
     */
    public double getY() {
        return this.y;
    }
    /**
     * Set the point.
     *
     * @param p - Gui.Shapes.Point
     */
    public void setPoint(Point p) {
        this.x = p.x;
        this.y = p.y;
    }

    /**
     * Set the x value of point.
     *
     * @param x1 - double
     */
    public void setX(double x1) {
        this.x = x1;
    }

    /**
     * Set the y value of point.
     *
     * @param y1 - double
     */
    public void setY(double y1) {
        this.y = y1;
    }
}

