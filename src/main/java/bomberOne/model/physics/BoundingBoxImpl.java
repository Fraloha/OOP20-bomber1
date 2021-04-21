package bomberOne.model.physics;

import bomberOne.model.common.P2d;

public class BoundingBoxImpl implements BoundingBox {

    private P2d lTCorner;
    private P2d rBCorner;

    public BoundingBoxImpl(final P2d lTop, final P2d rBottom) {
        this.lTCorner = lTop;
        this.rBCorner = rBottom;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isCollidingWith(final BoundingBox obj) {
        // obj collide on top
        if (this.lTCorner.getY() < obj.getRightBottomCorner().getY()
                && this.rBCorner.getY() >= obj.getRightBottomCorner().getY()
                && this.lTCorner.getX() <= obj.getLeftTopCorner().getX()
                && this.rBCorner.getX() > obj.getLeftTopCorner().getX()
                || this.lTCorner.getY() < obj.getRightBottomCorner().getY()
                        && this.rBCorner.getY() > obj.getRightBottomCorner().getY()
                        && this.lTCorner.getX() >= obj.getLeftTopCorner().getX()
                        && this.lTCorner.getX() <= obj.getRightBottomCorner().getX()) {
            return true;
        }
        // obj collide on bottom
        if (this.rBCorner.getY() > obj.getLeftTopCorner().getY() && this.lTCorner.getY() < obj.getLeftTopCorner().getY()
                && this.lTCorner.getX() <= obj.getLeftTopCorner().getX()
                && this.rBCorner.getX() >= obj.getLeftTopCorner().getX()
                || this.rBCorner.getY() > obj.getLeftTopCorner().getY()
                        && this.lTCorner.getY() < obj.getLeftTopCorner().getY()
                        && this.lTCorner.getX() >= obj.getLeftTopCorner().getX()
                        && this.lTCorner.getX() <= obj.getRightBottomCorner().getX()) {
            return true;
        }
        // obj collide on left
        if (this.lTCorner.getX() < obj.getRightBottomCorner().getX()
                && this.rBCorner.getX() > obj.getRightBottomCorner().getX()
                && this.lTCorner.getY() <= obj.getLeftTopCorner().getY()
                && this.rBCorner.getY() >= obj.getLeftTopCorner().getY()
                || this.lTCorner.getX() < obj.getRightBottomCorner().getX()
                        && this.rBCorner.getX() > obj.getRightBottomCorner().getX()
                        && this.lTCorner.getY() >= obj.getLeftTopCorner().getY()
                        && this.lTCorner.getY() <= obj.getRightBottomCorner().getY()) {
            return true;
        }
        // obj collide on right
        if (this.rBCorner.getX() > obj.getLeftTopCorner().getX() && this.lTCorner.getX() < obj.getLeftTopCorner().getX()
                && this.lTCorner.getY() <= obj.getLeftTopCorner().getY()
                && this.rBCorner.getY() >= obj.getLeftTopCorner().getY()
                || this.rBCorner.getX() > obj.getLeftTopCorner().getX()
                        && this.lTCorner.getX() < obj.getLeftTopCorner().getX()
                        && this.lTCorner.getX() >= obj.getLeftTopCorner().getY()
                        && this.lTCorner.getY() <= obj.getRightBottomCorner().getY()) {
            return true;
        }
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public P2d getLeftTopCorner() {
        return this.lTCorner;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public P2d getRightBottomCorner() {
        return this.rBCorner;
    }

}
