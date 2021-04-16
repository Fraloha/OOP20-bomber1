<<<<<<< HEAD:src/main/java/bomberOne/model/input/commands/PlantBomb.java
package bomberOne.model.input.commands;

import bomberOne.model.GameModel;

public class PlantBomb implements Command{

	@Override
	public void execute(GameModel gameModel) {
		gameModel.getWorld().getBomber().plantBomb();		
	}

}
=======
package bomberOne.model.input;

import bomberOne.model.GameModel;

public class PlantBomb implements Command{

	@Override
	public void execute(GameModel gameModel) {
		// TODO Auto-generated method stub
		
	}

}
>>>>>>> develop:src/main/java/bomberOne/model/input/PlantBomb.java
