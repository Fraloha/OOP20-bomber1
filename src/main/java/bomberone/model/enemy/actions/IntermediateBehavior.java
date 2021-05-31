package bomberone.model.enemy.actions;

import java.util.List;
import bomberone.model.enemy.EnemyImpl;
import bomberone.model.common.Direction;
import bomberone.model.enemy.navigation.Navigation;
import bomberone.model.enemy.navigation.NavigationImpl;
import bomberone.model.gameboard.BoardPoint;
import bomberone.model.gameboard.GameBoard;

public final class IntermediateBehavior extends AbstractActions {

    /* Fields. */
    private boolean playerFound;
    private Navigation navigator;
    private BasicBehavior basicActions;

    /* Constructor. */
    public IntermediateBehavior(final EnemyImpl newEnemy) {
        super(newEnemy);
        this.playerFound = false;
        this.basicActions = new BasicBehavior(this.selectedEnemy);
        this.navigator = new NavigationImpl();
    }

    /* Methods. */

    /**
     * {@inheritDoc}
     */
    @Override
    public void doActions() {
        BoardPoint enemyLocation = GameBoard.getInstance().convertPosition(this.selectedEnemy.getPosition());

        if (this.playerFound) {
            List<Direction> computedPath = this.navigator.searchShortestPath(this.selectedEnemy.getPosition());
            if (computedPath.isEmpty()) {
                System.out.println("Unable to find a path.");
            } else {
                this.selectedEnemy.setDir(computedPath.get(0));
                this.nextMove();
                computedPath.clear();
            }
        } else {
            this.basicActions.doActions();
            this.playerFound = GameBoard.getInstance().isPlayerVisible(enemyLocation);
        }
    }
}