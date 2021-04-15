package bomberone.model.enemy.actions.movements;

import bomberone.model.common.P2d;

/**
 * This class defines the enemy up movement.
 * @author Francesco
 *
 */
public class MoveUp implements Movement{
	
	/* Methods. */
	
	/**
	 * This method sets the current position second coordinate to 
	 * a value greater than the current.
	 * @return the new position.
	 */
	@Override
	public P2d doMovement(P2d currentPosition, double speed) {
		return new P2d(currentPosition.getX(), currentPosition.getY() + speed);
	}
}
