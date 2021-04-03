package bomberOne.model.bomber;

import java.awt.image.BufferedImage;

import bomberOne.model.common.Direction;
import bomberOne.model.common.P2d;
import bomberOne.model.gameObjects.AnimatedEntity;
import bomberOne.model.gameObjects.Bomb;
import bomberOne.model.gameObjects.BombImpl;
import bomberOne.model.gameObjects.PowerUp;
import bomberOne.model.gameObjects.PowerUp.type;

public class Bomber extends AnimatedEntity {
	private static final int SPEED_INC = 2;
	private static final int AMMO_INC = 1;
	private static final int FIRE_POWER_INC = 2;
	private final P2d startPosition;
	private int firePower;
	private int speed;
	private boolean pierce;
	private int maxAmmo;
	private int usedAmmo;
	private PowerUpHandler activator;
	private int sprites; //0 UP, 1 DOWN, 2 LEFT, 3 RIGHT, 4 DEATH
	private Direction direction;

	private Bomber(P2d pos, BufferedImage img, int lifes, boolean isBreakable) {
		super(pos, img, lifes, isBreakable);
		this.startPosition = pos;
		this.firePower  = 1;
		this.speed = 1;
		this.pierce = false;
		this.maxAmmo = 1;
		this.usedAmmo = 0;
		this.sprites = 1;
		this.direction = Direction.DOWN;
	}
	
	public void setPowerUpHandler(PowerUpHandler activator) {
		this.activator = activator;
	}
	
	
	
	public void respawn() {
		this.position = startPosition;
		this.firePower = 1;
		this.speed = 1;
		this.pierce = false;
		this.maxAmmo = 1;
		this.usedAmmo = 0;
		this.sprites = 1;
		this.direction = Direction.DOWN;
	}
	
	public void addLifes(int lifes) {
		this.lifes += lifes;
	}
	
	public void restoreAmmo() {
		this.usedAmmo--;
	}
	
	public Bomb plantBomb() {
		if(this.maxAmmo>this.usedAmmo) {
			usedAmmo++;
			return new BombImpl(this.position, null, 1, true, this.firePower, this.pierce);
		}
		return null;
	}
	
	public void applyPowerUp(PowerUp.type typeOfPowerUp){
		switch (typeOfPowerUp) {
			case FirePower:
				this.firePower += FIRE_POWER_INC;
				break;
			case Ammo:
				this.maxAmmo += AMMO_INC;
				break;
			case Pierce:
				this.pierce = true;
				break;
			case Speed:
				this.speed += SPEED_INC;
				break;
		}
	}
	
	public int getSprite() {
		return this.sprites;
	}
	
	public Direction getDirection(){
		return this.direction;
	}
	
	public void setUpHandler(PowerUpHandler activator) {
		this.activator = activator;
	}
	
	@Override
	public void moveUp() {
		this.sprites = 0;
		this.direction = Direction.UP;
		super.moveUp();
	}

	@Override
	public void moveDown() {
		this.sprites = 1;
		this.direction = Direction.DOWN;
		super.moveDown();
	}

	@Override
	public void moveLeft() {
		this.sprites = 2;
		this.direction = Direction.LEFT;
		super.moveLeft();
	}

	@Override
	public void moveRight() {
		this.sprites = 3;
		this.direction = Direction.RIGHT;
		super.moveRight();
	}

	@Override
	public void attack() {
		
	}
	
	@Override
	public void hitted() {
		this.lifes--;
		if(this.lifes>=0) {
			this.respawn();
		} else {
			this.sprites = 4;
			this.isAlive = false;
		}
	}

	@Override
	public void update(int elapsed) {
		super.update(elapsed);
		if(!this.isAlive) {
			this.sprites = 4;
		}
	}
}
