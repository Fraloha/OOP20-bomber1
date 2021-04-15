package bomberone.model.gameObject;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import bomberone.model.common.P2d;
import bomberone.model.gameObjects.BombImpl;
import bomberone.model.gameObjects.Explosion;
import bomberone.tools.img.ObjectsImages;

/**
 * Tester for Bomb.
 *
 */
public class TestBomb {
    private BombImpl bomb;
    private Optional<Explosion> explosion;

    /**
     * 
     */
    @BeforeEach
    public void init() {
        this.bomb = new BombImpl(new P2d(0, 0), ObjectsImages.BOMB.getImage(), 1, 3, false);
    }

    @Test
    public void testOptionalExplosion() {
        this.explosion = Optional.empty();
        assertTrue(this.bomb.getExplosion() == this.explosion);
        this.explosion = Optional.of(this.bomb.explode());
        assertTrue(this.bomb.getExplosion().equals(this.explosion));
    }
}
