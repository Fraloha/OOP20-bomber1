<<<<<<< HEAD:src/main/java/bomberOne/model/input/commands/MoveRight.java
package bomberOne.model.input.commands;

import bomberOne.model.GameModel;

public class MoveRight implements Command {

	@Override
	public void execute(GameModel gameModel) {
		gameModel.getWorld().getBomber().moveRight();
	}

}
=======
package bomberOne.model.input.movement;

import bomberOne.model.GameModel;
import bomberOne.model.input.Command;

public class MoveRight implements Command {

	@Override
	public void execute(GameModel gameModel) {
		gameModel.getWorld().getBomber().moveRight();
	}

}
>>>>>>> develop:src/main/java/bomberOne/model/input/movement/MoveRight.java
