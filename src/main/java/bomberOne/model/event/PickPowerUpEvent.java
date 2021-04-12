package bomberOne.model.event;

import bomberOne.model.GameModel;
import bomberOne.model.gameObjects.PowerUp;

public class PickPowerUpEvent implements WorldEvent{
	

	private static final int TIMER_INC = 30;
	private PowerUp powerUp;
	
	public PickPowerUpEvent(PowerUp pU) {
		this.powerUp = pU;
	}
	
	public PowerUp getPowerUp() {
		return this.powerUp;
	}

	/*
	 * When the Bomber picks the PowerUp, this method applies the PowerUp to the Bomber
	 */
	@Override
	public void process(GameModel model) {
		if(this.powerUp.getType().equals(PowerUp.type.Time)) {
			model.getTime().setTimer(model.getTime().getTime().getTotal() + TIMER_INC);
		}
		else {
			model.getWorld().getBomber().applyPowerUp(this.powerUp.getType());			
		}
		this.powerUp.hitted();
	}

}
