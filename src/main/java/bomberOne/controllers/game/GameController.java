package bomberOne.controllers.game;

import bomberOne.controllers.Controller;
import bomberOne.model.input.CommandListener;

/**
 * The Game Controller that contains the gameloop and handles Events & Command
 * @author Luigi
 *
 */
public interface GameController extends Controller{
	
	/**
	 * Process all the User's input command on the Command Queue
	 */
	void processInput();
	
	/**
	 * Process all the WorldEvents on the Event Queue
	 */
	void processEvent();
	
	/**
	 * Calls the render on the View
	 */
	public void render();
	
	/**
	 * Calls the updateState on the World to update every GameObject
	 * @param elapsedTime
	 */
	public void updateGame(int elapsedTime);
	
	
	/**
	 * Return the command Listener attached to the controller
	 */
	public CommandListener getCommandListener();
}
