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
}
