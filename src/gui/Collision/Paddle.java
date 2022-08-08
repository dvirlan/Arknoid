// 208388140
package gui.Collision;
/**
 * @version 1.00 20/05/2021
 * @author Dvir Landau
 */

import gui.game.GameLevel;
import gui.game.Velocity;
import gui.shapes.Ball;
import gui.shapes.Line;
import gui.shapes.Point;
import gui.shapes.Rectangle;
import gui.sprite.Sprite;
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

import java.awt.Color;
import java.util.ArrayList;

/**
 * Gui.Collision.Paddle class.
 */
public class Paddle implements Sprite, Collidable {
    private biuoop.KeyboardSensor keyboard;
    private Rectangle shape;
    private Color color;
    private int speed;
    private final int move = 10;
    private final int frame = 800;

    /**
     * Instantiates a new Gui.Collision.Paddle.
     *
     * @param keyboard - KeyboardSensor
     * @param shape    - Gui.Shapes.Rectangle
     * @param color    - Color
     * @param speed    - int
     */
    public Paddle(KeyboardSensor keyboard, Rectangle shape, Color color, int speed) {
        this.keyboard = keyboard;
        this.shape = shape;
        this.color = color;
        this.speed = speed;
    }

    /**
     * returns x of the upper left point of the board.
     *
     * @return the x
     */
    public double getX() {
        return this.shape.getUpperLeft().getX();
    }

    /**
     * returns y of the upper left point of the board.
     *
     * @return the y
     */
    public double getY() {
        return this.shape.getUpperLeft().getY();
    }

    /**
     *
     */
    public void moveLeft() {
        shape = new Rectangle(new Point(this.getX() - move, this.getY()),
                this.shape.getWidth(), this.shape.getHeight());
    }

    /**
     *
     */
    public void moveRight() {
        shape = new Rectangle(new Point(this.getX() + move, this.getY()),
                this.shape.getWidth(), this.shape.getHeight());
    }

    /**
     *
     */
    public void timePassed() {
        double outR = this.shape.getUpperLeft().getX() + shape.getWidth();
        double outL = this.shape.getUpperLeft().getX();
        if (keyboard.isPressed(KeyboardSensor.LEFT_KEY) && outL >= 16) {
            this.moveLeft();
        }
        if (keyboard.isPressed(KeyboardSensor.RIGHT_KEY) && outR + move < frame) {
            this.moveRight();
        }
    }

    /**
     * @param d - DrawSurface
     */
    public void drawOn(DrawSurface d) {
        double x = this.getCollisionRectangle().getUpperLeft().getX();
        double y = this.getCollisionRectangle().getUpperLeft().getY();
        double width = this.getCollisionRectangle().getWidth();
        double height = this.getCollisionRectangle().getHeight();
        d.setColor(this.color);
        d.fillRectangle((int) x, (int) y, (int) width, (int) height);
        d.setColor(Color.black);
        d.drawRectangle((int) x, (int) y, (int) width, (int) height);
    }

    /**
     * @return - Gui.Shapes.Rectangle - Gui.Collision.Paddle's shape
     */
    public Rectangle getCollisionRectangle() {
        return this.shape;
    }

    /**
     * @param collisionPoint  - the collision point with the block.
     * @param currentVelocity - the current velocity of the ball.
     * @param hitter          - Ball.
     * @return - The updated velocity after the collision.
     */
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        double lineSize = this.shape.getWidth() / 5;
        // initialization array of lines for paddle's sides
        ArrayList<Line> lines = new ArrayList<Line>();
        Point start = this.shape.getUpperLeft();
        Point end = new Point(start.getX() + lineSize, start.getY());
        // loop that insert the sides to the array
        for (int i = 0; i < 5; i++) {
            double newStartX = start.getX() + (lineSize * i);
            double newEndX = end.getX() + (lineSize * i);
            Line l = new Line(newStartX, start.getY(), newEndX, end.getY());
            lines.add(l);
        }
        // the left reign
        if (lines.get(0).inLine(collisionPoint)) {
            return Velocity.fromAngleAndSpeed(300, currentVelocity.getSpeed());
        }
        // the middle left reign
        if (lines.get(1).inLine(collisionPoint)) {
            return Velocity.fromAngleAndSpeed(330, currentVelocity.getSpeed());
        }
        // the middle reign
        if (lines.get(2).inLine(collisionPoint)) {
            currentVelocity.setDy(-Math.abs(currentVelocity.getDy()));
        }
        //  the middle right reign
        if (lines.get(3).inLine(collisionPoint)) {
            return Velocity.fromAngleAndSpeed(30, currentVelocity.getSpeed());
        }
        // the right reign
        if (lines.get(4).inLine(collisionPoint)) {
            return Velocity.fromAngleAndSpeed(60, currentVelocity.getSpeed());
            // if the ball hit the left or right side of paddle
        } else if (shape.getSidesOfRec()[2].inLine(collisionPoint)) {
            currentVelocity.setDx((-1) * currentVelocity.getDx());
        } else if (shape.getSidesOfRec()[3].inLine(collisionPoint)) {
            currentVelocity.setDx((-1) * currentVelocity.getDx());
        }
        return currentVelocity;
    }

    /**
     * Add this paddle to the game.
     *
     * @param g - the game
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
        g.addCollidable(this);
    }
}
