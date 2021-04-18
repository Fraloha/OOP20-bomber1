package bomberOne.model.observation;

import bomberOne.model.common.P2d;

public interface Observation {

        /* Methods. */
        void setDestination(P2d newDestination);

        P2d getDestination();

        void setNextPosition(P2d nextPosition);

        P2d getNextPosition();
}
