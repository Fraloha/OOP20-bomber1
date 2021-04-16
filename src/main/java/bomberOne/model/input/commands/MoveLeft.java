<<<<<<< HEAD:src/main/java/bomberOne/model/input/commands/MoveLeft.java
package bomberOne.model.input.commands;

import bomberOne.model.GameModel;

public class MoveLeft implements Command {

	@Override
	public void execute(GameModel gameModel) {
		gameModel.getWorld().getBomber().moveLeft();
	}

}
=======
package bomberOne.model.input.movement;

import bomberOne.model.GameModel;
import bomberOne.model.input.Command;

public class MoveLeft implements Command {

	@Override
	public void execute(GameModel gameModel) {
		gameModel.getWorld().getBomber().moveLeft();
	}

}
>>>>>>> develop:src/main/java/bomberOne/model/input/movement/MoveLeft.java
