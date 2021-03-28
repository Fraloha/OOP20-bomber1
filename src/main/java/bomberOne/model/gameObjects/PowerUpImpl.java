package bomberOne.model.gameObjects;

import java.awt.image.BufferedImage;

import bomberOne.model.common.P2d;

public class PowerUpImpl extends AbstractGameObjectImpl implements PowerUp {

	
	private boolean released;
	private PowerUp.type type;
	
	public PowerUpImpl(P2d pos, BufferedImage img, int lifes, boolean isBreakable, PowerUp.type type) {
		super(pos, img, lifes, isBreakable);
		this.released = false;
		this.type = type;
	}

	@Override
	public boolean isReleased() {
		return this.released;
	}

	@Override
	public void release() {
		this.released = true;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public bomberOne.model.gameObjects.PowerUp.type getType() {
		return this.type;
	}
	
	
}
