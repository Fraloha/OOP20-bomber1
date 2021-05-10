package bomber.controllers.game;

import bomber.controllers.Controller;
import bomber.controllers.game.input.CommandListener;

/**
 * The Game Controller that contains the gameloop and handles Events & Command.
 * 
 *
 */
public interface GameController extends Controller {

    /**
     * Process all the User's input command on the Command Queue.
     */
    void processInput();

    /**
     * Process all the WorldEvents on the Event Queue.
     */
    void processEvent();

    /**
     * Calls the render on the View.
     */
    void render();

    /**
     * Calls the updateState on the World to update every GameObject.
     * 
     * @param elapsedTime
     */
    void updateGame(int elapsedTime);

    /**
     * Return the command Listener attached to the controller.
     * 
     * @return the listener
     */
    CommandListener getCommandListener();

    /**
     * Called if the Player interrupt the Game before the GameOver.
     */
    void quitGame();
}
