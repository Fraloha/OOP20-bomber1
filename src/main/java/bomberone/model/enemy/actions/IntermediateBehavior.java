package bomberone.model.enemy.actions;

import java.util.Random;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

import bomberone.model.common.P2d;
import bomberone.model.enemy.EnemyImpl;
import bomberone.model.common.Direction;
import bomberone.model.enemy.navigation.Node;
import bomberone.model.enemy.navigation.NodeImpl;

public class IntermediateBehavior implements Actions {

    /* Fields. */
    private P2d playerPosition;
    private Random randomGenerator;
    private EnemyImpl selectedEnemy;
    private BasicBehavior basicActions;
    private HashSet<P2d> visitedPosition;
    private LinkedList<Node> positionsToVisit;

    /* Constructor. */
    public IntermediateBehavior(final EnemyImpl newEnemy, final P2d playerPos) {
        this.selectedEnemy = newEnemy;
        this.playerPosition = playerPos;
        this.randomGenerator = new Random();
        this.positionsToVisit = new LinkedList<Node>();
        this.visitedPosition = new HashSet<P2d>();
        this.basicActions = new BasicBehavior(this.selectedEnemy);
    }

    /* Methods. */

    /**
     * {@inheritDoc}
     */
    @Override
    public void doActions() {
        P2d actualPosition = this.selectedEnemy.getPosition();
        this.shortestPath(actualPosition, this.selectedEnemy.get)
    }

    @Override
    public void nextMove() {
        
    }
    
    public void setPlayerPosition(final P2d playerPos) {
        this.playerPosition = playerPos;
    }

    private P2d doMovements(final Direction direction) {
        if (direction.equals(Direction.UP)) {
            this.selectedEnemy.moveUp();
        } else if (direction.equals(Direction.DOWN)) {
            this.selectedEnemy.moveDown();
        } else if (direction.equals(Direction.RIGHT)) {
            this.selectedEnemy.moveRight();
        } else {
            this.selectedEnemy.moveLeft();
        }

        return this.selectedEnemy.getPosition();
    }

    private void addTargets(final Node node) {
        /* Variables declaration. */
        P2d currentInitialPosition = this.selectedEnemy.getPosition();
        P2d positionToCheck;

        for (Direction currentDirection : Direction.values()) {
            positionToCheck = this.doMovements(currentDirection);
            
            if (!this.visitedPosition.contains(positionToCheck) && 
                    node.isAccessible(this.selectedEnemy)) {
                this.positionsToVisit.add(new NodeImpl(currentDirection, positionToCheck, node));
            }
        }
        this.selectedEnemy.setPosition(currentInitialPosition);
    }
    
    private List<Direction> shortestPath(final P2d initialPosition, final P2d destination) {
        /* Variables declaration. */
        List<Direction> path = null;
        
        // Setting the initial node.
        this.positionsToVisit.add(new NodeImpl(null, initialPosition, null));
        
        while(!this.positionsToVisit.isEmpty()) {
            Node currentNode = this.positionsToVisit.remove();
            if (currentNode.getPosition().equals(destination)) {
                path = currentNode.getPath();
            }
            this.visitedPosition.add(currentNode.getPosition());
            this.addTargets(currentNode);
        }
        return path;
    }
}