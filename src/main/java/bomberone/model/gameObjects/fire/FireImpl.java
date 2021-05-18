package bomberone.model.gameObjects.fire;


import bomberone.model.common.P2d;
import bomberone.model.gameObjects.GameObjectImpl;

/**
 * An implementation of Fire.
 *
 */
public class FireImpl extends GameObjectImpl implements Fire {

    /**
     * Constant to set life time of the Fire.
     */
    private static final int LIFE_TIME = 100;
    /**
     * Constant to set the fire animation.
     */
    private static final int ANIMATION_TIMER = 5;

    private int lifeTime;
    private int thick;
    private int animationThick = 0;
    private int animationIndex = 0;

    public FireImpl(final P2d pos, final int lifes) {
        super(pos, lifes);
        this.lifeTime = LIFE_TIME;
        this.thick = 0;
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

    /**
     * {@inheritDoc}
     */
    @Override
    public int getIndexAnimation() {
        return this.animationIndex;
    }

}
