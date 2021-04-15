package bomberone.model.physics;

import bomberone.model.common.P2d;

public interface BoundingBox {

	/**
	 * 
	 * @param obj the Object to check if its collide with the current
	 * @return TRUE if "obj" collide the current Object
	 */
	public boolean isCollidingWith(BoundingBox obj);
	
	/**
	 * 
	 * @return the P2d of the Rectangle Left-Top Corner 
	 */
	public P2d getLeftTopCorner();
	
	/**
	 * 
	 * @return the P2d of the Rectangle Left-Top Corner 
	 */
	public P2d getRightBottomCorner();
}
