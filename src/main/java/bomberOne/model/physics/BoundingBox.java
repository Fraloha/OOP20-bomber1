package bomberOne.model.physics;

import bomberOne.model.common.P2d;

public interface BoundingBox {

    /**
     * 
     * @param obj the Object to check if its collide with the current
     * @return TRUE if "obj" collide the current Object
     */
    boolean isCollidingWith(BoundingBox obj);

    /**
     * 
     * @return the P2d of the Rectangle Left-Top Corner
     */
    P2d getLeftTopCorner();

    /**
     * 
     * @return the P2d of the Rectangle Left-Top Corner
     */
    P2d getRightBottomCorner();
}
