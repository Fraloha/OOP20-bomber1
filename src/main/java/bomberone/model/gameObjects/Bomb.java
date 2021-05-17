package bomberone.model.gameObjects;

import java.util.Optional;

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
