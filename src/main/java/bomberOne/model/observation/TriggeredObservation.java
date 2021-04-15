package bomberone.model.observation;

import bomberone.model.common.P2d;

public interface TriggeredObservation extends SimpleObservation{
	
	/* Methods. */
	
	public boolean Found(P2d position);
}
