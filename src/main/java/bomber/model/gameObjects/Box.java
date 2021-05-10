package bomber.model.gameObjects;

import java.util.Optional;

/**
 * Represent every Box in the Game.
 *
 */
public interface Box extends GameObject {

    /**
     * 
     * @return Optional.empty() if the box doesn't contain the PowerUp, else returns the PowerUp.
     */
    Optional<PowerUp> getPowerUp();

    /**
     * Puts the PowerUp into the Box.
     * 
     * @param pU the PowerUp to put into the Box
     */
    void addPowerUp(PowerUp pU);
}
