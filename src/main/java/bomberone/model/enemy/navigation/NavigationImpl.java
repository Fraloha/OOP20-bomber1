package bomberone.model.enemy.navigation;

import java.util.Set;
import java.util.List;
import java.io.IOException;
import java.util.HashSet;
import java.util.LinkedList;
import bomberone.model.common.P2d;
import bomberone.model.common.Direction;
import bomberone.model.gameboard.GameBoard;
import bomberone.model.enemy.Log;

public class NavigationImpl implements Navigation {

    private List<int[]> exploredNodes;
    private List<Node> discoveredNodes;

    public NavigationImpl() {
        this.exploredNodes = new LinkedList<int[]>();
        this.discoveredNodes = new LinkedList<Node>();
    }

    private int[] getNeighbours(final int currentX, final int currentY, final Direction directionToCheck) {
        int newX = currentX;
        int newY = currentY;
        
        if (directionToCheck.equals(Direction.UP)) {
            newX--;
        } else if (directionToCheck.equals(Direction.DOWN)) {
            newX++;
        } else if (directionToCheck.equals(Direction.RIGHT)) {
            newY++;
        } else {
            newY--;
        }

        return new int[] { newX, newY };
    }

    @Override
    public void addTargets(Node currentNode) {
        int[] position;
        int[] positionToCheck;

        for (Direction currentDirection : Direction.values()) {
            position = currentNode.getPosition();
            positionToCheck = this.getNeighbours(position[0], position[1], currentDirection);

            if (!this.exploredNodes.contains(positionToCheck)) {
                if (GameBoard.getInstance().isAccessible(positionToCheck[0], positionToCheck[1])) {
                    this.discoveredNodes.add(new NodeImpl(currentDirection, positionToCheck, currentNode));
                }
            }
        }

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Direction> searchShortestPath(P2d enemyLocation) {
        /* Variables declaration. */
        GameBoard.getInstance().setMarkedBoard();
        List<Direction> path = new LinkedList<Direction>();
        boolean found = false;
        Node currentNode = null;
        int[] playerLocation;

        this.discoveredNodes.add(new NodeImpl(null, GameBoard.getInstance().convertLocation(enemyLocation), null));
        while (!this.discoveredNodes.isEmpty()) {
            currentNode = this.discoveredNodes.remove(0);
            playerLocation = GameBoard.getInstance().findPlayerLocation();
            
            System.out.println("\n\n\n\n\n\n\n\n\n");
            GameBoard.getInstance().setPlaceHolder(currentNode.getPosition()[0],
            currentNode.getPosition()[1]);
            GameBoard.getInstance().printMarkedBoard();
            System.out.print("\n\n\n\n\n\n\n\n\n\n");
            
            if (currentNode.getPosition().equals(playerLocation)) {
                Log.getInstance().getLog("Found a path", false);
                found = true;
                break;
            }

            this.exploredNodes.add(currentNode.getPosition());
            this.addTargets(currentNode);
        }

        if (found) {
            path = currentNode.getPath();
            this.discoveredNodes.clear();
            this.exploredNodes.clear();
        }

        return path;
    }
}
