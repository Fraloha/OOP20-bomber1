package bomberOne.model.input.commands;

import bomberOne.model.GameModel;

public class MoveLeft implements Command {

    /**
     * {@inheritDoc}
     */
    @Override
    public void execute(final GameModel gameModel) {
        gameModel.getWorld().getBomber().moveLeft();
        gameModel.getWorld().getBomber().setStatic(false);
    }

}