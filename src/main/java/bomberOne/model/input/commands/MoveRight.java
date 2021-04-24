package bomberOne.model.input.commands;

import bomberOne.model.GameModel;
import bomberOne.model.common.Direction;

public class MoveRight implements Command {

    Direction dir;

    public MoveRight() {
        this.dir = Direction.RIGHT;
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
        gameModel.getWorld().getBomber().moveRight();
        gameModel.getWorld().getBomber().setStatic(false);
    }

}
