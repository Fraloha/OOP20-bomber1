package bomberOne.model.input;

import java.util.LinkedList;
import java.util.List;

import bomberOne.model.GameModel;

public class CommandListenerImpl implements CommandListener{
	private List<Command> commandList;
	private GameModel game;
	
	
	
	public CommandListenerImpl() {
		this.commandList = new LinkedList<>();
	}
	
	public CommandListenerImpl(GameModel game) {
		this.game = game;
	}
	
	@Override
	public void addCommand(Command command) {
		this.commandList.add(command);
	}

	@Override
	public List<Command> getCommandList() {
		return this.commandList;
	}

	@Override
	public void executeAll() {
		this.commandList.stream().forEach(i -> {
			i.execute(this.game); 
			this.commandList.remove(i);
		});
	}

	@Override
	public void setGameModel(GameModel game) {
		this.game = game;		
	}

	@Override
	public GameModel getGameModel() {
		return this.game;
	}
}