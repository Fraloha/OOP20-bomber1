package bomberOne.model.enemy.actions;

import bomberOne.model.common.P2d;
import bomberOne.model.enemy.EnemyImpl;
import bomberOne.model.common.Direction;
import java.util.Random;

public class IntermediateBehavior implements Actions {

	/* Fields. */
        private Random randomGenerator;
	private BasicBehavior basicActions;
	private EnemyImpl selectedEnemy;
	private boolean playerFound;

	/* Constructor. */
	public IntermediateBehavior(final EnemyImpl newEnemy) {
	        this.randomGenerator = new Random();
		this.selectedEnemy = newEnemy;
		this.basicActions = new BasicBehavior(this.selectedEnemy);
		this.playerFound = false;
	}
	
	/* Methods. */
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doActions() {
	    //Checking if the enemy can see the player.
	    if (this.playerFound) {
	        
	    } else {
	        //If the enemy have not seen the player, it acts randomly.
	        this.basicActions.doActions();
	    }
	}

    @Override
    public void nextMove() {
        // TODO Auto-generated method stub
        
    }
}