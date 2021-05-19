/**
 * This interface define a basic enemy.
 */

package bomberone.model.enemy;

import bomberone.model.common.Direction;
import bomberone.model.gameObjects.moveable.MoveableObject;

public interface Enemy extends MoveableObject {

    /* Methods. */
    void setBoxes();

    void setHardWalls();

    boolean isHittable();

    void update(int elapsed);

    int getFrameCounterAnimation();

    void setFrameCounterAnimation(int i);
}
