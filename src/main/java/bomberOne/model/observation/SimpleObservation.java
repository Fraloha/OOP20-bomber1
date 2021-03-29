package bomberOne.model.observation;

import java.awt.geom.Point2D;

public interface SimpleObservation extends Observation{
	
	/* Methods. */
	public Point2D.Float calculateDistance(Point2D.Float point);
}
