package bomberone.model.timer;

/**
 * This interface simulates a timer that receives an amount of time and allows you to decrease or increase it
 * @author Luigi
 *
 */
public interface Timer {

	/**
	 * Set the Time attached to the timer, creates it by adding "time" seconds
	 * @param time the total seconds that compose the Time
	 */
	public void setTimer(int time);
	
	/**
	 * Decreases by one the Time attached to the timer
	 */
	public void decTime();
	
	/**
	 * @return the Time attached to the timer
	 */
	public Time getTime();
	
	/**
	 * 
	 * @return The object through a String
	 */
	public String toString();
}
