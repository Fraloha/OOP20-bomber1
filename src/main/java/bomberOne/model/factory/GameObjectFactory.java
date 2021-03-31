package bomberOne.model.factory;

import bomberOne.model.Difficulty;
import bomberOne.model.Skins;
import bomberOne.model.common.P2d;
import bomberOne.model.gameObjects.GameObject;
import bomberOne.model.gameObjects.PowerUp;

/**
 * A Factory class for create every GameObject
 * @author Luigi
 *
 */
public interface GameObjectFactory {

	/**
	 * Create a new Bomberman
	 * @param position The position of the bomber
	 * @param color The skin of the Bomber
	 * @return the Bomberman
	 */
	public GameObject createBomber(P2d position, Skins color);
	
	/**
	 * Create a new Enemy
	 * @param position The position of the enemy
	 * @param diff The Difficulty of the game
	 * @return the Enemy
	 */
	public GameObject createEnemy(P2d position, Difficulty diff);
	
	/**
	 * Create a new Box
	 * @param position of the box
	 * @return the Box
	 */
	public GameObject createBox(P2d position);
	
	/**
	 * Create a new PowerUp
	 * @param position The position of the PowerUp
	 * @param type The type of the PowerUp
	 * @return the PowerUp
	 */
	public GameObject createPowerUp(P2d position, PowerUp.type type);
	
	/**
	 * Create a new HardWall
	 * @param position The position of the HardWall
	 * @return the HardWall
	 */
	public GameObject createHardWall(P2d position);
	
	/**
	 * Create a new Fire Object
	 * @param position The position of the Fire
	 * @return the Fire
	 */
	public GameObject createFire(P2d position);
	
	/**
	 * Create a new Bomb Object
	 * @param position of the Bomb
	 * @param firePower of the Bomb
	 * @param pierce of the Bomb
	 * @return the Bomb
	 */
	public GameObject createBomb(P2d position, int firePower, boolean pierce);
}
