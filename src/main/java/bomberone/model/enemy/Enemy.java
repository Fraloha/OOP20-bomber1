/**
 * This interface define a basic enemy.
 */

package bomberone.model.enemy;

import bomberone.model.gameObjects.AnimatedEntity;
import bomberone.model.gameObjects.BoxImpl;
import bomberone.model.gameObjects.HardWall;
import java.util.List;

public interface Enemy extends AnimatedEntity {

    /* Methods. */
    void update(int elapsed);

    boolean isHittable();
    
    List<BoxImpl> getBoxes();
    
    List<HardWall> getHardWalls();
}
