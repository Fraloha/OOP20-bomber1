package bomberone.model.factory;

import bomberone.model.common.P2d;
import bomberone.model.gameObjects.GameObject;
import bomberone.model.gameObjects.PowerUp;
import bomberone.model.user.Difficulty;
import bomberone.model.user.Skins;

/**
 * A Factory class for create every GameObject.
 * 
 *
 */
public interface GameObjectFactory {

    /**
     * Create a new Bomberman.
     * 
     * @param position The position of the bomber
     * @param color    The skin of the Bomber
     * @return the Bomberman
     */
    GameObject createBomber(P2d position, Skins color);

    /**
     * Create a new Enemy.
     * 
     * @param position The position of the enemy
     * @param diff     The Difficulty of the game
     * @return the Enemy
     */
    GameObject createEnemy(P2d position, Difficulty diff);

    /**
     * Create a new Box.
     * 
     * @param position of the box
     * @return the Box
     */
    GameObject createBox(P2d position);

    /**
     * Create a new PowerUp.
     * 
     * @param position The position of the PowerUp
     * @param type     The type of the PowerUp
     * @return the PowerUp
     */
    GameObject createPowerUp(P2d position, PowerUp.Type type);

    /**
     * Create a new HardWall.
     * 
     * @param position The position of the HardWall
     * @return the HardWall
     */
    GameObject createHardWall(P2d position);

    /**
     * Create a new Fire Object.
     * 
     * @param position The position of the Fire
     * @return the Fire
     */
    GameObject createFire(P2d position);

    /**
     * Create a new Bomb Object.
     * 
     * @param position  of the Bomb
     * @param firePower of the Bomb
     * @param pierce    of the Bomb
     * @return the Bomb
     */
    GameObject createBomb(P2d position, int firePower, boolean pierce);
}
