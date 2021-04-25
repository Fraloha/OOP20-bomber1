package bomberOne.model.observation;

import bomberOne.model.common.P2d;

public class EnemySimpleObservation extends EnemyObservation implements SimpleObservation{
	
	/* Constructor. */
        public EnemySimpleObservation() {
            super();
        }

	public EnemySimpleObservation(P2d destination) {
		super(destination);
	}
	
	/* Methods. */
	public P2d calculateDistance(P2d point){
		//Variables declaration.
		P2d currentDestination = this.getDestination();
		
		//Calculating the distance between the destination and the point passed as parameter.
		return new P2d(currentDestination.getX() - point.getX(), currentDestination.getY() - point.getY());
	}
}