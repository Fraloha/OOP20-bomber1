package bomberone.controllers.match.input.commands;

import bomberone.model.common.Direction;
import bomberone.model.match.GameMatch;

public class MoveUp implements Command {

    private Direction dir;

    public MoveUp() {
        this.dir = Direction.UP;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Direction dir() {
        return this.dir;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void execute(final GameMatch gameMatch) {
        gameMatch.getWorld().getBomber().moveUp();
        gameMatch.getWorld().getBomber().setStatic(false);
    }

}
