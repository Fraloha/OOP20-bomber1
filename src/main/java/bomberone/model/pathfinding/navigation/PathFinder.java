package bomberone.model.pathfinding.navigation;

import java.util.List;
import bomberone.model.common.Direction;
import bomberone.model.pathfinding.gameboard.BoardPoint;

/**
 * This interface defines a generic path finding algorithm.
 */
public interface PathFinder {

    /**
     * This method checks if the BoardPoint object passed as argument was already
     * explored.
     * 
     * @param pointToCheck The point to check.
     * @return true if the point was already explored, otherwise false.
     */
    boolean explored(BoardPoint pointToCheck);

    /**
     * This method adds new positions to check in the search algorithm. In
     * particular, this method builds the tree or graph, where the searching
     * algorithm can be performed.
     * 
     * @param currentNode The node from which the neighbors are searched.
     */
    void addTargets(Node currentNode);

    /**
     * This method search the path to reach the player.
     * 
     * @param enemyLocation The initial enemy's position.
     * @return A list of directions that defines the path.
     */
    List<Direction> searchPath(BoardPoint enemyLocation);
}
