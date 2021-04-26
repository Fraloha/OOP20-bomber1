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
    public static final int LIFE_TIME = 100;

    private int lifeTime;
    private int thick;
    private int animationIndex = 0;
    private BufferedImage [][] img;

    public FireImpl(final P2d pos, final BufferedImage [][] img, final int lifes) {
        super(pos, img[0][0], lifes);
        this.img = img;
        this.lifeTime = LIFE_TIME;
        this.thick = 0;
    }

    /**
     * @return the correct animation of the Fire
     */
    public BufferedImage getImage() {
        return this.img[0][animationIndex];
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
