// 208388140
package gui.shapes;
/**
 * @version 3.00 05/06/2021
 * @author Dvir Landau
 */

import gui.Collision.CollisionInfo;
import gui.Collision.Paddle;
import gui.game.GameLevel;
import gui.game.GameEnvironment;
import gui.game.Velocity;
import gui.sprite.Sprite;
import biuoop.DrawSurface;

import java.awt.Color;

/**
 * Gui.Shapes.Ball class.
 */
public class Ball implements Sprite {
    private Point center;
    private int radius;
    private Color color;
    private Velocity velocity;
    private GameEnvironment gameE;
    private Paddle paddle;

    /**
     * Gui.Shapes.Ball - a constructor.
     *
     * @param center - point of center
     * @param r      - the radius
     * @param color  - a ball color
     * @param gameE  - Gui.Game.GameEnvironment
     * @param paddle - the paddle
     */
    public Ball(Point center, int r, java.awt.Color color, GameEnvironment gameE, Paddle paddle) {
        this.center = center;
        this.radius = r;
        this.color = color;
        this.velocity = new Velocity(0, 0);
        this.gameE = gameE;
        this.paddle = paddle;
    }

    /**
     * Another constructor.
     *
     * @param x      - the x value
     * @param y      - the y value
     * @param r      - the radius
     * @param color  - the color of the ball
     * @param gameE  - the Gui.Game.GameEnvironment
     * @param paddle - the paddle
     */
    public Ball(int x, int y, int r, java.awt.Color color, GameEnvironment gameE, Paddle paddle) {
        this(new Point(x, y), r, color, gameE, paddle);
    }

    /**
     * This method creates a ball.
     *
     * @param center - Gui.Shapes.Point
     * @param r      - the radius
     */
    public Ball(Point center, int r) {
        this.center = center;
        this.radius = r;
    }

    /**
     * Accessor.
     *
     * @return x value of the center point
     */
    public int getX() {
        return (int) this.center.getX();
    }

    /**
     * Accessor.
     *
     * @return y value of the center point
     */
    public int getY() {
        return (int) this.center.getY();
    }

    /**
     * Accessor.
     *
     * @return - the center point of ball.
     */
    public Point getCenter() {
        return this.center;
    }

    /**
     * Accessor.
     *
     * @return the radius of the ball.
     */
    public int getSize() {
        return this.radius;
    }

    /**
     * Accessor.
     *
     * @return the color of the ball.
     */
    public java.awt.Color getColor() {
        return this.color;
    }

    /**
     * draw the ball on the given DrawSurface.
     *
     * @param surface - the draw surface.
     */
    public void drawOn(DrawSurface surface) {
        surface.setColor(this.color);
        surface.fillCircle(this.getX(), this.getY(), this.radius);
        surface.setColor(Color.black);
        surface.drawCircle(this.getX(), this.getY(), this.radius);
    }

    @Override
    public void timePassed() {
        moveOneStep();
    }

    /**
     * set the velocity of the ball.
     *
     * @param v - the velocity
     */
    public void setVelocity(Velocity v) {
        this.velocity = v;
    }

    /**
     * set the velocity of the ball.
     *
     * @param dx - x position
     * @param dy - y position
     */
    public void setVelocity(double dx, double dy) {
        this.velocity = new Velocity(dx, dy);
    }

    /**
     * get the velocity of the ball.
     *
     * @return the velocity
     */
    public Velocity getVelocity() {
        return this.velocity;
    }

    /**
     * get the Gui.Game.GameEnvironment of ball.
     *
     * @return - Gui.Game.GameEnvironment
     */
    public GameEnvironment getGameEnvironment() {
        return this.gameE;
    }

    /**
     * Set the game environment.
     *
     * @param gameE1 - Gui.Game.GameEnvironment
     */
    public void setGameE(GameEnvironment gameE1) {
        this.gameE = gameE1;
    }

    /**
     * Set the paddle.
     *
     * @param paddle1 - Gui.Collision.Paddle
     */
    public void setPaddle(Paddle paddle1) {
        this.paddle = paddle1;
    }

    /**
     * This method check if the ball in the paddle.
     * @return - boolean
     */
    public boolean inPaddle() {
        if (this.center.getX() >= this.paddle.getCollisionRectangle().getUpperLeft().getX()
                && this.center.getX() <= this.paddle.getCollisionRectangle().getSidesOfRec()[3].end().getX()
                && this.center.getY() <= this.paddle.getCollisionRectangle().getSidesOfRec()[1].end().getY()
                && this.center.getY() >= this.paddle.getCollisionRectangle().getSidesOfRec()[0].end().getY()) {
            return true;
        }
        return false;
    }

    /**
     * The function moves the ball according to the speed,
     * and changes the direction when it reaches the frame limit.
     */
    public void moveOneStep() {
        // Check if ball is in the paddle, and move it in accordance
        if (this.inPaddle()) {
            this.center.setY(this.paddle.getCollisionRectangle().getUpperLeft().getY() - this.radius);
        }
        Line trajectory = new Line(this.center, this.getVelocity().applyToPoint(this.center));
        CollisionInfo c = this.gameE.getClosestCollision(trajectory);
        if (c == null) {
            this.center = this.getVelocity().applyToPoint(this.center);
        } else {
            double dirX = velocity.getDx() < 0 ? -1 : velocity.getDx() == 0 ? 0 : 1;
            double dirY = velocity.getDy() < 0 ? -1 : velocity.getDy() == 0 ? 0 : 1;
            // Put the ball right before the collision point
            center.setX(c.getCollisionPoint().getX() - dirX);
            center.setY(c.getCollisionPoint().getY() - dirY);
            Velocity newV = c.getCollisionObject().hit(this, c.getCollisionPoint(), this.getVelocity());
            this.setVelocity(newV);
        }
    }

    /**
     * Add this ball to the game.
     *
     * @param g - Gui.Game.Game
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }

}
