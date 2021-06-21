package bomberone.model.pathfinding.gameboard;

/**
 * This enumerator contains values to set to a BoardPoint object. Every value
 * indicates a specific status of a BoardPoint object.
 */
public enum Markers {

    /**
     * This value indicates that the BoardPoint object is accessible, so walkable.
     */
    ACCESSIBLE('F'),

    /**
     * This value indicates that the BoardPoint object is not accessible, so
     * non-walkable.
     */
    NOTACCESSIBLE('N'),

    /**
     * This value indicates that the BoardPoint object is not accessible but there
     * is an removable entity in. If the entity was removed, the BoardPoint's would
     * be accessible.
     */
    REMOVABLE('D'),

    /**
     * This value indicates that the BoardPoint object is the spot that the enemy
     * will try to reach using path finding.
     */
    SPOT('X');

    private char marker;

    Markers(final char markerToSet) {
        this.marker = markerToSet;
    }

    public char getMarker() {
        return this.marker;
    }
}