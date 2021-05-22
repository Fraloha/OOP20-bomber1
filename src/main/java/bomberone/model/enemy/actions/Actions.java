package bomberone.model.enemy.actions;

/**
 * This interface defines the actions of an enemy.
 */
public interface Actions {

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