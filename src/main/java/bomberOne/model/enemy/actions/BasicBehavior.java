package bomberOne.model.enemy.actions;

import java.util.Random;
import bomberOne.model.common.Direction;
import bomberOne.model.enemy.EnemyImpl;

public class BasicBehavior implements Actions{
	
	/* Fields. */
	private Random randomGenerator = new Random();
	private EnemyImpl selectedEnemy;
	
	/* Constructors. */
	public BasicBehavior(EnemyImpl newEnemy) {
		this.selectedEnemy = newEnemy;
	}
	
	/* Methods. */
	@Override
	public void doActions() {
	    //Checking if the enemy changed direction.
	    if (this.selectedEnemy.getDir() != this.selectedEnemy.getPreviousDirection()) {
	        this.selectedEnemy.setPreviousDirection(this.selectedEnemy.getDir());
	        
	        //Moving the enemy on the basis of the generated random value.
	        switch(this.randomGenerator.nextInt(4)) {
	        
	        case 0:
	            this.selectedEnemy.setSpriteIndex(3);
	            this.selectedEnemy.setAnimationIndex(0);
	            this.selectedEnemy.setDir(Direction.UP);
	            this.selectedEnemy.moveUp();
	            break;
	            
	        case 1:
	            this.selectedEnemy.setSpriteIndex(2);
	            this.selectedEnemy.setAnimationIndex(0);
	            this.selectedEnemy.setDir(Direction.RIGHT);
	            this.selectedEnemy.moveRight();
	            break;
	            
	        case 2:
	            this.selectedEnemy.setSpriteIndex(1);
	            this.selectedEnemy.setAnimationIndex(0);
	            this.selectedEnemy.setDir(Direction.LEFT);
	            this.selectedEnemy.moveLeft();
	            break;
	            
	        case 3:
	            this.selectedEnemy.setSpriteIndex(0);
	            this.selectedEnemy.setAnimationIndex(0);
	            this.selectedEnemy.setDir(Direction.DOWN);
	            this.selectedEnemy.moveDown();
	            break;
	        }
	    } else {
	        //Animating the enemy.
	        if (this.selectedEnemy.getFrameCounterAnimation() == 10) {
	            this.selectedEnemy.setFrameCounterAnimation(0);
	            this.selectedEnemy.setAnimationIndex((this.selectedEnemy.getAnimationIndex() + 1) % 4);
	        } else {
	            this.selectedEnemy.setFrameCounterAnimation(this.selectedEnemy.getFrameCounterAnimation() + 1);
	        }
	    }
	}
}