/**
 * This interface define a basic enemy.
 */

package bomberOne.model.enemy;

import bomberOne.model.gameObjects.AnimatedEntity;
import bomberOne.model.common.P2d;

public interface Enemy extends AnimatedEntity {

        /* Methods. */
	void update(P2d playerPosition);
}
