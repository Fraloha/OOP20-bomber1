package bomberOne.model.input;

import bomberOne.model.GameModel;

public interface Command {
	
	/**
	 * Execute the command on
	 * @param gameModel
	 */
	public void execute(GameModel gameModel);
}
