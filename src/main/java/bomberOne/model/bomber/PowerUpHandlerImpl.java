package bomberOne.model.bomber;

/**
 * This class apply the powerUp at the Bomber.
 * 
 *
 */
public class PowerUpHandlerImpl implements PowerUpHandler {

    private final BomberImpl bomber;

    public PowerUpHandlerImpl(final BomberImpl bomber) {
        this.bomber = bomber;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void applyFirePower(final int increment) {
        this.bomber.incFirePower(increment);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void applySpeed(final double increment) {
        this.bomber.incSpeed(increment);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void applyPierce() {
        this.bomber.activatePierce();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void applyMultiAmmo(final int increment) {
        this.bomber.incAmmo(increment);
    }
}
