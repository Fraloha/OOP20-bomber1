package bomber1.controllers.game.event;

import bomber1.model.GameModel;

/**
 * Interface for generic WorldEvent.
 * 
 *
 */
public interface WorldEvent {

    /**
     * In this method is done the routine to handle the Event.
     * @param model to apply the event
     */
    void process(GameModel model);
}
