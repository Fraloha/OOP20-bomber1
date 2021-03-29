package bomberOne.model.gameObjects;

import java.awt.image.BufferedImage;

import bomberOne.model.common.P2d;

public class HardWall extends GameObjectImpl {

	public HardWall(P2d pos, BufferedImage img, int lifes, boolean isBreakable) {
		super(pos, img, lifes, isBreakable);
	}

	@Override
	public void update() {
	}

}
