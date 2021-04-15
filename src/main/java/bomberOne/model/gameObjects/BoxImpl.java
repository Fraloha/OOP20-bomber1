package bomberone.model.gameObjects;

import java.awt.image.BufferedImage;
import java.util.Optional;

import bomberone.model.common.P2d;

public final class BoxImpl extends GameObjectImpl implements Box {

    private Optional<PowerUp> powerUp;

    public BoxImpl(final P2d pos, final BufferedImage img, final int lifes) {
        super(pos, img, lifes);
        this.powerUp = Optional.empty();
    }

    @Override
    public void update(final int elapsed) {
    }

    @Override
    public Optional<PowerUp> getPowerUp() {
        return (this.powerUp.equals(Optional.empty())) ? Optional.empty() : this.powerUp;
    }

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
