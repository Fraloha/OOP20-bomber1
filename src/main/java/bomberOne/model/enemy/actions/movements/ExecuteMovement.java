package bomberone.model.enemy.actions.movements;

import bomberone.model.common.P2d;

public class ExecuteMovement {
	
	/* Fields. */
	Movement actualMovement;
	
	/* Constructor. */
	public ExecuteMovement(Movement movementToPerform) {
		this.actualMovement = movementToPerform;
	}
	
	public P2d execute(P2d currentPosition, double speed) {
		return this.actualMovement.doMovement(currentPosition, speed);
	}
}