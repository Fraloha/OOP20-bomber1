package bomberOne.model.event;

import bomberOne.model.GameModel;
import bomberOne.model.enemy.EnemyImpl;
import bomberOne.model.gameObjects.BoxImpl;
import bomberOne.model.gameObjects.GameObject;

public class HitFireEvent implements WorldEvent {

	private static final int BOX_INC_SCORE = 50;
	private static final int ENEMY_INC_SCORE = 150;
	private GameObject entity;
	
	public HitFireEvent(GameObject entity) {
		this.entity = entity;
	}
	
	public GameObject getEntity() {
		return this.entity;
	}

	/**
	 * When an GameObject is Colliding with the fire, it calls "hitted()" on the Object
	 * @param event
	 */
	@Override
	public void process(GameModel model) {
		this.entity.hitted();
		if(this.entity.getClass().equals(BoxImpl.class)) {
			model.incScore(BOX_INC_SCORE);
		}
		if(this.entity.getClass().equals(EnemyImpl.class)) {
			model.incScore(ENEMY_INC_SCORE);
		}
	}
	
}
