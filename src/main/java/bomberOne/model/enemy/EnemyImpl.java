package bomberOne.model.enemy;

import bomberOne.model.common.P2d;
import bomberOne.model.gameObjects.AnimatedEntityImpl;
import java.awt.image.BufferedImage;
import bomberOne.model.enemy.actions.*;

public class EnemyImpl extends AnimatedEntityImpl implements Enemy{
	
	/* Fields. */
	BehaviorExecutor executor;
	
	/* Constructors. */
	public EnemyImpl(P2d position, BufferedImage img, int lifes, boolean isAlive) {
		super(position, img, lifes, isAlive);
	}
	
	/* Methods. */
	public void setBasicEnemy() {
		/* Variables declaration. */
		Actions behavior = new BasicBehavior(this);
		
		//Set the enemy's behavior to basic.
		this.executor = new BehaviorExecutor(behavior);
	}
	
	public void setIntermediateEnemy(P2d playerPosition) {
		/* Variables declaration. */
		Actions behavior = new IntermediateBehavior(playerPosition, this);
		
		//Set the enemy's behavior to intermediate.
		this.executor = new BehaviorExecutor(behavior);
	}
}