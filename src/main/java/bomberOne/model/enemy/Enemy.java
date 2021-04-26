/**
 * This interface define a basic enemy.
 */

package bomberOne.model.enemy;

import bomberOne.model.gameObjects.AnimatedEntity;
import bomberOne.model.common.Direction;

public interface Enemy extends AnimatedEntity {

        /* Methods. */
	void update(int elapsed);

	/**
	 * This method return the previous direction of the enemy.
	 * The previousDirection field is used to manage the animations.
	 * @return an Direction enumerator value that specify the previous direction.
	 */
	Direction getPreviousDirection();

	/**
	 * This method sets the previous direction of the enemy.
	 * The previousDirection field is used to manage the animations.
	 * @param newDirection
	 */
	void setPreviousDirection(Direction newDirection);
}
