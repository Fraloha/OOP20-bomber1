package bomberOne.model.enemy.actions.movements;

import bomberOne.model.common.P2d;

public class MovementExecutor {
	
	/* Fields. */
	Movement actualMovement;
	P2d position;
	double speed;
	
	/* Constructor. */
	public MovementExecutor(Movement movementToPerform) {
		this.actualMovement = movementToPerform;
	}
	
	public P2d execute() {
		return this.actualMovement.doMovement(this.position, speed);
	}
}