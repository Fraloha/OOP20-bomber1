package bomberOne.model.observation;

import java.awt.geom.Point2D;

public class EnemySimpleObservation extends EnemyObservation implements SimpleObservation{
	
	/* Constructor. */
	public EnemySimpleObservation(Point2D.Float destination) {
		super(destination);
	}
	
	/* Methods. */
	public Point2D.Float calculateDistance(Point2D.Float point){
		//Variables declaration.
		Point2D.Float currentDestination = this.getDestination();
		
		//Calculating the distance between the destination and the point passed as parameter.
		return new Point2D.Float(currentDestination.x - point.x, currentDestination.y - point.y);
	}
}