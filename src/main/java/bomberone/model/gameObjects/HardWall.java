package bomberone.model.gameObjects;


import bomberone.model.common.P2d;

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
