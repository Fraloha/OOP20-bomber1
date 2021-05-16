
package bomberone.controllers.game;

import bomberone.controllers.ControllerImpl;
import bomberone.controllers.game.event.WorldEventListener;
import bomberone.controllers.game.event.WorldEventListenerImpl;
import bomberone.controllers.game.input.CommandListener;
import bomberone.controllers.game.input.CommandListenerImpl;
import bomberone.model.bomber.Bomber;
import bomberone.model.gameObjects.GameObjectCollection;
import bomberone.model.match.Difficulty;
import bomberone.model.timer.Timer;
import bomberone.model.user.User;
import bomberone.tools.RankLoader;
import bomberone.views.game.GameView;

public class GameControllerImpl extends ControllerImpl implements GameController, Runnable {

    private static final double PERIOD = 16.6666;

    private WorldEventListener eventHandler;
    private CommandListener commandHandler;
    private Thread game;
    private boolean wasStopped;

    /**
     * {@inheritDoc}
     */
    @Override
    public void run() {
        long lastTime = System.currentTimeMillis();
        while (!this.getModel().getCurrentMatch().getGameOver()) {
            long current = System.currentTimeMillis();
            int elapsed = (int) (current - lastTime);
            this.processInput();
            this.updateGame(elapsed);
            this.render();
            this.waitForNextFrame(current);
            lastTime = current;

        }
        this.getModel().getCurrentMatch().getTimerThread().stopTimer();
        this.getModel().getCurrentMatch().getUser().setScore(this.getModel().getCurrentMatch().getScore());
        if (!this.wasStopped) {
            /* Add the user on the specific rank */
            if (this.getModel().getCurrentMatch().getDifficulty().equals(Difficulty.HARD)) {
                this.getModel().getHardRank().add(this.getModel().getCurrentMatch().getUser());
            } else {
                this.getModel().getStdRank().add(this.getModel().getCurrentMatch().getUser());
            }
            RankLoader.writeUsers(this.getModel().getHardRank(), this.getModel().getStdRank());
            ((GameView) this.getView()).switchToRank();
        }

    }

    private void waitForNextFrame(final long current) {
        long dt = System.currentTimeMillis() - current;
        if (dt < PERIOD) {
            try {
                Thread.sleep((long) (PERIOD - dt));
            } catch (Exception ex) {
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void quitGame() {
        this.getModel().getCurrentMatch().setGameOver(true);
        this.wasStopped = true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void processInput() {
        commandHandler.executeCommands();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void render() {
        ((GameView) this.getView()).render();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void updateGame(final int elapsedTime) {
        this.getModel().getCurrentMatch().updateGame(elapsedTime);
        this.getModel().getCurrentMatch().getWorld().checkBoundary();
        this.processEvent();
        this.getModel().getCurrentMatch().getWorld().checkCollision();
        this.getModel().getCurrentMatch().getWorld().checkRespawn();
        this.processEvent();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void init() {
        this.eventHandler = new WorldEventListenerImpl();
        this.commandHandler = new CommandListenerImpl();
        this.eventHandler.setGameMatch(this.getModel().getCurrentMatch());
        this.commandHandler.setGameModel(this.getModel().getCurrentMatch());
        this.getModel().getCurrentMatch().init();
        this.getModel().getCurrentMatch().getWorld().setEventListener(this.eventHandler);
        this.game = new Thread(this);
        this.game.setName("LOOP");
        this.game.start();
        this.getModel().getCurrentMatch().getTimerThread().start();
        Thread.currentThread().interrupt();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void processEvent() {
        this.eventHandler.processEvents();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CommandListener getCommandListener() {
        return this.commandHandler;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Bomber getBomber() {
        return this.getModel().getCurrentMatch().getWorld().getBomber();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timer getTimer() {
        return this.getModel().getCurrentMatch().getTimer();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public User getPlayerOfTheGame() {
        return this.getModel().getCurrentMatch().getUser();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public GameObjectCollection getObjList() {
        return this.getModel().getCurrentMatch().getWorld().getGameObjectCollection();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getScore() {
        return this.getModel().getCurrentMatch().getScore();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Difficulty getDifficulty() {
        return this.getModel().getCurrentMatch().getDifficulty();
    }

}
