package bomberone.model.enemy.actions;

import bomberone.model.common.P2d;
import bomberone.model.enemy.actions.movements.*;

public class ActionsImpl implements Actions{
	
	/* Methods. */
	@Override
	public P2d MoveEnemy(Movement newMovement, P2d currentPosition, double speed) {
		return new ExecuteMovement(newMovement).execute(currentPosition, speed);
	}
	
	public void Attack() {
		
	}
}