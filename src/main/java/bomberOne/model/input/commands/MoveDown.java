<<<<<<< HEAD:src/main/java/bomberOne/model/input/commands/MoveDown.java
package bomberOne.model.input.commands;

import bomberOne.model.GameModel;

public class MoveDown implements Command {

	@Override
	public void execute(GameModel gameModel) {
		gameModel.getWorld().getBomber().moveDown();
	}

}
=======
package bomberOne.model.input.movement;

import bomberOne.model.GameModel;
import bomberOne.model.input.Command;

public class MoveDown implements Command {

	@Override
	public void execute(GameModel gameModel) {
		gameModel.getWorld().getBomber().moveDown();
	}

}
>>>>>>> develop:src/main/java/bomberOne/model/input/movement/MoveDown.java
