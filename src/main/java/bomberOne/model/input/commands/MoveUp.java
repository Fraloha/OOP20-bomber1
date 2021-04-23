package bomberOne.model.input.commands;

import bomberOne.model.GameModel;

public class MoveUp implements Command {

    /**
     * {@inheritDoc}
     */
    @Override
    public void execute(final GameModel gameModel) {
        gameModel.getWorld().getBomber().moveUp();
        gameModel.getWorld().getBomber().setStatic(false);
    }

}