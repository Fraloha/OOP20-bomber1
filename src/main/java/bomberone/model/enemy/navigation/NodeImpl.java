package bomberone.model.enemy.navigation;

import java.util.LinkedList;
import bomberone.model.common.Direction;

/**
 * {@inheritDoc}
 */
public class NodeImpl implements Node {

    /* Fields. */
    private Node parent;
    private int[] position;
    private Direction direction;

    /* Constructors. */
    public NodeImpl(final Direction directionToSet, final int[] positionToSet, final Node nodeParent) {
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
    public int[] getPosition() {
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
    public LinkedList<Direction> getPath() {
        if (this.parent == null) {
            return new LinkedList<Direction>();
        } else {
            LinkedList<Direction> path = this.parent.getPath();
            path.add(getDirection());
            return path;
        }
    }
}