package bomberOne.model.timer;

public class TimerThread extends Thread {

    private Timer timer;

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
     * 
     */
    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.timer.decTime();
        }
    }

}
