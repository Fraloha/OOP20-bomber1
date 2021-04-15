package bomberone.model.observation;

import bomberone.model.common.P2d;

public interface SimpleObservation extends Observation{
	
	/* Methods. */
	public P2d calculateDistance(P2d point);
}
