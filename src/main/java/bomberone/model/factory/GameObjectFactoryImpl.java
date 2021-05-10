package bomberone.model.factory;

import java.awt.image.BufferedImage;

import bomberone.model.Difficulty;
import bomberone.model.bomber.BomberImpl;
import bomberone.model.common.AnimatedObjectsSprites;
import bomberone.model.common.GameImages;
import bomberone.model.common.P2d;
import bomberone.model.enemy.EnemyImpl;
import bomberone.model.gameObjects.BombImpl;
import bomberone.model.gameObjects.BoxImpl;
import bomberone.model.gameObjects.FireImpl;
import bomberone.model.gameObjects.GameObject;
import bomberone.model.gameObjects.HardWall;
import bomberone.model.gameObjects.PowerUp;
import bomberone.model.gameObjects.PowerUpImpl;
import bomberone.model.gameObjects.PowerUp.Type;
import bomberone.model.user.Skins;

public class GameObjectFactoryImpl implements GameObjectFactory {

    private static final int BOMBER_LIFES = 3;

    /**
     * {@inheritDoc}
     */
    @Override
    public GameObject createBomber(final P2d position, final Skins color) {
        BufferedImage[][] images = null;
        if (color.equals(Skins.WHITE)) {
            images = AnimatedObjectsSprites.BOMBER_WHITE.getSprites();
        }
        if (color.equals(Skins.BLACK)) {
            images = AnimatedObjectsSprites.BOMBER_BLACK.getSprites();
        }
        if (color.equals(Skins.RED)) {
            images = AnimatedObjectsSprites.BOMBER_RED.getSprites();
        }
        if (color.equals(Skins.BLUE)) {
            images = AnimatedObjectsSprites.BOMBER_BLUE.getSprites();
        }

        return new BomberImpl(position, images, GameObjectFactoryImpl.BOMBER_LIFES);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public GameObject createEnemy(final P2d position, final Difficulty diff) {
        BufferedImage[][] sprites = null;
        // Choosing the enemy sprites on the basis of the difficulty game mode chosen.
        if (diff.equals(Difficulty.STANDARD)) {
            sprites = AnimatedObjectsSprites.ENEMIES_STANDARD.getSprites();
        } else if (diff.equals(Difficulty.HARD)) {
            sprites = AnimatedObjectsSprites.ENEMIES_HARD.getSprites();
        }

        return new EnemyImpl(position, sprites, 1, diff);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public GameObject createBox(final P2d position) {
        return new BoxImpl(position, GameImages.BOX.getImage(), 1);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public GameObject createPowerUp(final P2d position, final Type type) {

        BufferedImage powerUpImage = null;
        if (type.equals(PowerUp.Type.FirePower)) {
            powerUpImage = GameImages.POWER_FIREPOWER.getImage();
        }
        if (type.equals(PowerUp.Type.Pierce)) {
            powerUpImage = GameImages.POWER_PIERCE.getImage();
        }
        if (type.equals(PowerUp.Type.Speed)) {
            powerUpImage = GameImages.POWER_SPEED.getImage();
        }
        if (type.equals(PowerUp.Type.Time)) {
            powerUpImage = GameImages.POWER_TIMER.getImage();
        }
        if (type.equals(PowerUp.Type.Ammo)) {
            powerUpImage = GameImages.POWER_BOMB.getImage();
        }
        PowerUp pU = new PowerUpImpl(position, powerUpImage, 1, true, type);
        return pU;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public GameObject createHardWall(final P2d position) {
        return new HardWall(position, GameImages.HARDWALL.getImage(), 1);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public GameObject createFire(final P2d position) {
        return new FireImpl(position, AnimatedObjectsSprites.FIRE.getSprites(), 1);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public GameObject createBomb(final P2d position, final int firePower, final boolean pierce) {
        if (pierce) {
            return new BombImpl(position, AnimatedObjectsSprites.PIERCED_BOMB.getSprites(), 1, firePower, pierce); 
        }
        return new BombImpl(position, AnimatedObjectsSprites.BOMB.getSprites(), 1, firePower, pierce);
    }

}
