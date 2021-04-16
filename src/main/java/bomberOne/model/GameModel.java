package bomberOne.model;

import bomberOne.model.timer.Timer;
import bomberOne.model.user.Difficulty;
import bomberOne.model.user.User;

/**
 * The Model of the Game
 * @author Tommaso Brini
 *
 */
public interface GameModel {

	/**
	 * Initialize the entire game world
	 */
	void init();
	
	/**
	 * set the User of this game
	 */
	void setUser(User user);
	
	
	/**
	 * 
	 * @return the user
	 */
	User getUser();
	
	/**
	 * Initialize the difficulty of the gameplay
	 * @param difficulty
	 */
	void setDifficulty(Difficulty difficulty);
	
	/**
	 * 
	 * @return the World of this game
	 */
	World getWorld();
	
	/**
	 * 
	 * @return the current score
	 */
	int getScore();
	
	/**
	 * Setting the World
	 * @param world
	 */
	void setWorld(World world);
	
	/**
	 * Decrease the current score by the param dec
	 * @param dec
	 */
	void decScore(int dec);
	
	/**
	 * Increase the current score by the param inc
	 * @param inc
	 */
	void incScore(int inc);
	
	void updateGame(int elapsed);
	
	boolean getGameOver();
	
	void checkGameOver();
	
	Timer getTimer();
}
