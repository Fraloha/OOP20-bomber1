package bomberone.model.gameObject;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import bomberOne.model.common.P2d;
import bomberOne.model.factory.GameObjectFactoryImpl;
import bomberOne.model.gameObjects.FireImpl;
<<<<<<< HEAD
import bomberOne.tools.img.SpriteMapsObj;
/**
 * Tester for Fire
 * @author Gustavo Mazzanti
 *
 */
=======
import bomberOne.tools.img.AnimatedObjectsSprites;

>>>>>>> develop
public class TestFire {
	FireImpl fire;
	
	@BeforeEach
	public void init() {
<<<<<<< HEAD
		this.fire = (FireImpl) new GameObjectFactoryImpl().createFire(new P2d(10, 10));
=======
		this.fire = new FireImpl(new P2d(0, 0), AnimatedObjectsSprites.EXPLOSION.getImage(), 1);
>>>>>>> develop
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
