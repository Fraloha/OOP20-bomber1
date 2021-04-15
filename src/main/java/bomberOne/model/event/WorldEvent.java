package bomberone.model.event;

import bomberone.model.GameModel;

/**
 * Generic interface for Every WorldEvent.
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
