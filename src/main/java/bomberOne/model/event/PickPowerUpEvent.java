package bomberone.model.event;

import bomberone.model.GameModel;
import bomberone.model.gameObjects.PowerUp;

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
        if (this.powerUp.getType().equals(PowerUp.type.Time)) {
            model.getTimer().setTimer(model.getTimer().getTime().getTotal() + TIMER_INC);
        } else {
            model.getWorld().getBomber().applyPowerUp(this.powerUp.getType());
        }
        this.powerUp.hitted();
    }

}
