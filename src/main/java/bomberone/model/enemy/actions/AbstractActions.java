package bomberone.model.enemy.actions;

import bomberone.model.enemy.Enemy;
import bomberone.model.common.Direction;

/**
 * This class defines a basic design and implementation of all the enemies
 * behavior.
 */
public abstract class AbstractActions implements Actions {

    /* Fields. */

    /**
     * The enemy object that uses an instance of AbstractActions.
     */
    private Enemy selectedEnemy;

    /* Constructors. */
    public AbstractActions(final Enemy newEnemy) {
        this.selectedEnemy = newEnemy;
    }

    /* Methods. */

    /**
     * {@inheritDoc}
     */
    @Override
    public void setEnemy(final Enemy newEnemy) {
        this.selectedEnemy = newEnemy;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Enemy getEnemy() {
        return this.selectedEnemy;
    }

    /**
     * {@inheritDoc}
     */
    public void doActions() {

    }

    /**
     * {@inheritDoc}
     */
    public void nextMove() {
        Direction currentDirection = this.selectedEnemy.getDir();
        if (currentDirection.equals(Direction.UP)) {
            this.selectedEnemy.moveUp();
        } else if (currentDirection.equals(Direction.DOWN)) {
            this.selectedEnemy.moveDown();
        } else if (currentDirection.equals(Direction.RIGHT)) {
            this.selectedEnemy.moveRight();
        } else {
            this.selectedEnemy.moveLeft();
        }
    }
}
