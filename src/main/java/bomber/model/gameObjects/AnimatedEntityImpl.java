package bomber.model.gameObjects;

import java.awt.image.BufferedImage;

import bomber.model.common.Direction;
import bomber.model.common.P2d;
import javafx.geometry.Rectangle2D;

public class AnimatedEntityImpl extends GameObjectImpl implements AnimatedEntity {

    private static final double TIME_QUOTIENT = 5000.0;
    private int elapsed;
    private Direction dir;
    private double speed;
    private boolean isStatic;
    private int spriteIndex; // 0:UP 1:DOWN 2:LEFT 3:RIGHT 4:DEATH
    private int animationsIndex;
    private BufferedImage[][] sprites;

    public AnimatedEntityImpl(final P2d pos, final BufferedImage[][] img, final int lifes,
            final BufferedImage initialSprite) {
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

    /**
     * {@inheritDoc}
     */
    public BufferedImage[][] getSprites() {
        return this.sprites;
    }
}
