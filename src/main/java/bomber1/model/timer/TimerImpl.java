package bomber1.model.timer;

public final class TimerImpl implements Timer {

    private Time time;

    public TimerImpl(final int tot) {
        this.time = new TimeImpl(tot);
    }

    @Override
    public synchronized void setTimer(final int time) {
        this.time.setTotal(time);
    }

    @Override
    public synchronized void decTime() {
        this.time.setTotal(time.getTotal() - 1);
    }

    @Override
    public synchronized Time getTime() {
        return this.time;
    }

    @Override
    public String toString() {
        return String.format("%02d", this.getTime().getMinutes()) + ":" + String.format("%02d", this.getTime().getSeconds());
    }
}
