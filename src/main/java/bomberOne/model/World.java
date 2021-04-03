package bomberOne.model;

import bomberOne.model.bomber.Bomber;
import bomberOne.model.event.WorldEventListener;
import bomberOne.model.factory.GameObjectFactory;
import bomberOne.model.gameObjects.GameObjectCollection;
import bomberOne.model.physics.BoundingBox;

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
	
	GameObjectFactory getGameObjectFactory();
	
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
