package bomberone.model.user;

import java.io.Serializable;

/**
 * The user of the Game, to be saved on the rank
 * @author Luigi Borriello
 *
 */

public interface User extends Serializable{
	
	/**
	 * Sets the name of the User
	 * @param name
	 */
	public void setName(String name);
	
	/**
	 * Sets the score of the user
	 * @param score
	 */
	public void setScore(int score);
	
	/**
	 * Sets the skin of the user
	 * @param skin The skin to attach to the User
	 */
	public void setSkin(Skins skin);
	
	/**
	 * 
	 * @return the name of the User
	 */
	public String getName();
	
	/**
	 * 
	 * @return the score of the User
	 */
	public int getScore();
	
	/**
	 * 
	 * @return the skin choised by the User
	 */
	public Skins getSkin();
	
	/**
	 * 
	 * Set the controls of the User
	 */
	public void setControls(Controls controls);
	
	/**
	 * 
	 * @return the controls of the User
	 */
	public Controls getControls();
	

}
