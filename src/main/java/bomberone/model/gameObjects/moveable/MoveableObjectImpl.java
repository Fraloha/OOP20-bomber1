package bomberone.model.gameObjects.moveable;

import bomberone.model.common.Direction;
import bomberone.model.common.P2d;
import bomberone.model.gameObjects.GameObjectImpl;
import javafx.geometry.Rectangle2D;

/**
 * An implementation of AnimatedEntity.
 *
 */
public class MoveableObjectImpl extends GameObjectImpl implements MoveableObject {

    private static final double TIME_QUOTIENT = 5000.0;
    private int elapsed;
    private Direction dir;
    private double speed;
    private boolean isStatic;
    private int directionIndex; // 0:UP 1:DOWN 2:LEFT 3:RIGHT 4:DEATH
    private int animationsIndex;

    public MoveableObjectImpl(final P2d pos, final int lifes) {
        super(pos, lifes);
        this.dir = Direction.DOWN;
        this.isStatic = true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setTimeElapsed(final int elapsed) {
        this.elapsed = elapsed;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getTimeElapsed() {
        return this.elapsed;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setSpeed(final double speed) {
        this.speed = speed;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double getSpeed() {
        return this.speed;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void moveUp() {
        this.setPosition(new P2d(this.getPosition().getX(),
                this.getPosition().getY() - Math.round(this.speed * (elapsed / TIME_QUOTIENT))));
        this.setStatic(false);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void moveDown() {
        this.setPosition(new P2d(this.getPosition().getX(),
                this.getPosition().getY() + Math.round(this.speed * (elapsed / TIME_QUOTIENT))));
        this.setStatic(false);

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void moveLeft() {
        this.setPosition(new P2d(this.getPosition().getX() - Math.round(this.speed * (elapsed / TIME_QUOTIENT)),
                this.getPosition().getY()));
        this.setStatic(false);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void moveRight() {
        this.setPosition(new P2d(this.getPosition().getX() + Math.round(this.speed * (elapsed / TIME_QUOTIENT)),
                this.getPosition().getY()));
        this.setStatic(false);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setDir(final Direction dir) {
        this.dir = dir;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Direction getDir() {
        return this.dir;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void update(final int elapsed) {
        this.setCollider(new Rectangle2D(this.getPosition().getX(), this.getPosition().getY(), 32, 32));
        this.setTimeElapsed(elapsed);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isStatic() {
        return this.isStatic;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setStatic(final boolean value) {
        this.isStatic = value;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setDirectionIndex(final int index) {
        this.directionIndex = index;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setAnimationIndex(final int index) {
        this.animationsIndex = index;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getDirectionIndex() {
        return this.directionIndex;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getAnimationIndex() {
        return this.animationsIndex;
    }
}
