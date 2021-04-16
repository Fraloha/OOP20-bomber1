<<<<<<< HEAD:src/main/java/bomberOne/model/input/commands/MoveUp.java
package bomberOne.model.input.commands;

import bomberOne.model.GameModel;

public class MoveUp implements Command {

	@Override
	public void execute(GameModel gameModel) {
		gameModel.getWorld().getBomber().moveUp();
	}

}
=======
package bomberOne.model.input.movement;

import bomberOne.model.GameModel;
import bomberOne.model.input.Command;

public class MoveUp implements Command {

	@Override
	public void execute(GameModel gameModel) {
		gameModel.getWorld().getBomber().moveUp();
	}

}
>>>>>>> develop:src/main/java/bomberOne/model/input/movement/MoveUp.java
