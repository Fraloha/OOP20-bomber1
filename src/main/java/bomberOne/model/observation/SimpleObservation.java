package bomberOne.model.observation;

import bomberOne.model.common.P2d;

public interface SimpleObservation extends Observation {

        /* Methods. */
        P2d calculateDistance(P2d point);
}
