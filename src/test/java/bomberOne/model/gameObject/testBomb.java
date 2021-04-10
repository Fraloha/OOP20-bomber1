package bomberOne.model.gameObject;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import bomberOne.model.common.P2d;
import bomberOne.model.gameObjects.BombImpl;
import bomberOne.model.gameObjects.Explosion;
import bomberOne.tools.img.SpriteMapsObj;

/**
 * Tester for Bomb
 * @author Gustavo Mazzanti
 *
 */
public class testBomb {
	BombImpl bomb;
	Optional<Explosion> explosion;
	
	@BeforeEach
	public void init() {
		this.bomb = new BombImpl(new P2d(0, 0), SpriteMapsObj.BOMB.getImage(), 1, true, 3, false);
		this.explosion = Optional.empty();
	}
	
	@Test
	public void testOptionalExplosion() {
		assertTrue(this.bomb.getExplosion() == this.explosion);
		this.bomb.explode();
		assertFalse(this.bomb.getExplosion() == this.explosion);
		this.explosion = this.bomb.getExplosion();
		assertTrue(this.bomb.getExplosion() == this.explosion);
	}
	
	
}
