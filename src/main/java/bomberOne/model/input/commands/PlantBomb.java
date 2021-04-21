package bomberOne.model.input.commands;

import bomberOne.model.GameModel;

public class PlantBomb implements Command {

    /**
     * {@inheritDoc}
     */
    @Override
    public void execute(final GameModel gameModel) {
        gameModel.getWorld().getBomber().plantBomb();
    }

}