package bomberone.model.gameObjects.bomb;

import java.util.Optional;

import bomberone.model.gameObjects.GameObject;

/**
 * Bomb Object.
 *
 */
public interface Bomb extends GameObject {

    /**
     * Method that generate the explosion of @this Bomb, and it fill the Optional
     * with the Explosion.
     * 
     * @return the Explosion
     */
    Explosion explode();

    /**
     * 
     * @return Optional.empty() if explode() isn't already called, else return the
     *         Optional filled by the Explosion
     * 
     */
    Optional<Explosion> getExplosion();

    /**
     * @return index of the bomb's Animation.
     */
    int getIndexAnimation();

    /**
     * 
     * @return true if bomb has PuP Pierce.
     */
    boolean getPierce();

}
