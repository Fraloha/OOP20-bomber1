package bomberOne.model.enemy.actions;

import java.util.Random;
import bomberOne.model.common.Direction;
import bomberOne.model.enemy.EnemyImpl;

public final class BasicBehavior implements Actions{
	
	/* Fields. */
        private static final int FRAMES_TO_CHANGE_DIRECTION = 420;
        
	private Random randomGenerator;
	private EnemyImpl selectedEnemy;
	private int nextDirectionCounter;
	
	/* Constructors. */
	public BasicBehavior(final EnemyImpl newEnemy) {
	        this.randomGenerator = new Random();
		this.selectedEnemy = newEnemy;
		this.nextDirectionCounter = 0;
	}
	
	/* Methods. */
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doActions() {
	    //Checking if the enemy has to change the direction.
	    if(++this.nextDirectionCounter == BasicBehavior.FRAMES_TO_CHANGE_DIRECTION) {
	        
	        this.nextDirectionCounter = 0;
	        
                //Generating a new random direction.
	        int newDirection;
	        do {
	            newDirection = this.randomGenerator.nextInt(4);
	        } while(newDirection == this.selectedEnemy.getDir().ordinal());
	        
	        System.out.println("newDirection : " + newDirection + "\t getDir() : " + this.selectedEnemy.getDir().ordinal());
	        //Setting the new direction and the sprite.
	        this.selectedEnemy.setDir(Direction.values()[newDirection]);
	        this.selectedEnemy.setAnimationIndex(0);
	        
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
	    } else {
	        if (this.selectedEnemy.getFrameCounterAnimation() == 5) {
	            this.selectedEnemy.setFrameCounterAnimation(0);
	            this.selectedEnemy.setAnimationIndex((this.selectedEnemy.getAnimationIndex() + 1) % 3);
	        }else {
	            this.selectedEnemy.setFrameCounterAnimation(this.selectedEnemy.getFrameCounterAnimation() + 1);
	        }
	        System.out.println("Enemy animated.");
	    }
	    
	    //Moving the enemy.
	    this.nextMove();
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