package bomberone.model.gameObjects;

import java.awt.image.BufferedImage;

import bomberone.model.common.P2d;

public class HardWall extends GameObjectImpl {

    public HardWall(final P2d pos, final BufferedImage img, final int lifes) {
        super(pos, img, lifes);
    }

    @Override
    public void update(final int elapsed) {
    }

}
