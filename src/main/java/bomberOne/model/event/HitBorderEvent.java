package bomberOne.model.event;

import java.awt.geom.Rectangle2D;

import bomberOne.model.GameModel;
import bomberOne.model.common.Direction;
import bomberOne.model.common.P2d;
import bomberOne.model.enemy.Enemy;
import bomberOne.model.enemy.EnemyImpl;
import bomberOne.model.gameObjects.AnimatedEntity;
import bomberOne.model.gameObjects.GameObject;

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
    public void process(final GameModel model) {
        //Slipping effect
        int roundBitX = (int) (this.getEntity().getPosition().getX() % 32);
        int roundBitY = (int) (this.getEntity().getPosition().getY() % 32);
        int slippingX = (roundBitX == 0) ? 0 : ((roundBitX < 16) ? -1 : 1);
        int slippingY= (roundBitY == 0) ? 0 : ((roundBitY < 16) ? -1 : 1);
        
        if (this.entity.getDir().equals(Direction.UP)) {
            this.entity.setPosition(
                    new P2d(this.entity.getPosition().getX() + slippingX, this.wall.getPosition().getY() + OBJ_DIMETIONS));
        }
        if (this.entity.getDir().equals(Direction.DOWN)) {
            this.entity.setPosition(
                    new P2d(this.entity.getPosition().getX() + slippingX, this.wall.getPosition().getY() - OBJ_DIMETIONS));
        }

        if (this.entity.getDir().equals(Direction.LEFT)) {
            this.entity.setPosition(
                    new P2d(this.wall.getPosition().getX() + OBJ_DIMETIONS, this.entity.getPosition().getY() + slippingY));
        }
        if (this.entity.getDir().equals(Direction.RIGHT)) {
            this.entity.setPosition(
                    new P2d(this.wall.getPosition().getX() - OBJ_DIMETIONS, this.entity.getPosition().getY() +  slippingY));
        }
        if (this.entity.getClass().equals(EnemyImpl.class)) {
            ((Enemy) this.entity).changePath();
        }
    }
//    Rectangle2D intersection = this.collider.createIntersection(obj.collider);
//    // Vertical collision
//    if (intersection.getWidth() >= intersection.getHeight()) {
//        // From the top
//        if (intersection.getMaxY() >= this.collider.getMaxY()) {
//            this.position.setLocation(this.position.x, this.position.y - intersection.getHeight());
//        }
//        // From the bottom
//        if (intersection.getMaxY() >= obj.collider.getMaxY()) {
//            this.position.setLocation(this.position.x, this.position.y + intersection.getHeight());
//        }
//
//        // Smoothing around corners
//        if (intersection.getWidth() < 16) {
//            if (intersection.getMaxX() >= this.collider.getMaxX()) {
//                this.position.setLocation(this.position.x - 0.5, this.position.y);
//            }
//            if (intersection.getMaxX() >= obj.collider.getMaxX()) {
//                this.position.setLocation(this.position.x + 0.5, this.position.y);
//            }
//        }
//    }
//
//    // Horizontal collision
//    if (intersection.getHeight() >= intersection.getWidth()) {
//        // From the left
//        if (intersection.getMaxX() >= this.collider.getMaxX()) {
//            this.position.setLocation(this.position.x - intersection.getWidth(), this.position.y);
//        }
//        // From the right
//        if (intersection.getMaxX() >= obj.collider.getMaxX()) {
//            this.position.setLocation(this.position.x + intersection.getWidth(), this.position.y);
//        }
//
//        // Smoothing around corners
//        if (intersection.getHeight() < 16) {
//            if (intersection.getMaxY() >= this.collider.getMaxY()) {
//                this.position.setLocation(this.position.x, this.position.y - 0.5);
//            }
//            if (intersection.getMaxY() >= obj.collider.getMaxY()) {
//                this.position.setLocation(this.position.x, this.position.y + 0.5);
//            }
//        }
//    }
}
