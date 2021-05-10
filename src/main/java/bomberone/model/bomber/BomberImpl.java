package bomberone.model.bomber;

import java.awt.image.BufferedImage;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

import bomberone.model.common.Direction;
import bomberone.model.common.P2d;
import bomberone.model.factory.GameObjectFactoryImpl;
import bomberone.model.gameObjects.AnimatedEntityImpl;
import bomberone.model.gameObjects.Bomb;
import bomberone.model.gameObjects.BombImpl;
import bomberone.model.gameObjects.PowerUp.Type;
import bomberone.tools.audio.AudioHandler;
import bomberone.tools.audio.GameAudio;
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
    public static final double SPEED_INC = 250;
    /**
     * Constant for set the upgrade from powerUp Bomber .
     */
    public static final int AMMO_INC = 1;
    /**
     * Constant for set the upgrade from powerUp Bomber.
     */
    public static final int FIRE_POWER_INC = 2;
    /**
     * Constant for walking animation.
     */
    private static final int WALKING_TIME = 10;
    /**
     * Constant for death animation.
     */
    private static final int DEATH_TIME = 15;

    private final P2d startPosition;
    private int firePower;
    private boolean pierce;
    private int maxAmmo;
    private int usedAmmo;
    private PowerUpHandler activator;
    private int fpAgg = 0;
    private boolean isChangedDir = false;

    public BomberImpl(final P2d pos, final BufferedImage[][] img, final int lifes) {
        super(pos, img, lifes, img[0][1]);
        this.setSpeed(SPEED);
        this.setDir(DIR);
        this.startPosition = pos;
        this.firePower = FIRE_POWER;
        this.pierce = false;
        this.maxAmmo = AMMO;
        this.usedAmmo = 0;
        this.setSpriteIndex(SPRITES);
        this.setAnimationIndex(0);
        this.setUpHandler(new PowerUpHandlerImpl(this));
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
        this.setSpriteIndex(SPRITES);
        this.setAnimationIndex(0);
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
        AudioHandler.start(GameAudio.POWER_UP);
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
        if (this.isAlive()) {
            if (this.getDirection() != Direction.UP) {
                this.isChangedDir = true;
                this.setDir(Direction.UP);
            }
            super.moveUp();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void moveDown() {
        if (this.isAlive()) {
            if (this.getDirection() != Direction.DOWN) {
                this.isChangedDir = true;
                this.setDir(Direction.DOWN);
            }
            super.moveDown();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void moveLeft() {
        if (this.isAlive()) {
            if (this.getDirection() != Direction.LEFT) {
                this.isChangedDir = true;
                this.setDir(Direction.LEFT);
            }
            super.moveLeft();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void moveRight() {
        if (this.isAlive()) {
            if (this.getDirection() != Direction.RIGHT) {
                this.isChangedDir = true;
                this.setDir(Direction.RIGHT);
            }
            super.moveRight();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void hitted() {
        AudioHandler.start(GameAudio.HITTED);
        this.setLifes(this.getLifes() - 1);
        this.setCollider(new Rectangle2D(32, 32, 0, 0));
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
                    this.setAnimationIndex(0);
                    this.setSpriteIndex(0);
                    break;
                case DOWN:
                    this.setAnimationIndex(0);
                    this.setSpriteIndex(1);
                    break;
                case LEFT:
                    this.setAnimationIndex(0);
                    this.setSpriteIndex(2);
                    break;
                case RIGHT:
                    this.setAnimationIndex(0);
                    this.setSpriteIndex(3);
                    break;
                default:
                    break;
                }
                this.isChangedDir = false;
            }
            if (!this.isStatic() && ++this.fpAgg == WALKING_TIME) {
                this.fpAgg = 0;
                this.setAnimationIndex((this.getAnimationIndex() + 1) % 4);
            }
        } else {
            if (this.getSpriteIndex() != 4) {
                this.setAnimationIndex(0);
                this.setSpriteIndex(4);
                this.fpAgg = 0;
            } else if (++this.fpAgg == DEATH_TIME) {
                this.fpAgg = 0;
                this.setAnimationIndex((this.getAnimationIndex() + 1) % 4);
            }
            if (this.getSpriteIndex() == 4 && this.getAnimationIndex() == 3) {
                this.respawn();
            }
        }
        if (this.isStatic() && this.getSpriteIndex() != 4) {
            this.setAnimationIndex(0);
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
