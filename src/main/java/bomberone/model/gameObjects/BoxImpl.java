package bomberone.model.gameObjects;

import java.util.Optional;

import bomberone.model.common.P2d;

/**
 * An implementation of Box.
 *
 */
public class BoxImpl extends GameObjectImpl implements Box {

    private Optional<PowerUp> powerUp;

    public BoxImpl(final P2d pos, final int lifes) {
        super(pos, lifes);
        this.powerUp = Optional.empty();
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
    public Optional<PowerUp> getPowerUp() {
        return (this.powerUp.equals(Optional.empty())) ? Optional.empty() : this.powerUp;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addPowerUp(final PowerUp pU) {
        this.powerUp = Optional.of(pU);
    }

    /**
     * If the box contains the PowerUp, release it.
     */
    @Override
    public void hitted() {
        if (!this.powerUp.isEmpty()) {
            this.powerUp.get().release();
        }
        super.hitted();
    }

}
