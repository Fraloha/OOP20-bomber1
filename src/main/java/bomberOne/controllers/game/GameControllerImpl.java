package bomberOne.controllers.game;

import bomberOne.controllers.ControllerImpl;
import bomberOne.model.GameModel;
import bomberOne.model.GameModelImpl;
import bomberOne.model.event.WorldEventListener;
import bomberOne.model.event.WorldEventListenerImpl;
import bomberOne.model.input.CommandListener;
import bomberOne.model.input.CommandListenerImpl;
import bomberOne.views.game.GameView;

public class GameControllerImpl extends ControllerImpl implements GameController, Runnable{

	private static final int PERIOD = 20;
	
	private GameModel model;
	private WorldEventListener eventHandler;
	private CommandListener commandHandler;
	private GameView view;
	
	@Override
	public void run() {
		long lastTime = System.nanoTime();
        final double NS = 1000000000.0 / 60.0; // Locked ticks per second to 60
        double delta = 0;
        // Count FPS, Ticks, and execute updates
        while (this.model.getGameOver()) {
            long currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / NS;
            int elapsed = (int)(currentTime - lastTime);
            lastTime = currentTime;          
            if (delta >= 1) {
                this.updateGame(elapsed);
                this.processEvent();
                this.processInput();
                delta--;
            }
            this.render();
	    }
        this.view.switchToRank();
	        
	}

	protected void waitForNextFrame(long current){
		long dt = System.currentTimeMillis() - current;
		if (dt < PERIOD){
			try {
				Thread.sleep(PERIOD-dt);
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
		view.render();
	}

	@Override
	public void updateGame(int elapsedTime) {
		this.model.getWorld().updateState(elapsedTime);
	}

	@Override
	public void init() {
		this.model = new GameModelImpl();
		this.eventHandler = new WorldEventListenerImpl();
		this.commandHandler = new CommandListenerImpl();
		view.drawGame();
		this.model.init();
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
