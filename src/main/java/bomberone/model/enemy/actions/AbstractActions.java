package bomberone.model.enemy.actions;

import bomberone.model.common.Direction;
import bomberone.model.enemy.Enemy;

public abstract class AbstractActions implements Actions {
    /* Fields. */
    protected Enemy selectedEnemy;
    
    /* Constructors. */
    public AbstractActions(final Enemy newEnemy) {
        this.selectedEnemy = newEnemy;
    }

    /* Methods. */
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
