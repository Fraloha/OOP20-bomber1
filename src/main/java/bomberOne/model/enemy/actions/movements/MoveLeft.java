package bomberOne.model.enemy.actions.movements;

import bomberOne.model.common.P2d;

/**
 * This class define the enemy left movement.
 * @author Francesco
 *
 */
public class MoveLeft implements Movement{
	
	/* Methods. */
	
	/**
	 * This method sets the first coordinate value to a value lesser than the current.
	 * @return the new position.
	 */
	@Override
	public P2d doMovement(P2d currentPosition, double speed) {
		return new P2d(currentPosition.getX() - speed, currentPosition.getY());
	}
}
