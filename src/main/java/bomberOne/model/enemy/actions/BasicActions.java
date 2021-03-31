package bomberOne.model.enemy.actions;

import bomberOne.model.enemy.actions.movements.*;
import java.util.Random;
import bomberOne.model.common.P2d;

public class BasicActions {
	
	/* Fields. */
	MovementExecutor executor;
	Random randomGenerator = new Random();
	
	/* Constructor. */
	public BasicActions(MovementExecutor newExecutor) {
		this.executor = newExecutor;
	}
	
	/* Methods. */
	public P2d doAction(P2d currentPosition, double speed) {
		
		//Generating a random number and select an action.
		switch(this.randomGenerator.nextInt(4)) {
		
		case 0:
			this.executor = new MovementExecutor(new MoveUp());
			break;
			
		case 1:
			this.executor = new MovementExecutor(new MoveLeft());
			break;
			
		case 2:
			this.executor = new MovementExecutor(new MoveDown());
			break;
			
		case 3:
			this.executor = new MovementExecutor(new MoveRight());
			break;
		}
		
		//Executing the action.
		return this.executor.execute();
	}
}