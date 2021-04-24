package bomberOne.model.input.commands;

import bomberOne.model.GameModel;

public class MoveRight implements Command {

    /**
     * {@inheritDoc}
     */
    @Override
    public void execute(final GameModel gameModel) {
        gameModel.getWorld().getBomber().moveRight();
        gameModel.getWorld().getBomber().setStatic(false);
    }

}
