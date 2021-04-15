package bomberone.model.gameObjects;

import java.awt.image.BufferedImage;

import bomberone.model.common.P2d;

public class PowerUpImpl extends GameObjectImpl implements PowerUp {

	
	private boolean released;
	private PowerUp.type type;
	
	public PowerUpImpl(P2d pos, BufferedImage img, int lifes, boolean isBreakable, PowerUp.type type) {
		super(pos, img, lifes);
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
	public void update(int elapsed) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public bomberone.model.gameObjects.PowerUp.type getType() {
		return this.type;
	}
	
	
}
