package bomberone.model.input;

import bomberone.model.GameModel;

public interface Command {
	
	/**
	 * Execute the command on
	 * @param gameModel
	 */
	public void execute(GameModel gameModel);
}
