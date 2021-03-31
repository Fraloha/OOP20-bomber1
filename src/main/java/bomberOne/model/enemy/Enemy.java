package bomberOne.model.enemy;

import bomberOne.model.gameObjects.GameObject;

/**
 * This interface define a basic enemy.
 * @author Francesco
 *
 */
public interface Enemy extends GameObject{
	
	/* Methods. */
	
	/**
	 * This method changes the coordinates of the enemy in the 2D space.
	 * In particular, it set the second coordinate with a value greater than the current.
	 */
	public void MoveUp();
	
	/**
	 * This method changes the coordinates of the enemy in the 2D space.
	 * In particular, it set the second coordinate with a value lesser than the current.
	 */
	public void MoveDown();
	
	/**
	 * This method changes the coordinates of the enemy in the 2D space.
	 * In particular, it set the first coordinate with a value greater than the current.
	 */
	public void MoveRight();
	
	/**
	 * This method changes the coordinates of the enemy in the 2D space.
	 * In particular, it set the first coordinate with a value lesser than the current.
	 */
	public void MoveLeft();
}