package bomberOne.model.common;

public class P2d {

	private double x,y;

    public P2d(double x,double y){
        this.x=x;
        this.y=y;
    }

    public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public P2d update(double time, double velocityX, double velocityY){
        return new P2d(x + time * velocityX , y + time * velocityY);
    }

    public String toString(){
        return "P2d("+x+","+y+")";
    }

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

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		P2d other = (P2d) obj;
		if (Double.doubleToLongBits(x) != Double.doubleToLongBits(other.x))
			return false;
		if (Double.doubleToLongBits(y) != Double.doubleToLongBits(other.y))
			return false;
		return true;
	}
}
