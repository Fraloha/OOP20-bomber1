package bomberOne.model.physics;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import bomberOne.model.common.P2d;

/**
 * Test if "object" collide with other Objects in every directions.
 * 
 *
 */
public class TestCollision {

    private static final int COORD_96 = 96;
    private static final int COORD_95 = 95;
    private static final int COORD_63 = 63;
    private static final int COORD_64 = 64;
    private static final int COORD_32 = 32;
    private static final int COORD_33 = 33;

    private BoundingBox object = new BoundingBoxImpl(new P2d(COORD_32, COORD_32), new P2d(COORD_64, COORD_64));

    @Test
    public void testCollisionOnTop() {
        assertTrue(object.isCollidingWith(new BoundingBoxImpl(new P2d(COORD_32, 1), new P2d(COORD_64, COORD_33))));
        assertFalse(object.isCollidingWith(new BoundingBoxImpl(new P2d(COORD_32, 0), new P2d(COORD_64, COORD_32))));
    }

    @Test
    public void testCollisionOnBottom() {
        assertTrue(object.isCollidingWith(new BoundingBoxImpl(new P2d(COORD_32, COORD_63), new P2d(COORD_64, COORD_95))));
        assertFalse(object.isCollidingWith(new BoundingBoxImpl(new P2d(COORD_32, COORD_64), new P2d(COORD_64, COORD_96))));
    }

    @Test
    public void testCollisionOnLeft() {
        assertTrue(object.isCollidingWith(new BoundingBoxImpl(new P2d(1, COORD_32), new P2d(COORD_33, COORD_64))));
        assertFalse(object.isCollidingWith(new BoundingBoxImpl(new P2d(0, COORD_32), new P2d(COORD_32, COORD_64))));
    }

    @Test
    public void testCollisionOnRight() {
        assertTrue(object.isCollidingWith(new BoundingBoxImpl(new P2d(COORD_63, COORD_32), new P2d(COORD_95, COORD_64))));
        assertFalse(object.isCollidingWith(new BoundingBoxImpl(new P2d(COORD_64, COORD_32), new P2d(COORD_96, COORD_64))));
    }

}
