package bomberOne.model.enemy.actions;

import java.util.Random;
import bomberOne.model.common.P2d;
import bomberOne.model.gameObjects.AnimatedEntity;

public class BasicBehavior implements Actions{
	
	/* Fields. */
	Random randomGenerator = new Random();
	
	/* Methods. */
	@Override
	public P2d doAction(P2d currentPosition, double speed) {
		
		return currentPosition;
	}
}