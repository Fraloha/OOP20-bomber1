package bomber.model.bomber;

import java.util.Optional;

import bomber.model.common.Direction;
import bomber.model.gameObjects.AnimatedEntity;
import bomber.model.gameObjects.Bomb;
import bomber.model.gameObjects.PowerUp;

/**
 * This is the interface of the Bomber.
 * 
 */
public interface Bomber extends AnimatedEntity {

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
     * Method that generates new Bomb.
     * 
     * @return Bomb
     */
    Optional<Bomb> plantBomb();

    /**
     * Method that applies the powerUp to Bomber.
     * 
     * @param typeOfPowerUp to apply
     */
    void applyPowerUp(PowerUp.Type typeOfPowerUp);

    /**
     * Method that return the number of the resumed lifes.
     * 
     * @return number Life
     */
    int getLifes();

    /**
     * Method that return the number of maxAmmo aviable.
     * 
     * @return number maxAmmo
     */
    int getAmmo();

    /**
     * Method that return the firePower generated for the next Bomb.
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
    boolean isPierced();

    /**
     * Method for attaching the PowerUpHandler.
     * 
     * @param activator
     */
    void setUpHandler(PowerUpHandler activator);

    /**
     * Method that increment the Bomber's speed.
     * @param increment
     */
    void incSpeed(double increment);

    /**
     * Method that increment the Bomber's ammo.
     * @param increment
     */
    void incAmmo(int increment);

    /**
     * Method that increment the Bomber's firePower.
     * @param increment
     */
    void incFirePower(int increment);

    /**
     * Method to activate Bomber's pierce (PowerUp).
     */
    void activatePierce();
}