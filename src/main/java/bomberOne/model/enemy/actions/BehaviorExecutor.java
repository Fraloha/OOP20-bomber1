package bomberOne.model.enemy.actions;

import bomberOne.model.common.P2d;

public class BehaviorExecutor {
	
	/* Variables declaration. */
	Actions behavior;
	P2d currentPosition;
	double speed;
	
	/* Constructors. */
	public BehaviorExecutor(Actions newBehavior, P2d position, double speedToSet) {
		this.behavior = newBehavior;
		this.currentPosition = position;
		this.speed = speedToSet;
	}
	
	public BehaviorExecutor(P2d position, double speedToSet) {
		this.currentPosition = position;
		this.speed = speedToSet;
	}
	
	/* Methods. */
	public void setBehavior(Actions newBehavior) {
		this.behavior = newBehavior;
	}
	
	public void execute() {
		this.behavior.doActions();
	}
}