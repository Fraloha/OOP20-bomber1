package bomberone.model.world.collection;

import java.util.List;

import bomberone.model.enemy.Enemy;
import bomberone.model.gameObjects.GameObject;
import bomberone.model.gameObjects.bomb.Bomb;
import bomberone.model.gameObjects.bomb.Explosion;
import bomberone.model.gameObjects.box.Box;
import bomberone.model.gameObjects.fire.Fire;
import bomberone.model.gameObjects.hardwall.HardWall;
import bomberone.model.gameObjects.powerUp.PowerUp;

/**
 * This interface's implementation must contains a list of GameObject. It will
 * be used by World to filter the list of specific GameObject.
 *
 */
public interface GameObjectCollection {

    /**
     * 
     * @return the entire List of GameObject
     */
    List<GameObject> getGameObjectCollection();

    /**
     * This method filters the List of GameObject and creates a List of Bomb.
     * 
     * @return a List of Bomb
     */
    List<Bomb> getBombList();

    /**
     * This method filters the List of GameObject and creates a List of Enemy.
     * 
     * @return a List of Enemy
     */
    List<Enemy> getEnemyList();

    /**
     * This method filters the List of GameObject and creates a List of Explosion.
     * 
     * @return a List of Explosion
     */
    List<Explosion> getExplosionList();

    /**
     * This method filters the List of GameObject and creates a List of Box.
     * 
     * @return a List of Box
     */
    List<Box> getBoxList();

    /**
     * This method filters the List of GameObject and creates a List of HardWall.
     * 
     * @return a List of HardWall
     */
    List<HardWall> getHardWallList();

    /**
     * This method filters the List of GameObject and creates a List of PowerUp.
     * 
     * @return a List of PowerUp
     */
    List<PowerUp> getPowerUpList();

    /**
     * This method filters the List of GameObject and creates a List of PowerUp.
     * 
     * @return a List of PowerUp
     */
    List<Fire> getFireList();

    /**
     * This method takes a GameObject and add it in the List of GameObject.
     * 
     * @param obj
     */
    void spawn(GameObject obj);

    /**
     * This method deletes GameObject in the List of GameObject.
     * 
     * @param obj 
     */
    void despawn(GameObject obj);

    /**
     * This method return the list of all eliminated object.
     * @return a List of object
     */
    List<GameObject> getDespawnedObject();
}
