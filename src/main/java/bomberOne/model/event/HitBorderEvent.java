package bomberone.model.event;

import bomberone.model.GameModel;
import bomberone.model.common.Direction;
import bomberone.model.common.P2d;
import bomberone.model.enemy.Enemy;
import bomberone.model.enemy.EnemyImpl;
import bomberone.model.gameObjects.AnimatedEntity;
import bomberone.model.gameObjects.GameObject;

/**
 * This event is Triggered when the Bomber or the Enemy hit a Box or an HardWall.
 * 
 * 
 *
 */
public class HitBorderEvent implements WorldEvent {

    private static final int OBJ_DIMETIONS = 32;
    private AnimatedEntity entity;
    private GameObject wall;

    public HitBorderEvent(final AnimatedEntity entity, final GameObject wall) {
        this.entity = entity;
    }

    /**
     * 
     * @return the AnimatedEntity
     */
    public AnimatedEntity getEntity() {
        return this.entity;
    }

    /**
     * 
     * @return the HardWall 
     */
    public GameObject getWall() {
        return this.wall;
    }

    /**
     * Repositioning of the AniatedEntity that is colliding with the Wall/Box.
     * 
     * 
     */
    @Override
    public void process(final GameModel model) {
        if (this.entity.getDir().equals(Direction.UP)) {
            this.entity.setPosition(
                    new P2d(this.entity.getPosition().getX(), this.wall.getPosition().getY() + OBJ_DIMETIONS));
        }
        if (this.entity.getDir().equals(Direction.DOWN)) {
            this.entity.setPosition(
                    new P2d(this.entity.getPosition().getX(), this.wall.getPosition().getY() - OBJ_DIMETIONS));
        }

        if (this.entity.getDir().equals(Direction.LEFT)) {
            this.entity.setPosition(
                    new P2d(this.wall.getPosition().getX() + OBJ_DIMETIONS, this.wall.getPosition().getY()));
        }
        if (this.entity.getDir().equals(Direction.RIGHT)) {
            this.entity.setPosition(
                    new P2d(this.wall.getPosition().getX() - OBJ_DIMETIONS, this.wall.getPosition().getY()));
        }
        if (this.entity.getClass().equals(EnemyImpl.class)) {
            ((Enemy) this.entity).changeDir();
        }
    }

}
