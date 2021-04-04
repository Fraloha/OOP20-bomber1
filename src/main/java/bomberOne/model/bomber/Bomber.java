package bomberOne.model.bomber;

import bomberOne.model.common.Direction;
import bomberOne.model.gameObjects.Bomb;
import bomberOne.model.gameObjects.PowerUp;
/**This is the interface of the Bomber 
 * @author Gustavo Mazzanti
 *
 */
public interface Bomber {
	/**
	 * Costants to initialize the Bomber
	 */
	static final int FIRE_POWER = 1;
	static final int SPEED = 100;
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
	Bomb plantBomb();

	/**
	 * Method that applies the 
	 * @param PowerUp to the Bomber
	 */
	void applyPowerUp(PowerUp.type typeOfPowerUp);

	/**
	 * Method that
	 * @return number of the current Sprite image
	 */
	int getSprite();

	/**
	 * Method that
	 * @return Direction current
	 */
	Direction getDirection();

	/** Mothod for attaching 
	 * @param PowerUpHandler
	 */
	void setUpHandler(PowerUpHandler activator);

}