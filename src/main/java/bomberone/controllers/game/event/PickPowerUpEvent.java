package bomberone.controllers.game.event;

import bomberone.model.GameModel;
import bomberone.model.gameObjects.PowerUp;
import bomberone.tools.audio.AudioHandler;
import bomberone.tools.audio.GameAudio;

/**
 * This event is triggered when the Bomber picks a PowerUp.
 *
 */
public class PickPowerUpEvent implements WorldEvent {

    private static final int TIMER_INC = 30;
    private PowerUp powerUp;

    public PickPowerUpEvent(final PowerUp pU) {
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
    public void process(final GameModel model) {
        AudioHandler.start(GameAudio.POWER_UP); // This is the Audio Effect for powerUp
        if (this.powerUp.getType().equals(PowerUp.Type.Time)) {
            /* Timer PowerUp */
            model.getTimer().setTimer(model.getTimer().getTime().getTotal() + TIMER_INC);
        } else {
            /* All other PowerUp */
            model.getWorld().getBomber().applyPowerUp(this.powerUp.getType());
        }
        this.powerUp.hitted();
    }

}
