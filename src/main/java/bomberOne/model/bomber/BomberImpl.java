package bomberOne.model.bomber;

import java.awt.image.BufferedImage;
import java.util.Optional;

import bomberOne.model.common.Direction;
import bomberOne.model.common.P2d;
import bomberOne.model.factory.GameObjectFactoryImpl;
import bomberOne.model.gameObjects.AnimatedEntityImpl;
import bomberOne.model.gameObjects.Bomb;
import bomberOne.model.gameObjects.BombImpl;
import bomberOne.model.gameObjects.PowerUp.Type;
import bomberOne.tools.ResourcesLoader;

public final class BomberImpl extends AnimatedEntityImpl implements Bomber {

    /**
     * Constant to initialize the Bomber.
     */
    public static final int FIRE_POWER = 1;
    /**
     * Constant to initialize the Bomber.
     */
    public static final double SPEED = 100;
    /**
     * Constant to initialize the Bomber.
     */
    public static final int AMMO = 1;
    /**
     * Constant to initialize the Bomber.
     */
    public static final int SPRITES = 1;
    /**
     * Constant to initialize the Bomber.
     */
    public static final Direction DIR = Direction.DOWN;

    /**
     * Constant for set the upgrade from powerUp Bomber.
     */
    public static final double SPEED_INC = 2;
    /**
     * Constant for set the upgrade from powerUp Bomber .
     */
    public static final int AMMO_INC = 1;
    /**
     * Constant for set the upgrade from powerUp Bomber.
     */
    public static final int FIRE_POWER_INC = 2;

    private final P2d startPosition;
    private int firePower;
    private boolean pierce;
    private int maxAmmo;
    private int usedAmmo;
    private PowerUpHandler activator;
    private int fpAgg = 0;
    // Images and animations
    private int spriteIndex; // 0 UP, 1 DOWN, 2 LEFT, 3 RIGHT, 4 DEATH
    private int animationIndex;
    private BufferedImage[][] animations;
    private boolean isChangedDir = false;

    public BomberImpl(final P2d pos, final BufferedImage[][] img, final int lifes) {
        super(pos, img, lifes, img[0][1]);
        this.setSpeed(SPEED);
        this.setDir(DIR);
        this.animations = img;
        this.startPosition = pos;
        this.firePower = FIRE_POWER;
        this.pierce = false;
        this.maxAmmo = AMMO;
        this.usedAmmo = 0;
        this.spriteIndex = SPRITES;
        this.animationIndex = 0;
        ResourcesLoader.start();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void respawn() {
        this.setSpeed(SPEED);
        this.setDir(DIR);
        this.setAlive(true);
        this.setPosition(startPosition);
        this.firePower = FIRE_POWER;
        this.pierce = false;
        this.maxAmmo = AMMO;
        this.usedAmmo = 0;
        this.spriteIndex = SPRITES;
        this.animationIndex = 0;
        this.fpAgg = 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addLifes(final int lifes) {
        this.setLifes(this.getLifes() + lifes);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void restoreAmmo() {
        if (this.usedAmmo > 0) {
            this.usedAmmo--;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<Bomb> plantBomb() {
        if (this.maxAmmo > this.usedAmmo) {
            usedAmmo++;
            return Optional.of((BombImpl) new GameObjectFactoryImpl().createBomb(
                    new P2d(this.getPosition().getX(), this.getPosition().getY()), this.firePower, this.pierce));
        }
        return Optional.empty();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void applyPowerUp(final Type typeOfPowerUp) {
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

    /**
     * {@inheritDoc}
     */
    @Override
    public BufferedImage getImage() {
        return this.animations[this.spriteIndex][this.animationIndex % 4];
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getAmmo() {
        return this.maxAmmo - this.usedAmmo;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getFirePower() {
        return this.firePower;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Direction getDirection() {
        return this.getDir();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isPierced() {
        return this.pierce;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setUpHandler(final PowerUpHandler activator) {
        this.activator = activator;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void moveUp() {
        if (this.getDirection() != Direction.UP) {
            this.isChangedDir = true;
            this.setDir(Direction.UP);
        }
        super.moveUp();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void moveDown() {
        if (this.getDirection() != Direction.DOWN) {
            this.isChangedDir = true;
            this.setDir(Direction.DOWN);
        }
        super.moveDown();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void moveLeft() {
        if (this.getDirection() != Direction.LEFT) {
            this.isChangedDir = true;
            this.setDir(Direction.LEFT);
        }
        super.moveLeft();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void moveRight() {
        if (this.getDirection() != Direction.RIGHT) {
            this.isChangedDir = true;
            this.setDir(Direction.RIGHT);
        }
        super.moveRight();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void hitted() {
        this.setLifes(this.getLifes() - 1);
        this.setAlive(false);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void update(final int elapsed) {
        if (this.isAlive()) {
            if (this.isChangedDir) {
                switch (this.getDir()) {
                case UP:
                    this.spriteIndex = 0;
                    this.animationIndex = 0;
                    break;
                case DOWN:
                    this.spriteIndex = 1;
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
                default:
                    break;
                }
                this.isChangedDir = false;
            }
        } else {
            this.spriteIndex = 4;
            this.animationIndex = 0;
        }
        if (!this.isStatic() && ++this.fpAgg == 4) {
            this.fpAgg = 0;
            this.animationIndex++;
        }
        if (this.spriteIndex == 4 && this.animationIndex % 4 == 3) {
            this.respawn();
        }
        super.update(elapsed);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void incSpeed(final double increment) {
        this.setSpeed(this.getSpeed() + increment);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void incAmmo(final int increment) {
        this.maxAmmo += increment;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void incFirePower(final int increment) {
        this.firePower += increment;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void activatePierce() {
        this.pierce = true;
    }
}
