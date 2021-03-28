package bomberOne.model.gameObjects;

public interface PowerUp {

	/**
	 * 
	 * @return True, if the PowerUp is dropped by the box
	 */
	public boolean isReleased();
	
	/**
	 * When the Box is destroyed, it calls this method
	 */
	public void release();
}
