package bomberOne.controllers.game.event;

import bomberOne.model.GameModel;

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
