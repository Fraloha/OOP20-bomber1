package bomberOne.model.gameObjects;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Optional;

import bomberOne.model.common.P2d;
import bomberOne.tools.audio.GameAudio;
import bomberOne.tools.audio.AudioHandler;

/**
 * This class implements a simple Bomb who extends a GameObject.
 *
 */
public class BombImpl extends GameObjectImpl implements Bomb {

    /**
     * Constant TimeToExplode.
     */
    public static final int TIME_TO_EXPLODE = 200;
    private static final int ANIMATION_COUNTDOWN = 2;
    private static final int N_BOMB_ANIMATIONS = 15;

    private int thicks;
    private final int firePower;
    private final boolean pierced;
    private Optional<Explosion> explosion;
    private BufferedImage[][] sprites;
    private int indexAnimation = 0;
    private int animationTimer = 0;
    //private AudioInputStream audio = GameAudio.BOMB.getAudio();
    //private Clip clip;

    public BombImpl(final P2d pos, final BufferedImage[][] img, final int lifes, final int firePower,
            final boolean pierced) {
        super(pos, img[0][0], lifes);
        this.sprites = img;
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
        AudioHandler.start(GameAudio.BOMB);
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
        if (this.thicks++ == TIME_TO_EXPLODE) {
            this.explode();
        }

        /* Bomb pulse animation */
        if (this.animationTimer++ == BombImpl.ANIMATION_COUNTDOWN) {
            this.animationTimer = 0;
            this.indexAnimation = (this.indexAnimation + 1) % N_BOMB_ANIMATIONS;
        }
    }

    /**
     * @return the correct animation of the bomb
     */
    @Override
    public BufferedImage getImage() {
        return this.sprites[0][this.indexAnimation];
    }

}
