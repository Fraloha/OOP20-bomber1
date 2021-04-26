package bomberOne.model.enemy.actions;

import java.util.Random;
import bomberOne.model.common.Direction;
import bomberOne.model.enemy.EnemyImpl;

public final class BasicBehavior implements Actions{
	
	/* Fields. */
	private Random randomGenerator = new Random();
	private EnemyImpl selectedEnemy;
	
	/* Constructors. */
	public BasicBehavior(final EnemyImpl newEnemy) {
		this.selectedEnemy = newEnemy;
	}
	
	/* Methods. */
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doActions() {
	    int newMovement = this.randomGenerator.nextInt(4);
	    if (newMovement != this.selectedEnemy.getDir().ordinal()) {
	        this.selectedEnemy.setDir(Direction.values()[newMovement]);
	        
	        //Setting the sprite.
	        switch(this.selectedEnemy.getDir()) {
	        case UP:
	            this.selectedEnemy.setSpriteIndex(0);
	            break;
	            
	        case LEFT:
	            this.selectedEnemy.setSpriteIndex(1);
	            break;
	            
	        case RIGHT:
	            this.selectedEnemy.setSpriteIndex(2);
	            break;
	            
	        case DOWN:
	            this.selectedEnemy.setSpriteIndex(3);
	            break;
	        }
	        
	        this.selectedEnemy.setAnimationIndex(0);
	        
	    } else {
	        if (this.selectedEnemy.getFrameCounterAnimation() == 5) {
	            this.selectedEnemy.setFrameCounterAnimation(0);
	        } else {
	            this.selectedEnemy.setFrameCounterAnimation(this.selectedEnemy.getFrameCounterAnimation() + 1);
	        }
	    }
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void nextMove() {
	    //Moving the enemy on the basis of the direction.
	    if (this.selectedEnemy.getDir() == Direction.UP) {
	        this.selectedEnemy.moveUp();
	    } else if (this.selectedEnemy.getDir() == Direction.DOWN) {
	        this.selectedEnemy.moveDown();
	    } else if (this.selectedEnemy.getDir() == Direction.RIGHT) {
	        this.selectedEnemy.moveRight();
	    } else {
	        this.selectedEnemy.moveLeft();
	    }
	}
}