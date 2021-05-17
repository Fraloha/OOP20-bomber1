package bomberone.model.gameObjects;

/**
 * PowerUp Object that can change the Game's property.
 *
 */
public interface PowerUp extends GameObject {

    enum Type {
        /**
         * 
         */
        FirePower, 

        /**
         * 
         */
        Speed, 

        /**
         * 
         */
        Pierce, 

        /**
         * 
         */
        Time, 

        /**
         * 
         */
        Ammo;
    }

    /**
     * 
     * @return True, if the PowerUp is dropped by the box
     */
    boolean isReleased();

    /**
     * When the Box is destroyed, it calls this method.
     */
    void release();

    /**
     * 
     * @return The type of the PowerUp
     */
    PowerUp.Type getType();
}
