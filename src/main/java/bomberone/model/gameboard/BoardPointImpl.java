package bomberone.model.gameboard;

public class BoardPointImpl implements BoardPoint {

    /* Fields. */
    private int x;
    private int y;

    public BoardPointImpl(final int xToSet, final int yToSet) {
        this.x = xToSet;
        this.y = yToSet;
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
