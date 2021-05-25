package bomberone.model.enemy;

public class Log {

    private boolean trigger = false;

    private static final class LogHolder {
        private static final Log LOGGERSINGLETON = new Log();
    }

    public static Log getInstance() {
        return LogHolder.LOGGERSINGLETON;
    }

    public void getLog(String message, boolean oneLine) {
        if (oneLine && !this.trigger) {
            this.trigger = true;
            System.out.println(message);
        }
    }
}
