package bomberOne.model.event;

import bomberOne.model.gameObjects.GameObject;

/**
 * This event is Triggered when the Bomber or the Enemy hit a Box or an HardWall
 * @author Luigi
 *
 */
public class HitBorderEvent implements WorldEvent{

	public HitBorderEvent(GameObject entity, int elapsed) {
		
	}
	
}
