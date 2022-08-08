// 208388140
package gui.shapes;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Dvir Landau
 * @version 1.00 14/04/2021
 */
public class Rectangle {
    private Point upperLeft;
    private double width;
    private double height;
    // 0 - up , 1 - down , 2 - left , 3 - right
    private Line[] sidesOfRec;

    /**
     * This function Create a new rectangle with location and width/height.
     *
     * @param upperLeft - the upper left point of a rectangle.
     * @param width     -  the width of a rectangle.
     * @param height    - the height of a rectangle.
     */
    public Rectangle(Point upperLeft, double width, double height) {
        this.upperLeft = upperLeft;
        this.height = height;
        this.width = width;
        this.sidesOfRec = sidesCalculation(upperLeft, width, height);
    }

    /**
     * The method calculates and inserts each side of the rectangle into the array.
     *
     * @param upperLeft - the upper left of rectangle
     * @param width     - the width of rectangle
     * @param height    - the height of rectangle
     * @return - array of lines
     */
    public static Line[] sidesCalculation(Point upperLeft, double width, double height) {
        Line[] lines = new Line[4];
        // the up side line
        Point start1 = new Point(upperLeft.getX(), upperLeft.getY());
        Point end1 = new Point(upperLeft.getX() + width, upperLeft.getY());
        lines[0] = new Line(start1, end1);
        // the down side line
        Point start2 = new Point(upperLeft.getX(), upperLeft.getY() + height);
        Point end2 = new Point(upperLeft.getX() + width, upperLeft.getY() + height);
        lines[1] = new Line(start2, end2);
        // the left side line
        Point start3 = new Point(upperLeft.getX(), upperLeft.getY());
        Point end3 = new Point(upperLeft.getX(), upperLeft.getY() + height);
        lines[2] = new Line(start3, end3);
        // the right side line
        Point start4 = new Point(upperLeft.getX() + width, upperLeft.getY());
        Point end4 = new Point(upperLeft.getX() + width, upperLeft.getY() + height);
        lines[3] = new Line(start4, end4);
        return lines;
    }

    /**
     * This function Return a (possibly empty) List of intersection points
     * with the specified line.
     *
     * @param line - Gui.Shapes.Line
     * @return - a List of intersection points
     */
    public java.util.List<Point> intersectionPoints(Line line) {
        // the list of intersection points
        List<Point> listOfPoints = new ArrayList<Point>();
        // loop that check intersection with any side of rectangle
        for (Line l : this.sidesOfRec) {
            // initialization the intersection point
            Point intersection = l.intersectionWith(line);
            if (intersection != null) {
                listOfPoints.add(intersection);
            }
        }
        return listOfPoints;
    }

    /**
     * This method Return the width of the rectangle.
     *
     * @return - double
     */
    public double getWidth() {
        return this.width;
    }

    /**
     * This method Return the height of the rectangle.
     *
     * @return - double
     */
    public double getHeight() {
        return this.height;
    }

    /**
     * This method Return the upper left point of the rectangle.
     *
     * @return - Gui.Shapes.Point
     */
    public Point getUpperLeft() {
        return this.upperLeft;
    }

    /**
     * This method Return the sides of the rectangle.
     * @return - array of lines
     */
    public Line[] getSidesOfRec() {
        return this.sidesOfRec;
    }
}

