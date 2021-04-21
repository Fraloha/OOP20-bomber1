package bomberOne.model.gameObjects;

import java.awt.image.BufferedImage;
import bomberOne.model.physics.BoundingBoxImpl;
import bomberOne.model.common.Direction;
import bomberOne.model.common.P2d;

public class AnimatedEntityImpl extends GameObjectImpl implements AnimatedEntity {

    private int elapsed;
    private Direction dir;
    private double speed;
    private boolean isStatic;
    private int spriteIndex; //0:UP 1:DOWN 2:LEFT 3:RIGHT 4:DEATH
    private int animationsIndex;
    private BufferedImage [][] sprites;

    public AnimatedEntityImpl(final P2d pos, final BufferedImage [][] img, final int lifes, final BufferedImage initialSprite) {
        super(pos, initialSprite, lifes);
        this.sprites = img;
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
        BoundingBoxImpl newBoundingBox = new BoundingBoxImpl(this.getPosition(), new P2d(this.getPosition().getX() + 32, this.getPosition().getY() + 32));
        this.setTimeElapsed(elapsed);
        this.setBoundingBox(newBoundingBox);
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
    public BufferedImage getImage() {
        return this.sprites[this.spriteIndex][this.animationsIndex];
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setSpriteIndex(final int index) {
        this.spriteIndex = index;
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
    public int getSpriteIndex() {
        return this.spriteIndex;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getAnimationIndex() {
        return this.animationsIndex;
    }
}
