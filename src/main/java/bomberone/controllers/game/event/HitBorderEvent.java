package bomberone.controllers.game.event;


import bomberone.model.GameMatch;
import bomberone.model.common.Direction;
import bomberone.model.common.P2d;
import bomberone.model.gameObjects.AnimatedEntity;
import bomberone.model.gameObjects.GameObject;
import javafx.geometry.Rectangle2D;

/**
 * This event is Triggered when the Bomber or the Enemy hit a Box or an
 * HardWall.
 * 
 * 
 *
 */
public class HitBorderEvent implements WorldEvent {

    private static final int SLIPPING_BITS = 1;
    private static final int HALF_CELL_SIZE = 16;
    private static final int CELL_SIZE = 32;
    private static final int OBJ_DIMETIONS = 32;
    private AnimatedEntity entity;
    private GameObject wall;

    public HitBorderEvent(final AnimatedEntity entity, final GameObject wall) {
        this.entity = entity;
        this.wall = wall;
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
    public void process(final GameMatch model) {
        // Slipping effect
        int roundBitX = (int) (this.getEntity().getPosition().getX() % CELL_SIZE);
        int roundBitY = (int) (this.getEntity().getPosition().getY() % CELL_SIZE);
        int slippingX = (roundBitX == 0) ? 0 : ((roundBitX < HALF_CELL_SIZE) ? -SLIPPING_BITS : SLIPPING_BITS);
        int slippingY = (roundBitY == 0) ? 0 : ((roundBitY < HALF_CELL_SIZE) ? -SLIPPING_BITS : SLIPPING_BITS);

        if (this.entity.getDir().equals(Direction.UP)) {
            this.entity.setPosition(new P2d(this.entity.getPosition().getX() + slippingX,
                    this.wall.getPosition().getY() + OBJ_DIMETIONS));
        }
        if (this.entity.getDir().equals(Direction.DOWN)) {
            this.entity.setPosition(new P2d(this.entity.getPosition().getX() + slippingX,
                    this.wall.getPosition().getY() - OBJ_DIMETIONS));
        }

        if (this.entity.getDir().equals(Direction.LEFT)) {
            this.entity.setPosition(new P2d(this.wall.getPosition().getX() + OBJ_DIMETIONS,
                    this.entity.getPosition().getY() + slippingY));
        }
        if (this.entity.getDir().equals(Direction.RIGHT)) {
            this.entity.setPosition(new P2d(this.wall.getPosition().getX() - OBJ_DIMETIONS,
                    this.entity.getPosition().getY() + slippingY));
        }
        this.entity.setCollider(new Rectangle2D(this.entity.getPosition().getX(), this.entity.getPosition().getY(), 32, 32));
    }
}
