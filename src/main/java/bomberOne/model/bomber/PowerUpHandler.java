package bomberOne.model.bomber;

public interface PowerUpHandler {

        /**
         * This method apply the powerUp More Fire Power.
         * 
         * @param increment
         */
        void applyFirePower(int increment);

        /**
         * This method apply the powerUp More Speed.
         * 
         * @param increment
         */
        void applySpeed(double increment);

        /**
         * This method apply the powerUp Pierce.
         * 
         */
        void applyPierce();

        /**
         * This method apply the powerUp More Ammo.
         * 
         * @param increment
         */
        void applyMultiAmmo(int increment);
}
