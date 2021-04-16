package bomberone.model.timer;

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
    public Time getTime() {
        return this.time;
    }

    @Override
    public String toString() {
        return this.getTime().getMinutes() + ":" + this.getTime().getSeconds();
    }
}
