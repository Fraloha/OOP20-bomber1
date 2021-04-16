package bomberOne.model.timer;

/**
 * This interface let's the user to manage a quantity of time through minutes
 * and seconds.
 * 
 * 
 *
 */
public interface Time {

    /**
     * Sets the total time.
     * 
     * @param tot The total seconds to set
     */
    void setTotal(int tot);

    /**
     * @return the total number of seconds remained
     */
    int getTotal();

    /**
     * 
     * @return the total number of minutes remained
     */
    int getMinutes();

    /**
     * 
     * @return the total number of seconds remained
     */
    int getSeconds();
}
