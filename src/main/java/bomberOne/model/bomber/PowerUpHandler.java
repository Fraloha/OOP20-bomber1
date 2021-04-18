package bomberOne.model.bomber;

public interface PowerUpHandler {
	/**
	 * This method apply the powerUp More Fire Power
	 */
	public void applyFirePower(int increment);
	
	/**
	 * This method apply the powerUp More Speed
	 */
	public void applySpeed(double increment);
	
	/**
	 * This method apply the powerUp Pierce
	 */
	public void applyPierce();
	
	/**
	 * This method apply the powerUp More Ammo
	 */
	public void applyMultiAmmo(int increment);	
}
