package bomberOne.model.gameObject;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import bomberOne.model.common.P2d;
import bomberOne.model.gameObjects.ExplosionImpl;
/**
 * Tester for Explosion
 * @author Gustavo Mazzanti
 *
 */
public class TestExplosion {
	ExplosionImpl explosion;
	
	@BeforeEach
	public void init() {
		this.explosion = new ExplosionImpl(1, false, new P2d(0, 0));
	}
	
	@Test
	public void testFirePower() {
		assertTrue(this.explosion.getFirePower() ==  1);
	}
	
	@Test
	public void testPierced() {
		assertTrue(this.explosion.getPierce() == false);
	}
	
	@Test
	public void testPosition() {
		assertTrue(this.explosion.getCenter().equals(new P2d(0, 0)));
	}
}
