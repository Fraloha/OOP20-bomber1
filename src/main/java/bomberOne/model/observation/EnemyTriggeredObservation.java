package bomberOne.model.observation;

import bomberOne.model.common.*;

public class EnemyTriggeredObservation extends EnemySimpleObservation implements TriggeredObservation{
	
	/* Constructor. */
	public EnemyTriggeredObservation(P2d destination) {
		
		super(destination);
	}
	
	/* Methods. */
	
	/**
	 * This method checks if the first component of the destination 2D point is equal
	 * to the first component of the 2D point passed as parameter.
	 * @param position The 2D point to check.
	 * @return true if the points have the first component equal to each other, otherwise false.
	 */
	private boolean sameRow(P2d position) {
		return (int)this.getDestination().getX() == (int)position.getX() ? true : false;
	}
	
	/**
	 * This method check if the second component of the destination 2d point is equal
	 * to the second component of the 2D point passed as parameter.
	 * @param position The 2D point to check.
	 * @return True if the points have the second component equal to each other, otherwise false.
	 */
	private boolean sameColumn(P2d position) {
		return (int)this.getDestination().getY() == (int)position.getY() ? true : false;
	}
	
	public boolean found(P2d position, Direction currentDirection) {
		
	}
}