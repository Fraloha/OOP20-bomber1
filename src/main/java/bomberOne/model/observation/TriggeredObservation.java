package bomberOne.model.observation;

import bomberOne.model.common.P2d;

public interface TriggeredObservation extends SimpleObservation{
	
	/* Methods. */
	
	public boolean found(P2d position);
}
