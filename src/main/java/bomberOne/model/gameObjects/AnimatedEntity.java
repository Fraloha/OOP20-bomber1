package bomberone.model.gameObjects;

import bomberone.model.common.Direction;

public interface AnimatedEntity extends GameObject{

	/**
	 * Method to set TimeElapsed at
	 * @param elapsed
	 */
	void setTimeElapsed(int elapsed);
	
	/**
	 * Method that
	 * @return TimeElapsed
	 */
	int getTimeElapsed();
	
	/**
	 * Method to set
	 * @param speed
	 */
	void setSpeed(double speed);
	
	/**
	 * 
	 * @return speed of the Object
	 */
	double getSpeed();
	
	/**
	 * Method to moveUp the Entity
	 */
	void moveUp();

	/**
	 * Method to moveDown the Entity
	 */
	void moveDown();

	/**
	 * Method to moveLeft the Entity
	 */
	void moveLeft();

	/**
	 * Method to moveRight the Entity
	 */
	void moveRight();

	/**
	 * Method to set
	 * @param dir
	 */
	void setDir(Direction dir);
	
	/**
	 * Method that
	 * @return Direction of the Entity
	 */
	Direction getDir();
	
	/**
	 * @return True if the Animated Entity is static
	 */
	boolean isStatic();
	
	/**
	 * Set the isStatic propriety as "value"
	 */
	void setStatic(boolean value);
}