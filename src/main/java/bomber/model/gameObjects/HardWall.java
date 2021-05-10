package bomber.model.gameObjects;

import java.awt.image.BufferedImage;

import bomber.model.common.P2d;

/**
 * Wall-Object in the Map.
 *
 */
public class HardWall extends GameObjectImpl {

    public HardWall(final P2d pos, final BufferedImage img, final int lifes) {
        super(pos, img, lifes);
    }

    @Override
    public void update(final int elapsed) {
    }

}
