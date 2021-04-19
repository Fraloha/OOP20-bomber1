package bomberOne.model.observation;

import bomberOne.model.common.P2d;
import bomberOne.model.common.Direction;
import bomberOne.model.observation.DirectionComparator;

public final class EnemyTriggeredObservation extends EnemySimpleObservation implements TriggeredObservation {
	
	/* Constructors. */
        public EnemyTriggeredObservation() {
            super();
        }

	public EnemyTriggeredObservation(final P2d destination) {
		super(destination);
	}

	/* Methods. */
	
	/**
	 * This method checks if the first component of the destination 2D point is equal
	 * to the first component of the 2D point passed as parameter.
	 * @param position The 2D point to check.
s	 * @return true if the points have the first component equal to each other, otherwise false.
	 */
	private boolean sameRow(final P2d position) {
		return (int) this.getDestination().getX() == (int) position.getX() ? true : false;
	}
	
	/**
	 * This method check if the second component of the destination 2D point is equal
	 * to the second component of the 2D point passed as parameter.
	 * @param position The 2D point to check.
	 * @return True if the points have the second component equal to each other, otherwise false.
	 */
	private boolean sameColumn(final P2d position) {
		return (int) this.getDestination().getY() == (int) position.getY() ? true : false;
	}

	@Override
	public boolean found(final P2d position, final Direction currentDirection) {
		/* Variables declaration. */
		boolean result = false;

		//Checking if the 2D point parameter is on the same row.
		if (sameRow(position)) {

			//Checking if the enemy can see the player.
			if (currentDirection == Direction.UP) {
				result = (int) this.getDestination().getY() > (int) position.getY() ? true : false; 
			} else if (currentDirection == Direction.DOWN) {
				result = (int) this.getDestination().getY() < (int) position.getY() ? true : false;
			}
		} else if (sameColumn(position)) {

			//Checking if the enemy can see the player.
			if (currentDirection == Direction.RIGHT) {
				result = (int) this.getDestination().getX() > (int) position.getX() ? true : false;
			} else if (currentDirection == Direction.LEFT) {
				result = (int) this.getDestination().getX() < (int) position.getX() ? true : false;
			}
		}

		return result;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Direction computeDestinationDirection(P2d enemyPosition, DirectionComparator comparator) {
	    /* Variables declaration. */
	    int directionValue = comparator.compare(this.getDestination(), enemyPosition);
	    Direction direction = Direction.DOWN;
	    
	    switch(directionValue) {
	    case 0:
	        direction = Direction.UP;
	        break;
	        
	    case 1:
	        direction = Direction.DOWN;
	        break;
	        
	    case 2:
	        direction = Direction.LEFT;
	        break;
	        
	    case 3:
	        direction = Direction.RIGHT;
	        break;
	    }
	    
	    return direction;
	}
}