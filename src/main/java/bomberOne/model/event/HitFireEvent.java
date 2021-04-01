package bomberOne.model.event;

import bomberOne.model.gameObjects.GameObject;

public class HitFireEvent implements WorldEvent {

	private GameObject entity;
	
	public HitFireEvent(GameObject entity) {
		this.entity = entity;
	}
	
	public GameObject getEntity() {
		return this.entity;
	}
	
}
