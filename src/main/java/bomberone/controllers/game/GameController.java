package bomberone.controllers.game;

import bomberone.controllers.Controller;
import bomberone.controllers.game.input.CommandListener;
import bomberone.model.bomber.Bomber;
import bomberone.model.gameObjects.GameObjectCollection;
import bomberone.model.match.Difficulty;
import bomberone.model.timer.Timer;
import bomberone.model.user.User;

/**
 * The Game Controller of the MatchView that contains the Gameloop and handles
 * Events & Command.
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

    /**
     * Called if the View needs Bomber Info.
     * 
     * @return the Bomber
     */
    Bomber getBomber();

    /**
     * Called if the View needs Timer Info.
     * 
     * @return the GameModel's timer.
     */
    Timer getTimer();

    /**
     * Called if the View needs the User Info.
     * 
     * @return the GameModel's User
     */
    User getPlayerOfTheGame();

    /**
     * Called if View needs the GameObjects list.
     * 
     * @return the GameObject list.
     */
    GameObjectCollection getObjList();

    /**
     * Called if View needs the Game Score.
     * 
     * @return the Game Score.
     */
    int getScore();

    /**
     * Called if View needs the Game Difficulty.
     * 
     * @return the Game Difficulty.
     */
    Difficulty getDifficulty();

}
