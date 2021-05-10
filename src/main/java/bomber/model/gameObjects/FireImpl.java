package bomber.model.gameObjects;

import java.awt.image.BufferedImage;

import bomber.model.common.P2d;

/**
 * This class implements a simple Fire who extends a GameObject.
 *
 */
public class FireImpl extends GameObjectImpl implements Fire {

    private static final int LIFE_TIME = 100;
    private static final int ANIMATION_TIMER = 5;

    private int lifeTime;
    private int thick;
    private int animationThick = 0;
    private int animationIndex = 0;
    private BufferedImage[][] img;

    public FireImpl(final P2d pos, final BufferedImage[][] img, final int lifes) {
        super(pos, img[0][0], lifes);
        this.img = img;
        this.lifeTime = LIFE_TIME;
        this.thick = 0;
    }

    /**
     * @return the correct animation of the Fire
     */
    public BufferedImage getImage() {
        return this.img[0][animationIndex % 3];
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void update(final int elapsed) {
        /* Turn off the fire after a set Time */
        if (this.thick++ == this.lifeTime) {
            this.setAlive(false);
        }
        /* Update the animation of the Fire */
        if (this.animationThick++ == ANIMATION_TIMER) {
            this.animationIndex = (this.animationIndex + 1);
            this.animationThick = 0;
        }
    }

}
