package bomberOne.model.enemy.actions;

import bomberOne.model.common.P2d;
import bomberOne.model.enemy.actions.movements.*;
import bomberOne.model.observation.EnemyTriggeredObservation;

public class IntermediateBehavior implements Actions{
	
	/* Fields. */
	MovementExecutor executor;
	EnemyTriggeredObservation triggeredObs;
	
	/* Constructor. */
	public IntermediateBehavior(P2d playerPosition, P2d currentPosition, double speed) {
		this.executor = new MovementExecutor(currentPosition, speed);
		this.triggeredObs = new EnemyTriggeredObservation(playerPosition);
	}
	
	/* Methods. */
	
	private void followByRow(boolean direction) {
		
		if(direction) {
			this.executor.setMovement(new MoveRight());
		}else {
			this.executor.setMovement(new MoveLeft());
		}
		
		this.executor.execute();
	}
	
	private void followByColumn(boolean direction) {
		
		if(direction) {
			this.executor.setMovement(new MoveUp());
		}else {
			this.executor.setMovement(new MoveDown());
		}
		
		this.executor.execute();
	}
	
	public P2d doAction() {
		
	}
}