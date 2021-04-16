package bomberOne.model.enemy.actions;

import bomberOne.model.common.P2d;
import bomberOne.model.observation.EnemyTriggeredObservation;
import bomberOne.model.enemy.Enemy;
import bomberOne.model.common.Direction;

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
	
	public void setPlayerPosition(P2d position) {
		this.triggeredObs.setDestination(position);
	}
}