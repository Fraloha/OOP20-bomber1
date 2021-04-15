package bomberone.model.gameObjects;

public interface PowerUp extends GameObject {

    enum type {
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
    PowerUp.type getType();
}
