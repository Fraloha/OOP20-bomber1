package bomberOne.model.event;

import java.util.List;

import bomberOne.model.GameModel;

/**
 * This class Handle every type of event in the World
 * @author Luigi
 *
 */
public interface WorldEventListener {

	/**
	 * Add an Event to the Event-Queue
	 * @param event the WorldEvent to be added on the queue
	 */
	public void notifyEvent(WorldEvent event);
	
	/**
	 * 
	 * @return the Queue of the Events notified
	 */
	public List<WorldEvent> getEventList();
	
	/**
	 * Execute all the event in the queue
	 */
	public void processEvents();
	
	/**
	 * Set the GameModel linked to the Listener
	 * @param game the Model to attach to the Listener
	 */
	public void setGameModel(GameModel game);	
	
	/**
	 * Get the GameModel linked to the Listener
	 * @return GameModel, the Model attached to the Listener
	 */
	public GameModel getGameModel();
}
