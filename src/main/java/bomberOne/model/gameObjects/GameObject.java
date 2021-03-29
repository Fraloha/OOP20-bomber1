package bomberOne.model.gameObjects;

import java.awt.image.BufferedImage;

import bomberOne.model.common.P2d;
import bomberOne.model.physics.BoundingBox;

public interface GameObject {

	/**
	 * 
	 * Associates the Buffered Image with Object
	 * @param img the Buffered Image
	 */
	public void setImage(BufferedImage img);
	
	/**
	 * 
	 * @return the Image of the Object
	 */
	public BufferedImage getImage();
	
	/**
	 * Repeatedly called during the game loop.
	 */
	public void update();
	
	/**
	 * 
	 * @return the position of the Object through a P2d
	 */
	public P2d getPosition();
	
	/**
	 * 
	 * @return the Rectangle associated with the Object
	 */
	public BoundingBox getBoundingBox();
	
	/**
	 * 
	 * @return speed of the Object
	 */
	public double getSpeed();
	
	/**
	 * 
	 * @return the number of Object's lifes
	 */
	public int getLifes();
	
	
	/**
	 * 
	 * @return True is the number of lifes of the Object is > 0
	 */
	public boolean isAlive();
	
	/**
	 * 
	 * @return True if Obj is hitted from an explosion
	 */
	public boolean isHitted();
	
	/**
	 * Decreases the number of lifes of the Object
	 */
	public void hitted();
	
	/**
	 * 
	 * @return True if the Object is Breakable
	 */
	public boolean isBreakable();
}
