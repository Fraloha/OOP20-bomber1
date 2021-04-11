package bomberOne.model.enemy;

import bomberOne.model.gameObjects.AnimatedEntity;


/**
 * This interface define a basic enemy.
 * @author Francesco
 *
 */
public interface Enemy extends AnimatedEntity{
	void changeDir();
}