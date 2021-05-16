package bomberone.controllers.game.event;

import java.util.Optional;

import bomberone.model.bomber.BomberImpl;
import bomberone.model.common.P2d;
import bomberone.model.enemy.EnemyImpl;
import bomberone.model.gameObjects.BoxImpl;
import bomberone.model.gameObjects.Fire;
import bomberone.model.gameObjects.GameObject;
import bomberone.model.match.GameMatch;
import bomberone.tools.audio.SoundsHandler;
import bomberone.tools.audio.GameSounds;

/**
 * This event is triggered when the fire hits an Object or if the Bomber collide
 * with an Enemy.
 *
 */
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
    public void process(final GameMatch model) {

        if (this.entity.getClass().equals(BomberImpl.class)) {
            /* Check if the entity isn't the body of the death bomber */
            if (!this.entity.isAlive()) {
                return;
            } else {
                SoundsHandler.start(GameSounds.HITTED); // This is the Audio Effect for Bomber's death
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
        /* Increment the Score */
        if (this.entity.getClass().equals(BoxImpl.class)) {
            model.incScore(BOX_INC_SCORE);
        }
        if (this.entity.getClass().equals(EnemyImpl.class)) {
            SoundsHandler.start(GameSounds.ENEMY_HIT); // This is the Sound Effect for Enemy hitted
            model.incScore(ENEMY_INC_SCORE);
        }
    }

}
