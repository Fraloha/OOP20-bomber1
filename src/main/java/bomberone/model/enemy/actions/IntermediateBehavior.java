package bomberone.model.enemy.actions;

import bomberone.model.enemy.EnemyImpl;
import bomberone.model.enemy.Log;
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
        // BoardPoint enemyLocation = GameBoard.getInstance().convertPosition(this.selectedEnemy.getPosition());
        // this.playerFound = this.playerFound ? true : GameBoard.getInstance().isPlayerVisible(enemyLocation);
        if (true) {
            try {
                Direction nextStep = this.navigator.searchShortestPath(this.selectedEnemy.getPosition()).get(0);
                System.out.println(nextStep);
                this.selectedEnemy.setDir(nextStep);
                this.nextMove();
            } catch (Exception e) {
                Log.getInstance().getLog("Unable to find a path", true);
            }
        } else {
            this.basicActions.doActions();
        }
    }
}