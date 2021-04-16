package bomberOne.model.enemy.actions;

public class BehaviorExecutor {
	
	/* Variables declaration. */
	Actions behavior;
	
	/* Constructors. */
	public BehaviorExecutor(Actions newBehavior) {
		this.behavior = newBehavior;
	}
	
	/* Methods. */
	public void execute() {
		this.behavior.doActions();
	}
}