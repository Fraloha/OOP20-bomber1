package bomberOne.model.enemy.actions;

import bomberOne.model.common.P2d;
import bomberOne.model.observation.EnemyTriggeredObservation;
import bomberOne.model.enemy.Enemy;

public class IntermediateBehavior implements Actions{
	
	/* Fields. */
	EnemyTriggeredObservation triggeredObs;
	Enemy selectedEnemy;
	
	/* Constructor. */
	public IntermediateBehavior(P2d playerPosition, Enemy newEnemy) {
		this.triggeredObs = new EnemyTriggeredObservation(playerPosition);
		this.selectedEnemy = newEnemy;
	}
	
	/* Methods. */
	
	private void followByRow(boolean direction) {
		
	}
	
	private void followByColumn(boolean direction) {
		
	}
	
	@Override
	public P2d doAction(P2d currentPosition, double speed) {
		
		return currentPosition;
	}
}