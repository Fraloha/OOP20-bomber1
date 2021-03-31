package bomberOne.model.enemy.actions.movements;

import bomberOne.model.common.P2d;

public class MoveRight implements Movement{
	
	/* Methods. */
	/**
	 * This method sets the first coordinate value to a value greater than the current.
	 * @return the new position.
	 */
	@Override
	public P2d doMovement(P2d currentPosition, double speed) {
		return new P2d(currentPosition.getX() + speed, currentPosition.getY());
	}
}