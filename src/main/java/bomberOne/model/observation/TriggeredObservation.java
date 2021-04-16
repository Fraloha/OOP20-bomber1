package bomberOne.model.observation;

import bomberOne.model.common.*;
import java.util.Queue;

/*
 * A class that can perform a sort of simulation allowing the enemy to check
 * if a point of the map can be seen by it or not.
 */
public interface TriggeredObservation extends SimpleObservation{
	
	/* Methods. */
	
	/**
	 * This method check if the 2D point passed as parameter has, at least, one component equal
	 * to the destination 2D point.
	 * @param position The 2D point to check.
	 * @return true if the points have one component equal at least, otherwise false.
	 */
	public boolean found(P2d position);
	
	/**
	 * This method returns the directions that creates a path to reach the 2D point position. 
	 * @param position
	 * @return
	 */
	public Queue<Direction> computePathToPosition(P2d position);
}