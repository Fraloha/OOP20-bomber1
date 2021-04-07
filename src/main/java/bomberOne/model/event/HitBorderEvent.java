package bomberOne.model.event;

import bomberOne.model.gameObjects.AnimatedEntity;
import bomberOne.model.gameObjects.GameObject;

/**
 * This event is Triggered when the Bomber or the Enemy hit a Box or an HardWall
 * @author Luigi
 *
 */
public class HitBorderEvent implements WorldEvent{

	private AnimatedEntity entity;
	private GameObject wall;
	
	public HitBorderEvent(AnimatedEntity entity, GameObject wall) {
		this.entity = entity;
	}
	
	public AnimatedEntity getEntity() {
		return this.entity;
	}
	
	public GameObject getWall() {
		return this.wall;
	}
	
}
