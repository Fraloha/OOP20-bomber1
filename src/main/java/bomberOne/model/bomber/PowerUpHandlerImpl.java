package bomberOne.model.bomber;

import bomberOne.model.gameObjects.PowerUp;
/**
 * This class apply the powerUp at the Bomber
 * @author Gustavo Mazzanti
 *
 */
public class PowerUpHandlerImpl implements PowerUpHandler {
	
	private final BomberImpl bomber;
		
	public PowerUpHandlerImpl(BomberImpl bomber) {
		this.bomber = bomber;
	}
	
	@Override
	public void applyFirePower(int increment) {
		this.bomber.incFirePower(increment);
	}

	@Override
	public void applySpeed(int increment) {
		this.bomber.incSpeed(increment);
	}

	@Override
	public void applyPierce() {
		this.bomber.activatePierce();
	}

	@Override
	public void applyMultiAmmo(int increment) {
		this.bomber.incAmmo(increment);
	}
}
