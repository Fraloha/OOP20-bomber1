package bomberOne.model.gameObjects;

import java.awt.image.BufferedImage;

import bomberOne.model.common.P2d;

/**
 * This class implements a simple Fire who extends a GameObject.
 *
 */
public class FireImpl extends GameObjectImpl implements Fire {

    /**
     * Constant LifeTime.
     */
    public static final int LIFE_TIME = 210;

    private int lifeTime;
    private int thick;

    public FireImpl(final P2d pos, final BufferedImage img, final int lifes) {
        super(pos, img, lifes);
        this.lifeTime = this.LIFE_TIME;
        this.thick = 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void update(final int elapsed) {
        if (this.thick++ == this.lifeTime) {
            this.setAlive(false);
        }
    }

}
