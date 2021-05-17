package bomberone.model.enemy.actions;

import java.util.Random;

import bomberone.model.common.Direction;
import bomberone.model.enemy.Enemy;

public abstract class AbstractActions implements Actions {
    /* Fields. */
    /**
     * This constant is the number of frames that the enemy has to wait to change
     * his direction.
     */
    protected static final int FRAMES_TO_CHANGE_DIRECTION = 120;
    protected Enemy selectedEnemy;
    protected int nextDirectionCounter;
    protected Random randomGenerator;

    /* Constructors. */
    public AbstractActions(final Enemy newEnemy) {
        this.selectedEnemy = newEnemy;
        this.randomGenerator = new Random();
    }

    /* Methods. */
    
    private void manageSprite() {
        if (this.selectedEnemy.getFrameCounterAnimation() == 10) {
            this.selectedEnemy.setFrameCounterAnimation(0);
            this.selectedEnemy.setAnimationIndex(this.selectedEnemy.getAnimationIndex() + 1);
        } else {
            this.selectedEnemy.setFrameCounterAnimation(this.selectedEnemy.getFrameCounterAnimation() + 1);
        }
    }
    /**
     * {@inheritDoc}
     */
    public void doActions() {
        int newDirection;
        
        if (this.nextDirectionCounter == AbstractActions.FRAMES_TO_CHANGE_DIRECTION) {
            
        } else {
            
        }
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
