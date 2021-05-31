package bomberone.model.enemy.actions;

import bomberone.model.enemy.EnemyImpl;
import bomberone.model.enemy.Log;

import java.util.List;

import bomberone.model.common.Direction;
import bomberone.model.enemy.navigation.Navigation;
import bomberone.model.enemy.navigation.NavigationImpl;
import bomberone.model.gameboard.BoardPoint;
import bomberone.model.gameboard.GameBoard;

public final class IntermediateBehavior extends AbstractActions {

    /* Fields. */
    private BasicBehavior basicActions;
    private Navigation navigator;
    private boolean playerFound;
    private int blocked = 0;

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
                if (this.selectedEnemy.getDir() != computedPath.get(0)) {
                    this.setSprite();
                    this.selectedEnemy.setDir(computedPath.get(0));
                } else {
                    this.manageAnimation();
                }
                // GameBoard.getInstance().printBoard();
                this.nextMove();
                computedPath.clear();
            }
        } else {
            this.basicActions.doActions();
            this.playerFound = GameBoard.getInstance().isPlayerVisible(enemyLocation);
        }
    }
}