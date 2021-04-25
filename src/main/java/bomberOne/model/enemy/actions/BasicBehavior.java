package bomberOne.model.enemy.actions;

import java.util.Random;

import bomberOne.model.common.Direction;
import bomberOne.model.enemy.Enemy;

public class BasicBehavior implements Actions{
	
	/* Fields. */
	private Random randomGenerator = new Random();
	private Enemy selectedEnemy;
	
	/* Constructors. */
	public BasicBehavior(Enemy newEnemy) {
		this.selectedEnemy = newEnemy;
	}
	
	/* Methods. */
	@Override
	public void doActions() {
	    /*Generating a new random number between 0 and 3.
	     * On the basis of the generated value, a movement is performed.*/
	    switch(randomGenerator.nextInt(4)) {
	    case 0:
	        this.selectedEnemy.setDir(Direction.UP);
	        this.selectedEnemy.setSpriteIndex(0);
	        this.selectedEnemy.setAnimationIndex(0);
	        this.selectedEnemy.moveUp();
	        break;
	        
	    case 1:
	        this.selectedEnemy.setDir(Direction.LEFT);
	        this.selectedEnemy.setSpriteIndex(1);
	        this.selectedEnemy.setAnimationIndex(0);
	        this.selectedEnemy.moveLeft();
	        break;
	        
	    case 2:
	        this.selectedEnemy.setDir(Direction.RIGHT);
	        this.selectedEnemy.setSpriteIndex(2);
	        this.selectedEnemy.setAnimationIndex(0);
	        this.selectedEnemy.moveRight();
	        break;
	        
	    case 3:
	        this.selectedEnemy.setDir(Direction.DOWN);
	        this.selectedEnemy.setSpriteIndex(3);
	        this.selectedEnemy.setAnimationIndex(0);
	        this.selectedEnemy.moveDown();
	        break;
	    }
	}
}