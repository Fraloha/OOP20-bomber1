package bomberOne.model.input.movement;

import bomberOne.model.GameModel;
import bomberOne.model.input.Command;

public class MoveDown implements Command {

	@Override
	public void execute(GameModel gameModel) {
		gameModel.getWorld().getBomber().moveDown();
	}

}
