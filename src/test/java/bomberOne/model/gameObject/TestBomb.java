package bomberOne.model.gameObject;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import bomberOne.model.common.P2d;
import bomberOne.model.gameObjects.BombImpl;
import bomberOne.model.gameObjects.Explosion;
import bomberOne.tools.img.AnimatedObjectsSprites;

/**
 * Tester for Bomb
 * @author Gustavo Mazzanti
 *
 */
public class TestBomb {
	BombImpl bomb;
	Optional<Explosion> explosion;
	
	@BeforeEach
	public void init() {
		this.bomb = new BombImpl(new P2d(0, 0), AnimatedObjectsSprites.BOMB.getImage(), 1, 3, false);
	}
	
	@Test
	public void testOptionalExplosion() {
		this.explosion = Optional.empty();
		assertTrue(this.bomb.getExplosion() == this.explosion);
		this.explosion = Optional.of(this.bomb.explode());
		assertTrue(this.bomb.getExplosion().equals(this.explosion));
	}
	
	
}
