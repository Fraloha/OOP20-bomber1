package bomberone.model.input.movement;

import bomberone.model.GameModel;
import bomberone.model.input.Command;

public class MoveUp implements Command {

	@Override
	public void execute(GameModel gameModel) {
		gameModel.getWorld().getBomber().moveUp();
	}

}
