package bomberOne.model.gameObjects;

import bomberOne.model.common.Direction;
import java.awt.image.BufferedImage;

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
     * Method to moveUp the Entity.
     */
    void moveUp();

    /**
     * Method to moveDown the Entity.
     */
    void moveDown();

    /**
     * Method to moveLeft the Entity.
     */
    void moveLeft();

    /**
     * Method to moveRight the Entity.
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
     * Gets the current image (sprite) of the AnimatedEntity.
     * (See the documentation of AnimatedEntityImpl to learn more.)
     * @return A BufferedImage object that contains the current sprite of the AnimatedEntity.
     */
    BufferedImage getImage();

    /**
     * Sets the AnimatedEntity sprite index.
     * (See the documentation of AnimatedEntityImpl to learn more.)
     * @param index The value of the index.
     */
    void setSpriteIndex(int index);

    /**
     * Sets the AnimatedEntity animation index.
     * (See the documentation of AnimatedEntityImpl to learn more.)
     * @param index The value of the index
     */
    void setAnimationIndex(int index);

    /**
     * Gets the current sprite index.
     * @return the value of the current sprite index.
     */
    int getSpriteIndex();

    /**
     * Gets the current animation index.
     * @return the value of the animation index.
     */
    int getAnimationIndex();
}
