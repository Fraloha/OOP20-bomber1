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
import bomberOne.tools.img.ObjectsImages;

public final class GameObjectFactoryImpl implements GameObjectFactory {

    private static final int BOMBER_LIFES = 3;

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

    @Override
    public GameObject createEnemy(final P2d position, final Difficulty diff) {
        
    }

    @Override
    public GameObject createBox(final P2d position) {
        return new BoxImpl(position, ObjectsImages.BOX.getImage(), 1);
    }

    @Override
    public GameObject createPowerUp(final P2d position, final Type type) {

        BufferedImage powerUpImage = new BufferedImage(0, 0, 0);
        if (type.equals(PowerUp.Type.FirePower)) {
            powerUpImage = ObjectsImages.POWER_FIREPOWER.getImage();
        }
        if (type.equals(PowerUp.Type.Pierce)) {
            powerUpImage = ObjectsImages.POWER_PIERCE.getImage();
        }
        if (type.equals(PowerUp.Type.Speed)) {
            powerUpImage = ObjectsImages.POWER_SPEED.getImage();
        }
        if (type.equals(PowerUp.Type.Time)) {
            powerUpImage = ObjectsImages.POWER_TIMER.getImage();
        }
        PowerUp pU = new PowerUpImpl(position, powerUpImage, 1, true, type);
        return pU;
    }

    @Override
    public GameObject createHardWall(final P2d position) {
        return new HardWall(position, ObjectsImages.HARDWALL.getImage(), 1);
    }

    @Override
    public GameObject createFire(final P2d position) {
        return new FireImpl(position, ObjectsImages.FIRE.getImage(), 1);
    }

    @Override
    public GameObject createBomb(final P2d position, final int firePower, final boolean pierce) {
        return new BombImpl(position, ObjectsImages.BOMB.getImage(), 1, firePower, pierce);
    }

}
