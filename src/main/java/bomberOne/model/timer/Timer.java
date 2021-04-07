package bomberOne.model.timer;

public class Timer {

	private Time time;
	
	public Timer(int tot) {
		this.time = new Time(tot);
	}
	
	public void setTimer(int time) {
		this.time.setTotal(time);
	}
	
	public synchronized void decTime() {
		this.time.setTotal(time.getTotal() - 1);
	}
	
	public Time getTime() {
		return this.time;
	}
	
	public String toString() {
		return this.getTime().getMinutes() + ":" + this.getTime().getSeconds();
	}
}
