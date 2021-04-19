package bomberOne.model.observation;

import bomberOne.model.common.Direction;
import bomberOne.model.common.P2d;
import java.util.Comparator;

public class DirectionComparator implements Comparator<P2d> {
    
    /* Fields. */
    private FollowingModes mode;

    /* Constructors. */
    public DirectionComparator(FollowingModes newMode) {
        this.mode = newMode;
    }

    public int compare(P2d playerPosition, P2d enemyPosition) {
        /* Variables declaration. */
        int directionValue;
        
        //Checking which mode was chosen.
        if (this.mode.equals(FollowingModes.Horinzotally)) {
            directionValue = playerPosition.getX() > enemyPosition.getX() ? Direction.RIGHT.ordinal() : Direction.LEFT.ordinal();
        }else {
            directionValue = playerPosition.getY() > enemyPosition.getY() ? Direction.UP.ordinal() : Direction.DOWN.ordinal();
        }

        return directionValue;
    }
}
