package bomberone.model.input.movement;

import bomberone.model.GameModel;
import bomberone.model.input.Command;

public class MoveRight implements Command {

	@Override
	public void execute(GameModel gameModel) {
		gameModel.getWorld().getBomber().moveRight();
	}

}
