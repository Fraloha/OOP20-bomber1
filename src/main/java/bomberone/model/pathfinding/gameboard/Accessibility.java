package bomberone.model.pathfinding.gameboard;

/**
 * A simple enumerator to specify if has to be checked the accessibility of a
 * row or a column.
 */
public enum Accessibility {
    /**
     * This value indicates that the accessibility has to be checked on the same
     * columns.
     */
    ROWS,
    /**
     * This value indicates that the accessibility has to be checked on the same
     * row.
     */
    COLUMNS;
}
