package bomberone.model.enemy.navigation;

import java.util.LinkedList;
import bomberone.model.common.P2d;
import bomberone.model.enemy.Enemy;
import bomberone.model.common.Direction;

/**
 * This interface defines a point in the game map where an enemy can pass through or
 * has passed.
 * 
 * This type of object is fundamental in the shortest path calculation algorithm, that is a
 * Breadth-First Search (BFS) algorithm, to reach the player.
 * 
 * In summary, the Node object is used in the process of building a tree or a graph, where
 * the BFS will be performed.
 * (see Navigation object documentation to learn more.)
 */
public interface Node {

    /* Methods. */

    /**
     * This method return the direction in which the node can be traversed or
     * in which it was traversed.
     * @return the direction of the node.
     */
    Direction getDirection();
    
    /**
     * The actual position of the node.
     * @return the coordinates of the node.
     */
    P2d getPosition();
    
    /**
     * This method returns the parent of this node.
     * @return the parent of the node.
     */
    Node getParent();
    
    /**
     * This method returns a list of directions that the enemy has to follow
     * to reach the player.
     * @return a List of Direction.
     */
    LinkedList<Direction> getPath();
    
    /**
     * This method checks if the enemy can pass through the position of this node or not.
     * The enemy can not pass through this position if a box or a hard wall is in the same position.
     * @param enemy The enemy that tries to pass in the current position.
     * @return true if is accessible or false if it is not.
     */
    boolean isAccessible(Enemy enemy);
}
