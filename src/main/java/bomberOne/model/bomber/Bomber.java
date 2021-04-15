package bomberone.model.bomber;

import java.util.Optional;

import bomberone.model.common.Direction;
import bomberone.model.gameObjects.AnimatedEntity;
import bomberone.model.gameObjects.Bomb;
import bomberone.model.gameObjects.PowerUp;
/**This is the interface of the Bomber 
 * @author Gustavo Mazzanti
 *
 */
public interface Bomber extends AnimatedEntity {
	/**
	 * Constants to initialize the Bomber
	 */
	static final int FIRE_POWER = 1;
	static final double SPEED = 100;
	static final int AMMO = 1;
	static final int SPRITES = 1;
	static final Direction DIR = Direction.DOWN;
	
	/**
	 * Method for the respawn of the Bomber
	 * who initialize all the parameter
	 */
	void respawn();

	/**
	 * Method for increments the lifes of
	 * @param lifes
	 */
	void addLifes(int lifes);

	/**
	 * Method for restore the usedAmmo to 0
	 */
	void restoreAmmo();

	/**
	 * Method that generates new Bomb
	 * @return Bomb
	 */
	Optional<Bomb> plantBomb();

	/**
	 * Method that applies the 
	 * @param PowerUp to the Bomber
	 */
	void applyPowerUp(PowerUp.type typeOfPowerUp);

	/**
	 * Method that
	 * @return number of the Life
	 */
	int getLifes();
	
	/**
	 * Method that
	 * @return number of maxAmmo
	 */
	int getAmmo();
	
	/**
	 * Method that
	 * @return dimension of the bomb's explosion
	 */
	int getFirePower();
	
	/**
	 * Method that
	 * @return Direction current
	 */
	Direction getDirection();

	/**
	 * Method that
	 * @return true if Bomber is Pierced (PowerUp)
	 */
	boolean isPierced();
	
	/** Method for attaching 
	 * @param PowerUpHandler
	 */
	void setUpHandler(PowerUpHandler activator);


}