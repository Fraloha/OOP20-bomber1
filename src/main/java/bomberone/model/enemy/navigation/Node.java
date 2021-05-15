package bomberone.model.enemy.navigation;

import java.util.List;
import bomberone.model.common.P2d;
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
    List<Direction> getPath();
}
