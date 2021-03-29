package bomberOne.model.event;

import bomberOne.model.gameObjects.PowerUp;

public class PickPowerUpEvent implements WorldEvent{
	
	private PowerUp powerUp;
	
	public PickPowerUpEvent(PowerUp pU) {
		this.powerUp = pU;
	}
	
	public PowerUp getPowerUp() {
		return this.powerUp;
	}

}
