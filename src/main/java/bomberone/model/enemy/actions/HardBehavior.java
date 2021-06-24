package bomberone.model.enemy.actions;

import java.util.List;
import bomberone.model.enemy.Enemy;
import bomberone.model.bombergameboard.BomberOneBoard;
import bomberone.model.common.Direction;
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
     * @param finder
     */
    public HardBehavior(final Enemy newEnemy, final PathFinder finder) {
        super(newEnemy);
        this.navigator = finder;
    }

    /* Methods. */

    /**
     * {@inheritDoc}
     */
    @Override
    public void doActions() {
        BoardPoint enemyPosition = BomberOneBoard.getInstance().convertPosition(this.getEnemy().getPosition());
        List<Direction> computedPath = this.navigator.searchPath(enemyPosition);
        this.getEnemy().setDir(computedPath.get(0));
        this.getEnemy().manageAnimations();
        this.nextMove();
    }
}
