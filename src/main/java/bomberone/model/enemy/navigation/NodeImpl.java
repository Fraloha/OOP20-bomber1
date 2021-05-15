package bomberone.model.enemy.navigation;

import java.util.LinkedList;
import bomberone.model.common.P2d;
import bomberone.model.enemy.Enemy;
import bomberone.model.gameObjects.BoxImpl;
import bomberone.model.gameObjects.HardWall;
import bomberone.model.common.Direction;

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
    
    /**
     * {@inheritDoc}
     */
    public LinkedList<Direction> getPath(){
        if (this.parent == null) {
            return new LinkedList<Direction>();
        } else {
            LinkedList<Direction> path = this.parent.getPath();
            path.add(getDirection());
            return path;
        }
    }
    
    /**
     * {@inheritDoc}
     */
    public boolean isAccessible(final Enemy enemy) {
        boolean result = false;
        for (BoxImpl currentBox : enemy.getBoxes()) {
            result = currentBox.getCollider().intersects(enemy.getCollider()) ? true : false;
        }
        
        for (HardWall currentWall : enemy.getHardWalls()) {
            result = currentWall.getCollider().intersects(enemy.getCollider()) ? true : false;
        }
        return result;
    }
}