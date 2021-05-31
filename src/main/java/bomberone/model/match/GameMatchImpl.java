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

    /**
     * {@inheritDoc}
     */
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

    /**
     * {@inheritDoc}
     */
    @Override
    public final void setUser(final User user) {
        this.user = user;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final User getUser() {
        return this.user;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final void setDifficulty(final Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final World getWorld() {
        return this.world;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final int getScore() {
        return this.score;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final void setWorld(final World world) {
        this.world = world;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final void decScore(final int dec) {
        this.score -= dec;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final void incScore(final int inc) {
        this.score += inc;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final void updateGame(final int elapsed) {
        world.updateState(elapsed);
        this.checkGameOver();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final void setGameOver(final boolean gameOver) {
        this.gameOver = gameOver;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final boolean getGameOver() {
        return this.gameOver;
    }

    /**
     * {@inheritDoc}
     */
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

    /**
     * {@inheritDoc}
     */
    public final Difficulty getDifficulty() {
        return this.difficulty;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final Timer getTimer() {
        return this.timer;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final TimerThread getTimerThread() {
        return this.thread;
    }
}
