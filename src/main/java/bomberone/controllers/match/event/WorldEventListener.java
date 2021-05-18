package bomberone.controllers.match.event;

import java.util.List;

import bomberone.model.match.GameMatch;

/**
 * This class Handle every type of event in the World.
 * 
 *
 */
public interface WorldEventListener {

    /**
     * Add an Event to the Event-Queue.
     * 
     * @param event the WorldEvent to be added on the queue
     */
    void notifyEvent(WorldEvent event);

    /**
     * 
     * @return the Queue of the Events notified
     */
    List<WorldEvent> getEventList();

    /**
     * Execute all the event in the queue.
     */
    void processEvents();

    /**
     * Set the GameMatch linked to the Listener.
     * 
     * @param match the Model to attach to the Listener
     */
    void setGameMatch(GameMatch match);

    /**
     * Get the GameMatch linked to the Listener.
     * 
     * @return GameMatch, the Model attached to the Listener
     */
    GameMatch getGameMatch();
}
