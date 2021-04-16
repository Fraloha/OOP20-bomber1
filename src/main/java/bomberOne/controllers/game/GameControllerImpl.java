package bomberone.controllers.game;

import bomberone.controllers.ControllerImpl;
import bomberone.model.event.WorldEventListener;
import bomberone.model.event.WorldEventListenerImpl;
import bomberone.model.input.CommandListener;
import bomberone.model.input.CommandListenerImpl;
import bomberone.views.game.GameView;

public final class GameControllerImpl extends ControllerImpl implements GameController, Runnable {

    private static final int PERIOD = 20;

    private WorldEventListener eventHandler;
    private CommandListener commandHandler;

    @Override
    public void run() {
        long lastTime = System.nanoTime();
        final double ns = 1000000000.0 / 60.0; // Locked ticks per second to 60
        double delta = 0;
        // Count FPS, Ticks, and execute updates
        while (this.getModel().getGameOver()) {
            long currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / ns;
            int elapsed = (int) (currentTime - lastTime);
            lastTime = currentTime;
            if (delta >= 1) {
                this.updateGame(elapsed);
                this.processEvent();
                this.processInput();
                delta--;
            }
            this.render();
        }
        ((GameView) this.getView()).switchToRank();

    }

    protected void waitForNextFrame(final long current) {
        long dt = System.currentTimeMillis() - current;
        if (dt < PERIOD) {
            try {
                Thread.sleep(PERIOD - dt);
            } catch (Exception ex) {

            }
        }
    }

    @Override
    public void processInput() {
        commandHandler.executeAll();
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
        this.getModel().init();
        this.run();
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
