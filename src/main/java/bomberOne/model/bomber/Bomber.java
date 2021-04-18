package bomberOne.model.bomber;

import java.util.Optional;

import bomberOne.model.common.Direction;
import bomberOne.model.gameObjects.AnimatedEntity;
import bomberOne.model.gameObjects.Bomb;
import bomberOne.model.gameObjects.PowerUp;

/**
 * This is the interface of the Bomber.
 * 
 *
 */
public interface Bomber extends AnimatedEntity {
    /**
     * Constants to initialize the Bomber.
     */
    int FIRE_POWER = 1;
    double SPEED = 100;
    int AMMO = 1;
    int SPRITES = 1;
    Direction DIR = Direction.DOWN;

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
     * Method for restore the usedAmmo to 0
     */
    void restoreAmmo();

    /**
     * Method that generates new Bomb
     * 
     * @return Bomb
     */
    Optional<Bomb> plantBomb();

    /**
     * Method that applies the
     * 
     * @param PowerUp to the Bomber
     */
    void applyPowerUp(PowerUp.Type typeOfPowerUp);

    /**
     * Method that
     * 
     * @return number of the Life
     */
    int getLifes();

    /**
     * Method that
     * 
     * @return number of maxAmmo
     */
    int getAmmo();

    /**
     * Method that
     * 
     * @return dimension of the bomb's explosion
     */
    int getFirePower();

    /**
     * Method that
     * 
     * @return Direction current
     */
    Direction getDirection();

    /**
     * Method that
     * 
     * @return true if Bomber is Pierced (PowerUp)
     */
    boolean isPierced();

    /**
     * Method for attaching
     * 
     * @param PowerUpHandler
     */
    void setUpHandler(PowerUpHandler activator);

}