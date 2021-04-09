package bomberOne.model.timer;

public class TimerThread extends Thread{

	private Timer timer;
	
	public void setTimer(Timer t) {
		this.timer = t;
	}
	
	public TimerThread(Timer t) {
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
