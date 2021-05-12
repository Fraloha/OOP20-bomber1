package bomberone.model.gameObjects;

import java.util.Optional;

import bomberone.model.common.P2d;
import bomberone.tools.audio.SoundsHandler;
import bomberone.tools.audio.GameSounds;

/**
 * This class implements a simple Bomb who extends a GameObject.
 *
 */
public class BombImpl extends GameObjectImpl implements Bomb {

    /**
     * Constant to set life time of the Bomb before the Explosion.
     */
    public static final int TIME_TO_EXPLODE = 200;
    /**
     * Constant to control the pulse animation.
     */
    private static final int ANIMATION_COUNTDOWN = 2;
    /**
     * Number of the pulse animations.
     */
    private static final int N_BOMB_ANIMATIONS = 15;

    private int thicks;
    private final int firePower;
    private final boolean pierced;
    private Optional<Explosion> explosion;
    private int indexAnimation = 0;
    private int animationTimer = 0;

    public BombImpl(final P2d pos, final int lifes, final int firePower,
            final boolean pierced) {
        super(pos, lifes);
        this.explosion = Optional.empty();
        this.firePower = firePower;
        this.pierced = pierced;
        this.thicks = 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Explosion explode() {
        Explosion boom = new ExplosionImpl(this.firePower, this.pierced, this.getPosition());
        this.explosion = Optional.of(boom);
        super.hitted();
        SoundsHandler.start(GameSounds.BOMB);
        return boom;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<Explosion> getExplosion() {
        return this.explosion;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getIndexAnimation() {
        return this.indexAnimation;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void update(final int elapsed) {
        if (this.thicks++ == TIME_TO_EXPLODE) {
            this.explode();
        }

        /* Bomb pulse animation */
        if (this.animationTimer++ == BombImpl.ANIMATION_COUNTDOWN) {
            this.animationTimer = 0;
            this.indexAnimation = (this.indexAnimation + 1) % N_BOMB_ANIMATIONS;
        }
    }

}
