package bomberOne.model.physics;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import bomberOne.model.common.P2d;

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
//	
//	@Test
//	public void testCollisionOnLeft() {
//		assertTrue(object.isCollidingWith(new BoundingBoxImpl(new P2d(32,1), new P2d(64,33))));
//	}
//	
//	@Test
//	public void testCollisionOnRight() {
//		assertTrue(object.isCollidingWith(new BoundingBoxImpl(new P2d(32,1), new P2d(64,33))));
//	}
	
}
