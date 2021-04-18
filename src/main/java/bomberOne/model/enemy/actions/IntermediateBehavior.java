package bomberOne.model.enemy.actions;

import bomberOne.model.common.P2d;
import bomberOne.model.observation.EnemyTriggeredObservation;
import bomberOne.model.enemy.Enemy;
import bomberOne.model.common.Direction;

public class IntermediateBehavior implements Actions {

	/* Fields. */
	private EnemyTriggeredObservation triggeredObs;
	private BasicBehavior basicActions;
	private Enemy selectedEnemy;
	private boolean following;

	/* Constructor. */
	public IntermediateBehavior(final Enemy newEnemy, final P2d playerPosition) {
		this.triggeredObs = new EnemyTriggeredObservation(playerPosition);
		this.selectedEnemy = newEnemy;
		this.basicActions = new BasicBehavior(this.selectedEnemy);
		this.following = false;
	}
	
	/* Methods. */
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doActions() {
	}
	
	/**
	 * This method sets the TriggeredObservation object destination.
	 * @param playerPosition The current player position to let the enemy to follow him.
	 */
	public void setPlayerPosition(P2d playerPosition) {
	    this.triggeredObs.setDestination(playerPosition);
	}
}