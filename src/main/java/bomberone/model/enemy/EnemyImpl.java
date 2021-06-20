package bomberone.model.enemy;

import bomberone.model.common.P2d;
import bomberone.model.match.Difficulty;
import bomberone.model.enemy.actions.Actions;
import bomberone.model.enemy.actions.BasicBehavior;
import bomberone.model.enemy.actions.HardBehavior;
import bomberone.model.gameObjects.moveable.MoveableObjectImpl;

/**
 * This class represent an enemy. On the basis of the difficulty chosen by the
 * user, the enemy has a different behavior. (For further information about the
 * behavior see the documentation in the actions package.)
 */
public final class EnemyImpl extends MoveableObjectImpl implements Enemy {

    /* Fields. */
    private static final int NEXT_MOVE_FRAME_QUANTITY = 1;
    private static final int SECONDS_TO_WAIT = 4;
    private static final int FRAME_PER_SECOND = 60;
    private static final int LOW_SPEED = 300;
    private static final int HIGH_SPEED = 200;
    private Actions behavior;
    private int frameCounter;
    private int nextMoveFrameCounter;
    private int frameCounterAnimation;
    private boolean isHittable = false;

    /* Constructors. */
    public EnemyImpl(final P2d position, final int lifes, final Difficulty mode) {
        super(position, lifes);

        // Setting the number of frames that the enemy has to wait before start moving.
        this.frameCounter = SECONDS_TO_WAIT * FRAME_PER_SECOND;

        // Setting the frames number that the enemy has to wait to perform the next
        // move.
        this.nextMoveFrameCounter = NEXT_MOVE_FRAME_QUANTITY;

        // Creating the enemy behavior on the basis of the mode chosen by the user.
        if (mode.equals(Difficulty.EASY)) {
            this.behavior = new BasicBehavior(this);
            this.setSpeed(LOW_SPEED);
        } else if (mode.equals(Difficulty.HARD)) {
            this.behavior = new HardBehavior(this);
            this.setSpeed(HIGH_SPEED);
        }
    }

    /* Methods. */

    /**
     * {@inheritDoc}
     */
    public void update(final int elapsed) {
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
                this.behavior.doActions();
                super.update(elapsed);
            }
        }
    }

    public int getFrameCounterAnimation() {
        return this.frameCounterAnimation;
    }

    public void setFrameCounterAnimation(final int value) {
        this.frameCounterAnimation = value;
    }

    public boolean isHittable() {
        return this.isHittable;
    }
}
