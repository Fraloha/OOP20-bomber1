package bomberone.model.gameObjects;

import java.awt.image.BufferedImage;

import bomberone.model.common.P2d;

public class PowerUpImpl extends GameObjectImpl implements PowerUp {

    private boolean released;
    private PowerUp.type type;

    public PowerUpImpl(final P2d pos, final BufferedImage img, final int lifes, final boolean isBreakable, final PowerUp.type type) {
        super(pos, img, lifes);
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
    public bomberone.model.gameObjects.PowerUp.type getType() {
        return this.type;
    }

}
