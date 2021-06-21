package bomberone.model.pathfinding.navigation;

import java.util.List;
import java.util.LinkedList;
import bomberone.model.common.Direction;
import bomberone.model.pathfinding.gameboard.BoardPoint;

public class NodeImpl implements Node {

    /* Fields. */
    private Node parent;
    private BoardPoint position;
    private Direction direction;

    /* Constructors. */
    public NodeImpl(final Direction directionToSet, final BoardPoint positionToSet, final Node nodeParent) {
        this.parent = nodeParent;
        this.position = positionToSet;
        this.direction = directionToSet;
    }

    /* Methods. */
    /**
     * {@inheritDoc}
     */
    public Direction getDirection() {
        return this.direction;
    }

    /**
     * {@inheritDoc}
     */
    public BoardPoint getPosition() {
        return this.position;
    }

    /**
     * {@inheritDoc}
     */
    public Node getParent() {
        return this.parent;
    }

    /**
     * {@inheritDoc}
     */
    public List<Direction> getPath() {
        if (this.parent == null) {
            return new LinkedList<Direction>();
        } else {
            List<Direction> path = this.parent.getPath();
            path.add(getDirection());
            return path;
        }
    }
}
