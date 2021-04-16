package bomberOne.model.enemy.actions;

import java.util.Random;
import bomberOne.model.enemy.Enemy;

public class BasicBehavior implements Actions{
	
	/* Fields. */
	private Random randomGenerator = new Random();
	private Enemy selectedEnemy;
	private int frameCounter;
	
	/* Constructors. */
	public BasicBehavior(Enemy newEnemy) {
		this.selectedEnemy = newEnemy;
		this.frameCounter = 1;
	}
	
	/* Methods. */
	@Override
	public void doActions() {
		
		//Checking the frame counter.
		if(this.frameCounter == 4) {
			
			//Generating a new random integer value.
			switch(this.randomGenerator.nextInt(3)) {
			
			case 0:
				this.selectedEnemy.moveUp();
				break;
				
			case 1:
				this.selectedEnemy.moveDown();
				break;
				
			case 2:
				this.selectedEnemy.moveRight();
				break;
				
			case 3:
				this.selectedEnemy.moveLeft();
				break;
			}
			
			//Resetting the frame counter.
			this.frameCounter = 1;
			
		}else {
			this.frameCounter++;
		}
	}
}