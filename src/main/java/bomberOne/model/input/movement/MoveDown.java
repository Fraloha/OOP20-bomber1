package bomberone.model.input.movement;

import bomberone.model.GameModel;
import bomberone.model.input.Command;

public class MoveDown implements Command {

	@Override
	public void execute(GameModel gameModel) {
		gameModel.getWorld().getBomber().moveDown();
	}

}
