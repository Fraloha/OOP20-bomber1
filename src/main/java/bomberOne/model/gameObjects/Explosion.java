package bomberOne.model.gameObjects;


import bomberOne.model.common.P2d;

public interface Explosion {
	
	/**
	 * 
	 * @return the range of the Explosion
	 */
	int getFirePower();
	
	/**
	 * 
	 * @return true if @this Explosion can go across the wall
	 */
	boolean getPierce();
	
	/**
	 * 
	 * @return the Fire referring to the center of @this Explosion
	 */
	P2d getCenter();
}
