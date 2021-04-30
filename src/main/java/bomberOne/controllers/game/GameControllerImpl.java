
package bomberOne.controllers.game;

import bomberOne.controllers.ControllerImpl;
import bomberOne.model.event.WorldEventListener;
import bomberOne.model.event.WorldEventListenerImpl;
import bomberOne.model.input.CommandListener;
import bomberOne.model.input.CommandListenerImpl;
import bomberOne.views.game.GameView;

public final class GameControllerImpl extends ControllerImpl implements GameController, Runnable {

    private static final double PERIOD = 16.6666;

    private WorldEventListener eventHandler;
    private CommandListener commandHandler;
    private Thread game;
    public boolean wasStopped;

    @Override
    public void run() {
        long lastTime = System.currentTimeMillis();
        while (!this.getModel().getGameOver()) {
            long current = System.currentTimeMillis();
            int elapsed = (int) (current - lastTime);
            this.processInput();
            this.updateGame(elapsed);
            this.processEvent();
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

    @Override
    public void quitGame() {
        this.getModel().getTimerThread().stopTimer();
        this.getModel().setGameOver(true);
        this.wasStopped = true;
    }

    @Override
    public void processInput() {
        commandHandler.executeCommands();
    }

    @Override
    public void render() {
        ((GameView) this.getView()).render();
    }

    @Override
    public void updateGame(final int elapsedTime) {
        this.getModel().updateGame(elapsedTime);
    }

    @Override
    public void init() {
        this.eventHandler = new WorldEventListenerImpl();
        this.commandHandler = new CommandListenerImpl();
        this.eventHandler.setGameModel(this.getModel());
        this.commandHandler.setGameModel(this.getModel());
        this.getModel().getWorld().setEventListener(this.eventHandler);
        // this.getModel().init();
        this.game = new Thread(this);
        this.game.setName("LOOP");
        this.game.start();
        Thread.currentThread().interrupt();
    }

    @Override
    public void processEvent() {
        this.eventHandler.processEvents();
    }

    @Override
    public CommandListener getCommandListener() {
        return this.commandHandler;
    }

}
