package bomberone.model.observation;

import bomberone.model.common.P2d;

public class EnemyTriggeredObservation extends EnemySimpleObservation implements TriggeredObservation{
	
	/* Constructor. */
	public EnemyTriggeredObservation(P2d destination) {
		
		super(destination);
	}
	
	/* Methods. */
	private boolean sameRow(P2d position) {
		return (int)this.getDestination().getX() == (int)position.getX() ? true : false;
	}
	
	private boolean sameColumn(P2d position) {
		return (int)this.getDestination().getY() == (int)position.getY() ? true : false;
	}
	
	public boolean Found(P2d position) {
		return sameRow(position) || sameColumn(position) ? true : false;
	}
}