package bomberOne.model.gameObjects;

import java.awt.image.BufferedImage;
import java.util.Date;

import bomberOne.model.common.P2d;

public abstract class AnimatedEntity extends GameObjectImpl implements GameObject {

	int elapset;
	
	public AnimatedEntity(P2d pos, BufferedImage img, int lifes, boolean isBreakable) {
		super(pos, img, lifes, isBreakable);
	}
	
	public int getTimeElapset() {
		return 0;
	}
	
	public void moveUp() {
		//this.position.update(0, this.position.getX(), this.position.getY() + 1);
	}
	
	public void moveDown() {
		
	}
	
	public void moveLeft() {
		
	}
	
	public void moveRight() {
		
	}
	
	public abstract void attack();

	@Override
	public void update(int elapsed) {
		// TODO Auto-generated method stub

	}

}
