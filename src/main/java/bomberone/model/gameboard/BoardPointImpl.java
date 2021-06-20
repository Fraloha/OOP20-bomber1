package bomberone.model.gameboard;

/**
 * This object represent the GameBoard unit, indeed the GameBoard is composed by
 * BoardPoint objects.
 */
public class BoardPointImpl implements BoardPoint {

    /* Fields. */
    private int x;
    private int y;
    private Markers pointMarker;

    /* Constructors. */
    /**
     * Instantiate a new BoardPoint object.
     */
    public BoardPointImpl() {

    }

    /**
     * Creates a new BoardPoint object.
     * 
     * @param newMarker The BoardPoint marker.
     */
    public BoardPointImpl(final Markers newMarker) {
        this.pointMarker = newMarker;
    }

    /**
     * Creates a new BoardPoint object.
     * 
     * @param xToSet The BoardPoint first coordinate.
     * @param yToSet The BoardPoint second coordinate.
     */
    public BoardPointImpl(final int xToSet, final int yToSet) {
        this.x = xToSet;
        this.y = yToSet;
    }

    /**
     * Create a new BoardPoint object.
     * 
     * @param xToSet    The BoardPoint first coordinate.
     * @param yToSet    The BoardPoint second coordinate.
     * @param newMarker The BoardPoint marker.
     */
    public BoardPointImpl(final int xToSet, final int yToSet, final Markers newMarker) {
        this.x = xToSet;
        this.y = yToSet;
        this.pointMarker = newMarker;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getX() {
        return this.x;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getY() {
        return this.y;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Markers getMarker() {
        return this.pointMarker;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public char getMarkerValue() {
        return this.pointMarker.getMarker();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setX(final int newX) {
        this.x = newX;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setY(final int newY) {
        this.y = newY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setMarker(final Markers markerToSet) {
        this.pointMarker = markerToSet;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setPoint(final int newX, final int newY) {
        this.x = newX;
        this.y = newY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isEquals(final BoardPoint pointToCheck) {
        return this.x == pointToCheck.getX() && this.y == pointToCheck.getY();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return this.x + ", " + this.y;
    }
}
