package bomberOne.model.factory;

import java.awt.image.BufferedImage;

import bomberOne.model.bomber.BomberImpl;
import bomberOne.model.common.P2d;
import bomberOne.model.gameObjects.BombImpl;
import bomberOne.model.gameObjects.BoxImpl;
import bomberOne.model.gameObjects.FireImpl;
import bomberOne.model.enemy.EnemyImpl;
import bomberOne.model.gameObjects.GameObject;
import bomberOne.model.gameObjects.HardWall;
import bomberOne.model.gameObjects.PowerUp;
import bomberOne.model.gameObjects.PowerUpImpl;
import bomberOne.model.gameObjects.PowerUp.Type;
import bomberOne.model.user.Difficulty;
import bomberOne.model.user.Skins;
import bomberOne.tools.img.AnimatedObjectsSprites;
import bomberOne.tools.img.GameImages;

public class GameObjectFactoryImpl implements GameObjectFactory {

    private static final int BOMBER_LIFES = 3;

    /**
     * {@inheritDoc}
     */
    @Override
    public GameObject createBomber(final P2d position, final Skins color) {
        BufferedImage[][] images = null;
        if (color.equals(Skins.WHITE)) {
            images = AnimatedObjectsSprites.PLAYER_1.getSprites();
        }
        if (color.equals(Skins.BLACK)) {
            images = AnimatedObjectsSprites.PLAYER_2.getSprites();
        }
        if (color.equals(Skins.RED)) {
            images = AnimatedObjectsSprites.PLAYER_3.getSprites();
        }
        if (color.equals(Skins.BLUE)) {
            images = AnimatedObjectsSprites.PLAYER_4.getSprites();
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
        return new BombImpl(position, AnimatedObjectsSprites.BOMB.getSprites(), 1, firePower, pierce);
    }

}
