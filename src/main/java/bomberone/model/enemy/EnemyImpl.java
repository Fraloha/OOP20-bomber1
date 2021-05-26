package bomberone.model.enemy;

import bomberone.model.common.P2d;
import bomberone.model.enemy.actions.Actions;
import bomberone.model.enemy.actions.BasicBehavior;
import bomberone.model.enemy.actions.IntermediateBehavior;
import bomberone.model.gameObjects.moveable.MoveableObjectImpl;
import bomberone.model.match.Difficulty;

public final class EnemyImpl extends MoveableObjectImpl implements Enemy {

    /* Fields. */
    private static final int LOW_SPEED = 500;
    private static final int HIGH_SPEED = 600;
    private static final int SECONDS_TO_WAIT = 4;
    private static final int FRAME_PER_SECOND = 60;
    private static final int NEXT_MOVE_FRAME_QUANTITY = 1;
    private Actions behavior;
    private int frameCounter;
    private int nextMoveFrameCounter;
    private int frameCounterAnimation;
    private boolean isHittable = false;

    /* Constructors. */
    public EnemyImpl(final P2d position, final int lifes, Difficulty mode) {
        super(position, lifes);

        this.frameCounterAnimation = 0;

        // Setting the number of frames that the enemy has to wait before start moving.
        this.frameCounter = SECONDS_TO_WAIT * FRAME_PER_SECOND;

        // Setting the frames number that the enemy has to wait to perform the next
        // move.
        this.nextMoveFrameCounter = NEXT_MOVE_FRAME_QUANTITY;

        // Creating the enemy behavior on the basis of the mode chosen by the user.
        if (mode.equals(Difficulty.STANDARD)) {
            this.behavior = new BasicBehavior(this);
            this.setSpeed(LOW_SPEED);
        } else if (mode.equals(Difficulty.HARD)) {
            this.behavior = new IntermediateBehavior(this);
            this.setSpeed(HIGH_SPEED);
        }
    }

    /* Methods. */

    /**
     * {@inheritDoc}
     */
    public void update(int elapsed) {
        // The enemy before acts has to wait four second that are 240 frames.
        // Checking if the frame counter is greater than zero.
        if (this.frameCounter > 0) {
            this.frameCounter--;
        } else {
            if (!this.isHittable) {
                this.isHittable = true;
            }
            // The enemy has to wait some frames before the next move.
            if (++this.nextMoveFrameCounter >= NEXT_MOVE_FRAME_QUANTITY) {
                this.nextMoveFrameCounter = 0;

                // If the difficulty is hard the enemy has to keep track of the player.
                /*
                 * if (this.behavior.getClass() == IntermediateBehavior.class) {
                 * ((IntermediateBehavior) this.behavior).setPlayerPosition(playerPosition); }
                 */
                this.behavior.doActions();
                super.update(elapsed);
            }
        }
    }

    public int getFrameCounterAnimation() {
        return this.frameCounterAnimation;
    }

    public void setFrameCounterAnimation(int value) {
        this.frameCounterAnimation = value;
    }

    public boolean isHittable() {
        return this.isHittable;
    }
}