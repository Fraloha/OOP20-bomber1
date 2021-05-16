package bomberone.model.factory;

import bomberone.model.bomber.BomberImpl;
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
import bomberone.model.match.Difficulty;
import bomberone.model.user.Skins;
import bomberone.views.game.img.AnimatedObjectsSprites;
import bomberone.views.game.img.GameImages;

public class GameObjectFactoryImpl implements GameObjectFactory {

    private static final int BOMBER_LIFES = 3;

    /**
     * {@inheritDoc}
     */
    @Override
    public GameObject createBomber(final P2d position, final Skins color) {
        return new BomberImpl(position, GameObjectFactoryImpl.BOMBER_LIFES);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public GameObject createEnemy(final P2d position, final Difficulty diff) {
        return new EnemyImpl(position, 1, diff);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public GameObject createBox(final P2d position) {
        return new BoxImpl(position, 1);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public GameObject createPowerUp(final P2d position, final Type type) {
        PowerUp pU = new PowerUpImpl(position, 1, true, type);
        return pU;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public GameObject createHardWall(final P2d position) {
        return new HardWall(position, 1);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public GameObject createFire(final P2d position) {
        return new FireImpl(position, 1);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public GameObject createBomb(final P2d position, final int firePower, final boolean pierce) {
        if (pierce) {
            return new BombImpl(position, 1, firePower, pierce); 
        }
        return new BombImpl(position, 1, firePower, pierce);
    }

}
