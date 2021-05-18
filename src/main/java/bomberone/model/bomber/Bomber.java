package bomberone.model.bomber;

import java.util.Optional;

import bomberone.model.common.Direction;
import bomberone.model.gameObjects.bomb.Bomb;
import bomberone.model.gameObjects.moveable.MoveableObject;
import bomberone.model.gameObjects.powerUp.PowerUp;

/**
 * This is the interface of the Bomber.
 * 
 */
public interface Bomber extends MoveableObject {

    /**
     * Method for the respawn of the Bomber who initialize all the parameter.
     */
    void respawn();

    /**
     * Method for increments the lifes of.
     * 
     * @param lifes
     */
    void addLifes(int lifes);

    /**
     * Method for restore the usedAmmo to 0.
     */
    void restoreAmmo();

    /**
     * Method that generates new Bomb, if they are not available, that generates
     * Optional.empty().
     * 
     * @return Optional.of(Bomb) or Optional.empty()
     */
    Optional<Bomb> plantBomb();

    /**
     * Method that applies the powerUp to Bomber.
     * 
     * @param typeOfPowerUp to apply
     */
    void applyPowerUp(PowerUp.Type typeOfPowerUp);

    /**
     * Method that return the number of the resumed lives.
     * 
     * @return number of Lives
     */
    int getLifes();

    /**
     * Method that return the number of maxAmmo available.
     * 
     * @return number maxAmmo
     */
    int getAmmo();

    /**
     * Method that return the firePower generated from the next Bomb.
     * 
     * @return number firePower
     */
    int getFirePower();

    /**
     * Method that return current direction of Bomber.
     * 
     * @return Direction current
     */
    Direction getDirection();

    /**
     * Method that return true if Bomber is Pierced (PowerUp).
     * 
     * @return boolean isPierced
     */
    boolean getPierce();

    /**
     * Method that increment the Bomber's speed.
     */
    void incSpeed();

    /**
     * Method that increment the Bomber's ammo.
     */
    void incAmmo();

    /**
     * Method that increment the Bomber's firePower.
     */
    void incFirePower();

    /**
     * Method to activate Bomber's pierce (PowerUp).
     */
    void activatePierce();
}
