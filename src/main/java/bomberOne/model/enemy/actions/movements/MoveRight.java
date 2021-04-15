package bomberone.model.enemy.actions.movements;

import bomberone.model.common.P2d;

public class MoveRight implements Movement{
	
	/**
	 * This method sets the first coordinate value to a value greater than the current.
	 */
	@Override
	public P2d doMovement(P2d currentPosition, double speed) {
		return new P2d(currentPosition.getX() + speed, currentPosition.getY());
	}
}
