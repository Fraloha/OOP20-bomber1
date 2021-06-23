/**
 * This interface define a basic enemy.
 */

package bomberone.model.enemy;

import bomberone.model.gameObjects.moveable.MoveableObject;

public interface Enemy extends MoveableObject {

    /* Methods. */
    boolean isHittable();

    /**
     * This method sets the proper sprite on the basis of the enemy direction.
     */
    void setSprite();

    /**
     * This method animates the enemy selecting the right "sprite animation" on the
     * basis of the direction of it.
     */
    void setAnimation();

    /**
     * This method is a template method, according to the Template method pattern.
     * It manages the sprite and the animations.
     */
    void manageAnimations();

    void update(int elapsed);
}
