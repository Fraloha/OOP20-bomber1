package bomberOne.model.bomber;

import java.awt.image.BufferedImage;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

import bomberOne.model.common.Direction;
import bomberOne.model.common.P2d;
import bomberOne.model.factory.GameObjectFactoryImpl;
import bomberOne.model.gameObjects.AnimatedEntityImpl;
import bomberOne.model.gameObjects.Bomb;
import bomberOne.model.gameObjects.BombImpl;
import bomberOne.model.gameObjects.PowerUp.Type;
import bomberOne.model.input.PlayerBehaviour;
import bomberOne.tools.ResourcesLoader;
import javafx.geometry.Rectangle2D;

public final class BomberImpl extends AnimatedEntityImpl implements Bomber {

    /**
     * Constant to initialize the Bomber.
     */
    public static final int FIRE_POWER = 1;
    /**
     * Constant to initialize the Bomber.
     */
    public static final double SPEED = 200;
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
            return Optional.of((BombImpl) new GameObjectFactoryImpl().createBomb(this.roundingBombPos(getPosition()),
                    this.firePower, this.pierce));
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
        System.out.println("moveUP");
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
        System.out.println("moveDOWN");
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
        System.out.println("moveLEFT");
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
        System.out.println("moveRIGHT");
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
        if (!this.isStatic() && ++this.fpAgg == 10) {
            this.fpAgg = 0;
            this.animationIndex++;
        }
        if (this.spriteIndex == 4 && this.animationIndex % 4 == 3) {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.respawn();
        }
        if (this.isStatic() && this.spriteIndex != 4) {
            this.animationIndex = 0;
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

    /**
     * Method that get in input the current position of the bomber, and return the
     * position rounded when the Bomber can plant a bomb.
     * 
     * @param actualPos
     * @return P2d
     */
    private P2d roundingBombPos(final P2d actualPos) {
        double x, y;
        double mX = actualPos.getX() % 32;
        double mY = actualPos.getY() % 32;
        if (mX < 16) {
            x = actualPos.getX() - mX;
        } else {
            x = actualPos.getX() + (32 - mX);
        }
        if (mY < 16) {
            y = actualPos.getY() - mY;
        } else {
            y = actualPos.getY() + (32 - mY);
        }
        return new P2d(x, y);
    }
}
