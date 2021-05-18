package bomberone.controllers.match.input.commands;

import bomberone.model.common.Direction;
import bomberone.model.match.GameMatch;

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
    public void execute(final GameMatch gameMatch) {
        gameMatch.getWorld().getBomber().moveLeft();
        gameMatch.getWorld().getBomber().setStatic(false);
    }

}