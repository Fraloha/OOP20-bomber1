package bomberone.controllers.setUp;

import bomberone.controllers.Controller;
import bomberone.model.user.Controls;
import bomberone.model.user.Difficulty;
import bomberone.model.user.Skins;

/**
 * This Controller sets some settings of the GameModel by the choice of the User in the SetUpView
 * @author Luigi
 *
 */
public interface SetUpController extends Controller{

	/**
	 * Set the Difficulty of the GameModel attached on it
	 * @param diff 
	 */
	public void setDifficulty(Difficulty diff);
	
	/**
	 * Set the User on the GameModel
	 * @param name
	 */
	public void setUser(String name);
	
	/**
	 * Set the skin of the Bomberman
	 * @param id
	 */
	public void setSkin(Skins skin);
	
	/**
	 * Set the Controls that are used by the Player to manage the Bomberman
	 * @param choice
	 */
	public void setControls(Controls choice);
}
