package bomberone.controllers.match.event;

import bomberone.model.match.GameMatch;

/**
 * Interface for generic WorldEvent.
 * 
 *
 */
public interface WorldEvent {

    /**
     * In this method is done the routine to handle the Event.
     * 
     * @param match to apply the event
     */
    void process(GameMatch match);
}
