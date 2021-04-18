package bomberOne.model.observation;

import bomberOne.model.common.P2d;

/**
 * This class define the path to a destination.
 */
public class EnemyObservation implements Observation {

	/* Fields. */
	private P2d destination;
	private P2d nextStep;
	
	/* Constructors. */
	public EnemyObservation(final P2d destination) {
		this.destination = destination;
	}
	
	/* Methods. */
	
	/**
	 * This method set the destination field of the observation object.
	 * @param newDestination
	 */
	public void setDestination(final P2d newDestination) {
		this.destination = newDestination;
	}
	
	/**
	 * This method gets the value of the destination field.
	 * @return the current destination.
	 */
	public P2d getDestination() {
		return this.destination;
	}
	
	/**
	 * This method sets the next position.
	 * @param nextPosition
	 */
	public void setNextPosition(final P2d nextPosition) {
		this.nextStep = nextPosition;
	}
	
	/**
	 * This method gets value of the next position value.
	 * @return the next position value.
	 */
	public P2d getNextPosition() {
		return this.nextStep;
	}
}
