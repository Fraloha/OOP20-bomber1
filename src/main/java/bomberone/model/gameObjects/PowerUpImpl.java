package bomberone.model.gameObjects;


import bomberone.model.common.P2d;

/**
 * An implementation of PowerUp.
 *
 */
public class PowerUpImpl extends GameObjectImpl implements PowerUp {

    private boolean released;
    private PowerUp.Type type;

    public PowerUpImpl(final P2d pos, final int lifes, final boolean isBreakable, final PowerUp.Type type) {
        super(pos, lifes);
        this.released = false;
        this.type = type;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isReleased() {
        return this.released;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void release() {
        this.released = true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void update(final int elapsed) {

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public bomberone.model.gameObjects.PowerUp.Type getType() {
        return this.type;
    }

}
