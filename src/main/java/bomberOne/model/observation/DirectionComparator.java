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
        if (this.mode.equals(FollowingModes.HORINZONTALLY)) {

            if (playerPosition.getX() > enemyPosition.getX()) {
                directionValue = Direction.RIGHT.ordinal();
            } else if (playerPosition.getX() < enemyPosition.getX()) {
                directionValue = Direction.LEFT.ordinal();
            } else {
                directionValue = new DirectionComparator(FollowingModes.VERTICALLY).compare(playerPosition, enemyPosition);
            }

        } else {

            if(playerPosition.getY() > enemyPosition.getY()) {
                directionValue = Direction.UP.ordinal();
            } else if (playerPosition.getY() < enemyPosition.getY()) {
                directionValue = Direction.DOWN.ordinal();
            } else {
                directionValue = new DirectionComparator(FollowingModes.HORINZONTALLY).compare(playerPosition, enemyPosition);
            }

        }

        return directionValue;
    }
}
