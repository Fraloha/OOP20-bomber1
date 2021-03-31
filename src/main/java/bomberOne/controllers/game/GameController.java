package bomberOne.controllers.game;

import bomberOne.controllers.Controller;
import bomberOne.model.event.WorldEventListener;

public interface GameController extends Controller{

	
	public void initGame();
	
	public void processInput();
	
	public void render();
	
	public void updateGame();
	
	public WorldEventListener getEventHandler();
	
}
