package bomberOne.model.gameObjects;

import java.awt.image.BufferedImage;

import bomberOne.model.common.P2d;
/**
 * This class implements a simple Fire who extends a GameObject
 * @author Gustavo Mazzanti
 *
 */
public class FireImpl extends GameObjectImpl implements Fire {

	public FireImpl(P2d pos, BufferedImage img, int lifes, boolean isBreakable) {
		super(pos, img, lifes, isBreakable);
	}

	@Override
	public void update(int elapsed) {
		if(this.lifes == 0) {
			this.isAlive = false;
		}
	}

}
