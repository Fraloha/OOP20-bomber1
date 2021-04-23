package bomberOne.model.input.commands;

import bomberOne.model.GameModel;
import bomberOne.model.common.Direction;

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
    }

}