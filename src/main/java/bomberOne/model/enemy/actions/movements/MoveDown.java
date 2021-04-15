package bomberone.model.enemy.actions.movements;

import bomberone.model.common.P2d;

/**
 * This class define the enemy down movement.
 * @author Francesco
 *
 */
public class MoveDown implements Movement{
	
	/* Methods. */
	
	/**
	 * This method sets the second coordinate to a value lesser than the current.
	 */
	@Override
	public P2d doMovement(P2d currentPosition, double speed) {
		return new P2d(currentPosition.getX(), currentPosition.getY() - speed);
	}
	
}
