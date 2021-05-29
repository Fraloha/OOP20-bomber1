package bomberone.model.world;

import bomberone.controllers.match.event.WorldEventListener;
import bomberone.model.bomber.BomberImpl;
import bomberone.model.factory.GameObjectFactory;
import bomberone.model.world.collection.GameObjectCollection;

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
     * 
     * @param event
     */
    void setEventListener(WorldEventListener event);

    /**
     * @return the bomber
     */
    BomberImpl getBomber();

    /**
     * Update the state of the game and calls the update of each GameObject.
     * 
     * @param time
     */
    void updateState(int time);

    /**
     * Check if some of object breakable is colliding with fire, if the bomber picks
     * up one PowerUp or if enemy hit Bomber.
     */
    void checkCollision();

    /**
     * Check if the enemy can be respawned and eventually respawns them.
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
}
