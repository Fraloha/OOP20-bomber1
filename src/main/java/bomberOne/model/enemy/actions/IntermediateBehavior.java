package bomberOne.model.enemy.actions;

import bomberOne.model.common.P2d;
import bomberOne.model.observation.EnemyTriggeredObservation;
import bomberOne.model.enemy.Enemy;
import bomberOne.model.common.Direction;
import bomberOne.model.observation.DirectionComparator;
import bomberOne.model.observation.FollowingModes;
import java.util.Random;

public class IntermediateBehavior implements Actions {

	/* Fields. */
        private Random randomGenerator;
	private EnemyTriggeredObservation triggeredObs;
	private BasicBehavior basicActions;
	private Enemy selectedEnemy;
	private boolean playerFound;

	/* Constructor. */
	public IntermediateBehavior(final Enemy newEnemy) {
	        this.randomGenerator = new Random();
		this.triggeredObs = new EnemyTriggeredObservation();
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
	
	/**
	 * This method sets the TriggeredObservation object destination.
	 * @param playerPosition The current player position to let the enemy to follow him.
	 */
	public void setPlayerPosition(P2d playerPosition) {
	    this.triggeredObs.setDestination(playerPosition);
	}

	private void follow(Direction direction) {

	    this.selectedEnemy.setDir(direction);

	    if (direction.equals(Direction.RIGHT)) {

	        this.selectedEnemy.setSpriteIndex(2);
	        this.selectedEnemy.moveRight();

	    } else if (direction.equals(Direction.LEFT)) {

	        this.selectedEnemy.setSpriteIndex(1);
	        this.selectedEnemy.moveLeft();

	    } else if (direction.equals(Direction.UP)) {

	        this.selectedEnemy.setSpriteIndex(3);
	        this.selectedEnemy.moveUp();

	    } else if (direction.equals(Direction.DOWN)) {

	        this.selectedEnemy.setSpriteIndex(0);
	        this.selectedEnemy.moveDown();

	    }
	}
	
	public void isFound(P2d playerPosition) {
	    if(!this.playerFound) {
	        this.triggeredObs.found(playerPosition, this.selectedEnemy.getDir());
	    }
	}
}