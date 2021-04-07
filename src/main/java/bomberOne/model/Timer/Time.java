package bomberOne.model.Timer;

public class Time {

	private int totalSec;
	private int minutes;
	private int seconds;
	
	public void setTotal(int tot) {
		this.totalSec = tot;
	}
	
	public Time(int tot) {
		this.totalSec = tot;
	}
	
	public int getTotal() {
		return this.totalSec;
	}
	
	public int getMinutes() {
		this.minutes = this.totalSec / 60;
		return minutes;
	}
	
	public int getSeconds() {
		this.seconds = this.totalSec % 60;
		return this.seconds;
	}
	
}
