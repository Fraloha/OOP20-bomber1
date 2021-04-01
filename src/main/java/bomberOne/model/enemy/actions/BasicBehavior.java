package bomberOne.model.enemy.actions;

import bomberOne.model.enemy.actions.movements.*;
import java.util.Random;
import bomberOne.model.common.P2d;

public class BasicBehavior implements Actions{
	
	/* Fields. */
	Random randomGenerator = new Random();
	
	/* Methods. */
	@Override
	public P2d doAction(MovementExecutor executor) {
		
		//Generating a random number and select an action.
		switch(this.randomGenerator.nextInt(4)) {
		
		case 0:
			executor = new MovementExecutor(new MoveUp());
			break;
			
		case 1:
			executor = new MovementExecutor(new MoveLeft());
			break;
			
		case 2:
			executor = new MovementExecutor(new MoveDown());
			break;
			
		case 3:
			executor = new MovementExecutor(new MoveRight());
			break;
		}
		
		//Executing the action.
		return executor.execute();
	}

	@Override
	public void Attack() {
		
	}
}