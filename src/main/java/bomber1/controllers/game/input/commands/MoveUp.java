package bomber1.controllers.game.input.commands;

import bomber1.model.GameModel;
import bomber1.model.common.Direction;

public class MoveUp implements Command {

    Direction dir;

    public MoveUp() {
        this.dir = Direction.UP;
    }

    @Override
    public Direction dir() {
        return this.dir;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void execute(final GameModel gameModel) {
        gameModel.getWorld().getBomber().moveUp();
        gameModel.getWorld().getBomber().setStatic(false);
    }

}