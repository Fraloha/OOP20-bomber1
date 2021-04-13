package bomberOne.model.enemy.actions;

import bomberOne.model.common.P2d;
import bomberOne.model.observation.EnemyTriggeredObservation;
import bomberOne.model.enemy.Enemy;

public class IntermediateBehavior implements Actions{
	
	/* Fields. */
	private EnemyTriggeredObservation triggeredObs;
	private BasicBehavior basicActions;
	private Enemy selectedEnemy;
	
	/* Constructor. */
	public IntermediateBehavior(P2d playerPosition, Enemy newEnemy) {
		this.triggeredObs = new EnemyTriggeredObservation(playerPosition);
		this.selectedEnemy = newEnemy;
		this.basicActions = new BasicBehavior(this.selectedEnemy);
	}
	
	/* Methods. */
	
	@Override
	public void doActions() {
		
	}
}