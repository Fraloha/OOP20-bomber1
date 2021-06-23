package bomberone.model.pathfinding;

import java.util.List;
import java.util.Optional;
import java.util.Iterator;
import java.util.LinkedList;
import bomberone.model.common.Direction;
import bomberone.model.pathfinding.gameboard.BoardPoint;
import bomberone.model.pathfinding.navigation.Node;
import bomberone.model.pathfinding.navigation.NodeImpl;
import bomberone.model.pathfinding.navigation.PathFinder;
import bomberone.model.bombergameboard.BomberOneBoard;

public final class BFSSearch implements PathFinder {

    private List<BoardPoint> exploredNodes;
    private List<Node> discoveredNodes;

    /**
     * Creates a new BFSSearch object.
     */
    public BFSSearch() {
        this.exploredNodes = new LinkedList<BoardPoint>();
        this.discoveredNodes = new LinkedList<Node>();
    }

    /**
     * This method gets the neighbor BoardPoint at the specified direction
     * 
     * @param currentPosition  A BoardPoint object.
     * @param directionToCheck The direction that specify the neighbor.
     * @return A BoardPoint object at the specified direction.
     */
    private Optional<BoardPoint> getNeighbors(final BoardPoint currentPosition, final Direction directionToCheck) {
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

        return BomberOneBoard.getInstance().getItem(newX, newY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
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
        Optional<BoardPoint> positionToCheck;
        BoardPoint position = currentNode.getPosition();

        for (Direction currentDirection : Direction.values()) {
            positionToCheck = this.getNeighbors(position, currentDirection);

            if (!positionToCheck.isEmpty()) {
                if (!this.explored(positionToCheck.get())) {
                    if (BomberOneBoard.getInstance().isAccessible(positionToCheck.get().getX(), position.getY())) {
                        this.discoveredNodes.add(new NodeImpl(currentDirection, positionToCheck.get(), currentNode));
                    }
                }
            }
        }

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Direction> searchPath(final BoardPoint enemyLocation) {
        /* Variables declaration. */
        Node currentNode = null;
        Optional<BoardPoint> playerLocation;
        List<Direction> path = new LinkedList<Direction>();

        this.discoveredNodes.add(new NodeImpl(null, enemyLocation, null));
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
