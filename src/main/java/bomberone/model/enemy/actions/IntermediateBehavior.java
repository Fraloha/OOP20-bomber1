package bomberone.model.enemy.actions;

import bomberone.model.common.P2d;
import bomberone.model.enemy.EnemyImpl;
import bomberone.model.common.Direction;
import bomberone.model.enemy.navigation.Navigation;
import bomberone.model.enemy.navigation.NavigationImpl;
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
        int X = (int) (this.selectedEnemy.getPosition().getY() / 32);
        int Y = (int) (this.selectedEnemy.getPosition().getX() / 32);
        this.playerFound = this.playerFound ? true : GameBoard.getInstance().isPlayerVisible(X, Y);
        if (this.playerFound) {
            P2d enemyLocation = this.selectedEnemy.getPosition();
            try {
                Direction nextStep = this.navigator.searchShortestPath(enemyLocation).get(0);
                this.selectedEnemy.setDir(nextStep);
                this.nextMove();
            } catch (Exception e) {
                System.out.println("The list is empty.");
            }
        } else {
            this.basicActions.doActions();
        }
    }
}