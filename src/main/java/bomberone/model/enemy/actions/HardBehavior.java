package bomberone.model.enemy.actions;

import java.util.List;
import bomberone.model.enemy.Enemy;
import bomberone.model.bombergameboard.BomberOneBoard;
import bomberone.model.common.Direction;
import bomberone.model.pathfinding.BFSSearch;
import bomberone.model.pathfinding.gameboard.BoardPoint;
import bomberone.model.pathfinding.navigation.PathFinder;

/**
 * This class is an enemy behavior and uses a path finding algorithm to find the
 * player.
 */
public final class HardBehavior extends AbstractActions {

    /* Fields. */
    private PathFinder navigator;

    /* Constructor. */
    /**
     * Creates a new IntermediateBehavior object.
     * 
     * @param newEnemy The enemy that uses this behavior.
     */
    public HardBehavior(final Enemy newEnemy) {
        super(newEnemy);
        this.navigator = new BFSSearch();
    }

    /* Methods. */

    /**
     * {@inheritDoc}
     */
    @Override
    public void doActions() {
        BoardPoint enemyPosition = BomberOneBoard.getInstance().convertPosition(this.getEnemy().getPosition());
        List<Direction> computedPath = this.navigator.searchPath(enemyPosition);
        if (!computedPath.isEmpty()) {
            this.getEnemy().setDir(computedPath.get(0));
            this.manageAnimations();
            this.nextMove();
        }
    }
}
