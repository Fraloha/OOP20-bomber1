package bomberOne.model.input.commands;

import bomberOne.model.GameModel;

public interface Command {
	
	/**
	 * Execute the command on
	 * @param gameModel
	 */
	public void execute(GameModel gameModel);
}