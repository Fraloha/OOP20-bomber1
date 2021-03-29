package bomberOne.model.observation;

import java.awt.geom.Point2D;

public interface TriggeredObservation extends SimpleObservation{
	
	/* Methods. */
	
	public boolean Found(Point2D.Float position);
}
