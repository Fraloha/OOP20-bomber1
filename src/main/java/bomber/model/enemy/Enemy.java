/**
 * This interface define a basic enemy.
 */

package bomber.model.enemy;

import bomber.model.common.Direction;
import bomber.model.gameObjects.AnimatedEntity;

public interface Enemy extends AnimatedEntity {

        /* Methods. */
	void update(int elapsed);
}
