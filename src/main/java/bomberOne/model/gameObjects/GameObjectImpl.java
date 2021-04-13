package bomberOne.model.gameObjects;

import java.awt.image.BufferedImage;

import bomberOne.model.common.P2d;
import bomberOne.model.physics.BoundingBox;
import bomberOne.model.physics.BoundingBoxImpl;

public abstract class GameObjectImpl implements GameObject {
	

	private static final int RECTDIMENTIONS = 32;
	
	protected BufferedImage img;
	protected P2d position;
	protected BoundingBox collider;
	protected int lifes;
	protected boolean isAlive;
	
	public GameObjectImpl(P2d pos, BufferedImage img, int lifes) {
		this.position = pos;
		this.img = img;
		this.lifes = lifes;
		this.isAlive = true;
		this.collider = new BoundingBoxImpl(this.position, new P2d(this.position.getX() + RECTDIMENTIONS, this.position.getY() + RECTDIMENTIONS));
	}
	
	@Override
	public BufferedImage getImage() {
		return img;
	}

	@Override
	public abstract void update(int elapsed);

	
	@Override
	public P2d getPosition() {
		return this.position;
	}

	@Override
	public void setPosition(P2d newPos) {
		this.position = newPos;
	}
	
	@Override
	public BoundingBox getBoundingBox() {
		return this.collider;
	}

	@Override
	public int getLifes() {
		return this.lifes;
	}

	@Override
	public boolean isAlive() {
		return this.isAlive;
	}

	@Override
	public void hitted() {
		this.lifes--;
		if(this.getLifes() == 0) {
			this.isAlive = false;
		}
	}

	@Override
	public void setImage(BufferedImage img) {
		this.img = img;
	}

}
