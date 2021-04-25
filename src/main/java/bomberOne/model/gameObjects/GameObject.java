package bomberOne.model.gameObjects;

import java.awt.image.BufferedImage;

import bomberOne.model.common.P2d;
import javafx.geometry.BoundingBox;
import javafx.geometry.Rectangle2D;

public interface GameObject {

    /**
     * 
     * Associates the Buffered Image with Object.
     * 
     * @param img the Buffered Image
     */
    void setImage(BufferedImage img);

    /**
     * 
     * @return the Image of the Object
     */
    BufferedImage getImage();

    /**
     * Repeatedly called during the game loop.
     * @param elapsed
     */
    void update(int elapsed);

    /**
     * 
     * @return the position of the Object through a P2d
     */
    P2d getPosition();

    /**
     * Sets a new Position for the GameObject.
     * 
     * @param newPos the new Position to set
     */
    void setPosition(P2d newPos);

    /**
     * 
     * @return the Rectangle associated with the Object
     */
    Rectangle2D getBoundingBox();

    /**
     * Sets the BoundingBox.
     * @param bBox
     */
    void setBoundingBox(Rectangle2D bBox);

    /**
     * 
     * @return the number of Object's lifes
     */
    int getLifes();

    /**
     * Set the number of Object lifes.
     * @param lifes
     */
    void setLifes(int lifes);

    /**
     * 
     * @return True is the number of lifes of the Object is > 0
     */
    boolean isAlive();

    /**
     * Decreases the number of lifes of the Object.
     */
    void hitted();

}
