
package bomberOne.controllers.game;

import bomberOne.controllers.ControllerImpl;
import bomberOne.model.event.WorldEventListener;
import bomberOne.model.event.WorldEventListenerImpl;
import bomberOne.model.input.CommandListener;
import bomberOne.model.input.CommandListenerImpl;
import bomberOne.views.game.GameView;
import javafx.application.Platform;

public final class GameControllerImpl extends ControllerImpl implements GameController, Runnable {

    private static final double PERIOD = 16.6666;

    private WorldEventListener eventHandler;
    private CommandListener commandHandler;
    private Thread game;

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
        ((GameView) this.getView()).switchToRank();

    }

    protected void waitForNextFrame(final long current) {
        long dt = System.currentTimeMillis() - current;
        if (dt < PERIOD) {
            try {
                Thread.sleep((long) (PERIOD - dt));
            } catch (Exception ex) {

            }
        }
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
        this.getModel().getWorld().updateState(elapsedTime);
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
        this.game.start();
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
