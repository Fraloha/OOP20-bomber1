package bomberone.model.timer;

/**
 * This interface let's the user to manage a quantity of time through minutes and seconds
 * @author Luigi
 *
 */
public interface Time {
	
	/**
	 * Sets the total time 
	 * @param tot The total seconds to set
	 */
	public void setTotal(int tot); 
	
	/**
	 * @return the total number of seconds remained
	 */
	public int getTotal();
	
	/**
	 * 
	 * @return the total number of minutes remained
	 */
	public int getMinutes(); 
	
	/**
	 * 
	 * @return the total number of seconds remained
	 */
	public int getSeconds() ;
}
