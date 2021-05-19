package bomberone.model.gameObjects;

import bomberone.model.common.P2d;
import javafx.geometry.Rectangle2D;

/**
 * An implementation of GameObject.
 *
 */
public abstract class GameObjectImpl implements GameObject {

    private static final int RECTDIMENTIONS = 32;

    private P2d position;
    private Rectangle2D collider;
    private int lifes;
    private boolean isAlive;

    public GameObjectImpl(final P2d pos, final int lifes) {
        this.position = pos;
        this.lifes = lifes;
        this.isAlive = true;
        this.collider = new Rectangle2D(this.position.getX(), this.position.getY(), RECTDIMENTIONS, RECTDIMENTIONS);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public P2d getPosition() {
        return this.position;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Rectangle2D getCollider() {
        return this.collider;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getLifes() {
        return this.lifes;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isAlive() {
        return this.isAlive;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void hitted() {
        this.lifes--;
        if (this.getLifes() == 0) {
            this.isAlive = false;
        }
    }

    /**
     * {@inheritDoc}
     */
    public void setPosition(final P2d position) {
        this.position = position;
    }

    /**
     * {@inheritDoc}
     */
    public void setCollider(final Rectangle2D collider) {
        this.collider = collider;
    }

    /**
     * {@inheritDoc}
     */
    public void setLifes(final int lifes) {
        this.lifes = lifes;
    }

    /**
     * {@inheritDoc}
     */
    public void setAlive(final boolean isAlive) {
        this.isAlive = isAlive;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public abstract void update(int elapsed);

}
