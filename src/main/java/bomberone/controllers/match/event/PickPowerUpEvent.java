package bomberone.controllers.match.event;

import bomberone.model.gameObjects.powerUp.PowerUp;
import bomberone.model.match.GameMatch;
import bomberone.tools.audio.SoundsHandler;
import bomberone.tools.audio.GameSounds;

/**
 * This event is triggered when the Bomber picks a PowerUp.
 *
 */
public class PickPowerUpEvent implements WorldEvent {

    private static final int TIMER_INC = 30;
    private PowerUp powerUp;

    public PickPowerUpEvent(final PowerUp pU) {
        SoundsHandler.start(GameSounds.POWER_UP); // This is the Sound Effect for pickUp powerUp
        this.powerUp = pU;
    }

    /**
     * 
     * @return the PowerUp picked
     */
    public PowerUp getPowerUp() {
        return this.powerUp;
    }

    /**
     * 
     */
    @Override
    public void process(final GameMatch match) {
        if (this.powerUp.getType().equals(PowerUp.Type.Time)) {
            /* Timer PowerUp */
            match.getTimer().setTimer(match.getTimer().getTime().getTotal() + TIMER_INC);
        } else {
            /* All other PowerUp */
            match.getWorld().getBomber().applyPowerUp(this.powerUp.getType());
        }
        this.powerUp.hitted();
    }

}
