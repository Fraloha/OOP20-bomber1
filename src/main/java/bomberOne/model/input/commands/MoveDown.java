package bomberOne.model.input.commands;

import bomberOne.model.GameModel;
import bomberOne.model.common.Direction;

public class MoveDown implements Command {

    Direction dir;
    
    public MoveDown() {
        this.dir = Direction.DOWN;
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
        gameModel.getWorld().getBomber().moveDown();  
        gameModel.getWorld().getBomber().setStatic(false);
    }

    

}