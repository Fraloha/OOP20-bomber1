package bomberOne.model.input.commands;

import bomberOne.model.GameModel;

public class MoveRight implements Command {

	@Override
	public void execute(GameModel gameModel) {
		gameModel.getWorld().getBomber().moveRight();
	}

}
