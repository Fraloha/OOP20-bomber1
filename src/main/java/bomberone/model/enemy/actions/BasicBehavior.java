package bomberone.model.enemy.actions;

import java.util.Random;

import bomberone.model.common.Direction;
import bomberone.model.enemy.Enemy;

public final class BasicBehavior extends AbstractActions {

    /* Fields. */
    /**
     * This constant is the number of frames that the enemy has to wait to change
     * his direction.
     */
    private static final int FRAMES_TO_CHANGE_DIRECTION = 120;
    private Random randomGenerator;
    private int nextDirectionCounter;

    /* Constructors. */
    public BasicBehavior(final Enemy enemy) {
        super(enemy);
        this.randomGenerator = new Random();
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
            } while (newDirection == this.getEnemy().getDir().ordinal());

            // Setting the new direction.
            Direction newDir = Direction.values()[newDirection];
            this.getEnemy().setDir(newDir);
            this.getEnemy().setSprite();
            // Resetting the counter.
            this.nextDirectionCounter = 0;
        }

        this.getEnemy().setAnimation();
        this.nextDirectionCounter++;
        this.nextMove();
    }
}
