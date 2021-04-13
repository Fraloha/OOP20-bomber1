package bomberOne.model.event;

import bomberOne.model.GameModel;

/**
 * Generic interface for Every WorldEvent
 * @author Luigi
 *
 */
public interface WorldEvent {
 
	/**
	 * In this method is done the routine to handle the Event
	 */
	public void process(GameModel model);
}
