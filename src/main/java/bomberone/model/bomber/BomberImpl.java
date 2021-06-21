package bomberone.model.bomber;

import java.util.Optional;

import bomberone.model.common.Direction;
import bomberone.model.common.P2d;
import bomberone.model.factory.GameObjectFactoryImpl;
import bomberone.model.gameObjects.bomb.Bomb;
import bomberone.model.gameObjects.bomb.BombImpl;
import bomberone.model.gameObjects.moveable.MoveableObjectImpl;
import bomberone.model.gameObjects.powerUp.PowerUp.Type;

public final class BomberImpl extends MoveableObjectImpl implements Bomber {

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
    private int fpAgg = 0;
    private boolean isChangedDir = false;

    public BomberImpl(final P2d pos, final int lifes) {
        super(pos, lifes);
        this.setSpeed(SPEED);
        this.setDir(DIR);
        this.startPosition = pos;
        this.firePower = FIRE_POWER;
        this.pierce = false;
        this.maxAmmo = AMMO;
        this.usedAmmo = 0;
        this.setDirectionIndex(SPRITES);
        this.setAnimationIndex(0);
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
        this.setDirectionIndex(SPRITES);
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
            this.usedAmmo++;
            return Optional.of((BombImpl) new GameObjectFactoryImpl().createBomb(this.roundingBombPos(this.getPosition()),
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
            this.incFirePower();
            break;
        case Ammo:
            this.incAmmo();
            break;
        case Pierce:
            this.activatePierce();
            break;
        case Speed:
            this.incSpeed();
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
    public boolean getPierce() {
        return this.pierce;
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
                    this.setAnimationIndex(0);
                    this.setDirectionIndex(0);
                    break;
                case DOWN:
                    this.setAnimationIndex(0);
                    this.setDirectionIndex(1);
                    break;
                case LEFT:
                    this.setAnimationIndex(0);
                    this.setDirectionIndex(2);
                    break;
                case RIGHT:
                    this.setAnimationIndex(0);
                    this.setDirectionIndex(3);
                    break;
                default:
                    break;
                }
                this.isChangedDir = false;
            }
            if (!this.isStatic() && ++this.fpAgg == WALKING_TIME) {
                this.fpAgg = 0;
                this.setAnimationIndex((this.getAnimationIndex() + 1));
            }
        } else {
            if (this.getDirectionIndex() != 4) {
                this.setAnimationIndex(0);
                this.setDirectionIndex(4);
                this.fpAgg = 0;
            } else if (++this.fpAgg == DEATH_TIME) {
                this.fpAgg = 0;
                this.setAnimationIndex((this.getAnimationIndex() + 1));
            }
            if (this.getDirectionIndex() == 4 && this.getAnimationIndex() == 3) {
                this.respawn();
            }
        }
        if (this.isStatic() && this.getDirectionIndex() != 4) {
            this.setAnimationIndex(0);
        }
        super.update(elapsed);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void incSpeed() {
        this.setSpeed(this.getSpeed() + SPEED_INC);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void incAmmo() {
        this.maxAmmo += AMMO_INC;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void incFirePower() {
        this.firePower += FIRE_POWER_INC;
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
