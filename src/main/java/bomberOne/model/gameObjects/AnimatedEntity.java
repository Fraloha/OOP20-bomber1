package bomberOne.model.gameObjects;

import bomberOne.model.common.Direction;

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
	 * Method that
	 * @return Direction of the Entity
	 */
	Direction getDir();
}