package bomberone.model.gameboard;

/**
 * This interfaces defines a game board point. A BoardPoint has two coordinates,
 * the first indicates the row and the second the column.
 */
public interface BoardPoint {

    /**
     * This method gets the BoardPoint's first coordinate.
     * 
     * @return The point's first coordinate, so the row number.
     */
    int getX();

    /**
     * This method gets the BoardPoint's second coordinate.
     * 
     * @return The point's second coordinate, so the column number.
     */
    int getY();

    /**
     * This method gets the BoardPoint's marker.
     * 
     * @return The point's marker.
     */
    Markers getMarker();

    /**
     * This method gets the current marker's value.
     * 
     * @return a character that is the marker value.
     */
    char getMarkerValue();

    /**
     * This method sets the BoardPoint's first coordinate.
     * 
     * @param newX The new value of the first coordinate.
     */
    void setX(int newX);

    /**
     * This method sets the BoardPoint's second coordinate.
     * 
     * @param newY The new value of the second coordinate.
     */
    void setY(int newY);

    /**
     * This method sets a new marker.
     * 
     * @param markerToSet the marker to set.
     */
    void setMarker(Markers markerToSet);

    /**
     * This method sets the BoardPoint's coordinates.
     * 
     * @param newX The first coordinate's new value.
     * 
     * @param newY The second coordinate's new value.
     */
    void setPoint(int newX, int newY);

    /**
     * This method checks if the arguments passed is equal to the current BoardPoint
     * object.
     * 
     * @param pointToCheck The point to check.
     * 
     * @return true if the two object are equal, otherwise false.
     */
    boolean isEquals(BoardPoint pointToCheck);
}
