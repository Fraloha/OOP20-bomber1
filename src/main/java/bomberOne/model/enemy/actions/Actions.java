package bomberone.model.enemy.actions;

import bomberone.model.common.P2d;
import bomberone.model.enemy.actions.movements.*;

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