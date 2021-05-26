package bomberone.model.match;

import bomberone.model.factory.WorldFactory;
import bomberone.model.factory.WorldFactoryImpl;
import bomberone.model.timer.Timer;
import bomberone.model.timer.TimerImpl;
import bomberone.model.timer.TimerThread;
import bomberone.model.user.User;
import bomberone.model.user.UserImpl;
import bomberone.model.world.World;

public class GameMatchImpl implements GameMatch {

    private static final int TIME = 120;
    private User user;
    private World world;
    private Difficulty difficulty;
    private int score = 0;
    private WorldFactory factory;
    private Timer timer;
    private boolean gameOver = false;
    private TimerThread thread;

    public GameMatchImpl() {
        this.user = new UserImpl();
        this.factory = new WorldFactoryImpl();
    }

    @Override
    public final void init() {
        if (this.difficulty.equals(Difficulty.EASY)) {
            this.world = factory.createWorldStandard(this.user);
        } else {
            this.world = factory.createWorldHard(this.user);
        }

        this.timer = new TimerImpl(GameMatchImpl.TIME);
        this.thread = new TimerThread(timer);
    }

    @Override
    public final void setUser(final User user) {
        this.user = user;
    }

    @Override
    public final User getUser() {
        return this.user;
    }

    @Override
    public final void setDifficulty(final Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    @Override
    public final World getWorld() {
        return this.world;
    }

    @Override
    public final int getScore() {
        return this.score;
    }

    @Override
    public final void setWorld(final World world) {
        this.world = world;
    }

    @Override
    public final void decScore(final int dec) {
        this.score -= dec;
    }

    @Override
    public final void incScore(final int inc) {
        this.score += inc;
    }

    @Override
    public final void updateGame(final int elapsed) {
        world.updateState(elapsed);
        this.checkGameOver();
    }

    @Override
    public final void setGameOver(final boolean gameOver) {
        this.gameOver = gameOver;
    }

    @Override
    public final boolean getGameOver() {
        return this.gameOver;
    }

    @Override
    public final void checkGameOver() {
        if (this.world.getBomber().getLifes() == 0) {
            this.gameOver = true;
        } else if (this.world.getGameObjectCollection().getBoxList().size() == 0
                && this.world.getGameObjectCollection().getEnemyList().size() == 0) {
            this.gameOver = true;
        } else if (this.timer.getTime().getTotal() == 0) {
            this.gameOver = true;
        } else {
            this.gameOver = false;
        }


    }

    public final Difficulty getDifficulty() {
        return this.difficulty;
    }

    @Override
    public final Timer getTimer() {
        return this.timer;
    }

    @Override
    public final TimerThread getTimerThread() {
        return this.thread;
    }
}
