package bomberOne.model.bomber;

import bomberOne.model.GameModel;

public interface PowerUpHandler {
	/**
	 * This method apply the powerUp More Fire Power
	 */
	public void applyFirePower();
	
	/**
	 * This method apply the powerUp More Speed
	 */
	public void applySpeed();
	
	/**
	 * This method apply the powerUp Pierce
	 */
	public void activatePierce();
	
	/**
	 * This method apply the powerUp More Ammo
	 */
	public void applyMultiAmmo();	
}
