package bomberone.model.common;

public class P2d {

    private double x, y;

    public P2d(final double x, final double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * 
     * @return the X coord
     */
    public double getX() {
        return x;
    }

    /**
     * 
     * @return the Y coord
     */
    public double getY() {
        return y;
    }

    /**
     * 
     * @param time
     * @param velocityX
     * @param velocityY
     * @return the P2d
     */
    public P2d update(final double time, final double velocityX, final double velocityY) {
        return new P2d(x + time * velocityX, y + time * velocityY);
    }

    /**
     * @return the P2d in String form.
     *
     */
    public String toString() {
        return "P2d(" + x + "," + y + ")";
    }

    /**
     * 
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        long temp;
        temp = Double.doubleToLongBits(x);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(y);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    /**
     * 
     */
    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        P2d other = (P2d) obj;
        if (Double.doubleToLongBits(x) != Double.doubleToLongBits(other.x)) {
            return false;
        }
        if (Double.doubleToLongBits(y) != Double.doubleToLongBits(other.y)) {
            return false;
        }
        return true;
    }
}
