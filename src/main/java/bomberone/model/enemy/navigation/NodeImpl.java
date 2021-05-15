package bomberone.model.enemy.navigation;

import java.util.LinkedList;
import java.util.List;

import bomberone.model.common.Direction;
import bomberone.model.common.P2d;

/**
 * {@inheritDoc}
 */
public class NodeImpl implements Node{

    /* Fields. */
    private Direction direction;
    private P2d position;
    private Node parent;
    
    /* Constructors. */
    public NodeImpl(final Direction directionToSet, final P2d positionToSet, final Node nodeParent) {
        this.direction = directionToSet;
        this.position = positionToSet;
        this.parent = nodeParent;
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
    public P2d getPosition() {
        return this.position;
    }
    
    /**
     * {@inheritDoc}
     */
    public Node getParent() {
        return this.parent;
    }
    
    public LinkedList<Direction> getPath(){
        if (this.parent == null) {
            return new LinkedList<Direction>();
        } else {
            LinkedList<Direction> path = this.parent.getPath();
            path.add(getDirection());
            return path;
        }
    }
}
