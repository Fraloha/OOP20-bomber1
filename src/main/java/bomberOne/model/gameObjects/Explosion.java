package bomberOne.model.gameObjects;

import java.util.List;

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
	public Fire getCenter();
	
	/**
	 * 
	 * @return the List of vertical Fire referring @this Explosion
	 */
	public List<Fire> getVerticalFire();

	/**
	 * 
	 * @return the List of horizontal Fire referring @this Explosion
	 */
	public List<Fire> getHorizontalFire();
	
}
