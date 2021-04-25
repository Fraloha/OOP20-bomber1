package bomberOne.model.gameObjects;

import java.awt.image.BufferedImage;
import java.util.Optional;

import bomberOne.model.common.P2d;

/**
 * This class implements a simple Bomb who extends a GameObject.
 *
 */
public class BombImpl extends GameObjectImpl implements Bomb {

    /**
     * Constant TimeToExplode.
     */
    public static final int TIME_TO_EXPLODE = 270;

    private int timeToExplode;
    private int thicks;
    private final int firePower;
    private final boolean pierced;
    private Optional<Explosion> explosion;

    public BombImpl(final P2d pos, final BufferedImage img, final int lifes, final int firePower,
            final boolean pierced) {
        super(pos, img, lifes);
        this.explosion = Optional.empty();
        this.firePower = firePower;
        this.pierced = pierced;
        this.timeToExplode = this.TIME_TO_EXPLODE;
        this.thicks = 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Explosion explode() {
        Explosion boom = new ExplosionImpl(this.firePower, this.pierced, this.getPosition());
        this.explosion = Optional.of(boom);
        this.setLifes(this.getLifes() - 1);
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
    public void update(final int elapsed) {
        if (this.thicks++ == timeToExplode) {
            this.explode();
        }
        if (this.getLifes() == 0) {
            this.setAlive(false);
        }
    }

}
