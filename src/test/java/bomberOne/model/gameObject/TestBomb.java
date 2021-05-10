package bomberOne.model.gameObject;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import bomberone.model.common.P2d;
import bomberone.model.factory.GameObjectFactoryImpl;
import bomberone.model.gameObjects.BombImpl;
import bomberone.model.gameObjects.Explosion;

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
        this.bomb = (BombImpl) new GameObjectFactoryImpl().createBomb(new P2d(0, 0), 1, false);
    }

    @Test
    public void testOptionalExplosion() {
        this.explosion = Optional.empty();
        assertTrue(this.bomb.getExplosion().equals(this.explosion));
        this.explosion = Optional.of(this.bomb.explode());
        assertTrue(this.bomb.getExplosion().equals(this.explosion));
    }

    @Test
    public void testUpdate() {
        for (int c = 0; c < bomb.TIME_TO_EXPLODE; c++) {
            this.bomb.update(0);
        }
        assertTrue(this.bomb.isAlive());
        assertTrue(this.bomb.getExplosion().equals(Optional.empty()));
        this.bomb.update(0);
        assertFalse(this.bomb.isAlive());
        assertFalse(this.bomb.getExplosion().equals(Optional.empty()));
    }
}
