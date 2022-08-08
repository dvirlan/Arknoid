// 208388140
package gui.shapes;

import java.util.List;

/**
 * @author Dvir Landau
 * @version 1.00 12/04/2021
 */
public class Line {
    private Point start;
    private Point end;

    /**
     * @param start - of the line.
     * @param end   - of the line.
     */
    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    /**
     * @param x1 - of the first point.
     * @param y1 - of the first point.
     * @param x2 - of the second point.
     * @param y2 - of the second point.
     */
    public Line(double x1, double y1, double x2, double y2) {
        Point p1 = new Point(x1, y1);
        Point p2 = new Point(x2, y2);
        this.start = p1;
        this.end = p2;
    }

    /**
     * This function return the length of the line.
     *
     * @return double, length
     */
    public double length() {
        double length = this.start.distance(this.end);
        return length;
    }

    /**
     * This function returns the middle point of the line.
     *
     * @return Gui.Shapes.Point
     */
    public Point middle() {
        double sumX = this.start.getX() + this.end.getX();
        double sumY = this.start.getY() + this.end.getY();
        Point middle = new Point(sumX / 2, sumY / 2);
        return middle;
    }

    /**
     * This function returns the start point of the line.
     *
     * @return Gui.Shapes.Point
     */
    public Point start() {
        return this.start;
    }

    /**
     * This function returns the end point of the line.
     *
     * @return Gui.Shapes.Point
     */
    public Point end() {
        return this.end;
    }

    /**
     * This function returns the minimum x value of the line.
     *
     * @return double
     */
    public double minX() {
        if (this.start.getX() < this.end.getX()) {
            return this.start.getX();
        } else {
            return this.end.getX();
        }
    }

    /**
     * This function returns the minimum y value of the line.
     *
     * @return double
     */
    public double minY() {
        if (this.start.getY() < this.end.getY()) {
            return this.start.getY();
        } else {
            return this.end.getY();
        }
    }

    /**
     * This function returns the maximum x value of the line.
     *
     * @return double
     */
    public double maxX() {
        if (this.start.getX() > this.end.getX()) {
            return this.start.getX();
        } else {
            return this.end.getX();
        }
    }

    /**
     * This function returns the maximum y value of the line.
     *
     * @return double
     */
    public double maxY() {
        if (this.start.getY() > this.end.getY()) {
            return this.start.getY();
        } else {
            return this.end.getY();
        }
    }

    /**
     * This function returns the slope of line.
     *
     * @return the double
     */
    public double slope() {
        if (!this.hasSlope()) {
            return 0;
        }
        return ((this.end.getY() - this.start.getY()) / (this.end.getX() - this.start.getX()));
    }

    /**
     * This function checks if the line has a slope.
     *
     * @return the boolean
     */
    public boolean hasSlope() {
        if (this.end.getX() == this.start.getX()) {
            return false;
        }
        return true;
    }

    /**
     * This function returns the constant of the line's equation.
     *
     * @return the double
     */
    public double constant() {
        double constant;
        if (this.hasSlope()) {
            constant = (this.slope() * ((-1) * this.start.getX())) + this.start.getY();
        } else {
            constant = this.start.getX();
        }
        return constant;
    }

    /**
     * This function checks if line is a point.
     *
     * @return the boolean
     */
    public boolean isPoint() {
        if (this.start.equals(this.end)) {
            return true;
        }
        return false;
    }

    /**
     * This function checks if a point is within a line.
     *
     * @param p - a point
     * @return the boolean
     */
    public boolean inLine(Point p) {
        double d1 = p.distance(this.end);
        double d2 = p.distance(this.start);
        double epsilon = Math.pow(10, -12);
        if (Math.abs(d1 + d2 - this.length()) < epsilon) {
            return true;
        }
        return false;
    }

    /**
     * This function Calculates the point of intersection between two straight lines (assuming they have a slope).
     *
     * @param other - a line.
     * @return Gui.Shapes.Point
     */
    public Point intersection(Line other) {
        double m1 = this.slope();
        double m2 = other.slope();
        double c1 = this.constant();
        double c2 = other.constant();
        if (m1 == 0 && m2 == 0) {
            return new Point(c1, c2);
        }
        double x = (c1 - c2) / (m2 - m1);
        double y = (m1 * x) + c1;
        Point intersection = new Point(x, y);
        return intersection;
    }

