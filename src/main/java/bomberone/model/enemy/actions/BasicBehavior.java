package bomberone.model.enemy.actions;

import java.util.Random;

import bomberone.model.common.Direction;
import bomberone.model.enemy.EnemyImpl;

public final class BasicBehavior implements Actions{
	
	/* Fields. */
        /**
         * This constant is the number of frames that the enemy has to wait to
         * change his direction.
         */
        private static final int FRAMES_TO_CHANGE_DIRECTION = 120;
        
	private Random randomGenerator;
	private EnemyImpl selectedEnemy;
	private int nextDirectionCounter;
	
	/* Constructors. */
	public BasicBehavior(final EnemyImpl newEnemy) {
	        this.randomGenerator = new Random();
		this.selectedEnemy = newEnemy;
		
		//The counter is set to the limit, because at the start of the game,
		//it's better that the enemy change his direction.
		this.nextDirectionCounter = BasicBehavior.FRAMES_TO_CHANGE_DIRECTION;
	}
	
	/* Methods. */
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doActions() {
	    /* Variables declaration. */
	    int newDirection;

	    //Checking if the enemy has to change the direction.
	    if(this.nextDirectionCounter == BasicBehavior.FRAMES_TO_CHANGE_DIRECTION) {
                //Generating a new random direction.
	        do {
	            newDirection = this.randomGenerator.nextInt(4);
	        } while(newDirection == this.selectedEnemy.getDir().ordinal());

	        //Setting the new direction.
	        this.selectedEnemy.setDir(Direction.values()[newDirection]);
	        this.selectedEnemy.setAnimationIndex(0);
	        
	        //Setting the sprite on the basis of the direction.
	        if (this.selectedEnemy.getDir() == Direction.UP) {
	            this.selectedEnemy.setDirectionIndex(3);
	        } else if (this.selectedEnemy.getDir() == Direction.LEFT) {
	            this.selectedEnemy.setDirectionIndex(1);
	        } else if (this.selectedEnemy.getDir() == Direction.RIGHT) {
	            this.selectedEnemy.setDirectionIndex(2);
	        } else {
	            this.selectedEnemy.setDirectionIndex(0);
	        }
	        
	        //Resetting the counter.
	        this.nextDirectionCounter = 0;
	    } else {
	        if (this.selectedEnemy.getFrameCounterAnimation() == 10) {
	            this.selectedEnemy.setFrameCounterAnimation(0);
	            this.selectedEnemy.setAnimationIndex((this.selectedEnemy.getAnimationIndex() + 1));
	        }else {
	            this.selectedEnemy.setFrameCounterAnimation(this.selectedEnemy.getFrameCounterAnimation() + 1);
	        }
	    }
	    
	    //Moving the enemy.
	    this.nextMove();
	    this.nextDirectionCounter++;
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