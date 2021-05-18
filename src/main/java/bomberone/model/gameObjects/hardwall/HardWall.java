package bomberone.model.gameObjects.hardwall;


import bomberone.model.common.P2d;
import bomberone.model.gameObjects.GameObjectImpl;

/**
 * HardWall Object.
 *
 */
public class HardWall extends GameObjectImpl {

    public HardWall(final P2d pos, final int lifes) {
        super(pos, lifes);
    }

    @Override
    public void update(final int elapsed) {
    }

}
