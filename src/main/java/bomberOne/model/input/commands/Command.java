package bomberOne.model.input.commands;

import bomberOne.model.GameModel;
import bomberOne.model.common.Direction;

public interface Command {

    /**
     * Execute the command on "gameModel".
     * 
     * @param gameModel
     */
    void execute(GameModel gameModel);
    
    Direction dir();
}