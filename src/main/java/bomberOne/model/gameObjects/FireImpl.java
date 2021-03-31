package bomberOne.model.gameObjects;

import java.awt.image.BufferedImage;

import bomberOne.model.common.P2d;

public class FireImpl extends GameObjectImpl implements Fire {

	public FireImpl(P2d pos, BufferedImage img, int lifes, boolean isBreakable) {
		super(pos, img, lifes, isBreakable);
	}

	@Override
	public void update() {
		if(this.lifes == 0) {
			this.isAlive = false;
		}
	}

}
