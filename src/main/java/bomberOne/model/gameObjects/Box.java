package bomberOne.model.gameObjects;

import java.util.Optional;

public interface Box extends AbstractGameObject {

	/**
	 * 
	 * @return Optional.empty() if the box doesn't contain the PowerUp, else returns the PowerUp
	 */
	public Optional<PowerUp> getPowerUp();
	
	/**
	 * Puts the PowerUp into the Box
	 * @param pU the PowerUp to put into the Box
	 */
	public void addPowerUp(PowerUp pU);
}
