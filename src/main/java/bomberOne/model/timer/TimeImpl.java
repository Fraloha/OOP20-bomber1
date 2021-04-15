package bomberone.model.timer;

public final class TimeImpl implements Time {

    private static final int SECONDS_IN_A_MINUTE = 60;
    private int totalSec;
    private int minutes;
    private int seconds;

    public TimeImpl(final int tot) {
        this.totalSec = tot;
    }

    @Override
    public void setTotal(final int tot) {
        this.totalSec = tot;
    }

    @Override
    public int getTotal() {
        return this.totalSec;
    }

    @Override
    public int getMinutes() {
        this.minutes = this.totalSec / SECONDS_IN_A_MINUTE;
        return minutes;
    }

    @Override
    public int getSeconds() {
        this.seconds = this.totalSec % SECONDS_IN_A_MINUTE;
        return this.seconds;
    }

}
