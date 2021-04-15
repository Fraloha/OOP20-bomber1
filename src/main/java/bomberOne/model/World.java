package bomberone.model;

import bomberone.model.bomber.BomberImpl;
import bomberone.model.event.WorldEventListener;
import bomberone.model.factory.GameObjectFactory;
import bomberone.model.gameObjects.GameObjectCollection;

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
