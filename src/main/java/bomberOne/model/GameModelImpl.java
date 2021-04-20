package bomberOne.model;

import bomberOne.model.factory.WorldFactory;
import bomberOne.model.factory.WorldFactoryImpl;
import bomberOne.model.timer.Timer;
import bomberOne.model.timer.TimerImpl;
import bomberOne.model.timer.TimerThread;
import bomberOne.model.user.Difficulty;
import bomberOne.model.user.User;
import bomberOne.model.user.UserImpl;

public class GameModelImpl implements GameModel {

    private static final int TIME = 30;
    private User user;
    private World world;
    private Difficulty difficulty;
    private int score = 0;
    private WorldFactory factory;
    private Timer timer = new TimerImpl(GameModelImpl.TIME);
    private boolean gameOver = false;
    private TimerThread thread = new TimerThread(timer);

    public GameModelImpl() {
        this.user = new UserImpl();
        this.factory = new WorldFactoryImpl();
    }

    @Override
    public final void init() {
        // TODO Auto-generated method stub
        if (this.difficulty.equals(Difficulty.STANDARD)) {
            this.world = factory.createWorldStandard(this.user);
        } else {
            this.world = factory.createWorldHard(this.user);
        }
        this.thread.start();
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
        if (this.gameOver) {
            this.thread.interrupt();
        }
    }

    @Override
    public final Timer getTimer() {
        return this.timer;
    }

}
