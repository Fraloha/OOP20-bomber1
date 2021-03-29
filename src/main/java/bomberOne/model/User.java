package bomberOne.model;

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
	 * 
	 * @return the name of the User
	 */
	public String getName();
	
	/**
	 * 
	 * @return the score of the User
	 */
	public int getScore();

}
