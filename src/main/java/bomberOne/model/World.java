package bomberOne.model;

import bomberOne.model.bomber.BomberImpl;
import bomberOne.model.common.Direction;
import bomberOne.model.event.WorldEventListener;
import bomberOne.model.factory.GameObjectFactory;
import bomberOne.model.gameObjects.GameObjectCollection;

/**
 * The world of gameplay.
 *
 */
public interface World {

    /**
     * 
     * @return true if the enemies can respawn
     */
    boolean getRespawn();

    /**
     * @return all the collection of the GameObjects
     */
    GameObjectCollection getGameObjectCollection();

    /**
     * 
     * @return the objectFactory
     */
    GameObjectFactory getGameObjectFactory();

    /**
     * Set the event listener.
     * @param event
     */
    void setEventListener(WorldEventListener event);

    /**
     * @return the bomber
     */
    BomberImpl getBomber();

    /**
     * Update the state of the game.
     * @param time
     */
    void updateState(int time);

    /**
     * Check if some of object breakable is colliding with fire, if the bomber picks up one PowerUp or if enemy hit Bomber.
     */
    void checkCollision();

    /**
     * Check if the enemy can be respawned.
     */
    void checkRespawn();

    /**
     * Check if bomber or enemy is colliding with Wall or Box.
     */
    void checkBoundary();
    
    /**
     * Check if a bomb is exploded.
     */
    void checkExplosion();
    
    void setModel(GameModel model);
}
