package bomberone.model.enemy;

import bomberone.model.bombergameboard.BomberOneBoard;
import bomberone.model.common.Direction;
import bomberone.model.common.P2d;
import bomberone.model.match.Difficulty;
import bomberone.model.pathfinding.BFSSearch;
import bomberone.model.pathfinding.gameboard.BoardPoint;
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
    /**
     * This constant is the amount of frames to wait until the next animation. This
     * constant makes the animation as smooth as possible.
     */
    private static final int ANIMATION_FRAME_QUANTITY = 10;

    /**
     * This constant is the amount of frames to wait until the next enemy movement
     * can be executed.
     */
    private static final int NEXT_MOVE_FRAME_QUANTITY = 1;

    /**
     * This constant is the amount of seconds to wait until the enemy can start
     * moving.
     */
    private static final int SECONDS_TO_WAIT = 4;

    /**
     * This constant is the number of frames per second.
     */
    private static final int FRAME_PER_SECOND = 60;

    /**
     * This constant is the enemy speed in the easy mode.
     */
    private static final int LOW_SPEED = 300;

    /**
     * This constant is the enemy speed in the hard mode.
     */
    private static final int HIGH_SPEED = 200;

    private Difficulty mode;
    private Actions behavior;
    private int frameCounter;
    private int animationCounter;
    private int nextMoveFrameCounter;
    private boolean isHittable = false;
    private boolean playerFound = false;

    /* Constructors. */
    public EnemyImpl(final P2d position, final int lifes, final Difficulty gameMode) {
        super(position, lifes);

        // Setting the number of frames that the enemy has to wait before start moving.
        this.frameCounter = SECONDS_TO_WAIT * FRAME_PER_SECOND;

        // Setting the frames number that the enemy has to wait to perform the next
        // move.
        this.nextMoveFrameCounter = NEXT_MOVE_FRAME_QUANTITY;

        if (gameMode.equals(Difficulty.EASY)) {
            this.setSpeed(LOW_SPEED);
        } else {
            this.setSpeed(HIGH_SPEED);
        }
        this.mode = gameMode;
        this.animationCounter = 0;
        this.behavior = new BasicBehavior(this);
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
                if (this.mode.equals(Difficulty.HARD)) {
                    if (playerFound && this.behavior.getClass() == BasicBehavior.class) {
                        this.behavior = new HardBehavior(this, new BFSSearch(BomberOneBoard.getInstance()));
                    } else {
                        BoardPoint enemyPosition = BomberOneBoard.getInstance().convertPosition(this.getPosition());
                        playerFound = BomberOneBoard.getInstance().isSpotVisible(enemyPosition.getX(),
                                enemyPosition.getY());
                    }
                }
                this.nextMoveFrameCounter = 0;
                this.behavior.doActions();
                super.update(elapsed);
            }
        }
    }

    public boolean isHittable() {
        return this.isHittable;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setSprite() {
        if (this.getDir() == Direction.UP) {
            this.setDirectionIndex(3);
        } else if (this.getDir() == Direction.RIGHT) {
            this.setDirectionIndex(2);
        } else if (this.getDir() == Direction.LEFT) {
            this.setDirectionIndex(1);
        } else {
            this.setDirectionIndex(0);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setAnimation() {
        if (this.animationCounter == EnemyImpl.ANIMATION_FRAME_QUANTITY) {
            this.animationCounter = 0;
            this.setAnimationIndex(this.getAnimationIndex() + 1);
        } else {
            this.animationCounter++;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void manageAnimations() {
        this.setSprite();
        this.setAnimation();
    }
}
