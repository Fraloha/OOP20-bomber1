package bomberOne.model.gameObjects;

import java.awt.image.BufferedImage;

import bomberOne.model.common.Direction;
import bomberOne.model.common.P2d;

public class AnimatedEntityImpl extends GameObjectImpl implements AnimatedEntity {

	private int elapsed;
	private Direction dir;
	protected double speed;
	
	public AnimatedEntityImpl(P2d pos, BufferedImage img, int lifes, boolean isBreakable) {
		super(pos, img, lifes, isBreakable);
		dir = Direction.DOWN;
	}
	
	@Override
	public void setTimeElapsed(int elapsed) {
		this.elapsed = elapsed;
	}
	
	@Override
	public int getTimeElapsed() {
		return this.elapsed;
	}
	
	@Override
	public double getSpeed() {
		return this.speed;
	}
	
	@Override
	public void moveUp() {
		this.position.update(elapsed, 0, (-this.speed));
	}
	
	@Override
	public void moveDown() {
		this.position.update(elapsed, 0, this.speed);
	}
	
	@Override
	public void moveLeft() {
		this.position.update(elapsed, (-this.speed), 0);
	}
	
	@Override
	public void moveRight() {
		this.position.update(elapsed, this.speed, 0);
	}
	
	@Override
	public Direction getDir() {
		return this.dir;
	}

	@Override
	public void update(int elapsed) {
		if(this.lifes == 0) {
			this.isAlive = false;
		}
	}
}
