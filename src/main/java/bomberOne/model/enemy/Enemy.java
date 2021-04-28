/**
 * This interface define a basic enemy.
 */

package bomberOne.model.enemy;

import bomberOne.model.gameObjects.AnimatedEntity;
import bomberOne.model.common.Direction;

public interface Enemy extends AnimatedEntity {

        /* Methods. */
	void update(int elapsed);
}
