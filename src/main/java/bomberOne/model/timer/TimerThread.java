package bomberOne.model.timer;

/**
 * This Thread handles the Timer of the Game in parallel to the GameThread
 *
 */
public class TimerThread extends Thread {

    private Timer timer;
    private boolean stopped = false;

    /**
     * 
     * @param t
     */
    public void setTimer(final Timer t) {
        this.timer = t;
    }

    public TimerThread(final Timer t) {
        this.timer = t;
    }

    /**
     * Set "stopped" variable to true to Stop the Thread.
     */
    public void stopTimer() {
        this.stopped = true;
    }

    /**
     * Decrease the timer second by second.
     */
    @Override
    public void run() {
        while (!this.stopped) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.timer.decTime();
        }
    }

}
