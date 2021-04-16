package bomberOne.model.bomber;

import java.awt.image.BufferedImage;
import java.util.Optional;

import bomberOne.model.common.Direction;
import bomberOne.model.common.P2d;
import bomberOne.model.factory.GameObjectFactoryImpl;
import bomberOne.model.gameObjects.AnimatedEntityImpl;
import bomberOne.model.gameObjects.Bomb;
import bomberOne.model.gameObjects.BombImpl;
import bomberOne.model.gameObjects.PowerUp;
import bomberOne.tools.ImagesLoader;
import bomberOne.tools.img.SpriteMapsObj;

public class BomberImpl extends AnimatedEntityImpl implements Bomber {
	public static final double SPEED_INC = 2;
	public static final int AMMO_INC = 1;
	public static final int FIRE_POWER_INC = 2;
	private final P2d startPosition;
	private int firePower;
	private boolean pierce;
	private int maxAmmo;
	private int usedAmmo;
	private PowerUpHandler activator;
	private int fpAgg = 0;
	//Images and animations
	private int spriteIndex; //0 UP, 1 DOWN, 2 LEFT, 3 RIGHT, 4 DEATH
	private int animationIndex;
	private BufferedImage[][] animations;
	private boolean isChangedDir = false;

	public BomberImpl(P2d pos, BufferedImage[][] img, int lifes, boolean isBreakable) {
		super(pos, img[0][1], lifes, isBreakable);
		this.setSpeed(SPEED);
		this.setDir(DIR);
		this.animations = img;
		this.startPosition = pos;
		this.firePower  = FIRE_POWER;
		this.pierce = false;
		this.maxAmmo = AMMO;
		this.usedAmmo = 0;
		this.spriteIndex = SPRITES;
		this.animationIndex = 0;
		ImagesLoader.start();
	}
	
	@Override
	public void respawn() {
		this.setSpeed(SPEED);
		this.setDir(DIR);
		this.isAlive  = true;
		this.position = startPosition;
		this.firePower  = FIRE_POWER;
		this.pierce = false;
		this.maxAmmo = AMMO;
		this.usedAmmo = 0;
		this.spriteIndex = SPRITES;
		this.animationIndex = 0;
		this.fpAgg = 0;
	}
	
	@Override
	public void addLifes(int lifes) {
		this.lifes += lifes;
	}
	
	@Override
	public void restoreAmmo() {
		if(this.usedAmmo>0) {
			this.usedAmmo--;
		}
	}
	
	@Override
	public Optional<Bomb> plantBomb() {
		if(this.maxAmmo>this.usedAmmo) {
			usedAmmo++;
			return Optional.of((BombImpl) new GameObjectFactoryImpl().createBomb(new P2d(this.getPosition().getX(), this.getPosition().getY()), this.firePower, this.pierce));
		}
		return Optional.empty();
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
	public int getLifes() {
		return this.lifes;
	}
	
	@Override
	public int getAmmo() {
		return this.maxAmmo - this.usedAmmo;
	}
	
	@Override
	public int getFirePower() {
		return this.firePower;
	}
	
	@Override
	public Direction getDirection(){
		return this.getDir();
	}
	
	@Override
	public boolean isPierced() {
		return this.pierce;
	}
	
	@Override
	public void setUpHandler(PowerUpHandler activator) {
		this.activator = activator;
	}
	
	@Override
	public void moveUp() {
		if(this.getDirection() != Direction.UP) {
			this.isChangedDir = true;
			this.setDir(Direction.UP);
		}
		super.moveUp();
	}

	@Override
	public void moveDown() {
		if(this.getDirection() != Direction.DOWN) {
			this.isChangedDir = true;
			this.setDir(Direction.DOWN);
		}
		super.moveDown();
	}

	@Override
	public void moveLeft() {
		if(this.getDirection() != Direction.LEFT) {
			this.isChangedDir = true;
			this.setDir(Direction.LEFT);
		}
		super.moveLeft();
	}

	@Override
	public void moveRight() {
		if(this.getDirection() != Direction.RIGHT) {
			this.isChangedDir = true;
			this.setDir(Direction.RIGHT);
		}
		super.moveRight();
	}
	
	@Override
	public void hitted() {
		this.lifes--;
		this.isAlive = false;
	}

	@Override
	public void update(int elapsed) {
		if(this.isAlive) {
			if(this.isChangedDir) {
				switch (this.getDir()) {
				case UP:
					this.spriteIndex = 0;
					this.animationIndex = 0;
					break;
				case DOWN:
					this.spriteIndex  = 1;
					this.animationIndex = 0;
					break;
				case LEFT:
					this.spriteIndex = 2;
					this.animationIndex = 0;
					break;
				case RIGHT:
					this.spriteIndex = 3;
					this.animationIndex = 0;
					break;
				}
				this.isChangedDir = false;
			}
		} else {
			this.spriteIndex = 4;
			this.animationIndex = 0;
		}
		if(++this.fpAgg == 4) {
			this.fpAgg = 0;
			this.animationIndex++;
		}
		if(this.spriteIndex == 4 && this.animationIndex%4 == 3) {
			this.respawn();
		}
		super.update(elapsed);
	}

	protected void incSpeed(double increment) {
		this.setSpeed(this.getSpeed() + increment);
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
