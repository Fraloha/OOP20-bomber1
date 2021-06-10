package bomberone.model.enemy.actions;

import bomberone.model.enemy.EnemyImpl;
import bomberone.model.common.Direction;
import bomberone.model.gameboard.BoardPoint;
import bomberone.model.bombergameboard.BomberOneBoard;
import bomberone.model.enemy.navigation.Navigation;
import bomberone.model.enemy.navigation.NavigationImpl;

public final class IntermediateBehavior extends AbstractActions {

    /* Fields. */
    private boolean playerFound;
    private Navigation navigator;
    private BasicBehavior basicActions;

    /* Constructor. */
    public IntermediateBehavior(final EnemyImpl newEnemy) {
        super(newEnemy);
        this.playerFound = false;
        this.navigator = new NavigationImpl();
        this.basicActions = new BasicBehavior(this.selectedEnemy);
    }

    /* Methods. */

    /**
     * {@inheritDoc}
     */
    @Override
    public void doActions() {
        BoardPoint enemyLocation = BomberOneBoard.getInstance().convertPosition(this.selectedEnemy.getPosition());
        
        if (this.playerFound) {
            try {
                Direction nextStep = this.navigator.searchShortestPath(this.selectedEnemy.getPosition()).get(0);
                this.selectedEnemy.setDir(nextStep);
                this.setSprite();
                this.manageAnimations();
                this.nextMove();
            } catch(Exception e) {
                System.out.println("Unable to find a path.");
            }
        } else {
            this.basicActions.doActions();
            this.playerFound = BomberOneBoard.getInstance().isPlayerVisible(enemyLocation);
            if (this.playerFound) {
                System.out.println("Found");
                // GameBoard.getInstance().printBoard();
                BomberOneBoard.getInstance().isPlayerVisible(enemyLocation);
            }
        }
    }
}