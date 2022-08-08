package gui.game;
// 208388140

import gui.Collision.Collidable;
import gui.Collision.CollisionInfo;
import gui.shapes.Line;
import gui.shapes.Point;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Dvir Landau
 * @version 1.00 17/04/2021
 */
public class GameEnvironment {
    private List<Collidable> collidables;

    /**
     * Instantiates a new Gui.Game.Game environment.
     */
    public GameEnvironment() {
        this.collidables = new ArrayList<Collidable>();
    }

    /**
     * Get the list of collidables.
     *
     * @return - List<Gui.Collision.Collidable>
     */
    public List<Collidable> getCollidables() {
        return collidables;
    }

    /**
     * add the given collidable to the environment.
     *
     * @param c the collidable
     */
    public void addCollidable(Collidable c) {
        this.collidables.add(c);
    }

    /**
     * Remove collidable.
     * @param c - Collidable
     */
    public void removeCollidable(Collidable c) {
        this.collidables.remove(c);
    }


    /**
     * Assume an object moving from line.start() to line.end().
     * If this object will not collide with any of the collidables
     * in this collection, return null. Else, return the information
     * about the closest collision that is going to occur.
     *
     * @param trajectory - Gui.Shapes.Line
     * @return - Gui.Collision.CollisionInfo
     */
    public CollisionInfo getClosestCollision(Line trajectory) {
        double min = trajectory.length() + 1;
        int index = -1;
        Point closetPoint;
        // If the list of collidables is empty
        if (this.collidables.isEmpty()) {
            return null;
        }
        //A loop that runs on the list and checks the point of collision closest to the starting point of the line
        for (int i = 0; i < collidables.size(); i++) {
            closetPoint = trajectory.closestIntersectionToStartOfLine(collidables.get(i).getCollisionRectangle());
            if (closetPoint != null) {
                double distance = trajectory.start().distance(closetPoint);
                // check if the new distance Smaller than the minimum
                if (distance <= min) {
                    min = distance;
                    index = i;
                }
            }
        }
        // If a point of intersection is found
        if (index != -1) {
            CollisionInfo c = new CollisionInfo(trajectory.closestIntersectionToStartOfLine(this.collidables.get(index)
                    .getCollisionRectangle()), this.collidables.get(index));
            return c;
        }
        return null;
    }
}
