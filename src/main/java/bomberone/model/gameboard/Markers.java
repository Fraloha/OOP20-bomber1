package bomberone.model.gameboard;

public enum Markers {

    /**
     * 
     */
    PLAYER_MARKER('P'),

    /**
     * 
     */
    GROUND_MARKER('G'), 

    /**
     * 
     */
    BOX_MARKER('B'), 

    /**
     * 
     */
    WALL_MARKER('W'), 

    /**
     * 
     */
    ENEMY_MARKER('E');

    private char marker;

    Markers(final char markerToSet) {
        this.marker = markerToSet;
    }

    public char getMarker() {
        return this.marker;
    }
}
