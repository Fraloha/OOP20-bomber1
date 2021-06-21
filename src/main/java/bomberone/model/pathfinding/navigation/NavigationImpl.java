package bomberone.model.pathfinding.navigation;

import java.util.List;
import java.util.Optional;
import java.util.Iterator;
import java.util.LinkedList;
import bomberone.model.common.P2d;
import bomberone.model.common.Direction;
import bomberone.model.pathfinding.gameboard.BoardPoint;
import bomberone.model.pathfinding.gameboard.BoardPointImpl;
import bomberone.model.bombergameboard.BomberOneBoard;

public class NavigationImpl implements Navigation {

    private List<BoardPoint> exploredNodes;
    private List<Node> discoveredNodes;

    /**
     * Creates a new Navigation object.
     */
    public NavigationImpl() {
        this.exploredNodes = new LinkedList<BoardPoint>();
        this.discoveredNodes = new LinkedList<Node>();
    }

    private BoardPoint getNeighbours(final BoardPoint currentPosition, final Direction directionToCheck) {
        int newX = currentPosition.getX();
        int newY = currentPosition.getY();

        if (directionToCheck.equals(Direction.UP)) {
            newX--;
        } else if (directionToCheck.equals(Direction.DOWN)) {
            newX++;
        } else if (directionToCheck.equals(Direction.RIGHT)) {
            newY++;
        } else {
            newY--;
        }

        return new BoardPointImpl(newX, newY);
    }

    /**
     * {@inheritDoc}
     */
    public boolean explored(final BoardPoint pointToCheck) {
        boolean result = false;
        Iterator<BoardPoint> iterator = this.exploredNodes.iterator();

        while (iterator.hasNext()) {
            BoardPoint currentPoint = iterator.next();
            if (pointToCheck.isEquals(currentPoint)) {
                result = true;
                break;
            }
        }

        return result;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addTargets(final Node currentNode) {
        BoardPoint positionToCheck;
        BoardPoint position = currentNode.getPosition();

        for (Direction currentDirection : Direction.values()) {
            positionToCheck = this.getNeighbours(position, currentDirection);

            if (!this.explored(positionToCheck)) {
                if (BomberOneBoard.getInstance().isAccessible(positionToCheck.getX(), position.getY())) {
                    this.discoveredNodes.add(new NodeImpl(currentDirection, positionToCheck, currentNode));
                }
            }
        }

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Direction> searchShortestPath(final P2d enemyLocation) {
        /* Variables declaration. */
        Node currentNode = null;
        Optional<BoardPoint> playerLocation;
        List<Direction> path = new LinkedList<Direction>();

        this.discoveredNodes.add(new NodeImpl(null, BomberOneBoard.getInstance().convertPosition(enemyLocation), null));
        while (!this.discoveredNodes.isEmpty()) {
            currentNode = this.discoveredNodes.remove(0);
            playerLocation = BomberOneBoard.getInstance().findSpotLocation();

            if (!playerLocation.isEmpty() && currentNode.getPosition().isEquals(playerLocation.get())) {
                path = currentNode.getPath();
                break;
            }

            this.exploredNodes.add(currentNode.getPosition());
            this.addTargets(currentNode);
        }
        this.discoveredNodes.clear();
        this.exploredNodes.clear();
        return path;
    }
}