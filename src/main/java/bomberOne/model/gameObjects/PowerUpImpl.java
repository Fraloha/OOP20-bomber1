package bomberOne.model.gameObjects;

import java.awt.image.BufferedImage;

import bomberOne.model.common.P2d;

public class PowerUpImpl extends AbstractGameObjectImpl implements PowerUp {

	public enum type{
		FirePower,
		Speed,
		Pierce,
		Time;
	}
	
	private boolean released;
	
	public PowerUpImpl(P2d pos, BufferedImage img, int lifes, boolean isBreakable) {
		super(pos, img, lifes, isBreakable);
		this.released = false;
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
	
	
}
