package bomberOne.model.enemy.actions;

import bomberOne.model.common.P2d;
import bomberOne.model.observation.EnemyTriggeredObservation;

public class IntermediateBehavior implements Actions{
	
	/* Fields. */
	EnemyTriggeredObservation triggeredObs;
	
	/* Constructor. */
	public IntermediateBehavior(P2d playerPosition) {
		this.triggeredObs = new EnemyTriggeredObservation(playerPosition);
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

	@Override
	public void Attack() {
		
	}
}