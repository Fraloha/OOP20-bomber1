package bomberone.model.event;

import java.util.List;

import bomberone.model.GameModel;

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
     * Set the GameModel linked to the Listener.
     * 
     * @param game the Model to attach to the Listener
     */
    void setGameModel(GameModel game);

    /**
     * Get the GameModel linked to the Listener.
     * 
     * @return GameModel, the Model attached to the Listener
     */
    GameModel getGameModel();
}
