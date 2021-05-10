package bomber1.controllers.game.input.commands;

import bomber1.model.GameModel;
import bomber1.model.common.Direction;

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