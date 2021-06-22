package bomberone.model.enemy.actions;

import bomberone.model.enemy.Enemy;

/**
 * This interface defines the actions of an enemy.
 */
public interface Actions {

    /**
     * This method animates the enemy selecting the right "sprite animation" on the
     * basis of the direction of it.
     */
    void setAnimation();

    /**
     * This method sets the proper sprite on the basis of the enemy direction.
     */
    void setSprite();

    /**
     * This method sets the proper sprite and the animations. This method is a
     * Template method, it calls the setSprite() method and the setAnimation()
     * method
     */
    void manageAnimations();

    /**
     * This method sets a new enemy object in the current Actions instance.
     * 
     * @param newEnemy The new enemy object to set.
     */
    void setEnemy(Enemy newEnemy);

    /**
     * This method gets the enemy object that uses the current Actions instance.
     * 
     * @return The enemy object.
     */
    Enemy getEnemy();

    /**
     * This method contains all the actions that the enemy can perform in the
     * specified behavior, so for each difficulty mode, the behavior of the enemies
     * is different. The various behaviors are designed and developed using a
     * Strategy pattern. Too see more about the use and the implementation of the
     * behaviors, see the BasicBehavior and the IntermediateBehavior objects.
     */
    void doActions();

    /**
     * This method computes the enemy next movement.
     */
    void nextMove();
}
