package bomberOne.model.enemy.actions.movements;

import bomberOne.model.common.P2d;

/**
 * This class executes movements on the basis of the enemy speed and position.
 * @author Francesco
 *
 */
public class MovementExecutor {
	
	/* Fields. */
	Movement actualMovement;
	P2d position;
	double speed;
	
	/* Constructors. */
	
	/**
	 * This constructor create a MovementExecutor object.
	 * @param movementToPerform A movement object.
	 * @param currentPosition The current position of the enemy.
	 * @param speed THe speed of the enemy.
	 */
	public MovementExecutor(Movement movementToPerform, P2d currentPosition, double speed) {
		this.actualMovement = movementToPerform;
		this.position = currentPosition;
		this.speed = speed;
	}
	
	public MovementExecutor(P2d currentPosition, double speed) {
		this.position = currentPosition;
		this.speed = speed;
	}

	public P2d execute() {
		return this.actualMovement.doMovement(this.position, speed);
	}
	
	public void setMovement(Movement newMovement) {
		this.actualMovement = newMovement;
	}
}