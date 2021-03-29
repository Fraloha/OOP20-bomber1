package bomberOne.model.observation;

import java.awt.geom.Point2D;

public class EnemyTriggeredObservation extends EnemySimpleObservation implements TriggeredObservation{
	
	/* Constructor. */
	public EnemyTriggeredObservation(int observationThreshold, Point2D.Float destination) {
		
		super(destination);
	}
	
	/* Methods. */
	private boolean sameRow(Point2D.Float position) {
		return (int)this.getDestination().x == (int)position.x ? true : false;
	}
	
	private boolean sameColumn(Point2D.Float position) {
		return (int)this.getDestination().y == (int)position.y ? true : false;
	}
	
	public boolean Found(Point2D.Float position) {
		return sameRow(position) || sameColumn(position) ? true : false;
	}
}