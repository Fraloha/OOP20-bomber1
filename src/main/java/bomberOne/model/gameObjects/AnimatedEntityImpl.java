package bomberone.model.gameObjects;

import java.awt.image.BufferedImage;

import bomberone.model.common.Direction;
import bomberone.model.common.P2d;

public class AnimatedEntityImpl extends GameObjectImpl implements AnimatedEntity {

    private int elapsed;
    private Direction dir;
    private double speed;
    private boolean isStatic;

    public AnimatedEntityImpl(final P2d pos, final BufferedImage img, final int lifes) {
        super(pos, img, lifes);
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
        this.getPosition().update(elapsed, 0, (-this.speed));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void moveDown() {
        this.getPosition().update(elapsed, 0, this.speed);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void moveLeft() {
        this.getPosition().update(elapsed, (-this.speed), 0);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void moveRight() {
        this.getPosition().update(elapsed, this.speed, 0);
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
}
