/**
 * This interface define a basic enemy.
 */

package bomberone.model.enemy;

import bomberone.model.gameObjects.moveable.MoveableObject;

public interface Enemy extends MoveableObject {

    /* Methods. */
    boolean isHittable();

    void update(int elapsed);

    int getFrameCounterAnimation();

    void setFrameCounterAnimation(int i);
}
