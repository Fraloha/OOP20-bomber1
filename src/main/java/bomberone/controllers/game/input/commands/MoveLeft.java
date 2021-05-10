package bomberone.controllers.game.input.commands;

import bomberone.model.GameModel;
import bomberone.model.common.Direction;

public class MoveLeft implements Command {

    Direction dir;

    public MoveLeft() {
        this.dir = Direction.LEFT;
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
        gameModel.getWorld().getBomber().moveLeft();
        gameModel.getWorld().getBomber().setStatic(false);
    }

}