    /**
     * The function calculates the point of intersection in case one of the lines is parallel
     * to the y-axis and the other is not.
     *
     * @param vertical  - a line that parallel to the y-axis.
     * @param withSlope - the second line.
     * @return Gui.Shapes.Point
     */
    public Point parallel(Line vertical, Line withSlope) {
        Point p;
        if ((vertical.start.getX() >= withSlope.minX()) && (vertical.start.getX() <= withSlope.maxX())) {
            double x = vertical.start.getX();
            double y = (withSlope.slope() * x) + withSlope.constant();
            if (y >= vertical.minY() && y <= vertical.maxY()) {
                p = new Point(x, y);
                return p;
            }
        }
        return null;
    }

    /**
     * Returns the intersection point if the lines intersect, and null otherwise.
     *
     * @param other - a line.
     * @return Gui.Shapes.Point
     */
    public Point intersectionWith(Line other) {
        Point p = null;
        // case that the lines are one point
        if ((this.isPoint()) && (other.isPoint())) {
            if (this.start.equals(other.start)) {
                return this.start;
            }
            return null;
        }
        if ((this.isPoint()) && (!other.isPoint())) {
            if (other.inLine(this.start)) {
                return this.start;
            } else {
                return null;
            }
            // case that the lines are points
        } else if ((!this.isPoint()) && (other.isPoint())) {
            if ((this.inLine(other.start))) {
                return other.start;
            } else {
                return null;
            }
        }
        // case that have two lines with slope
        if ((this.hasSlope()) && (other.hasSlope())) {
            // case that the slopes of two lines are different
            if (this.slope() != other.slope()) {
                p = this.intersection(other);
                if ((this.inLine(p) && (other.inLine(p)))) {
                    return p;
                } else {
                    return null;
                }

                // case that the lines are parallel
            } else if (this.constant() != other.constant()) {
                return null;
            } else {
                //case that the lines are tangents
                if (this.minX() == other.maxX() || other.minX() == this.maxX()) {
                    p = this.intersection(other);
                    return p;
                } else {
                    return null;
                }
            }
        }
        // case that the lines are parallel to y axis.
        if ((!this.hasSlope()) && (!other.hasSlope())) {
            if (this.start.getX() != other.start.getX()) {
                return null;
            }
            if ((this.minY() == other.maxY())) {
                p = new Point(this.maxX(), this.minY());
                return p;
            } else if (this.maxY() == other.minY()) {
                p = new Point(this.maxX(), this.maxY());
                return p;
            } else {
                return null;
            }
        }
        // case that one line Parallel to y axis and the other not.
        if ((this.hasSlope()) && (!other.hasSlope())) {
            p = parallel(other, this);
            return p;
        }
        if ((!this.hasSlope()) && (other.hasSlope())) {
            p = parallel(this, other);
            return p;
        }
        return null;
    }

    /**
     * This function returns true if the lines intersect, false otherwise.
     *
     * @param other - line.
     * @return boolean
     */
    public boolean isIntersecting(Line other) {
        Point p = this.intersectionWith(other);
        if (p != null) {
            return true;
        }
        return false;
    }

    /**
     * This function return true is the lines are equal, false otherwise.
     *
     * @param other the other
     * @return the boolean
     */
    public boolean equals(Line other) {
        if (this.start.equals(other.start) && this.end.equals(other.end)
                || this.start.equals(other.end) && this.end.equals(other.start)) {
            return true;
        }
        return false;
    }

    /**
     * This method check if return the closest intersection point to the start of the line.
     * if this line does not intersect with the rectangle, return null.
     * @param rect - a rectangle
     * @return - Gui.Shapes.Point
     */
    public Point closestIntersectionToStartOfLine(Rectangle rect) {
        List<Point> intersectionPoints = rect.intersectionPoints(this);
        // no intersection Points
        if (intersectionPoints.isEmpty()) {
            return  null;
        }
        // one intersection Gui.Shapes.Point
        if (intersectionPoints.size() == 1) {
            return intersectionPoints.get(0);
        }
        // two intersection Points
        double distance1 = intersectionPoints.get(0).distance(this.start);
        double distance2 = intersectionPoints.get(1).distance(this.start);
        if (distance1 < distance2) {
            return intersectionPoints.get(0);
        }
        return intersectionPoints.get(1);
    }
}
