package bomberOne.model.enemy.actions;

import bomberOne.model.common.P2d;

/**
 * This interface defines the actions of an enemy.
 * @author Francesco
 *
 */
public interface Actions {
	
	public P2d doAction(P2d currentPosition, double speed);
}