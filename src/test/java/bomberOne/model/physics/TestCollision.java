package bomberOne.model.physics;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import bomberone.model.common.P2d;
import bomberone.model.physics.BoundingBox;
import bomberone.model.physics.BoundingBoxImpl;

/**
 * Test if "object" collide with other Objects in every directions
 * @author Luigi
 *
 */
public class TestCollision {

	BoundingBox object = new BoundingBoxImpl(new P2d(32,32), new P2d(64,64));
	
	@Test
	public void testCollisionOnTop() {
		assertTrue(object.isCollidingWith(new BoundingBoxImpl(new P2d(32,1), new P2d(64,33))));
		assertFalse(object.isCollidingWith(new BoundingBoxImpl(new P2d(32,0), new P2d(64,32))));
	}
	
	@Test
	public void testCollisionOnBottom() {
		assertTrue(object.isCollidingWith(new BoundingBoxImpl(new P2d(32, 63), new P2d(64,95))));
		assertFalse(object.isCollidingWith(new BoundingBoxImpl(new P2d(32, 64), new P2d(64,96))));
	}
	
	@Test
	public void testCollisionOnLeft() {
		assertTrue(object.isCollidingWith(new BoundingBoxImpl(new P2d(1, 32), new P2d(33,64))));
		assertFalse(object.isCollidingWith(new BoundingBoxImpl(new P2d(0, 32), new P2d(32,64))));
	}
	
	@Test
	public void testCollisionOnRight() {
		assertTrue(object.isCollidingWith(new BoundingBoxImpl(new P2d(63, 32), new P2d(95,64))));
		assertFalse(object.isCollidingWith(new BoundingBoxImpl(new P2d(64, 32), new P2d(96,64))));
	}
	
}
