package bomberone.model.event;

import bomberone.model.GameModel;
import bomberone.model.enemy.EnemyImpl;
import bomberone.model.gameObjects.BoxImpl;
import bomberone.model.gameObjects.GameObject;

public class HitFireEvent implements WorldEvent {

    private static final int BOX_INC_SCORE = 50;
    private static final int ENEMY_INC_SCORE = 150;
    private GameObject entity;

    public HitFireEvent(final GameObject entity) {
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
     * When an GameObject is Colliding with the fire, it calls "hitted()" on the
     * Object.
     * 
     */
    @Override
    public void process(final GameModel model) {
        this.entity.hitted();
        if (this.entity.getClass().equals(BoxImpl.class)) {
            model.incScore(BOX_INC_SCORE);
        }
        if (this.entity.getClass().equals(EnemyImpl.class)) {
            model.incScore(ENEMY_INC_SCORE);
        }
    }

}
