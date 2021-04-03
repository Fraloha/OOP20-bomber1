package bomberOne.model.event;

import bomberOne.model.gameObjects.Explosion;

/**
 * When a bomb explode, it generates an ExplosionEvent
 * @author Luigi
 *
 */
public class ExplosionEvent implements WorldEvent {
	
	private Explosion explosion;
	
	public ExplosionEvent(Explosion exp) {
		this.explosion = exp;
	}
	
	public Explosion getExplosion() {
		return this.explosion;
	}

}
