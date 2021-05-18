package bomberone.model.gameObjects.box;

import java.util.Optional;

import bomberone.model.gameObjects.GameObject;
import bomberone.model.gameObjects.powerUp.PowerUp;

/**
 * Box Object.
 *
 */
public interface Box extends GameObject {

    /**
     * 
     * @return Optional.empty() if the box doesn't contain the PowerUp, else returns
     *         the PowerUp.
     */
    Optional<PowerUp> getPowerUp();

    /**
     * Puts the PowerUp into the Box.
     * 
     * @param pU the PowerUp to put into the Box
     */
    void addPowerUp(PowerUp pU);
}
