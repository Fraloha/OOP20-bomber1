package bomberOne.model;

import bomberOne.model.bomber.BomberImpl;
import bomberOne.model.event.WorldEventListener;
import bomberOne.model.factory.GameObjectFactory;
import bomberOne.model.gameObjects.GameObjectCollection;

/**
 * The world of gameplay
 * @author Tommaso Brini
 *
 */
public interface World {

	/**
	 * @return true if the enemies can respawn
	 */
	boolean getRespawn();
	
	/**
	 * @return all the collection of the GameObjects
	 */
	GameObjectCollection getGameObjectCollection();
	
	GameObjectFactory getGameObjectFactory();
	
	void setEventListener(WorldEventListener event);
	
	/**
	 * @return the bomber
	 */
	BomberImpl getBomber();
	
	void updateState(int time);
	
	void checkCollision();
	
	void checkRespawn();
	
	void checkBoundary();
	
	/**
	 * Check if a bomb is exploded
	 */
	void checkExplosion();
}
