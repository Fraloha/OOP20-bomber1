package bomberOne.model.observation;

import java.awt.geom.Point2D;

/**
 * 
 * @author Francesco
 * This class define the path to a destination.
 */
public class EnemyObservation implements Observation{
	
	/* Fields. */
	private Point2D.Float destination;
	private Point2D.Float nextStep;
	
	/* Constructors. */
	public EnemyObservation(Point2D.Float destination) {
		this.destination = destination;
	}
	
	/* Methods. */
	
	/**
	 * This method set the destination field of the observation object.
	 * @param newDestination
	 */
	public void setDestination(Point2D.Float newDestination) {
		this.destination = newDestination;
	}
	
	/**
	 * This method gets the value of the destination field.
	 * @return the current destination.
	 */
	public Point2D.Float getDestination(){
		return this.destination;
	}
	
	/**
	 * This method sets the next position.
	 * @param nextPosition
	 */
	public void setNextPosition(Point2D.Float nextPosition) {
		this.nextStep = nextPosition;
	}
	
	/**
	 * This method gets value of the next position value.
	 * @return the next position value.
	 */
	public Point2D.Float getNextPosition(){
		return this.nextStep;
	}
}