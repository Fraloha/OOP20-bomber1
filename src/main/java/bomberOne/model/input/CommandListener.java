package bomberOne.model.input;

import java.util.List;

import bomberOne.model.GameModel;
import bomberOne.model.input.commands.Command;

public interface CommandListener {
	
	/**
	 * This method add the 
	 * @param command in the commandList
	 */
	public void addCommand(Command command);
	
	/**
	 * 
	 * @return the commandList
	 */
	public List<Command> getCommandList();
	
	/**
	 * Scroll all the commandList and call the method execute()
	 * on all the command of the commandList
	 */
	public void executeAll();
	
	/**
	 * Attach the 
	 * @param game at gameModel 
	 */
	public void setGameModel(GameModel game);
	
	/**
	 * 
	 * @return the GameModel attached
	 */
	public GameModel getGameModel();
}