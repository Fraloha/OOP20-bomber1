package bomberOne.model.gameObjects;

import java.awt.image.BufferedImage;

import bomberOne.model.common.Direction;
import bomberOne.model.common.P2d;

public abstract class AnimatedEntity extends GameObjectImpl implements GameObject {

	int elapsed;
	Direction dir;
	
	public AnimatedEntity(P2d pos, BufferedImage img, int lifes, boolean isBreakable) {
		super(pos, img, lifes, isBreakable);
		dir = Direction.DOWN;
	}
	
	public void setTimeElapsed(int elapsed) {
		this.elapsed = elapsed;
	}
	
	public int getTimeElapsed() {
		return this.elapsed;
	}
	
	public void moveUp() {
		this.position.update(elapsed, 0, (-this.speed));
	}
	
	public void moveDown() {
		this.position.update(elapsed, 0, this.speed);
	}
	
	public void moveLeft() {
		this.position.update(elapsed, (-this.speed), 0);
	}
	
	public void moveRight() {
		this.position.update(elapsed, this.speed, 0);
	}
	
	public Direction getDir() {
		return this.dir;
	}
	
	public abstract void attack();

	@Override
	public void update(int elapsed) {
		

	}

}
