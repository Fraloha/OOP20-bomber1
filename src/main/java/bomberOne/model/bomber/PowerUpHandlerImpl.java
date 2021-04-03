package bomberOne.model.bomber;

import bomberOne.model.gameObjects.PowerUp;
/**
 * This class apply the powerUp at the Bomber
 * @author Gustavo Mazzanti
 *
 */
public class PowerUpHandlerImpl implements PowerUpHandler {
	
	private final Bomber bomber;
		
	public PowerUpHandlerImpl(Bomber bomber) {
		this.bomber = bomber;
	}
	
	@Override
	public void applyFirePower() {
		this.bomber.applyPowerUp(PowerUp.type.FirePower);
	}

	@Override
	public void applySpeed() {
		this.bomber.applyPowerUp(PowerUp.type.Speed);
	}

	@Override
	public void activatePierce() {
		this.bomber.applyPowerUp(PowerUp.type.Pierce);
	}

	@Override
	public void applyMultiAmmo() {
		this.bomber.applyPowerUp(PowerUp.type.Ammo);
	}
}
