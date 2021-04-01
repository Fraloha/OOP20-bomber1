package bomberOne.model.enemy.actions;

import bomberOne.model.common.P2d;
import bomberOne.model.enemy.actions.movements.*;

/**
 * This interface defines the actions of an enemy.
 * @author Francesco
 *
 */
public interface Actions {
	
	public P2d doAction(MovementExecutor executor);
	
	public void Attack();
}