package bomberone.model.enemy.actions;

import java.util.Random;

import bomberone.model.common.Direction;
import bomberone.model.enemy.Enemy;
import bomberone.model.enemy.EnemyImpl;

public final class BasicBehavior extends AbstractActions {

    /* Fields. */

    /* Constructors. */
    public BasicBehavior(final Enemy enemy) {
        super(enemy);
        this.randomGenerator = new Random();
    }

    /* Methods. */
    public void doActions() {
        /* Variables declaration. */
        int newDirection;

        // Checking if the enemy has to change the direction.
        if (this.nextDirectionCounter == AbstractActions.FRAMES_TO_CHANGE_DIRECTION) {
            // Generating a new random direction.
            do {
                newDirection = this.randomGenerator.nextInt(4);
            } while (newDirection == this.selectedEnemy.getDir().ordinal());

            // Setting the new direction.
            this.selectedEnemy.setDir(Direction.values()[newDirection]);
            this.selectedEnemy.setAnimationIndex(0);

            // Setting the sprite on the basis of the direction.
            if (this.selectedEnemy.getDir() == Direction.UP) {
                this.selectedEnemy.setSpriteIndex(3);
            } else if (this.selectedEnemy.getDir() == Direction.LEFT) {
                this.selectedEnemy.setSpriteIndex(1);
            } else if (this.selectedEnemy.getDir() == Direction.RIGHT) {
                this.selectedEnemy.setSpriteIndex(2);
            } else {
                this.selectedEnemy.setSpriteIndex(0);
            }

            // Resetting the counter.
            this.nextDirectionCounter = 0;
        } else {
            if (this.selectedEnemy.getFrameCounterAnimation() == 10) {
                this.selectedEnemy.setFrameCounterAnimation(0);
                this.selectedEnemy.setAnimationIndex((this.selectedEnemy.getAnimationIndex() + 1));
            } else {
                this.selectedEnemy.setFrameCounterAnimation(this.selectedEnemy.getFrameCounterAnimation() + 1);
            }
        }
    }
}