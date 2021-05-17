package bomberone.model.gameObjects;

import bomberone.model.common.Direction;

/**
 * This Entity represent every GameObject that can be moved in the World.
 *
 */
public interface AnimatedEntity extends GameObject {

    /**
     * Method to set TimeElapsed every frame.
     * 
     * @param elapsed
     */
    void setTimeElapsed(int elapsed);

    /**
     * Method that return the time elapsed.
     * 
     * @return TimeElapsed
     */
    int getTimeElapsed();

    /**
     * Method to set speed.
     * 
     * @param speed
     */
    void setSpeed(double speed);

    /**
     * Method that return the current speed.
     * 
     * @return speed of the Object
     */
    double getSpeed();

    /**
     * Method to moveUp the Entity of one pixel.
     */
    void moveUp();

    /**
     * Method to moveDown the Entity of one pixel.
     */
    void moveDown();

    /**
     * Method to moveLeft the Entity of one pixel.
     */
    void moveLeft();

    /**
     * Method to moveRight the Entity of one pixel.
     */
    void moveRight();

    /**
     * Method to set the direction.
     * 
     * @param dir
     */
    void setDir(Direction dir);

    /**
     * Method that return the current Direction.
     * 
     * @return Direction of the Entity.
     */
    Direction getDir();

    /**
     * @return True if the Animated Entity is static
     */
    boolean isStatic();

    /**
     * Set the isStatic propriety as "value".
     * 
     * @param value
     */
    void setStatic(boolean value);

    /**
     * Sets the AnimatedEntity direction index.
     * 
     * @param index The value of the index.
     */
    void setDirectionIndex(int index);

    /**
     * Sets the AnimatedEntity animation index.
     * 
     * @param index The value of the index
     */
    void setAnimationIndex(int index);

    /**
     * Gets the current direction index.
     * 
     * @return the value of the current sprite index.
     */
    int getDirectionIndex();

    /**
     * Gets the current animation index.
     * 
     * @return the value of the animation index.
     */
    int getAnimationIndex();

}
