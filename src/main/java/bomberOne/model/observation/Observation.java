package bomberOne.model.observation;

import bomberOne.model.common.P2d;

public interface Observation {
	
	/* Methods. */
	public void setDestination(P2d newDestination);
	
	public P2d getDestination();
	
	public void setNextPosition(P2d nextPosition);
	
	public P2d getNextPosition();
}
