package bomberone.model.enemy.navigation;

import java.util.LinkedList;
import java.util.List;

import bomberone.model.common.Direction;
import bomberone.model.common.P2d;
import bomberone.model.gameboard.GameBoard;

public class NavigationImpl implements Navigation {

    List<P2d> visitedPosition;
    List<Node> positionsToVisit;

    /* Constructors. */
    public NavigationImpl() {
        this.visitedPosition = new LinkedList<P2d>();
        this.positionsToVisit = new LinkedList<Node>();
    }

    public int[] getNeighbours(int currentX, int currentY, Direction directionToCheck) {
        if (directionToCheck.equals(Direction.UP)) {
            currentY++;
        } else if (directionToCheck.equals(Direction.DOWN)) {
            currentY--;
        } else if (directionToCheck.equals(Direction.RIGHT)) {
            currentX++;
        } else if (directionToCheck.equals(Direction.LEFT)) {
            currentX--;
        }

        return new int[] { currentX, currentY };
    }

    @Override
    public void addTargets(Node currentNode) {
        int[] positionToCheck = new int[2];

        for (Direction currentDirection : Direction.values()) {
            P2d position = currentNode.getPosition();
            positionToCheck = this.getNeighbours((int) position.getX() / 32, (int) position.getY() / 32, currentDirection);
            P2d newPosition = new P2d(positionToCheck[0] * 32, positionToCheck[1] * 32);

            if (!this.visitedPosition.contains(newPosition)) {
                if (GameBoard.getInstance().isAccessible(positionToCheck[0], positionToCheck[1])) {
                    this.positionsToVisit.add(new NodeImpl(currentDirection, newPosition, currentNode));
                }
            }
        }

    }

    @Override
    public List<Direction> searchShortestPath(P2d enemyLocation) {
        List<Direction> path = new LinkedList<Direction>();

        this.positionsToVisit.add(new NodeImpl(null, enemyLocation, null));
        while (!this.positionsToVisit.isEmpty()) {
            Node currentNode = this.positionsToVisit.remove(0);
            int[] playerLocation = GameBoard.getInstance().findPlayerLocation();

            if (currentNode.getPosition().equals(new P2d(playerLocation[0] * 32, playerLocation[1] * 32))) {
                return currentNode.getPath();
            }

            this.visitedPosition.add(currentNode.getPosition());
            this.addTargets(currentNode);
        }

        return path;
    }
}
