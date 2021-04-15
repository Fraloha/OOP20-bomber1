package bomberone.model.enemy.actions.movements;

import bomberone.model.common.P2d;

/**
 * This interface define a generic movement.
 * @author Francesco
 *
 */
public interface Movement {
	
	/* Methods. */
	public P2d doMovement(P2d currentPosition, double speed);
}