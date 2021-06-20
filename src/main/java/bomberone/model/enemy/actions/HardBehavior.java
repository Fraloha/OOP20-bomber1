package bomberone.model.enemy.actions;

import bomberone.model.enemy.Enemy;
import bomberone.model.common.Direction;
import bomberone.model.gameboard.BoardPoint;
import bomberone.model.bombergameboard.BomberOneBoard;
import bomberone.model.enemy.navigation.Navigation;
import bomberone.model.enemy.navigation.NavigationImpl;

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
            try {
                Direction nextStep = this.navigator.searchShortestPath(this.getEnemy().getPosition()).get(0);
                this.getEnemy().setDir(nextStep);
                this.setSprite();
                this.manageAnimations();
                this.nextMove();
            } catch (Exception e) {
                System.out.println("Unable to find a path.");
            }
        } else {
            this.basicActions.doActions();
            this.playerFound = BomberOneBoard.getInstance().isSpotVisible(enemyLocation);
            if (this.playerFound) {
                System.out.println("Found");
                // GameBoard.getInstance().printBoard();
                BomberOneBoard.getInstance().isSpotVisible(enemyLocation);
            }
        }
    }
}
