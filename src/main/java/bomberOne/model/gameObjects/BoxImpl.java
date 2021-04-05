package bomberOne.model.gameObjects;

import java.awt.image.BufferedImage;
import java.util.Optional;

import bomberOne.model.common.P2d;

public class BoxImpl extends GameObjectImpl implements Box {

	private Optional<PowerUp> powerUp;	
	
	public BoxImpl(P2d pos, BufferedImage img, int lifes, boolean isBreakable) {
		super(pos, img, lifes, isBreakable);
	}

	@Override
	public void update(int elapsed) {
		if(this.lifes == 0) {
			this.isAlive = false;
		}
	}
	
	@Override
	public Optional<PowerUp> getPowerUp() {
		return (this.powerUp.equals(Optional.empty())) ? Optional.empty() : this.powerUp;
	}

	@Override
	public void addPowerUp(PowerUp pU) {
		this.powerUp = Optional.of(pU);
	}
	
	/**
	 * If the box contains the PowerUp, release it
	 */
	@Override
	public void hitted() {
		if(!this.powerUp.isEmpty()) {
			this.powerUp.get().release();
		}
		super.hitted();
	}

}
