package bomberOne.model.bomber;

import java.awt.image.BufferedImage;

import bomberOne.model.common.Direction;
import bomberOne.model.common.P2d;
import bomberOne.model.gameObjects.AnimatedEntityImpl;
import bomberOne.model.gameObjects.Bomb;
import bomberOne.model.gameObjects.BombImpl;
import bomberOne.model.gameObjects.PowerUp;

public class BomberImpl extends AnimatedEntityImpl implements Bomber {
	private static final int SPEED_INC = 2;
	private static final int AMMO_INC = 1;
	private static final int FIRE_POWER_INC = 2;
	private final P2d startPosition;
	private int firePower;
	private boolean pierce;
	private int maxAmmo;
	private int usedAmmo;
	private PowerUpHandler activator;
	private int fpAgg = 0;
	//Images and animations
	private int spriteIndex; //0 UP, 1 DOWN, 2 LEFT, 3 RIGHT, 4 DEATH
	private Direction direction;
	private int animationIndex = 0;
	private BufferedImage[][] animations;

	public BomberImpl(P2d pos, BufferedImage[][] img, int lifes, boolean isBreakable) {
		super(pos, img[0][1], lifes, isBreakable);
		this.animations = img;
		this.startPosition = pos;
		this.firePower  = FIRE_POWER;
		this.speed = SPEED;
		this.pierce = false;
		this.maxAmmo = AMMO;
		this.usedAmmo = 0;
		this.spriteIndex = SPRITES;
		this.direction = DIR;
	}
	
	@Override
	public void respawn() {
		this.position = startPosition;
		this.firePower  = FIRE_POWER;
		this.speed = SPEED;
		this.pierce = false;
		this.maxAmmo = AMMO;
		this.usedAmmo = 0;
		this.spriteIndex = SPRITES;
		this.direction = DIR;
	}
	
	@Override
	public void addLifes(int lifes) {
		this.lifes += lifes;
	}
	
	@Override
	public void restoreAmmo() {
		this.usedAmmo--;
	}
	
	@Override
	public Bomb plantBomb() {
		if(this.maxAmmo>this.usedAmmo) {
			usedAmmo++;
			return new BombImpl(new P2d(this.position.getX(), this.position.getY()), null, 1, true, this.firePower, this.pierce);
		}
		return null;
	}
	
	@Override
	public void applyPowerUp(PowerUp.type typeOfPowerUp){
		switch (typeOfPowerUp) {
			case FirePower:
				this.activator.applyFirePower(FIRE_POWER_INC);
				break;
			case Ammo:
				this.activator.applyMultiAmmo(AMMO_INC);
				break;
			case Pierce:
				this.activator.applyPierce();
				break;
			case Speed:
				this.activator.applySpeed(SPEED_INC);
				break;
			case Time:
				//TODO richiamare nuovo evento timerIncrease
				break;
			default:
				break;
		}
	}
	
	@Override
	public BufferedImage getImage() {
		return this.animations[this.spriteIndex][this.animationIndex%4];
	}
	
	@Override
	public int getSprite() {
		return this.spriteIndex;
	}
	
	@Override
	public Direction getDirection(){
		return this.direction;
	}
	
	@Override
	public void setUpHandler(PowerUpHandler activator) {
		this.activator = activator;
	}
	
	@Override
	public void moveUp() {
		this.direction = Direction.UP;
		super.moveUp();
	}

	@Override
	public void moveDown() {
		this.direction = Direction.DOWN;
		super.moveDown();
	}

	@Override
	public void moveLeft() {
		this.direction = Direction.LEFT;
		super.moveLeft();
	}

	@Override
	public void moveRight() {
		this.direction = Direction.RIGHT;
		super.moveRight();
	}
	
	@Override
	public void hitted() {
		this.lifes--;
		if(this.lifes>=0) {
			this.respawn();
		} else {
			this.isAlive = false;
		}
	}

	@Override
	public void update(int elapsed) {
		if(this.isAlive) {
			switch (this.direction) {
			case UP:
				this.spriteIndex = 0;
				break;
			case DOWN:
				this.spriteIndex  = 1;
				break;
			case LEFT:
				this.spriteIndex = 2;
				break;
			case RIGHT:
				this.spriteIndex = 3;
				break;
			}
		} else {
			this.spriteIndex = 4;
		}
		if(++this.fpAgg == 4) {
			this.fpAgg = 0;
			this.animationIndex++;
		}
		super.update(elapsed);
	}

	protected void incSpeed(int increment) {
		this.speed += increment;
	}
	
	protected void incAmmo(int increment) {
		this.maxAmmo += increment;
	}
	
	protected void incFirePower(int increment) {
		this.firePower += increment;
	}
	
	protected void activatePierce() {
		this.pierce = true;
	}
}
