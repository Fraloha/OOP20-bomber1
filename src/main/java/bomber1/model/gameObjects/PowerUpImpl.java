package bomber1.model.gameObjects;

import java.awt.image.BufferedImage;

import bomber1.model.common.P2d;

public class PowerUpImpl extends GameObjectImpl implements PowerUp {

    private boolean released;
    private PowerUp.Type type;

    public PowerUpImpl(final P2d pos, final BufferedImage img, final int lifes, final boolean isBreakable, final PowerUp.Type type) {
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
    public bomber1.model.gameObjects.PowerUp.Type getType() {
        return this.type;
    }

}
