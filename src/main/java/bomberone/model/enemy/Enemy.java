/**
 * This interface define a basic enemy.
 */

package bomberone.model.enemy;

import bomberone.model.gameObjects.AnimatedEntity;

public interface Enemy extends AnimatedEntity {

    /* Methods. */
    void setBoxes();

    void setHardWalls();

    boolean isHittable();

    void update(int elapsed);

    int getFrameCounterAnimation();

    void setFrameCounterAnimation(int i);
}
