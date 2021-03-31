package bomberOne.model.enemy.actions;

import bomberOne.model.common.P2d;
import bomberOne.model.enemy.actions.movements.*;

/**
 * This interface defines the actions of an enemy.
 * @author Francesco
 *
 */
public interface Actions {
	
	/**
	 * This method sets the current position of the enemy to a new one.
	 */
	public P2d MoveEnemy(Movement enemyMovement, P2d currentPositon, double speed);
	
	/**
	 * This method attacks the player.
	 */
	public void Attack();
}