package bomberOne.model.input.commands;

import bomberOne.model.GameModel;

public class MoveDown implements Command {

    /**
     * {@inheritDoc}
     */
    @Override
    public void execute(final GameModel gameModel) {
        gameModel.getWorld().getBomber().moveDown();
        gameModel.getWorld().getBomber().setStatic(false);
    }

}