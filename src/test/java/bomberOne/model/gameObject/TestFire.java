package bomberone.model.gameObject;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import bomberone.model.common.P2d;
import bomberone.model.gameObjects.FireImpl;
import bomberone.tools.img.AnimatedObjectsSprites;

public class TestFire {
	FireImpl fire;
	
	@BeforeEach
	public void init() {
		this.fire = new FireImpl(new P2d(0, 0), AnimatedObjectsSprites.EXPLOSION.getImage(), 1);
	}
	
	@Test
	public void testUpdate() {
		for(int c = 0 ; c<210 ;c++) {
			this.fire.update(0);
			assertTrue(this.fire.isAlive());
		}
		this.fire.update(0);
		assertFalse(this.fire.isAlive());
	}
	
	
}
