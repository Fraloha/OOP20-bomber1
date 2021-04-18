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
	
	@Override
	public void doActions() {
	}
}