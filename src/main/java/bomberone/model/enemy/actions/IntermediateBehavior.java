package bomberone.model.enemy.actions;

import java.util.Random;
import java.util.HashSet;
import java.util.LinkedList;
import bomberone.model.common.P2d;
import bomberone.model.enemy.EnemyImpl;
import bomberone.model.common.Direction;
import bomberone.model.enemy.navigation.Node;
import bomberone.model.enemy.navigation.NodeImpl;

public class IntermediateBehavior implements Actions {

    /* Fields. */
    private Random randomGenerator;
    private BasicBehavior basicActions;
    private EnemyImpl selectedEnemy;
    private LinkedList<Node> positionsToVisit;
    private HashSet<P2d> visitedPosition;

    /* Constructor. */
    public IntermediateBehavior(final EnemyImpl newEnemy) {
        this.selectedEnemy = newEnemy;
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

    }

    @Override
    public void nextMove() {
        // TODO Auto-generated method stub

    }

    private P2d doMovements(Direction direction) {
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

    private void addTargets(Node node) {
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
}