
package bomberone.controllers.game;

import bomberone.controllers.ControllerImpl;
import bomberone.controllers.game.event.WorldEventListener;
import bomberone.controllers.game.event.WorldEventListenerImpl;
import bomberone.controllers.game.input.CommandListener;
import bomberone.controllers.game.input.CommandListenerImpl;
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
        while (!this.getModel().getGameOver()) {
            long current = System.currentTimeMillis();
            int elapsed = (int) (current - lastTime);
            this.processInput();
            this.updateGame(elapsed);
            this.render();
            this.waitForNextFrame(current);
            lastTime = current;

        }
        if (!this.wasStopped) {
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
        // this.clip.stop();
        this.getModel().getTimerThread().stopTimer();
        this.getModel().setGameOver(true);
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
        this.getModel().updateGame(elapsedTime);
        this.getModel().getWorld().checkBoundary();
        this.processEvent();
        this.getModel().getWorld().checkCollision();
        this.getModel().getWorld().checkRespawn();
        this.processEvent();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void init() {
        this.eventHandler = new WorldEventListenerImpl();
        this.commandHandler = new CommandListenerImpl();
        this.eventHandler.setGameModel(this.getModel());
        this.commandHandler.setGameModel(this.getModel());
        this.getModel().init();
        this.getModel().getWorld().setEventListener(this.eventHandler);
        this.game = new Thread(this);
        this.game.setName("LOOP");
        this.game.start();
        this.getModel().getTimerThread().start();
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

}
