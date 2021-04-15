package bomberone.model.gameObjects;


import bomberone.model.common.P2d;

public interface Explosion{
	
	/**
	 * 
	 * @return the range of the Explosion
	 */
	public int getFirePower();
	
	/**
	 * 
	 * @return true if @this Explosion can go across the wall
	 */
	public boolean getPierce();
	
	/**
	 * 
	 * @return the Fire referring to the center of @this Explosion
	 */
	public P2d getCenter();
}
