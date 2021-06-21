package bomberone.model.enemy.actions;

import bomberone.model.enemy.Enemy;
import bomberone.model.common.Direction;
import bomberone.model.pathfinding.gameboard.BoardPoint;
import bomberone.model.pathfinding.navigation.Navigation;
import bomberone.model.pathfinding.navigation.NavigationImpl;

import java.util.List;

import bomberone.model.bombergameboard.BomberOneBoard;

/**
 * This class is an enemy behavior and uses a path finding algorithm to find the
 * player.
 */
public final class HardBehavior extends AbstractActions {

    /* Fields. */
    private boolean playerFound;
    private Navigation navigator;
    private BasicBehavior basicActions;

    /* Constructor. */
    /**
     * Creates a new IntermediateBehavior object.
     * 
     * @param newEnemy The enemy that uses this behavior.
     */
    public HardBehavior(final Enemy newEnemy) {
        super(newEnemy);
        this.playerFound = false;
        this.navigator = new NavigationImpl();
        this.basicActions = new BasicBehavior(this.getEnemy());
    }

    /* Methods. */

    /**
     * {@inheritDoc}
     */
    @Override
    public void doActions() {
        BoardPoint enemyLocation = BomberOneBoard.getInstance().convertPosition(this.getEnemy().getPosition());

        if (this.playerFound) {
            List<Direction> computedPath = this.navigator.searchShortestPath(this.getEnemy().getPosition());
            if (!computedPath.isEmpty()) {
                this.getEnemy().setDir(computedPath.get(0));
                this.setSprite();
                this.manageAnimations();
                this.nextMove();
            }
            computedPath.clear();
        } else {
            this.basicActions.doActions();
            this.playerFound = BomberOneBoard.getInstance().isSpotVisible(enemyLocation);
        }
    }
}
