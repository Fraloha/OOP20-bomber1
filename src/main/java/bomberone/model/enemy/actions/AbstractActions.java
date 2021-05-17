package bomberone.model.enemy.actions;

import java.util.Random;

import bomberone.model.common.Direction;
import bomberone.model.enemy.Enemy;

public abstract class AbstractActions implements Actions {
    /* Fields. */
    protected Enemy selectedEnemy;
    protected Random randomGenerator;

    /* Constructors. */
    public AbstractActions(final Enemy newEnemy) {
        this.selectedEnemy = newEnemy;
        this.randomGenerator = new Random();
    }

    /* Methods. */
    public void manageAnimation() {
        if (this.selectedEnemy.getFrameCounterAnimation() == 10) {
            this.selectedEnemy.setFrameCounterAnimation(0);
            this.selectedEnemy.setAnimationIndex(this.selectedEnemy.getAnimationIndex() + 1);
        } else {
            this.selectedEnemy.setFrameCounterAnimation(this.selectedEnemy.getFrameCounterAnimation() + 1);
        }
    }
    
    public void setSprite() {
        if (this.selectedEnemy.getDir() == Direction.UP) {
            this.selectedEnemy.setSpriteIndex(3);
        } else if (this.selectedEnemy.getDir() == Direction.RIGHT) {
            this.selectedEnemy.setSpriteIndex(2);
        } else if (this.selectedEnemy.getDir() == Direction.LEFT) {
            this.selectedEnemy.setSpriteIndex(1);
        } else {
            this.selectedEnemy.setSpriteIndex(0);
        }
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
