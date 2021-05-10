package bomber1.controllers.game.input.commands;

import bomber1.model.GameModel;
import bomber1.model.common.Direction;

public interface Command {

    /**
     * Execute the command on "gameModel".
     * 
     * @param gameModel
     */
    void execute(GameModel gameModel);
    
    Direction dir();
}