package bomberone.model.enemy.actions;

import bomberone.model.common.Direction;
import bomberone.model.enemy.Enemy;

public final class BasicBehavior extends AbstractActions {

    /* Fields. */
    /**
     * This constant is the number of frames that the enemy has to wait to change
     * his direction.
     */
    private static final int FRAMES_TO_CHANGE_DIRECTION = 120;
    private int nextDirectionCounter;

    /* Constructors. */
    public BasicBehavior(final Enemy enemy) {
        super(enemy);
        this.nextDirectionCounter = BasicBehavior.FRAMES_TO_CHANGE_DIRECTION;
    }

    /* Methods. */
    @Override
    public void doActions() {
        /* Variables declaration. */
        int newDirection;

        // Checking if the enemy has to change the direction.
        if (this.nextDirectionCounter == BasicBehavior.FRAMES_TO_CHANGE_DIRECTION) {
            // Generating a new random direction.
            do {
                newDirection = this.randomGenerator.nextInt(4);
            } while (newDirection == this.selectedEnemy.getDir().ordinal());

            // Setting the new direction.
            this.selectedEnemy.setDir(Direction.values()[newDirection]);
            this.selectedEnemy.setAnimationIndex(0);

            // Setting the sprite on the basis of the direction.
            this.setSprite();

            // Resetting the counter.
            this.nextDirectionCounter = 0;
        } else {
            this.manageAnimation();
        }
        this.nextDirectionCounter++;
        this.nextMove();
    }
}