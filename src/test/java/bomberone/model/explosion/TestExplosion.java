package bomberone.model.explosion;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import bomberone.model.common.P2d;
import bomberone.model.gameObjects.ExplosionImpl;

/**
 * Tester for Explosion.
 *
 */
public class TestExplosion {
    private ExplosionImpl explosion1;
    private ExplosionImpl explosion2;
    private ExplosionImpl explosion3;

    /**
     * 
     */
    @BeforeEach
    public void init() {
        this.explosion1 = new ExplosionImpl(1, false, new P2d(0, 0));
        this.explosion2 = new ExplosionImpl(10, true, new P2d(1, 0));
        this.explosion3 = new ExplosionImpl(100, true, new P2d(1, 1));
    }

    @Test
    public void testFirePower() {
        assertTrue(this.explosion1.getFirePower() == 1);
        assertTrue(this.explosion2.getFirePower() == 10);
        assertTrue(this.explosion3.getFirePower() == 100);
    }

    @Test
    public void testPierced() {
        assertFalse(this.explosion1.getPierce());
        assertTrue(this.explosion2.getPierce());
        assertTrue(this.explosion3.getPierce());
    }

    @Test
    public void testPosition() {
        assertTrue(this.explosion1.getCenter().equals(new P2d(0, 0)));
        assertTrue(this.explosion2.getCenter().equals(new P2d(1, 0)));
        assertTrue(this.explosion3.getCenter().equals(new P2d(1, 1)));
    }
}
