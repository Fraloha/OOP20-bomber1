package bomberOne.model.gameObjects;

import java.awt.image.BufferedImage;

import bomberOne.model.common.Direction;
import bomberOne.model.common.P2d;

public class AnimatedEntityImpl extends GameObjectImpl implements AnimatedEntity {

	private int elapsed;
	private Direction dir;
	private double speed;
	private boolean isStatic;
	
	public AnimatedEntityImpl(P2d pos, BufferedImage img, int lifes) {
		super(pos, img, lifes);
		this.dir = Direction.DOWN;
		this.isStatic = true;
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
	public void setSpeed(double speed) {
		this.speed = speed;
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
	public void setDir(Direction dir) {
		this.dir = dir;
	}
	
	@Override
	public Direction getDir() {
		return this.dir;
	}

	@Override
	public void update(int elapsed) {
		this.setTimeElapsed(elapsed);
	}

	@Override
	public boolean isStatic() {
		return this.isStatic;
	}

	@Override
	public void setStatic(boolean value) {
		this.isStatic = value;
	}
}
