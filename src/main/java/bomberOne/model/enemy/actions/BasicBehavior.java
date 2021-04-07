package bomberOne.model.enemy.actions;

import java.util.Random;
import bomberOne.model.common.P2d;
import bomberOne.model.enemy.Enemy;

public class BasicBehavior implements Actions{
	
	/* Fields. */
	Random randomGenerator = new Random();
	Enemy selectedEnemy;
	
	/* Constructors. */
	public BasicBehavior(Enemy newEnemy) {
		this.selectedEnemy = newEnemy;
	}
	
	/* Methods. */
	@Override
	public P2d doAction(P2d currentPosition, double speed) {
		
		return currentPosition;
	}
}