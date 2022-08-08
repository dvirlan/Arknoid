// 208388140
package gui.Collision;
/**
 * @author Dvir Landau
 * @version 1.00 16/04/2021
 */
import gui.shapes.Point;

/**
 * CollisionInfo Class.
 */
public class CollisionInfo {
    private Point collisionPoint;
    private Collidable collisionObject;
    /**
     * This function updates the details of the collision info.
     * @param point  the point
     * @param object the object
     */
    public CollisionInfo(Point point, Collidable object) {
        this.collisionObject = object;
        this.collisionPoint = point;
    }
    /**
     * the point at which the collision occurs.
     * @return the point
     */
    public Point getCollisionPoint() {
        return this.collisionPoint;
    }
    /**
     * the collidable object involved in the collision.
     * @return the collidable
     */
    public Collidable getCollisionObject() {
        return this.collisionObject;
    }

    /**
     * Set the object.
     * @param collisionObj - Gui.Collision.Collidable
     */
    public void setCollisionObject(Collidable collisionObj) {
        this.collisionObject = collisionObj;
    }

    /**
     * Set the collision Gui.Shapes.Point.
     * @param collisionPo - Gui.Shapes.Point
     */
    public void setCollisionPoint(Point collisionPo) {
        this.collisionPoint = collisionPo;
    }
}
