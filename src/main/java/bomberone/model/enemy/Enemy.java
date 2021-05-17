/**
 * This interface define a basic enemy.
 */

package bomberone.model.enemy;

import bomberone.model.common.Direction;
import bomberone.model.gameObjects.AnimatedEntity;

public interface Enemy extends AnimatedEntity {

    boolean isHittable();
        /* Methods. */
	void update(int elapsed);
}
