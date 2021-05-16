package bomberone.controllers.game.input.commands;

import bomberone.model.GameMatch;
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
    public void execute(final GameMatch gameModel) {
        gameModel.getWorld().getBomber().moveLeft();
        gameModel.getWorld().getBomber().setStatic(false);
    }

}