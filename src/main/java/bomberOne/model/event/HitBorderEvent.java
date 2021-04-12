package bomberOne.model.event;

import bomberOne.model.GameModel;
import bomberOne.model.common.Direction;
import bomberOne.model.common.P2d;
import bomberOne.model.enemy.Enemy;
import bomberOne.model.enemy.EnemyImpl;
import bomberOne.model.gameObjects.AnimatedEntity;
import bomberOne.model.gameObjects.GameObject;

/**
 * This event is Triggered when the Bomber or the Enemy hit a Box or an HardWall
 * @author Luigi
 *
 */
public class HitBorderEvent implements WorldEvent{

	private static final int OBJ_DIMETIONS = 32;
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

	/**
	 * Repositioning of the AniatedEntity that is colliding with the Wall/Box
	 * @param event
	 */
	@Override
	public void process(GameModel model) {
		if(this.entity.getDir().equals(Direction.UP)){
			this.entity.setPosition(new P2d(this.entity.getPosition().getX(), this.wall.getPosition().getY() + OBJ_DIMETIONS));
		}
		if(this.entity.getDir().equals(Direction.DOWN)){
			this.entity.setPosition(new P2d(this.entity.getPosition().getX(), this.wall.getPosition().getY() - OBJ_DIMETIONS));
		}
		
		if(this.entity.getDir().equals(Direction.LEFT)){
			this.entity.setPosition(new P2d(this.wall.getPosition().getX() + OBJ_DIMETIONS, this.wall.getPosition().getY()));
		}
		if(this.entity.getDir().equals(Direction.RIGHT)){
			this.entity.setPosition(new P2d(this.wall.getPosition().getX() - OBJ_DIMETIONS, this.wall.getPosition().getY()));
		}
		if(this.entity.getClass().equals(EnemyImpl.class)) {
			((Enemy) this.entity).changeDir();
		}
	}
	
}
