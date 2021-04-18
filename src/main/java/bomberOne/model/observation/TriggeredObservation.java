package bomberOne.model.observation;

import bomberOne.model.common.P2d;
import bomberOne.model.common.Direction;

/*
 * A class that can perform a sort of simulation allowing the enemy to check
 * if a point of the map can be seen by it or not.
 */
public interface TriggeredObservation extends SimpleObservation {

        /* Methods. */
        /**
         * This method checks if the object that manage a TriggeredObservation object
         * is in the same row or same column of the destination and is pointed to the direction
         * passed as argument.
         * @param position The position that uses this object.
         * @param currentDirection The current direction of the owner's object.
         * @return true if the owner object is in the same column or in the same row
         * and is pointed towards the destination.
         */
         boolean found(P2d position, Direction currentDirection);
}