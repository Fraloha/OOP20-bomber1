package bomberOne.controllers.game;

import bomberOne.controllers.ControllerImpl;
import bomberOne.model.GameModel;
import bomberOne.model.event.WorldEventListener;
import bomberOne.model.event.WorldEventListenerImpl;
import bomberOne.model.input.CommandListener;
import bomberOne.views.View;

public class GameControllerImpl extends ControllerImpl implements GameController, Runnable{

	private static final int PERIOD = 20;
	
	GameModel model;
	WorldEventListener eventHandler;
	CommandListener commandHandler;
	View view;
	
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
		this.model = new WorldEventListenerImpl();
		this.commandHandler = new CommandListenerImpl();
		view.drawGame();
		this.model.getWorld().init();
	}

	@Override
	public void processEvent() {
		this.eventHandler.processEvents();
	}

}
