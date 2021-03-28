package bomberOne.model.gameObjects;

import java.awt.image.BufferedImage;
import java.util.Optional;

import bomberOne.model.common.P2d;
import bomberOne.model.physics.BoundingBoxImpl;

public class BoxImpl extends AbstractGameObjectImpl implements Box {
	private static final int BOXDIMENTIONS = 32;
	private static final int BOXLIFES = 1;
	Optional<PowerUp> powerUp;
	
	
	public BoxImpl(P2d pos, BufferedImage img, int lifes, boolean isBreakable) {
		super(pos, img, BOXLIFES, true);
		this.collider = new BoundingBoxImpl(this.position, new P2d(this.position.x + BOXDIMENTIONS, this.position.y + BOXDIMENTIONS));
	}

	@Override
	public void update() {
		if(this.lifes == 0) {
			this.isAlive = false;
		}
	}
	
	@Override
	public Optional<PowerUp> getPowerUp() {
		return (this.powerUp.equals(Optional.empty())) ? Optional.empty() : Optional.of(this.powerUp.get());
	}

	@Override
	public void addPowerUp(PowerUp pU) {
		this.powerUp = Optional.of(pU);
	}

}
