package bomberOne.model.input.commands;

import bomberOne.model.GameModel;
import bomberOne.model.common.Direction;

public class PlantBomb implements Command {

    /**
     * {@inheritDoc}
     */
    @Override
    public void execute(final GameModel gameModel) {
        gameModel.getWorld().getBomber().plantBomb();
    }

    @Override
    public Direction dir() {
        // TODO Auto-generated method stub
        return null;
    }

}