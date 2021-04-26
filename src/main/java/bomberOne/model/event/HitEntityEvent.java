package bomberOne.model.event;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import bomberOne.model.GameModel;
import bomberOne.model.bomber.BomberImpl;
import bomberOne.model.common.P2d;
import bomberOne.model.enemy.EnemyImpl;
import bomberOne.model.gameObjects.BoxImpl;
import bomberOne.model.gameObjects.Fire;
import bomberOne.model.gameObjects.GameObject;

public class HitEntityEvent implements WorldEvent {

    private static final int FIRST_CELL_COORD = 32;
    private static final int BOX_INC_SCORE = 50;
    private static final int ENEMY_INC_SCORE = 150;
    private GameObject entity;

    public HitEntityEvent(final GameObject entity) {
        this.entity = entity;
    }

    /**
     * 
     * @return the Entity of the event
     */
    public GameObject getEntity() {
        return this.entity;
    }

    /**
     * When an GameObject is Colliding with the fire or when a enemy hit the Bomber,
     * it calls "hitted()" on the Object.
     * 
     */
    @Override
    public void process(final GameModel model) {

        if (this.entity.getClass().equals(BomberImpl.class)) {
            /* Check if the entity isn't the body of the death bomber */
            if (!this.entity.isAlive()) {
                return;
            } else {
                /*
                 * If there is a fireObject on the respawn cell, it is removed to avoid
                 * death-loop bugs
                 */
                Optional<Fire> fireToRemove = model.getWorld().getGameObjectCollection().getFireList().stream()
                        .filter(fire -> fire.getPosition().equals(new P2d(FIRST_CELL_COORD, FIRST_CELL_COORD)))
                        .findFirst();
                if (fireToRemove.isPresent()) {
                    model.getWorld().getGameObjectCollection().despawn(fireToRemove.get());
                }
            }
        }
        this.entity.hitted();
        if (this.entity.getClass().equals(BoxImpl.class)) {
            model.incScore(BOX_INC_SCORE);
        }
        if (this.entity.getClass().equals(EnemyImpl.class)) {
            model.incScore(ENEMY_INC_SCORE);
        }
    }

}
