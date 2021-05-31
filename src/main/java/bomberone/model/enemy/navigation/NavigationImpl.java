package bomberone.model.enemy.navigation;

import java.util.List;
import java.util.Iterator;
import java.util.LinkedList;
import bomberone.model.common.P2d;
import bomberone.model.common.Direction;
import bomberone.model.gameboard.BoardPoint;
import bomberone.model.gameboard.BoardPointImpl;
import bomberone.model.gameboard.GameBoard;

public class NavigationImpl implements Navigation {

    private List<BoardPoint> exploredNodes;
    private List<Node> discoveredNodes;

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

    private boolean explored(final BoardPoint pointToCheck) {
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

    @Override
    public void addTargets(final Node currentNode) {
        BoardPoint positionToCheck;
        BoardPoint position = currentNode.getPosition();

        for (Direction currentDirection : Direction.values()) {
            positionToCheck = this.getNeighbours(position, currentDirection);

            if (!this.explored(positionToCheck)) {
                if (GameBoard.getInstance().isAccessible(positionToCheck)) {
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
        BoardPoint playerLocation;
        List<Direction> path = new LinkedList<Direction>();
        
        // System.out.println("[Enemy] :" + GameBoard.getInstance().convertPosition(enemyLocation).toString() + "\t[Player] :" + GameBoard.getInstance().findPlayerLocation().toString());
        if (GameBoard.getInstance().findPlayerLocation().isEquals(new BoardPointImpl(7,8))) {
            System.out.print("");
        }
        this.discoveredNodes.add(new NodeImpl(null, GameBoard.getInstance().convertPosition(enemyLocation), null));
        while (!this.discoveredNodes.isEmpty()) {
            currentNode = this.discoveredNodes.remove(0);
            playerLocation = GameBoard.getInstance().findPlayerLocation();
            
            if (currentNode.getPosition().isEquals(playerLocation)) {
                System.out.print("");
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
