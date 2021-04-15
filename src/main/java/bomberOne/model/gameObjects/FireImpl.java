package bomberone.model.gameObjects;

import java.awt.image.BufferedImage;

import bomberone.model.common.P2d;
/**
 * This class implements a simple Fire who extends a GameObject
 * @author Gustavo Mazzanti
 *
 */
public class FireImpl extends GameObjectImpl implements Fire {

	private int lifeTime;
	private int thick;
	
	public FireImpl(P2d pos, BufferedImage img, int lifes) {
		super(pos, img, lifes);
		this.lifeTime = 210;
		this.thick = 0;
	}

	@Override
	public void update(int elapsed) {
		if(this.thick++ == this.lifeTime) {
			this.setAlive(false);
		}
	}

}
