package bomberone.controllers.match;

import java.util.List;

import bomberone.controllers.Controller;
import bomberone.controllers.match.input.CommandListener;
import bomberone.model.bomber.Bomber;
import bomberone.model.enemy.Enemy;
import bomberone.model.gameObjects.bomb.Bomb;
import bomberone.model.gameObjects.box.Box;
import bomberone.model.gameObjects.fire.Fire;
import bomberone.model.gameObjects.hardwall.HardWall;
import bomberone.model.gameObjects.powerUp.PowerUp;
import bomberone.model.match.Difficulty;
import bomberone.model.timer.Timer;
import bomberone.model.user.User;

/**
 * The Game Controller of the MatchView that contains the Gameloop and handles
 * Events & Command.
 * 
 *
 */
public interface MatchController extends Controller {

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
     * @return the GameMatch's timer.
     */
    Timer getTimer();

    /**
     * Called if the View needs the User Info.
     * 
     * @return the GameMatch's User
     */
    User getUserOfTheMatch();

    /**
     * Called if View needs the Game Score.
     * 
     * @return the Match Score.
     */
    int getScore();

    /**
     * Called if View needs the Game Difficulty.
     * 
     * @return the Game Difficulty.
     */
    Difficulty getDifficulty();

    /**
     * Called if View needs the list of FireObject.
     * 
     * @return the list of Fire.
     */
    List<Fire> getFireList();

    /**
     * Called if View needs the list of Bombs.
     * 
     * @return the list of Bombs.
     */
    List<Bomb> getBombList();

    /**
     * Called if View needs the list of Boxes.
     * 
     * @return the list of Boxes.
     */
    List<Box> getBoxList();

    /**
     * Called if View needs the list of Walls.
     * 
     * @return the list of Walls.
     */
    List<HardWall> getHardWallList();

    /**
     * Called if View needs the list of Enemies.
     * 
     * @return the list of Enemies.
     */
    List<Enemy> getEnemyList();

    /**
     * Called if View needs the list of PowerUp.
     * 
     * @return the list of PowerUp.
     */
    List<PowerUp> getPowerUpList();

}
