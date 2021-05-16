package bomberone.controllers.game.input.commands;

import bomberone.model.common.Direction;
import bomberone.model.match.GameMatch;

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
    public void execute(final GameMatch gameModel) {
        gameModel.getWorld().getBomber().moveRight();
        gameModel.getWorld().getBomber().setStatic(false);
    }

}
