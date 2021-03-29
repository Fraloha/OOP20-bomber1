package bomberOne.model.observation;

import java.awt.geom.Point2D;

public interface Observation {
	
	/* Methods. */
	public void setDestination(Point2D.Float newDestination);
	
	public Point2D.Float getDestination();
	
	public void setNextPosition(Point2D.Float nextPosition);
	
	public Point2D.Float getNextPosition();
}
