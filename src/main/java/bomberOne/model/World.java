package bomberOne.model;

import bomberOne.model.event.WorldEventListener;
import bomberOne.model.gameObjects.Bomber;
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
	 * Set the possibility of the enemies of respawn
	 */
	void setRespawn(Boolean respawn);
	
	/**
	 * @return all the collection of the GameObjects
	 */
	GameObjectCollection getGameObjectCollection();
	
	void setEventListener(WorldEventListener event);
	
	/**
	 * @return the bomber
	 */
	Bomber getBomber();
	
	void updateState(int time);
	
	void checkCollision();
	
	void checkRespawn();
	
	
	void checkBoundary();
	
	/**
	 * Check if a bomb is exploded
	 */
	void checkExplosion();
}
