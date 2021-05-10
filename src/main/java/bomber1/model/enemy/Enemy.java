/**
 * This interface define a basic enemy.
 */

package bomber1.model.enemy;

import bomber1.model.common.Direction;
import bomber1.model.gameObjects.AnimatedEntity;

public interface Enemy extends AnimatedEntity {

        /* Methods. */
	void update(int elapsed);
}
