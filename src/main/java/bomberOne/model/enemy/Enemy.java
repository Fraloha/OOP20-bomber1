package bomberone.model.enemy;

import bomberone.model.gameObjects.AnimatedEntity;


/**
 * This interface define a basic enemy.
 * @author Francesco
 *
 */
public interface Enemy extends AnimatedEntity{
	void changeDir();
}