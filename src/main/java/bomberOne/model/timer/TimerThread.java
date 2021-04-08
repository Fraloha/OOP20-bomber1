package bomberOne.model.timer;

public class TimerThread extends Thread{

	private TimerImpl timer;
	
	public void setTimer(TimerImpl t) {
		this.timer = t;
	}
	
	public TimerThread(TimerImpl t) {
		this.timer = t;
	}
	
	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			this.timer.decTime();
		}
	}

}
